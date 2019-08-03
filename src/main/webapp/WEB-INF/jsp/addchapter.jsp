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
          <h1>Escribiendo capitulo...</h1>
      <br>
  
        <br>
        <p>Recuerda escribir bien</p>
        <br>

        <form:form action="${pageContext.request.contextPath}/chapter/addchapter/${storyid}/${pageContext.request.userPrincipal.name}" method="post" modelAttribute="chapter">
          <spring:message code="lbl.title" text="Titulo" />
          <form:input path="title" class="form-control" />
          <form:errors path="title" cssClass="error" />
          
          <spring:message code="lbl.content" text="Contenido" />
          <form:textarea path="content" rows="10" class="form-control" />
          <form:errors path="content" cssClass="error" />

          <br>
          <button class="btn btn-success" type="submit" value="">Guardar</button> 
        </form:form>
      </div>
    </div>
  </div>

<%@include file="parts/foot.html" %>