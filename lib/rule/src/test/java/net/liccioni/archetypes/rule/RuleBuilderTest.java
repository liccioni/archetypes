package net.liccioni.archetypes.rule;

import net.liccioni.archetypes.common.TimeDate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Instant;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RuleBuilderTest {

    @Test
    void complexRule() {
        Rule rule = RuleBuilder.newRule("", builder -> builder
                .proposition("passengerIsEconomy")
                .and(builder.proposition("passengerIsGoldCardHolder")
                        .xor(builder.proposition("passengerIsSilverCardHolder")))
                .and(builder.variable("passengerCarryOnBaggageWeightKg")
                        .lessThanOrEqualTo(builder.variable("carryOnBaggageAllowanceKg")))
                .and(builder.proposition("passengerDressIsSmart")));
        RuleContext context = RuleContext.builder().name("complexRule").build()
                .addProposition("passengerIsEconomy", true)
                .addProposition("passengerIsGoldCardHolder", false)
                .addProposition("passengerIsSilverCardHolder", true)
                .addProposition("passengerDressIsSmart", true)
                .addVariable("passengerCarryOnBaggageWeightKg", 9)
                .addVariable("carryOnBaggageAllowanceKg", 15);
        Proposition actual = rule.evaluate(context);
        Proposition expected = new Proposition(
                "passengerIsEconomy_AND_passengerIsGoldCardHolder_XOR_passengerIsSilverCardHolder_AND_passengerCarryOnBaggageWeightKg_LESS_THAN_OR_EQUAL_TO_carryOnBaggageAllowanceKg_AND_passengerDressIsSmart",
                true);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"true:true:true", "false:true:false", "true:false:false", "false:false:false"}, delimiter = ':')
    void shouldEvaluate_AND(boolean firstOp, boolean secondOp, boolean expectedValue) {
        Rule rule = RuleBuilder.newRule("AND", ruleBuilder ->
                ruleBuilder.proposition("firstOp").and(ruleBuilder.proposition("secondOp")));
        RuleContext context = RuleContext.builder().name("shouldEvaluate_AND").build();
        context.addProposition("firstOp", firstOp);
        context.addProposition("secondOp", secondOp);
        Proposition actual = rule.evaluate(context);
        Proposition expected = new Proposition("firstOp_AND_secondOp", expectedValue);
        assertThat(actual).isEqualTo(expected);
        assertThat(rule.name()).isEqualTo("AND");
    }

    @ParameterizedTest
    @CsvSource(value = {"true:true:true", "false:true:true", "true:false:true", "false:false:false"}, delimiter = ':')
    void shouldEvaluate_OR(boolean firstOp, boolean secondOp, boolean expectedValue) {
        Rule rule = RuleBuilder.newRule("OR", ruleBuilder ->
                ruleBuilder.proposition("firstOp").or(ruleBuilder.proposition("secondOp")));
        RuleContext context = RuleContext.builder().name("shouldEvaluate_OR").build();
        context.addProposition("firstOp", firstOp);
        context.addProposition("secondOp", secondOp);
        Proposition actual = rule.evaluate(context);
        Proposition expected = new Proposition("firstOp_OR_secondOp", expectedValue);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"true:true:false", "false:true:true", "true:false:true", "false:false:false"}, delimiter = ':')
    void shouldEvaluate_XOR(boolean firstOp, boolean secondOp, boolean expectedValue) {
        Rule rule = RuleBuilder.newRule("XOR", ruleBuilder ->
                ruleBuilder.proposition("firstOp").xor(ruleBuilder.proposition("secondOp")));
        RuleContext context = RuleContext.builder().name("shouldEvaluate_XOR").build();
        context.addProposition("firstOp", firstOp);
        context.addProposition("secondOp", secondOp);
        Proposition actual = rule.evaluate(context);
        Proposition expected = new Proposition("firstOp_XOR_secondOp", expectedValue);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"true:false", "false:true"}, delimiter = ':')
    void shouldEvaluate_NOT(boolean firstOp, boolean expectedValue) {
        Rule rule = RuleBuilder.newRule("NOT", ruleBuilder -> ruleBuilder.not("firstOp"));
        RuleContext context = RuleContext.builder().name("shouldEvaluate_NOT").build();
        context.addProposition("firstOp", firstOp);
        Proposition actual = rule.evaluate(context);
        Proposition expected = new Proposition("NOT_firstOp", expectedValue);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"myValue:myOtherValue:false", "myValue:myValue:true"}, delimiter = ':')
    void shouldEvaluate_EQUAL_TO(String firstOp, String secondOp, boolean expectedValue) {
        Rule rule = RuleBuilder.newRule("EQUAL_TO", ruleBuilder ->
                ruleBuilder.variable("firstOp").equalTo(ruleBuilder.variable("secondOp")));
        RuleContext context = RuleContext.builder().name("shouldEvaluate_EQUAL_TO").build();
        context.addVariable("firstOp", firstOp);
        context.addVariable("secondOp", secondOp);
        Proposition actual = rule.evaluate(context);
        Proposition expected = new Proposition("firstOp_EQUAL_TO_secondOp", expectedValue);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"myValue:myOtherValue:true", "myValue:myValue:false"}, delimiter = ':')
    void shouldEvaluate_NOT_EQUAL_TO(String firstOp, String secondOp, boolean expectedValue) {
        Rule rule = RuleBuilder.newRule("NOT_EQUAL_TO", ruleBuilder ->
                ruleBuilder.variable("firstOp").notEqualTo(ruleBuilder.variable("secondOp")));
        RuleContext context = RuleContext.builder().name("shouldEvaluate_NOT_EQUAL_TO").build()
                .addVariable("firstOp", firstOp)
                .addVariable("secondOp", secondOp);
        Proposition actual = rule.evaluate(context);
        Proposition expected = new Proposition("firstOp_NOT_EQUAL_TO_secondOp", expectedValue);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"2:1:true", "1:2:false"}, delimiter = ':')
    void shouldEvaluate_GREATER_THAN(String firstOp, String secondOp, boolean expectedValue) {
        Rule rule = RuleBuilder.newRule("GREATER_THAN", ruleBuilder ->
                ruleBuilder.variable("firstOp").greaterThan(ruleBuilder.variable("secondOp")));
        RuleContext context = RuleContext.builder().name("shouldEvaluate_GREATER_THAN").build();
        context.addVariable("firstOp", firstOp);
        context.addVariable("secondOp", secondOp);
        Proposition actual = rule.evaluate(context);
        Proposition expected = new Proposition("firstOp_GREATER_THAN_secondOp", expectedValue);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"2:1:false", "1:2:true"}, delimiter = ':')
    void shouldEvaluate_LESS_THAN(String firstOp, String secondOp, boolean expectedValue) {
        Rule rule = RuleBuilder.newRule("LESS_THAN", ruleBuilder ->
                ruleBuilder.variable("firstOp").lessThan(ruleBuilder.variable("secondOp")));
        RuleContext context = RuleContext.builder().name("shouldEvaluate_LESS_THAN").build();
        context.addVariable("firstOp", firstOp);
        context.addVariable("secondOp", secondOp);
        Proposition actual = rule.evaluate(context);
        Proposition expected = new Proposition("firstOp_LESS_THAN_secondOp", expectedValue);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"2:1:true", "1:2:false", "2:2:true"}, delimiter = ':')
    void shouldEvaluate_GREATER_THAN_OR_EQUAL_TO(String firstOp, String secondOp, boolean expectedValue) {
        Rule rule = RuleBuilder.newRule("GREATER_THAN_OR_EQUAL_TO", ruleBuilder ->
                ruleBuilder.variable("firstOp").greaterThanOrEqualTo(ruleBuilder.variable("secondOp")));
        RuleContext context = RuleContext.builder().name("shouldEvaluate_GREATER_THAN_OR_EQUAL_TO").build();
        context.addVariable("firstOp", firstOp);
        context.addVariable("secondOp", secondOp);
        Proposition actual = rule.evaluate(context);
        Proposition expected = new Proposition("firstOp_GREATER_THAN_OR_EQUAL_TO_secondOp", expectedValue);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"2:1:false", "1:2:true", "2:2:true"}, delimiter = ':')
    void shouldEvaluate_LESS_THAN_OR_EQUAL_TO(String firstOp, String secondOp, boolean expectedValue) {
        Rule rule = RuleBuilder.newRule("LESS_THAN_OR_EQUAL_TO", ruleBuilder ->
                ruleBuilder.variable("firstOp").lessThanOrEqualTo(ruleBuilder.variable("secondOp")));
        RuleContext context = RuleContext.builder().name("shouldEvaluate_LESS_THAN_OR_EQUAL_TO").build();
        context.addVariable("firstOp", firstOp);
        context.addVariable("secondOp", secondOp);
        Proposition actual = rule.evaluate(context);
        Proposition expected = new Proposition("firstOp_LESS_THAN_OR_EQUAL_TO_secondOp", expectedValue);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldEvaluateDates() {
        Rule rule = RuleBuilder.newRule("LESS_THAN_OR_EQUAL_TO", ruleBuilder ->
                ruleBuilder.variable("firstOp").lessThanOrEqualTo(ruleBuilder.variable("secondOp")));
        RuleContext context = RuleContext.builder().name("shouldEvaluateDates").build();
        context.addVariable("firstOp", Instant.now().minusSeconds(20));
        context.addVariable("secondOp", Instant.now());
        Proposition actual = rule.evaluate(context);
        Proposition expected = new Proposition("firstOp_LESS_THAN_OR_EQUAL_TO_secondOp", true);
        assertThat(actual).isEqualTo(expected);
    }

    /*@Test
    void shouldEvaluateStringMatch() {
        Rule rule = RuleBuilder.newRule("MATCHES", ruleBuilder ->
                ruleBuilder.stringVariable("firstOp").matches(ruleBuilder.stringVariable("secondOp"))
                        .or(ruleBuilder.stringVariable("firstOp").equalTo(ruleBuilder.stringVariable("secondOp"))));
        RuleContext context = RuleContext.builder().name("shouldEvaluateStringMatch").build();
        context.addVariable("firstOp", "occurrences of the http:// pattern.");
        context.addVariable("secondOp", ".*http://.*");
        Proposition actual = rule.evaluate(context);
        Proposition expected = new Proposition("firstOp_MATCHES_secondOp_OR_firstOp_EQUAL_TO_secondOp", true);
        assertThat(actual).isEqualTo(expected);
    }
*/
    @Test
    void shouldEvaluateToTrue() {

        Rule rule1 = RuleBuilder.newRule("LESS_THAN_OR_EQUAL_TO", ruleBuilder ->
                ruleBuilder.variable("firstOp").lessThanOrEqualTo(ruleBuilder.variable("secondOp")));
        Rule rule2 = RuleBuilder.newRule("LESS_THAN_OR_EQUAL_TO", ruleBuilder ->
                ruleBuilder.variable("fourthOp").lessThanOrEqualTo(ruleBuilder.variable("thirdOp")));

        RuleSet ruleSet = new RuleSet("", rule1, rule2);
        RuleContext context = RuleContext.builder().name("shouldEvaluateToTrue").build();
        context.addVariable("firstOp", 1);
        context.addVariable("secondOp", 2);
        context.addVariable("thirdOp", 4);
        context.addVariable("fourthOp", 3);
        assertThat(ruleSet.evaluate(context)).isTrue();
    }

    @Test
    void shouldEvaluateToFalse() {

        Rule rule1 = RuleBuilder.newRule("alwaysTrue", ruleBuilder ->
                ruleBuilder.variable("firstOp").lessThanOrEqualTo(ruleBuilder.variable("secondOp")));
        Rule rule2 = RuleBuilder.newRule("LESS_THAN_OR_EQUAL_TO", ruleBuilder ->
                ruleBuilder.variable("fourthOp").lessThanOrEqualTo(ruleBuilder.variable("thirdOp")));

        RuleSet ruleSet = new RuleSet("", rule1, rule2);
        RuleContext context = RuleContext.builder().name("shouldEvaluateToFalse").build();
        context.addVariable("firstOp", 1);
        context.addVariable("secondOp", 2);
        context.addVariable("thirdOp", 3);
        context.addVariable("fourthOp", 4);
        assertThat(ruleSet.evaluate(context)).isFalse();
    }


    private static Stream<Arguments> shouldEvaluateWithRuleOverrideArgs() {

        final var context1 = Map.of("firstOp", 1, "secondOp", 2, "thirdOp", 4, "fourthOp", 3)
                .entrySet().stream().reduce(RuleContext.builder()
                                .name("shouldEvaluateToTrue")
                                .build(),
                        (BiFunction<RuleContext, Map.Entry<String, Integer>, RuleContext>)
                                (context, e) -> context.addVariable(
                                        e.getKey(), e.getValue()), (a, b) -> null);

        final var context2 = Map.of("firstOp", 1, "secondOp", 2, "thirdOp", 3, "fourthOp", 4)
                .entrySet().stream().reduce(RuleContext.builder()
                                .name("shouldEvaluateToFalse")
                                .build(),
                        (BiFunction<RuleContext, Map.Entry<String, Integer>, RuleContext>)
                                (context, e) -> context.addVariable(
                                        e.getKey(), e.getValue()), (a, b) -> null);

        return Stream.of(
                Arguments.of(context1, RuleOverride.builder().ruleName("ruleUnderTest").override(true).build(), true),
                Arguments.of(context1, RuleOverride.builder().ruleName("ruleUnderTest").override(false).build(), true),
                Arguments.of(context2, RuleOverride.builder().ruleName("ruleUnderTest").override(true).build(), true),
                Arguments.of(context2, RuleOverride.builder().ruleName("ruleUnderTest").override(false).build(), false)
        );
    }

    @ParameterizedTest
    @MethodSource("shouldEvaluateWithRuleOverrideArgs")
    void shouldEvaluateWithRuleOverride(RuleContext context,
                                        RuleOverride override,
                                        boolean expected) {
        Rule rule1 = RuleBuilder.newRule("alwaysTrue", ruleBuilder ->
                ruleBuilder.variable("firstOp").lessThanOrEqualTo(ruleBuilder.variable("secondOp")));
        Rule rule2 = RuleBuilder.newRule("ruleUnderTest", ruleBuilder ->
                ruleBuilder.variable("fourthOp").lessThanOrEqualTo(ruleBuilder.variable("thirdOp")));

        RuleSet ruleSet = new RuleSet("", rule1, rule2);
        ruleSet.addRuleOverride(override);
        assertThat(ruleSet.evaluate(context)).isEqualTo(expected);
    }

    @Test
    void shouldPrintRuleSet() {
        Rule rule1 = RuleBuilder.newRule("alwaysTrue", ruleBuilder ->
                ruleBuilder.variable("firstOp").lessThanOrEqualTo(ruleBuilder.variable("secondOp")));
        Rule rule2 = RuleBuilder.newRule("ruleUnderTest", ruleBuilder ->
                ruleBuilder.variable("fourthOp").lessThanOrEqualTo(ruleBuilder.variable("thirdOp"))
                        .and(ruleBuilder.proposition("fifthOp")));

        RuleSet ruleSet = new RuleSet("", rule1, rule2);
        ruleSet.addRuleOverride(
                new RuleOverride("ruleUnderTest", true, "because why not",
                        TimeDate.builder().value(Instant.parse("2023-01-26T10:22:47.353154Z")).build()));
        var actual = ruleSet.toString();
        assertThat(actual).isEqualTo("RuleSet[name=, rules=[Rule[name=alwaysTrue, elements=[Variable[name=firstOp, value=null], Variable[name=secondOp, value=null], Operator{name=LESS_THAN_OR_EQUAL_TO} ]], Rule[name=ruleUnderTest, elements=[Variable[name=fourthOp, value=null], Variable[name=thirdOp, value=null], Operator{name=LESS_THAN_OR_EQUAL_TO} , Proposition[name=fifthOp, value=false], Operator{name=AND} ]]], ruleOverrides={ruleUnderTest=RuleOverride[ruleName=ruleUnderTest, override=true, why=because why not, when=TimeDate[value=2023-01-26T10:22:47.353154Z]]}]");
    }

    @Test
    void shouldAppendContext() {
        Rule rule1 = RuleBuilder.newRule("lessThanIsTrue", ruleBuilder ->
                ruleBuilder.variable("firstOp").lessThanOrEqualTo(ruleBuilder.variable("secondOp")));
        Rule rule2 = RuleBuilder.newRule("lessThanAlsoTrue", ruleBuilder ->
                ruleBuilder.variable("fourthOp").lessThanOrEqualTo(ruleBuilder.variable("thirdOp")));
        var context1 = RuleContext.builder().name("context1").build();
        var context2 = RuleContext.builder().name("context2").build();
        context1.addVariable("firstOp", 1);
        context1.addVariable("secondOp", 2);
        context2.addVariable("thirdOp", 4);
        context2.addVariable("fourthOp", 3);
        context1.append(context2);
        RuleSet ruleSet = new RuleSet("", rule1, rule2);
        assertThat(ruleSet.evaluate(context1)).isEqualTo(true);
    }
}