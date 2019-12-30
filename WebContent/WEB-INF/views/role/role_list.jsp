<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/WEB-INF/views/common/header.jspf"%>
<%@ include file="/WEB-INF/views/common/navigation.jspf"%>
<form:form>

	<div class="container">
		<h2>Role</h2>
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Power</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach items="${list}" var="role">
				<tr>
					<td>${role.id}</td>
					<td>${role.name}</td>
					<td>${role.power}</td>
					<td><a href="${pageContext.servletContext.contextPath}/role/edit?id=${role.id}" class="btn btn-info">Edit</a>
					</td>
					<td><a href="${pageContext.servletContext.contextPath}/role/delete?id=${role.id}"
						class="btn btn-danger">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<a href="${pageContext.servletContext.contextPath}/role/new" class="btn btn-dark">Add</a>
	</div>

</form:form>

<%@ include file="/WEB-INF/views/common/footer.jspf"%>