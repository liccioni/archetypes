package net.liccioni.archetypes.order.discount;


import net.liccioni.archetypes.product.price.Price;

public interface Discount {

    String reason();

    Price calculateDiscountedPrice(Price price);
}
