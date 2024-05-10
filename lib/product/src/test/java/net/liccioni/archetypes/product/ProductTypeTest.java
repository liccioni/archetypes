package net.liccioni.archetypes.product;

import static java.time.ZoneOffset.UTC;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.Clock;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import lombok.val;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.money.ISOCurrency;
import net.liccioni.archetypes.money.Money;
import net.liccioni.archetypes.money.MoneyRecord;
import net.liccioni.archetypes.product.price.Price;
import net.liccioni.archetypes.product.price.PriceRecord;
import net.liccioni.archetypes.rule.RuleBuilder;
import net.liccioni.archetypes.rule.RuleContext;
import net.liccioni.archetypes.rule.RuleSet;
import org.junit.jupiter.api.Test;

class ProductTypeTest {


    @Test
    void shouldGetPrices() {

        final var preconditions1 =
                new RuleSet("preconditions1", RuleBuilder.newRule("is always true", p -> p.proposition("expectTrue")));
        final var preconditions2 =
                new RuleSet("preconditions2",
                        RuleBuilder.newRule("is always false", p -> p.proposition("expectFalse")));

        final Clock testClock = Clock.fixed(Instant.parse("2023-01-26T10:22:47.353154Z"), UTC);

        final TimeDate oneMinuteAgo =
                TimeDate.builder().value(testClock.instant().minus(1, ChronoUnit.MINUTES)).build();
        final TimeDate oneMinuteFromNow =
                TimeDate.builder().value(testClock.instant().plus(1, ChronoUnit.MINUTES)).build();

        val littleAfterOneMinuteAgo =
                TimeDate.builder().value(oneMinuteAgo.value().plus(1, ChronoUnit.MILLIS)).build();
        val littleBeforeOneMinuteFromNow =
                TimeDate.builder().value(oneMinuteFromNow.value().minus(1, ChronoUnit.MILLIS)).build();

        final TimeDate thirtyMinutesAgo =
                TimeDate.builder().value(testClock.instant().minus(30, ChronoUnit.MINUTES)).build();
        final TimeDate thirtyMinutesFromNow =
                TimeDate.builder().value(testClock.instant().plus(30, ChronoUnit.MINUTES)).build();

        final var euro = ISOCurrency.builder().alphabeticCode("EUR").build();
        final Price price1 = PriceRecord.builder()
                .preConditions(preconditions1)
                .amount(MoneyRecord.moneyBuilder().amount(10).currency(euro).build()).build();
        final Price price2 = PriceRecord.builder()
                .validFrom(littleAfterOneMinuteAgo)
                .validTo(littleBeforeOneMinuteFromNow)
                .preConditions(preconditions2)
                .amount(MoneyRecord.moneyBuilder().amount(15).currency(euro).build()).build();
        final Price price3 = PriceRecord.builder()
                .validFrom(thirtyMinutesAgo)
                .validTo(thirtyMinutesFromNow)
                .amount(MoneyRecord.moneyBuilder().amount(20).currency(euro).build()).build();
        final var p1 = ProductTypeRecord.builder().name("p1").prices(Set.of(price1, price2, price3)).build();
        final var actual = p1.getPrices(
                RuleContext.builder().build().addProposition("expectTrue", true).addProposition("expectFalse", false));
        assertThat(actual).containsExactlyInAnyOrder(price1, price3);

        final var actualByTime = p1.getPrices(oneMinuteAgo, oneMinuteFromNow);
        assertThat(actualByTime).containsExactly(price2);
    }
}