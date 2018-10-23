<%@ page import="com.codegym.model.Product" %><%--
  Created by IntelliJ IDEA.
  User: luutien18195
  Date: 10/22/18
  Time: 1:40 PM
  To change this template use File | Settings | File Templates.

--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Products</title>
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
        .wrapper{
            width: 75%;
            height: auto;
            margin:25px auto;
        }
        .wrapper  img{
            width: 100px;
        }
    </style>
</head>
<body>
    <div class="wrapper">

        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="nvbar-header">
                    <a href="/products?action=create" class="navbar-brand">Create new product</a>
                </div>

                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/index.jsp" class="navbar-brand">Logout</a></li>
                </ul>

                <form class="navbar-form navbar-right" role="search" method="post" action="products">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search" name="search">
                        <input type="hidden" name="action" value="find">
                    </div>
                    <button type="submit" class="btn btn-default">Submit</button>
                </form>

            </div>
        </nav>

        <table class="table table-striped">
            <tr>
                <th>#</th>
                <th>Images</th>
                <th>Name</th>
                <th>Description</th>
                <th>Type</th>
                <th>Date Production</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>

            <c:forEach items='${requestScope["products"]}' var="product">
                <tr>
                    <td>${product.getId()}</td>
                    <td><img src="${product.getImage()}" class="img-rounded img-responsive"></td>
                    <td><a href="/products?action=view&id=${product.getId()}">${product.getName()}</a></td>
                    <td>${product.getDescription()}</td>
                    <td>${product.getType()}</td>
                    <td>${product.getDateProduction()}</td>
                    <td><a href="/products?action=edit&id=${product.getId()}"> Edit</a></td>
                    <td><a href="/products?action=delete&id=${product.getId()}"> Delete</a></td>
                </tr>
            </c:forEach>
        </table>

    </div>

</body>
</html>
