<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/WEB-INF/views/common/header.jspf"%>
<%@ include file="/WEB-INF/views/common/navigation.jspf"%>
<form:form>

	<div class="container">
		<h2>Customer Manager</h2>
		<form method="get" action="search">
			<input type="text" name="keyword" /> &nbsp; <input type="submit"
				value="Search" />
		</form>
		<h3>
			<a href="new">New Customer</a>
		</h3>
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>E-mail</th>
				<th>Address</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${listCustomer}" var="customer">
				<tr>
					<td>${customer.id}</td>
					<td>${customer.name}</td>
					<td>${customer.email}</td>
					<td>${customer.address}</td>
					<td><a href="edit?id=${customer.id}">Edit</a>
						&nbsp;&nbsp;&nbsp; <a href="delete?id=${customer.id}"
						class="btn btn-danger">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

</form:form>



<%@ include file="/WEB-INF/views/common/footer.jspf"%>