package net.liccioni.archetypes.order;


import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import net.liccioni.archetypes.uniqueid.UniqueIdentifier;

@Value
@ToString(callSuper = true)
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class OrderIdentifier extends UniqueIdentifier {
}
