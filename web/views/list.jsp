<%@ page import="java.util.List" %>
<%@ page import="app.entities.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>

<body>
<div>
    <h1>Super app!</h1>
</div>

<div>
    <div>
        <div>
            <h2>Users</h2>
        </div>
        <%
            List<User> users = (List<User>)request.getAttribute("userNames");
            if (users != null && !users.isEmpty()) {
                out.println("<table>");
                for (User s : users) {
                    out.println("<tr>");
                    out.println("<td>"+s.getId()+"</td>");

                    out.println("<td>"+s.getName()+"</td>");
                    out.println("<td>"+s.getPassword()+"</td>");
                    out.println("<td>"+"<form action=\"/delete\" method=\"post\">\n" +
                            "        <button type=\"submit\">Delete</button>\n" +
                            "    </form>"+"</td>");

                    out.println("<td>"+"<form action=\"/update\" method=\"post\">\n" +
                            "        <button type=\"submit\">Update</button>\n" +
                            "    </form>"+ "</td>");
                    out.println("</tr>");
                }
                out.println("</table>");
            } else out.println("<p>There are no users yet!</p>");

           /* List<String> names = (List<String>) request.getAttribute("userNames");

            if (names != null && !names.isEmpty()) {
                out.println("<ui>");
                for (String s : names) {
                    out.println("<li>" + s + "</li>");
                }
                out.println("</ui>");
            } else out.println("<p>There are no users yet!</p>");*/
        %>
    </div>
</div>

<div>

    <button onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>