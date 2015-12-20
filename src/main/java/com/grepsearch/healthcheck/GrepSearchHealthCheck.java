package com.grepsearch.healthcheck;

import com.yammer.metrics.core.HealthCheck;

public class GrepSearchHealthCheck  extends HealthCheck {

    /**
     * Create a new {@link HealthCheck} instance with the given name.
     *
     * @param name the name of the health check (and, ideally, the name of the underlying
     *             component the health check tests)
     */
    public GrepSearchHealthCheck(String name) {
        super(name);
    }

    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}
