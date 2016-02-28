package com.grepsearch.SearcherUtil;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class SearchRequest {
    @Length(max = 100)
    private String query;

    public SearchRequest(String query) {
        this.query = query;
    }
    public SearchRequest() {}

    @Override
    public String toString() {
        return "SearchRequest{" +
                "query='" + query + '\'' +
                '}';
    }

    @JsonProperty
    public String getQuery() {
        return query;
    }
}
