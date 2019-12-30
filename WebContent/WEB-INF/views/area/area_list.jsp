<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/WEB-INF/views/common/header.jspf"%>
<%@ include file="/WEB-INF/views/common/navigation.jspf"%>
<form:form>

	<div class="container">
		<h2>Area</h2>
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach items="${list}" var="area">
				<tr>
					<td>${area.id}</td>
					<td>${area.name}</td>
					<td><a href="${pageContext.servletContext.contextPath}/area/edit?id=${area.id}" class="btn btn-info">Edit</a>
					</td>
					<td><a href="${pageContext.servletContext.contextPath}/area/delete?id=${area.id}"
						class="btn btn-danger">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<a href="${pageContext.servletContext.contextPath}/area/new" class="btn btn-dark">Add</a>
	</div>

</form:form>

<%@ include file="/WEB-INF/views/common/footer.jspf"%>