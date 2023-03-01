<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:useBean id="cart" scope="session" class="com.gdu.k14dcpm02.beans.CartBean" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shopping Cart</title>
</head>
<body>
	<p>
		<a href="${pageContext.request.contextPath}/DSSP">Product List</a>
	</p>
	<table width="50%" border="1">
		<tr bgcolor="#cccccc">
			<td>Model Description</td>
			<td>Quanlity</td>
			<td>Unit Price</td>
			<td>Total</td>
		</tr>

		<c:if test="${cart.lineItemCount==0}">
			<tr>
				<td colspan="4">Cart is currently empty - <br></td>
			</tr>
		</c:if>
		<c:forEach var="cartItem" items="${cart.cartItems}"
			varStatus="counter">
			<form name="item" method="post" action="${pageContext.request.contextPath}/CartController"> 
				<tr>
					<td><c:out value="${cartItem.partNumber}"></c:out>><br><br>
						<c:out value="${cartItem.modelDescription}"></c:out></td>
					<td>
						<input type="hidden" name="itemIndex"
						value='<c:out value="${counter.count}"></c:out>'> 
						<input type="text" name="quanlity"
						value='<c:out value="${cartItem.quantity}"></c:out>'><br/>
						<input type="submit" name="action" value="Update"> 
						<input type="submit" name="action" value="Delete">
					</td>
					<td>$<c:out value="${cartItem.unitCost}"></c:out></td>
					<td>$<c:out value="${cartItem.totaCost}"></c:out></td>
				</tr>
			</form>
		</c:forEach>
		<tr>
			<td colspan="2"></td>
			<td></td>
			<td>Subtotal: $<c:out value="${cart.orderTotal }"></c:out></td>
		</tr>
	</table>
</body>
</html>