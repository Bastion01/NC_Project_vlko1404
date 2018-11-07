<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update user</title>
</head>

<body>
<div>
    <h1>Super app!</h1>
</div>

<div>
    <%
        if (request.getAttribute("userName") != null) {
            out.println("<p>User '" + request.getAttribute("userName") + "' updated!</p>");
        }
    %>
    <div>
        <div>
            <h2>Update user</h2>
        </div>
        <form method="post">
            <label>Name:
                <input type="text" name="name"><br />
            </label>
            <label>Password:
                <input type="password" name="pass"><br />
            </label>
            <label>Id:
                <input type="text" name="id"><br />
            </label>
            <button type="submit">Submit</button>


        </form>
    </div>
</div>

<div>
    <button onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>