package com.jhennis.store.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "summary", types = Product.class)
public interface ProductSummary {
    int getProductId();
    String getName();
    double getPrice();
    String getDescription();
}
