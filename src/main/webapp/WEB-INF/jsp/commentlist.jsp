<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@include file="parts/head.html" %>
<%@include file="parts/nav.html" %>

<div class="container" style="margin-top:96px">
    <br>
    <br>
    <br>
    <h1>List comments</h1>
    <br>


    <table class="table">

        <tbody>
            <tr>

                <th>Comentario</th>
                <th>Valoracion</th>
                <th>Id. Chapter</th>
                <th>Id. User</th>
            </tr>
            <c:forEach items="${comment}" var="comment">
                <tr>


                    <td>
                        <c:out value="${comment.content}" />
                    </td>
                    <td>
                        <c:out value="${comment.valoracion}" />
                    </td>
                    <td>
                        <c:out value="${comment.chaptersid}" />
                    </td>
            
                    <td>   <c:out value="${comment.usersid}" />  </td>

                </tr>
            </c:forEach>
        </tbody>

    </table>
    <br />

    <br>
<!--   <a class="btn btn-secondary" href="/chapter/read" role="button"> Atrás </a>--> 
</div>

        <%@include file="parts/foot.html" %>