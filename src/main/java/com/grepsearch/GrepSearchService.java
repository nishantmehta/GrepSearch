package com.grepsearch;

import com.grepsearch.healthcheck.GrepSearchHealthCheck;
import com.grepsearch.resource.GrepSearchResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import org.apache.solr.client.solrj.SolrServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class GrepSearchService extends Service<GrepSearchConfiguration> {
    private static final Logger log = LoggerFactory.getLogger(GrepSearchService.class);

    public static void main(String[] args) throws Exception {
        new GrepSearchService().run(args);
    }

    @Override
    public void initialize(Bootstrap<GrepSearchConfiguration> bootstrap) {
    }

    @Override
    public void run(GrepSearchConfiguration configuration, Environment environment) throws Exception {
        Optional<SolrServer> solrServer = configuration.getSolrConfig().getSolrServer();

        environment.addHealthCheck(new GrepSearchHealthCheck(configuration.getSolrConfig().getType()));
        environment.addResource(new GrepSearchResource(solrServer.get()));
    }
}
