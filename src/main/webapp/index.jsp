<%--
  Created by IntelliJ IDEA.
  User: luutien18195
  Date: 10/22/18
  Time: 10:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <style>
      *{
        margin: 0;
        padding: 0;
      }
      .wrapper{
        width: 240px;
        height: auto;
        margin: 100px auto;
      }
    </style>
  </head>
  <body>
  <div class="wrapper">
    <h2>Login</h2>
    <form action="login" method="post">

      <div class="form-group">
        <label for="username">User name</label>
        <input type="text" name="Username" id="username" placeholder="Enter your user name" class="form-control">
      </div>
      <div class="form-group">
        <label for="password">Password</label>
        <input type="password" name="Password" id="password" placeholder="Enter your password" class="form-control">
      </div>

      <%if(request.getAttribute("status")=="bg-danger")
      {
        out.print("<p class=\"text-danger\">"+request.getAttribute("message")+"</p>");
      }
      %>
      <button type="submit" class="btn btn-primary">Login</button>
    </form>
  </div>
  </body>
</html>
