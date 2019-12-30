<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/WEB-INF/views/common/header.jspf"%>
<%@ include file="/WEB-INF/views/common/navigation.jspf"%>
	<div class="container">
		<h2>New Role</h2>
		<form:form action="${pageContext.servletContext.contextPath}/role/save" method="post" modelAttribute="role">
			<table>
				<tr>
					<td>Name: </td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td>Power: </td>
					<td><form:input path="power" /></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="submit" value="Save"></td>
				</tr>						
			</table>
		</form:form>
	</div>

<%@ include file="/WEB-INF/views/common/footer.jspf"%>