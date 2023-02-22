package net.liccioni.archetypes.product.price;


import java.util.Set;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.common.TimeDate;
import net.liccioni.archetypes.money.Money;
import net.liccioni.archetypes.rule.RuleContext;
import net.liccioni.archetypes.rule.RuleOverride;
import net.liccioni.archetypes.rule.RuleSet;

@Data
@SuperBuilder(toBuilder = true)
public class Price {


    private Money amount;
    private TimeDate validFrom;
    private TimeDate validTo;
    @Builder.Default
    private RuleSet preConditions = new RuleSet("preConditions");

    public boolean isValid(RuleContext context, Set<RuleOverride> overrides) {
        //TODO
        return false;
    }
}
