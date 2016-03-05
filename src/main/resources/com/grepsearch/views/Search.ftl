<#-- @ftlvariable name="" type="com.grepsearch.views.SearchView" -->
<html>
<head>
    <title>GREP search</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/assets.css" href="reset.css">
    <link rel="stylesheet" type="text/assets.css" href="/assets/css/style.css">
</head>
<body>
<div id="container">
    <!-- header -->
    <header id="header">
`        <h1 id="title">Grep search</h1>
        <form id="searchbox" action="/search" method="post">
            <input id="query" name="query" type="search" placeholder="search">
            <button type="submit">Submit</button>
        </form>
    </header>
    <!-- Main Content area -->
    <section id="content">

        <#if solrDocuments??>
        <h1> solr document count is ${numFound}</h1>
        <ul>
        <#list solrDocuments as docs>
        <section id="result">
            <li>

            <#if docs["body_txt"]??>
            <#if docs["body_txt"]?is_enumerable> ${docs["body_txt"][0]} <#else>${docs["body_txt"]} </#if>
            </#if>
            </if>
            </li>

        </section>
            <hr>
        </#list>
        </ul>
        </#if>

        <!-- Main content -->
    </section>
    <!-- Sidebar -->
    <aside  id="sidebar">
        <h3>lets show facets or features over here</h3>
        <!-- Sidebar content -->
    </aside>
</div>
</body>
</html>