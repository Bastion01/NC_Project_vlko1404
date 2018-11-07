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
            out.println("<p>This user was updated!</p>");
        }
    %>
    <div>
        <div>
            <h2>Update user</h2>
        </div>
        <form method="post">
            <label>Name:
                <input type="text" name="name" value="New Name"><br />
            </label>
            <label>Password:
                <input type="password" name="pass" value="New Password"><br />
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