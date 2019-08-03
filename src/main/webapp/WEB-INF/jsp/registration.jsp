

<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<%@include file="parts/head.html" %>
<%@include file="parts/nav.html" %>

<div class="container" style="margin-top:96px">
  
        <section class="text-center">

            <form:form class="form-main" method="POST" modelAttribute="userForm" action="${contextPath}/registration" >
                <img class="mb-4" src="${pageContext.request.contextPath}/images/LogoWebFondoTransparente.png" alt="" width="288px" height="288px"> 
                <h1 class="h3 mb-3 font-weight-normal">Crea tu cuenta</h1>  
                
                <div class="form-group  ${status.error ? 'has-error' : ''}">
                    <label for="username">Nombre de Usuario</label>
                    <input type="text" class="form-control" name="username" id="username" placeholder="Introduce tu nombre de usuario">
                    <form:errors path="username" style="color: red"></form:errors>
                </div>
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label for="password">Contraseña</label>
                    <input type="password" class="form-control" name="password" id="password" placeholder="Password">
                    <form:errors path="password" style="color: red"></form:errors>
                </div>
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label for="passwordConfirm">Confirmar contraseña</label>
                    <input type="password" class="form-control" name="passwordConfirm" id="passwordConfirm" placeholder="Password">
                    <form:errors path="passwordConfirm" style="color: red"></form:errors>
                </div>
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label for="nombre">Nombre</label>
                    <input type="text" class="form-control" name="name" id="name" placeholder="Introduce tu nombre">
                    <form:errors path="name" style="color: red"></form:errors>
                </div>

                 <div class="form-group">
                    <label for="email">Email</label>
                    <input type="text" class="form-control" name="email" id="email" placeholder="Email@ejemplo.com" pattern="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$">
                    <form:errors path="name" style="color: red"></form:errors>
                </div>
                
              
                <button type="submit" class="btn btn-primary">Registrarse</button>
            </form:form>

          </section>

 </div>

<%@include file="parts/foot.html" %>