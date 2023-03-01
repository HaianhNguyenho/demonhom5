<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	.a{
		width: 160px; height: 200px; border: 1px solid black;
		padding: 5px; margin: 10px;
		float: left; text-align: center;
	}
	.hinh{
		width: 80px; height: 100px;
	}
</style>
<title>Product List</title>
</head>
<body>
	<p><a href="${pageContext.request.contextPath}/ShoppingCart.jsp">View Cart</a></p>
	<%-- <p><a href="/ShoppingCartJSPSessiion/ShoppingCart.jsp">View Cart</a></p> --%>

	
	<c:forEach items="${ds}" var="sp">
		<div class="a">
			<form action="${pageContext.request.contextPath}/CartController" name="modelDetail" method="post">
            <%-- /ShoppingCartJSPSessiion/CartController --%>
				${sp.model} <br>
				<img src='${pageContext.request.contextPath}/${sp.imgURL}' class='hinh'><br/>
				Price: ${sp.price} <br>
				<input type="text" size="2" value="1" name="quanlity"> <br>
				<input type="hidden" name="modelNo" value="${sp.id} "> 
				<input type="hidden" name="price" value="${sp.price}"> 
				<input type="hidden" name="description" value="${sp.model}"> 
				<input type="hidden" name="action" value="add"> 
				<input type="submit" name="addToCart" value="Add To Cart">
			</form>
		</div>
	</c:forEach>
</body>
</html>