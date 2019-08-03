<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@include file="parts/head.html" %>
<%@include file="parts/nav.html" %>

<div class="container">

  <div class="row">
    <div class="col-md-6">
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <h1>Añadir comentarios:</h1>
      <br>

      <form:form action="${pageContext.request.contextPath}/comments/addcomment" method="post"
          modelAttribute="comments">
          <spring:message code="lbl.content" text="Descripcion" />
          <form:input path="content" class="form-control" />
          <form:errors path="content" cssClass="error" />

          <spring:message code="lbl.valoracion" text="Valoración(1-5) " />
          <form:input path="valoracion" class="form-control" />
          <form:errors path="valoracion" cssClass="error" />
          <!--  FALTA PASAR LOS VALORES -->
          <form:hidden path="chaptersid" value="${chapterid}" />
          <form:hidden path="name" value="${pageContext.request.userPrincipal.name}"/>

          <br>
          <button class="btn btn-success" type="submit" value="">Desar</button>
        </form:form>
    </div>
  </div>
</div>

<%@include file="parts/foot.html" %>