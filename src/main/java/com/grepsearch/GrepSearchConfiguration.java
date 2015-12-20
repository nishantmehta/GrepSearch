package com.grepsearch;

import com.grepsearch.config.SolrServerFactory;
import com.yammer.dropwizard.config.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class GrepSearchConfiguration extends Configuration {

    @Valid
    @NotNull
    @JsonProperty("solrserver")
    private SolrServerFactory solrConfig = new SolrServerFactory();

    public SolrServerFactory getSolrConfig() {
        return solrConfig;
    }

    public void setSolrConfig(SolrServerFactory solrConfig) {
        this.solrConfig = solrConfig;
    }
}
