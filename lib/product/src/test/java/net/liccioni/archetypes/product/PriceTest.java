package net.liccioni.archetypes.product;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.Set;
import net.liccioni.archetypes.money.ISOCurrency;
import net.liccioni.archetypes.money.Money;
import net.liccioni.archetypes.product.price.Price;
import net.liccioni.archetypes.rule.RuleBuilder;
import net.liccioni.archetypes.rule.RuleContext;
import net.liccioni.archetypes.rule.RuleOverride;
import net.liccioni.archetypes.rule.RuleSet;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PriceTest {

    @ParameterizedTest
    @CsvSource(value = {"true:true", "false:false"}, delimiter = ':')
    void shouldEvaluateRules(boolean approved, boolean expected) {

        RuleSet preconditions = new RuleSet("conditions for price",
                RuleBuilder.newRule("approvedBy", b -> b.proposition("isApprovedBy")));
        final Price price = Price.builder()
                .preConditions(preconditions)
                .amount(Money.moneyBuilder().amount(1).currency(ISOCurrency.builder()
                        .alphabeticCode("EUR")
                        .build()).build()).build();
        var actual = price.isValid(RuleContext.builder().build().addProposition("isApprovedBy", approved),
                Collections.emptySet());
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"true:true", "false:true"}, delimiter = ':')
    void shouldEvaluateRulesWithOverride(boolean approved, boolean expected) {

        RuleSet preconditions = new RuleSet("conditions for price",
                RuleBuilder.newRule("approvedBy", b -> b.proposition("isApprovedBy")));
        final Price price = Price.builder()
                .preConditions(preconditions)
                .amount(Money.moneyBuilder().amount(1).currency(ISOCurrency.builder()
                        .alphabeticCode("EUR")
                        .build()).build()).build();
        var actual = price.isValid(RuleContext.builder().build().addProposition("isApprovedBy", approved),
                Set.of(RuleOverride.builder().ruleName("isApprovedBy").override(true).build()));
        assertThat(actual).isEqualTo(expected);
    }
}