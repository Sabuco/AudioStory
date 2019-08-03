<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<%@include file="parts/head.html" %>
<%@include file="parts/nav.html" %>

<div class="container" style="margin-top:96px">
  
        <section class="text-center">

            <form:form class="form-main" method="POST" modelAttribute="mailForm" action="${pageContext.request.contextPath}/newMail/${currentUserName}" >
                <img class="mb-4" src="${pageContext.request.contextPath}/images/LogoWebFondoTransparente.png" alt="" width="288px" height="288px"> 
                <h1 class="h3 mb-3 font-weight-normal">Envianos tu mensaje, <c:out value="${currentUserName}"/></h1>  
                

                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label for="reason">Asunto:</label>
                    <input type="text" class="form-control" name="reason" id="reason" path="reason" placeholder="Asunto...">
                    
                </div>

                <div class="form-group">
                    <label for="content">Mensaje:</label>
                    <textarea class="form-control" rows="5" id="content" name="content" path="content" placeholder="Escribe tu mensaje..."></textarea>
                </div>
                
              
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form:form>

          </section>

 </div>

<%@include file="parts/foot.html" %>