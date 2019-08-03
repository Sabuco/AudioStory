<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.enfocat.audiolibro.*" %>
<%@page import="java.util.Date" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@include file="parts/head.html" %>
<%@include file="parts/nav.html" %>

<div class="container" style="margin-top:96px">
        <form:form  method="POST" modelAttribute="storyForm">
            <img class="mb-4" src="/images/LogoWebFondoTransparente.png" alt="" width="288px" height="288px">
            <h1 class="h3 mb-3 font-weight-normal">Crea nueva historia</h1>

            <!-- PORTADA -->
            <%-- <label for="inputCover">Portada historia</label>
            <input type="file" class="form-control" 
                   id="inputCover"
                   accept=".jpg,.jpeg,.png" > --%>
            <!-- PORTADA -->
            
            <div class="form-group">
                <label for="inputTitle">Titulo</label>
                <input type="text" class="form-control" name="title" 
                       id="title" placeholder="Escribe el titulo de tu historia"
                       required th:field="*{title}">
            </div>

            <div class="form-group">
                <label for="inputSinopsis">Sinopsis</label>
                <input type="text" class="form-control" name="sinopsis" 
                       id="sinopsis" placeholder="Introduce la sinopsis"
                       required th:field="*{sinopsis}">
            </div>

            <div class="form-group">
                <label for="inputCategoria">Categoria</label>
                <form:select class="custom-select" name="category" id="category" path="category">
                    <!--<option selected="selected" value="NONE" >-- select an option --</option>-->
                    <option value="Terror">Terror</option>
                    <option value="Fantasia">Fantasía</option>
                    <option value="Romance">Romance</option>
                    <option value="Historica">Historica</option>
                    <option value="Ciencia Ficcion">Ciencia Ficción</option>
                    <option value="No-Ficcion">No-Ficción</option>
                    <option value="Western">Western</option>
                    <option value="Misterio">Misterio</option>
                    <option value="Policiaca">Policíaca</option>
                    <option value="Belica">Bélica</option>
                </form:select>
            </div>

            <button class="btn btn-success" type="submit" value="">Add Story</button>
        </form:form>
</div>

<%@include file="parts/foot.html" %>