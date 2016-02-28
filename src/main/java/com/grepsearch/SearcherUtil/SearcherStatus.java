package com.grepsearch.SearcherUtil;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrResponse;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrDocumentList;

import javax.annotation.concurrent.Immutable;

@Immutable
public class SearcherStatus {
    private String solrHost;
    private long docCount;

    public String getSolrHost() {
        return solrHost;
    }

    public long getDocCount() {
        return docCount;
    }

    private SearcherStatus(String solrHost, long docCount) {
        this.solrHost = solrHost;
        this.docCount = docCount;
    }

    public static SearcherStatus getSearcherStatus(SolrServer solrServer) {
        SolrQuery query = new SolrQuery();
        query.setQuery("*:*");
        query.setRows(0);
        SolrDocumentList response = null;
        try {
            response = solrServer.query(query).getResults();
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
        return new SearcherStatus(solrServer.toString(), response.getNumFound());
    }


}
