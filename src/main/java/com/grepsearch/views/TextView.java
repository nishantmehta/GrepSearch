package com.grepsearch.views;

import com.yammer.dropwizard.views.View;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

public class TextView extends View{
    private String text;

    public TextView(String templateName,  SolrDocumentList text) {
        super(templateName);
        this.text = text.getNumFound() + "";
    }
    public String getText() {
        return text;
    }
}
