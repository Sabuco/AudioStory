<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@include file="parts/head.html" %>
<%@include file="parts/nav.html" %>

<div class="container" style="margin-top:110px">
    <div class="list-group">
    <c:forEach items="${stories}" var="story">
        <a href="/story/${story.id}" class="list-group-item list-group-item-action">
            <div class="row">
                <div class="col-sm-2 col-md-2 col-xl-2">
                    <img id="imageSearch" src="${pageContext.request.contextPath}${story.cover}" alt="Cover">
                    <br>
                    <br>
                    <br>
                    <p>${story.category}</p>
                </div>
                <div class="col-sm-10 col-md-10 col-xl-10">
                    <h3>${story.title}</h3>
                    <h5>${story.sinopsis}</h5>
                    <p>${story.createdDate}</p>
                </div>
            </div>
        </a><br/>    
    </c:forEach>
    </div>
</div>
        <%@include file="parts/foot.html" %>



