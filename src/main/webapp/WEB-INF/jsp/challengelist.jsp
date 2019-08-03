<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@include file="parts/head.html" %>
<%@include file="parts/nav.html" %>

<div class="container" style="margin-top:96px">
    <br>
    <br>
    <br>
    <h1>Lista desafios</h1>
    <br>
    <p>Quieres probar tus habilidades como escritor?</p>
    <p>Si es asi prueba a aceptar algunos de los desafio aqui presentes y sorprende a la comunidad.</p>

    <table class="table">

        <tbody>
            <c:forEach items="${challenge}" var="challenge">
            <tr>
                <td><c:out value="${challenge.content}" /></td>
                <td><a href="/story/addStory/${challenge.id}">Añadir una historia al desafio</a></td>
            </tr>
            </c:forEach>
        </tbody>

    </table>
    <br/>

    <br>
    <p>Sientes que puedes añadir un desafio a la comunidad? <br>
        Hazlo en el siguiente enlace!</p>
    
        <a href="/challenges/addchallenge">Crear desafio</a>

</div>

<%@include file="parts/foot.html" %>