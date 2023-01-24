package net.liccioni.archetypes.rule;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RuleBuilderTest {

    @Test
    void complexRule() {
        Rule rule = RuleBuilder.newRule("", builder -> builder
                .proposition("passengerIsEconomy")
                .and(builder.proposition("passengerIsGoldCardHolder").xor(builder.proposition("passengerIsSilverCardHolder")))
                .and(builder.variable("passengerCarryOnBaggageWeightKg").lessThanOrEqualTo(builder.variable("carryOnBaggageAllowanceKg")))
                .and(builder.proposition("passengerDressIsSmart")));
        RuleContext context = new RuleContext();
        context.addProposition("passengerIsEconomy", true);
        context.addProposition("passengerIsGoldCardHolder", false);
        context.addProposition("passengerIsSilverCardHolder", true);
        context.addProposition("passengerDressIsSmart", true);
        context.addVariable("passengerCarryOnBaggageWeightKg", 9);
        context.addVariable("carryOnBaggageAllowanceKg", 15);
        Proposition actual = rule.evaluate(context);
        Proposition expected = new Proposition("passengerIsEconomy_AND_passengerIsGoldCardHolder_XOR_passengerIsSilverCardHolder_AND_passengerCarryOnBaggageWeightKg_LESS_THAN_OR_EQUAL_TO_carryOnBaggageAllowanceKg_AND_passengerDressIsSmart", true);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"true:true:true", "false:true:false", "true:false:false", "false:false:false"}, delimiter = ':')
    void shouldEvaluate_AND(boolean firstOp, boolean secondOp, boolean expectedValue) {
        Rule rule = RuleBuilder.newRule("AND", ruleBuilder ->
                ruleBuilder.proposition("firstOp").and(ruleBuilder.proposition("secondOp")));
        RuleContext context = new RuleContext();
        context.addProposition("firstOp", firstOp);
        context.addProposition("secondOp", secondOp);
        Proposition actual = rule.evaluate(context);
        Proposition expected = new Proposition("firstOp_AND_secondOp", expectedValue);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"true:true:true", "false:true:true", "true:false:true", "false:false:false"}, delimiter = ':')
    void shouldEvaluate_OR(boolean firstOp, boolean secondOp, boolean expectedValue) {
        Rule rule = RuleBuilder.newRule("OR", ruleBuilder ->
                ruleBuilder.proposition("firstOp").or(ruleBuilder.proposition("secondOp")));
        RuleContext context = new RuleContext();
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
        RuleContext context = new RuleContext();
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
        RuleContext context = new RuleContext();
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
        RuleContext context = new RuleContext();
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
        RuleContext context = new RuleContext();
        context.addVariable("firstOp", firstOp);
        context.addVariable("secondOp", secondOp);
        Proposition actual = rule.evaluate(context);
        Proposition expected = new Proposition("firstOp_NOT_EQUAL_TO_secondOp", expectedValue);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"2:1:true", "1:2:false"}, delimiter = ':')
    void shouldEvaluate_GREATER_THAN(String firstOp, String secondOp, boolean expectedValue) {
        Rule rule = RuleBuilder.newRule("GREATER_THAN", ruleBuilder ->
                ruleBuilder.variable("firstOp").greaterThan(ruleBuilder.variable("secondOp")));
        RuleContext context = new RuleContext();
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
        RuleContext context = new RuleContext();
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
        RuleContext context = new RuleContext();
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
        RuleContext context = new RuleContext();
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
        RuleContext context = new RuleContext();
        context.addVariable("firstOp", Instant.now().minusSeconds(20));
        context.addVariable("secondOp", Instant.now());
        Proposition actual = rule.evaluate(context);
        Proposition expected = new Proposition("firstOp_LESS_THAN_OR_EQUAL_TO_secondOp", true);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldEvaluateStringMatch() {
        Rule rule = RuleBuilder.newRule("MATCHES", ruleBuilder ->
                ruleBuilder.stringVariable("firstOp").matches(ruleBuilder.stringVariable("secondOp"))
                        .or(ruleBuilder.stringVariable("firstOp").equalTo(ruleBuilder.stringVariable("secondOp"))));
        RuleContext context = new RuleContext();
        context.addVariable("firstOp", "occurrences of the http:// pattern.");
        context.addVariable("secondOp", ".*http://.*");
        Proposition actual = rule.evaluate(context);
        Proposition expected = new Proposition("firstOp_MATCHES_secondOp_OR_firstOp_EQUAL_TO_secondOp", true);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldEvaluateToTrue() {

        Rule rule1 = RuleBuilder.newRule("LESS_THAN_OR_EQUAL_TO", ruleBuilder ->
                ruleBuilder.variable("firstOp").lessThanOrEqualTo(ruleBuilder.variable("secondOp")));
        Rule rule2 = RuleBuilder.newRule("LESS_THAN_OR_EQUAL_TO", ruleBuilder ->
                ruleBuilder.variable("fourthOp").lessThanOrEqualTo(ruleBuilder.variable("thirdOp")));

        RuleSet ruleSet = new RuleSet(rule1, rule2);
        RuleContext context = new RuleContext();
        context.addVariable("firstOp", 1);
        context.addVariable("secondOp", 2);
        context.addVariable("thirdOp", 4);
        context.addVariable("fourthOp", 3);
        assertThat(ruleSet.evaluate(context)).isTrue();
    }

    @Test
    void shouldEvaluateToFalse() {

        Rule rule1 = RuleBuilder.newRule("LESS_THAN_OR_EQUAL_TO", ruleBuilder ->
                ruleBuilder.variable("firstOp").lessThanOrEqualTo(ruleBuilder.variable("secondOp")));
        Rule rule2 = RuleBuilder.newRule("LESS_THAN_OR_EQUAL_TO", ruleBuilder ->
                ruleBuilder.variable("fourthOp").lessThanOrEqualTo(ruleBuilder.variable("thirdOp")));

        RuleSet ruleSet = new RuleSet(Arrays.asList(rule1, rule2));
        RuleContext context = new RuleContext();
        context.addVariable("firstOp", 1);
        context.addVariable("secondOp", 2);
        context.addVariable("thirdOp", 3);
        context.addVariable("fourthOp", 4);
        assertThat(ruleSet.evaluate(context)).isFalse();
    }
}