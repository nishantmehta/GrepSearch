package com.grepsearch.resource;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.grepsearch.SearcherUtil.SearchRequest;
import com.grepsearch.views.SearchView;
import com.grepsearch.views.TextView;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Path("/")

public class GrepSearch {

    private final SolrServer solrServer;
    private static final Logger log = LoggerFactory.getLogger(GrepSearch.class);

    public GrepSearch(SolrServer solrServer) {
        this.solrServer = solrServer;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public SearchView getSearchPage() {
        return new SearchView("Search.ftl");
    }

    @POST
    @Produces(MediaType.TEXT_HTML)

    public SearchView getSearchPagePost(String body) {
        log.info(body);
        return new SearchView("Search.ftl");
    }

    @POST
    @Path("/search")
    @Produces(MediaType.TEXT_HTML)
    public SearchView search(@FormParam("query") String searchRequest) {
        log.debug("post body: " + searchRequest);
        QueryResponse response = null;
        try {
            SolrQuery query = new SolrQuery();
            query.setQuery(searchRequest);

            response = solrServer.query(query);
            log.info(response.toString());

        } catch (SolrServerException e) {
            e.printStackTrace();
        }
        ;
        return new SearchView("Search.ftl", response.getResults());
    }

}
