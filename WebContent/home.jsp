<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lezzayer</title>
</head>
<body>

<c:forEach var="article" items="${articles}">
<strong>${article.webSiteName} :</strong> ${article}
<br><br>
</c:forEach>
 
</body>
</html>