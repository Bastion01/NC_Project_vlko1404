<%@ page import="java.util.List" %>
<%@ page import="app.entities.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users and jobs</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>Super app!</h1>
</div>
<%--stroka--%>
<%%>
<div class="w3-container w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-green">
            <h2>Users and jobs</h2>
        </div>
        <%
            List<User> users = (List<User>)request.getAttribute("joinNames");
            if (users != null && !users.isEmpty()) {
                out.println("<table class=\"w3-table w3-striped w3-border\"");
                out.println("<tr >");
                out.println("<td>"+"User Name"+"</td>");
                out.println("<td>"+"Company name"+"</td>");
                out.println("<td>"+"Company rating"+"</td>");
                out.println("</tr>");
                out.println("<tr >");
                out.println("<td> </td>");
                out.println("</tr >");
                for (User s : users) {
                    out.println("<tr >");
                    out.println("<td>"+s.getName()+"</td>");


                    out.println("<td>"+s.getCompany().getName()+"</td>");
                    out.println("<td>"+s.getCompany().getRating()+"</td>");

                    out.println("</tr>");
                }
                out.println("</table>");
            } else out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n"
                    +
                    "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                    "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">×</span>\n" +
                    "   <h5>There are no users yet!</h5>\n" +
                    "</div>");


        %>

    </div>
</div>

<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">

    <button class="w3-btn w3-round-large" onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>