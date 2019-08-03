<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.enfocat.audiolibro.*" %>
<%@page import="java.util.Date" %>

<%@include file="parts/head.html" %>
<%@include file="parts/nav.html" %>


<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
        <title>Subida de archivos a AudioStory</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" />
    </head>
    <body>
        <div class="container" style="margin-top:96px">
            <noscript>
                <h2>Sorry! Your browser doesn't support Javascript</h2>
            </noscript>
            <div class="upload-container">
                <div class="upload-header">
                    <h2>Subida de archivos a AudioStory</h2>
                </div>
                <div class="upload-content">
                    <div class="single-upload">
                        <h3>Sube tu archivo</h3>
                        <form id="singleUploadForm" action="${pageContext.request.contextPath}/uploadFile/${idstory}?${_csrf.parameterName}=${_csrf.token}" name="singleUploadForm" enctype="multipart/form-data" method="post">
                            <input id="singleFileUploadInput" type="file" name="file" class="file-input" required />
                            <button type="submit" class="primary submit-btn">Envia</button>
                        </form>
                        <div class="upload-response">
                            <div id="singleFileUploadError"></div>
                            <div id="singleFileUploadSuccess"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <input id="imgId" name="imgId" type="hidden" value="${story.id}">
            <script src="${pageContext.request.contextPath}/js/main.js" ></script>
    </body>
</html>
<%@include file="parts/foot.html" %>