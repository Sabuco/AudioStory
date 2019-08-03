<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@include file="parts/head.html" %>
<%@include file="parts/nav.html" %>

<div class="container" style="margin-top:96px">
    <br>
    <br>
    <br>


    <div>

        <h2>${chapter.title}</h2>

        <br>

        <div class="capitule">
            <p id="cosita">${chapter.getContent()}</p>
        </div>
        
        <div>
            <button type="button" onclick="parla()" class="btn btn-outline-secondary">Reproducir el
                Audio</button>
            <button type="button" onclick="responsiveVoice.pause()" class="btn btn-outline-secondary">Pausar el
                Audio</button>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12 col-sm-12">
            
            <br>
            <br>
            <h3>Añade tu propio audio</h3>
            <c:choose>
                <c:when test="${chapter.fileaudio != null}">
                    <audio controls>
                        <source src="${pageContext.request.contextPath}${chapter.fileaudio}" type="audio/mpeg">
                        Your browser does not support the audio element.
                    </audio>
                    <br>
                    <br>
                    <a class="btn btn-outline-success" href="${pageContext.request.contextPath}/uploadAudio/${chapter.id}" role="button">Editar audio</a>
                </c:when> 

                <c:otherwise>
                    <a class="btn btn-outline-success" href="${pageContext.request.contextPath}/uploadAudio/${chapter.id}" role="button">Añadir audio</a>
                </c:otherwise>

            </c:choose>
        </div>


        <div class="col-md-12 col-sm-12">
            <br>
            <br>
            <h3>Añadir comentario y valoración</h3>
            <br>
         <a class="btn btn-outline-success" href="/comments/addcomment/${chapter.id}" role="button">Comentar</a>
        </div>

    </div>

    <br>

    <h2>Comentarios</h2>

    <c:forEach items="${comments}" var="comments">
            <div>
                <h5><c:out value="${comments.name}" /></h5>
                <p><c:out value="${comments.content}" /></p>
            </div>
    </c:forEach>

</div>

<%@include file="parts/foot.html" %>
<script src="https://code.responsivevoice.org/responsivevoice.js?key=CGwXwaTU"></script>

<script>
    function parla() {
        cosa = $("#cosita").text();
       
        responsiveVoice.speak(cosa, "Spanish Male", { rate: 1 }, { volume: 1 }, { pitch: 3 });
        responsiveVoice.setTextReplacements([{
            searchvalue: "robot",
            newvalue: "human"
        }]);
    }
</script>