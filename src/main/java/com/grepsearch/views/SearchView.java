package com.grepsearch.views;

import com.yammer.dropwizard.views.View;
import org.apache.solr.common.SolrDocumentList;

public class SearchView extends View {
    private SolrDocumentList solrDocuments;

    public String getMaker() {
        return maker;
    }

    public String maker = "nishant";

    public SearchView(String templateName) {
        super(templateName);
    }
    public SearchView(String templateName, SolrDocumentList solrDocuments) {
        super(templateName);
        this.solrDocuments = solrDocuments;
    }

    public SolrDocumentList getSolrDocuments() {
        return solrDocuments;
    }
}
