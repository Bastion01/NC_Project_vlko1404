<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update user</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>Super app!</h1>
</div>

<div class="w3-container w3-padding">
    <%
        if (request.getAttribute("companyName") != null) {
            out.println("<div class=\"w3-panel w3-green w3-display-container w3-card-4 w3-round\">\n" +
                    "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                    "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey\">×</span>\n" +
                    "   <h5>This company updated!</h5>\n" +
                    "</div>");
        }
        else if(request.getAttribute("userName") == null)
        {
            out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n" +
                    "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                    "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey\">×</span>\n" +
                    "   <h5>Please, fill in form fields...</h5>\n" +
                    "</div>");
        }
    %>
    <%%>
    <div class="w3-card-4">
        <div class="w3-container w3-green">
            <h2>Update company</h2>
        </div>
        <%--stroka--%>

        <form method="post" class="w3-selection w3-light-grey w3-padding">
            <label>Name:
                <input class="w3-input" type="text" name="name" ><br />
            </label>
            <label>Workers number:
                <input class="w3-input" type="text" name="workers_number" ><br />
            </label>
            <label>Rating:
                <input class="w3-input" type="text" name="rating"><br />
            </label>
            <button class="w3-input" type="submit">Submit</button>
        </form>
    </div>
</div>
<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>