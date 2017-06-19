<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<c:if test="${fn:length(foundOrders) > 0}">
			<c:forEach items="${foundOrders}" var="order">
				<c:if test="${not empty order } ">
					<tr>
						<td>${order.orderType}</td>
						<td>${order.address}</td>
						<td>${order.completed}</td>
						<td>InnitDate: ${order.innitDate}</td>
						<td>DeliveryDate: ${order.deliveryDate}</td>
						<td>NumberOfProducts: ${order.orderLis.size}</td>
					</tr>
				</c:if>
			</c:forEach>
		</c:if>
		<c:if test="${fn:length(foundOrders) > 0}">
		<tr>
		<td>No records found</td>
		</tr>
		</c:if>
	</table>
</body>
</html>