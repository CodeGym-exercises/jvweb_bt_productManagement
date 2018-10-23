<%--
  Created by IntelliJ IDEA.
  User: luutien18195
  Date: 10/23/18
  Time: 12:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create product</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        .wrapper{
            width: 50%;
            height: auto;
            margin: 25px auto;
        }
        .wrapper  img{
            width: 100px;
        }
        .wrapper .box{
            width:90%;
            margin:0 auto;
        }
        .wrapper .box input[type="text"]{
            width: 58%;
        }
    </style>
</head>
<body>
<div class="wrapper">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="nvbar-header">
                <a href="/products" class="navbar-brand">Go back</a>
            </div>
        </div>
    </nav>

    <div class="box">
        <form method="post" class="form-horizontal">

            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">Name</label>
                <div class="col-sm-10">
                    <input type="text" name="name" id="name" placeholder="${requestScope["product"].getName()}" class="form-control">
                </div>

            </div>
            <div class="form-group">
                <label for="description" class="col-sm-2 control-label">Description</label>
                <div class="col-sm-10">
                    <input type="text" name="description" id="description" placeholder="${requestScope["product"].getDescription()}" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label for="type" class="col-sm-2 control-label">Type</label>
                <div class="col-sm-10">
                    <input type="text" name="type" id="type" placeholder="${requestScope["product"].getType()}" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label for="dateproduction" class="col-sm-2 control-label">Date</label>
                <div class="col-sm-10">
                    <input type="text" name="dateproduction" id="dateproduction" placeholder="${requestScope["product"].getDateProduction()}" class="form-control">
                </div>
            </div>

            <c:if test='${requestScope["message"]!=null}'>
                <div class="alert alert-${requestScope["status"]}" role="alert">
                    <p class="text-${requestScope["status"]}">${requestScope["message"]}</p>
                </div>

            </c:if>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-primary">Create</button>
                </div>
            </div>

        </form>
    </div>

</div>
</body>
</html>
