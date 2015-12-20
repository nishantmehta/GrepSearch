package com.grepsearch.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;
import org.apache.solr.client.solrj.SolrQuery;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;

import org.apache.solr.client.solrj.response.QueryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class GrepSearchResource  {

    private final SolrServer solrServer;
    private static final Logger log = LoggerFactory.getLogger(GrepSearchResource.class);

    public GrepSearchResource(SolrServer solrServer) {
        this.solrServer = solrServer;
    }
    @GET
    @Path("/getAllDocuments")
    public QueryResponse getAllDocuments() {

        try {
            SolrQuery query = new SolrQuery();
            query.setQuery("*:*");
            QueryResponse response = solrServer.query(query);
            log.info(response.toString());
            return response;

        } catch (SolrServerException e) {
            e.printStackTrace();
        }
        return new QueryResponse();
    }
}
