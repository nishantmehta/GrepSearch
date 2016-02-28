package com.grepsearch.resource;


import com.grepsearch.SearcherUtil.SearcherStatus;
import com.grepsearch.views.SearcherStatusView;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/admin")
public class GrepSearchAdmin {
    private final SolrServer solrServer;
    private static final Logger log = LoggerFactory.getLogger(GrepSearchAdmin.class);

    public GrepSearchAdmin(SolrServer solrServer) {
        this.solrServer = solrServer;
    }

    @Path("/searcherStatus")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public SearcherStatusView getSearcherStatus() {
        return new SearcherStatusView("SearchAdmin.ftl", SearcherStatus.getSearcherStatus(solrServer));
    }

    @GET
    @Path("/getAllDocuments")
    @Produces(MediaType.APPLICATION_JSON)
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
