<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<%@include file="parts/head.html" %>
<%@include file="parts/nav.html" %>


<div class="container" style="margin-top:96px">
  
        <section class="text-center">

                <div class="container">
                        <form method="POST" action="${contextPath}/login" class="form-main">
                        <img class="mb-4" src="${pageContext.request.contextPath}/images/LogoWebFondoTransparente.png" alt="" width="288px" height="288px">
                          <h2 class="h3 mb-3 font-weight-normal">Inicia sesi&oacute;n</h2>
                  
                          <div class="form-group ${error != null ? 'has-error' : ''}">
                              <span style="color: red">${message}</span>
                              <input name="username" type="text" class="form-control" placeholder="Nombre de usuario"
                                     autofocus="true"/>
                              <br>
                              <input name="password" type="password" class="form-control" placeholder="Contrase&ntilde;a"/>
                              <span style="color: red">${error}</span>
                              <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                              <br>
                              <br>
                              <button class="btn btn-lg btn-primary btn-block" type="submit">Entra</button>
                              <br>
                              <h4 class="text-center"><a href="${contextPath}/registration">Crear una cuenta</a></h4>
                          </div>
                        </form>
                      </div>
        </section>

     </div>
<%@include file="parts/foot.html" %>

 