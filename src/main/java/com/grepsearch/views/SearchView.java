package com.grepsearch.views;

import com.yammer.dropwizard.views.View;
import org.apache.solr.common.SolrDocumentList;

public class SearchView extends View {
    private SolrDocumentList solrDocuments;
    private long numFound;

    public long getNumFound() {
        return numFound;
    }

    public SearchView(String templateName) {
        super(templateName);
    }
    public SearchView(String templateName, SolrDocumentList solrDocuments) {
        super(templateName);
        this.solrDocuments = solrDocuments;
        numFound = solrDocuments.getNumFound();
    }

    public SolrDocumentList getSolrDocuments() {
        return solrDocuments;
    }
}
