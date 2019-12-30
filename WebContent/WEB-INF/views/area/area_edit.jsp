<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/WEB-INF/views/common/header.jspf"%>
<%@ include file="/WEB-INF/views/common/navigation.jspf"%>
	<div class="container">
		<h2>Edit Area</h2>
		<form:form action="save" method="post" modelAttribute="area">
			<table>
				<tr>
					<td>ID: </td>
					<td>${area.id}
						<form:hidden path="id"/>
					</td>
				</tr>			
				<tr>
					<td>Name: </td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Save"></td>
				</tr>						
			</table>
		</form:form>
	</div>
<%@ include file="/WEB-INF/views/common/footer.jspf"%>