<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Lezzayer</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap-theme.min.css">


</head>
<body>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://code.jquery.com/jquery.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Lezzayer</a>
        </div>
      </div>
</div>

<div class="jumbotron">
      <div class="container">
        <h3>${articles[0].title}<small> ${articles[0].webSiteName} - ${articles[0].articleDate}</small></h3>
        <p>${articles[0].textPreview}</p>
        <p><a class="btn btn-primary btn-lg" href="${articles[0].articleUrl}" role="button" target="_blank">Lire plus »</a></p>
      </div>
    </div>

<div class="container">
      <!-- Example row of columns -->
      <div class="row">
      <c:forEach var="article" items="${articles}" begin="1">
        <div class="col-md-4">
          <h4>${article.title}<small> ${article.webSiteName} - ${article.articleDate}</small></h4>
          <p>${article.textPreview}</p>
          <p><a class="btn btn-default" href="${article.articleUrl}" role="button" target="_blank">Voir plus »</a></p>
        </div>
        </c:forEach>
      </div>
      
      <hr>

      <footer>
        <p>© Lezzayer 2014</p>
      </footer>
</div>

 
</body>
</html>