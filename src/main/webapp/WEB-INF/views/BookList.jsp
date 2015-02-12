<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
 
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    <div class = "body">
    <div class="container">
        <div align="center">
	        <h1>Books List</h1>
	        <h2><a href="newBook">New Book</a></h2>
	        
      <table class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<th>No</th>
								<th>Bookname</th>
								<th>ISBN</th>
								<th>Author</th>
								<th>Actions</th>
								</tr>
						</thead>
						<tbody>
							<c:forEach var="book" items="${bookList}" varStatus="status">
								<tr>
									<td>${status.index + 1}</td>
									<td>${book.bookName}</td>
									<td>${book.bookISBN}</td>
									<td>${book.author}</td>
									<td>
									<a href="${pageContext.request.contextPath}/editBook?id=${book.bookId}">Edit</a>&nbsp;&nbsp;&nbsp;&nbsp;
									<a href="${pageContext.request.contextPath}/deleteBook?id=${book.bookId}">Delete</a>
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
						
						
						
						
					