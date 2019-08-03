<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@include file="parts/head.html" %>
<%@include file="parts/nav.html" %>

<div class="container" style="margin-top:96px">
    <br>
    <br>
    <br>
    <h1>${user.username}</h1>
    <br>


    <div class="row">

        <div class="col-md-4">
            <h5>Nombre</h5>
            <label>${user.getName()}</label>
        </div>

    </div>

    <table class="table">
            <thead>
                <tr>
                    <th>Nombre historia</th>
                    <th>Num Capitulo</th>
                    <th>Titulo Capitulo</th>
                </tr>
            </thead>
    
            <tbody>
                <c:forEach items="${chapters}" var="chapter">
                <tr>
                    <td><c:out value="${chapter.getStory().getTitle()}" /></td>
                    <td><c:out value="${chapter.chapternum}" /></td>
                    <td><c:out value="${chapter.title}" /></td>
                    
                </tr>
                </c:forEach>
            </tbody>
    
    </table>

</div>

<%@include file="parts/foot.html" %>