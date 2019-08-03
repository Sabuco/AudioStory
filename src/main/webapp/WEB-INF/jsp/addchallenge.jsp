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
          <h1>Añadir desafios:</h1>
      <br>
  
        <br>
        <p>Recuerda a veces los mejores desafios son los mas cortos y simples!</p>
        <br>

        <form:form action="${pageContext.request.contextPath}/challenges/addchallenge" method="post" modelAttribute="challenges">
          <spring:message code="lbl.content" text="Descripcion" />
          <form:input path="content" class="form-control" />
          <form:errors path="content" cssClass="error" />
          <br>
          <button class="btn btn-success" type="submit" value="">Guardar</button> 
        </form:form>
      </div>
    </div>
  </div>

<%@include file="parts/foot.html" %>
