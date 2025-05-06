package com.jhennis.store.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "summary", types = User.class)
public interface UserSummary {
    int getUserId();
    String getFirstName();
    String getLastName();
    String getEmail();
}
