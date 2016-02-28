<#-- @ftlvariable name="" type="com.grepsearch.views.SearcherStatusView" -->

<html>
    <body>
        <h1> Solr server : ${searcherStatus.solrHost?html} </h1>
        <h1> Document Count: ${searcherStatus.docCount?html}</h1>
    </body>
</html>