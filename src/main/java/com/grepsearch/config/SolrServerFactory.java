package com.grepsearch.config;

import javax.validation.constraints.NotNull;
import com.yammer.dropwizard.config.Configuration;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.CommonsHttpSolrServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.util.Optional;

public class SolrServerFactory extends Configuration{

    @NotNull
    private String type;
    @NotNull
    private String host;
    @NotNull
    private String core;
    @NotNull
    private int port;

    private static final Logger log = LoggerFactory.getLogger(SolrServerFactory.class);

    private SolrServer solrServer = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getCore() {
        return core;
    }

    public void setCore(String core) {
        this.core = core;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Optional<SolrServer> getSolrServer() {
        if (!getType().equalsIgnoreCase("solr")) {
            return Optional.empty();
        }
        if(solrServer == null) {
            try {
                solrServer = new CommonsHttpSolrServer(getSolrHostURL());
                log.info("Created solr server with URL: " + getSolrHostURL());
            } catch (MalformedURLException e) {
                log.warn(e.getMessage());

            }
        }
        return Optional.of(solrServer);
    }

    public String getSolrHostURL() {
        return "http://" + getHost() + ":"
                + getPort() + "/solr/" + getCore();
    }
}
