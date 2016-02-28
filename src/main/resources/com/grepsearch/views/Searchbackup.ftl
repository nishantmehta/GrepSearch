<#-- @ftlvariable name="" type="com.grepsearch.views.SearchView" -->


<html>
    <body>
    Search box:
    <form  action="javascript:loadDoc();" method="post" id="searchform">
        <input type="text" name="query" id="searchbox">
        <button type="submit">Submit</button>
    </form>

    <script>
        function loadDoc() {
            var xhttp = new XMLHttpRequest();

            xhttp.open("POST", "/search", true);
            xhttp.setRequestHeader("Content-type", "application/json");
            xhttp.onreadystatechange = function() {
                if (xhttp.readyState == 4 && xhttp.status == 200) {
                    document.open();
                    console.log(xhttp.responseText);
                    document.write(xhttp.responseText);
                    document.close();
                }
            };
            var text = '{"query":" '+ document.getElementById('searchbox').value +'"}'
            xhttp.send(text);

        }
    </script>

    </body>
</html>