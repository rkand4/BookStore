<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="body">
			<div class="container">
				<div align="center">
					<h1>Customer List</h1>
					<h2>
						<a href="${pageContext.request.contextPath}/newCustomer">Add Customer</a>
					</h2>

					<table class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<th>S.No</th>
								<th>Customer ID</th>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Contact Num</th>
								
						</thead>
						<tbody>
							<c:forEach var="customer" items="${customerList}" varStatus="status">
								<tr>
									<td>${status.index + 1}</td>
									<td>${customer.customerId}</td>
									<td>${customer.firstName}</td>
									<td>${customer.lastName}</td>
									<td>${customer.contactNum}</td>
									<td>
									<a href="${pageContext.request.contextPath}/editCustomer?id=${customer.customerId}">Edit</a>&nbsp;&nbsp;&nbsp;&nbsp;
									<a href="${pageContext.request.contextPath}/deleteCustomer?id=${customer.customerId}">Delete</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>

					</table>
				</div>
			</div>
		</div>

	</tiles:putAttribute>
</tiles:insertDefinition>
