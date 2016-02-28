package com.grepsearch.views;

import com.grepsearch.SearcherUtil.SearcherStatus;
import com.yammer.dropwizard.views.View;


public class SearcherStatusView extends View {

    private SearcherStatus searcherStatus;

    public SearcherStatusView(String templateName, SearcherStatus searcherStatus) {
        super(templateName);
        this.searcherStatus = searcherStatus;
    }

    public SearcherStatus getSearcherStatus() {
        return searcherStatus;
    }

}
