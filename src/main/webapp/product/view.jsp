<%--
  Created by IntelliJ IDEA.
  User: luutien18195
  Date: 10/23/18
  Time: 10:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        form{
            width:52%;
            margin:0 auto;
        }
        .wrapper{
            width: 55%;
            height: auto;
            margin:25px auto;
        }
        .wrapper  img{
            width: 330px;
        }
    </style>
</head>
<body>
<div class="wrapper">
    <form method="post" class="form-horizontal">
        <img src="${product.getImage()}" class="img-rounded img-responsive">
        <fieldset>
            <legend>Product information</legend>
            <table class="table table-striped">
                <tr>
                    <td>ID: </td>
                    <td>${requestScope["product"].getId()}</td>
                </tr>
                <tr>
                    <td>Name: </td>
                    <td>${requestScope["product"].getName()}</td>
                </tr>
                <tr>
                    <td>Description: </td>
                    <td>${requestScope["product"].getDescription()}</td>
                </tr>
                <tr>
                    <td>Type: </td>
                    <td>${requestScope["product"].getType()}</td>
                </tr>
                <tr>
                    <td>Date: </td>
                    <td>${requestScope["product"].getDateProduction()}</td>
                </tr>
                <tr>
                    <td></td>
                    <td><a href="/products" class="btn btn-primary">Back to product list</a></td>
                </tr>
            </table>
        </fieldset>
    </form>
</div>
</body>
</html>
