<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@include file="parts/head.html" %>
<%@include file="parts/nav.html" %>

<div class="container" style="margin-top:96px">
    <br>
    <br>
    <br>
    <h1>${story.title}</h1>
    <br>


    <div class="row">

        <div class="col-md-4">
            <a href="${pageContext.request.contextPath}/uploadIn/${story.id}">
                <div class="view overlay">
                    <img id="imageStory" src="${pageContext.request.contextPath}${story.cover}" class="img-fluid"
                        alt="Cover">
                    <i class="fas fa-edit"></i>
                </div>
            </a>
        </div>

        <div class="col-md-4">
            <h5>Sinopsis</h5>
            <c:out value="${story.sinopsis}" />
        </div>

    </div>

    <br>

    <a class="btn btn-outline-primary" href="${pageContext.request.contextPath}/chapter/addchapter/${story.id}">Crear
        capitulo</a>

    <br><br><br>

    <table class="table">
        <thead>
            <tr>
                <th>Num Cap</th>
                <th>Nombre</th>
                <th>Autor</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach items="${capitulos}" var="capitulos">
                <tr>
                    <td>
                        <c:out value="${capitulos.chapternum}" />
                    </td>
                    <td><a class="nav-link"
                            href="${pageContext.request.contextPath}/chapter/${capitulos.id}">${capitulos.title}</a>
                    </td>
                    <td>
                        <c:out value="${capitulos.user.getUsername()}" />
                    </td>

                </tr>
            </c:forEach>
        </tbody>

    </table>
    <br />

</div>

<%@include file="parts/foot.html" %>