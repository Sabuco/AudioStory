<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.enfocat.audiolibro.*" %>
<%@page import="java.util.Date" %>

<%@include file="parts/head.html" %>
<%@include file="parts/nav.html" %>


<div class="container" style="margin-top:96px">
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>

    <c:choose>
        <c:when test="${size != 0}">

            <h1>Stories</h1>
            <br>

            <div class="jumbotron">
                <h2>Los más leídos de todos los tiempos</h2>

            </div>

            <div class="row">
                <div class="col-md-4">
                    <img src="${story1.cover}" width="195" height="120">
                    <h2><a href="${pageContext.request.contextPath}/story/${story1.id}"> ${story1.title}</a></h2>
                    <br>
                    <p>${story1.sinopsis}</p>
                </div>

                <div class="col-md-4">
                    <img src="${story2.cover}" width="195" height="120">
                    <h2><a href="${pageContext.request.contextPath}/story/${story2.id}"> ${story2.title}</a></h2>
                    <br>
                    <p>${story2.sinopsis}</p>
                </div>

                <div class="col-md-4">
                    <img src="${story3.cover}" width="195" height="120">
                    <h2><a href="${pageContext.request.contextPath}/story/${story3.id}"> ${story3.title}</a></h2>
                    <br>
                    <p>${story3.sinopsis}</p>
                </div>
            </div>


            <!-- los más leídos este mes-->
            <div class="jumbotron">
                <h2>Los más leídos este mes</h2>

            </div>

            <div class="row">
                <div class="col-md-4">
                    <img src="${story1.cover}" width="195" height="120">
                    <h2><a href="${pageContext.request.contextPath}/story/${story1.id}"> ${story1.title}</a></h2>
                    <br>
                    <p>${story1.sinopsis}</p>
                </div>

                <div class="col-md-4">
                    <img src="${story2.cover}" width="195" height="120">
                    <h2><a href="${pageContext.request.contextPath}/story/${story2.id}"> ${story2.title}</a></h2>
                    <br>
                    <p>${story2.sinopsis}</p>
                </div>

                <div class="col-md-4">
                    <img src="${story3.cover}" width="195" height="120">
                    <h2><a href="${pageContext.request.contextPath}/story/${story3.id}"> ${story3.title}</a></h2>
                    <br>
                    <p>${story3.sinopsis}</p>
                </div>
            </div>

            <!-- los más leídos este mes-->
            <div class="jumbotron">
                <h2>Los más leídos esta semana</h2>
            </div>

            <div class="row">
                <div class="col-md-4">
                    <img src="${story1.cover}" width="195" height="120">
                    <h2><a href="${pageContext.request.contextPath}/story/${story1.id}"> ${story1.title}</a></h2>
                    <br>
                    <p>${story1.sinopsis}</p>
                </div>

                <div class="col-md-4">
                    <img src="${story2.cover}" width="195" height="120">
                    <h2><a href="${pageContext.request.contextPath}/story/${story2.id}"> ${story2.title}</a></h2>
                    <br>
                    <p>${story2.sinopsis}</p>
                </div>

                <div class="col-md-4">
                    <img src="${story3.cover}" width="195" height="120">
                    <h2><a href="${pageContext.request.contextPath}/story/${story3.id}"> ${story3.title}</a></h2>
                    <br>
                    <p>${story3.sinopsis}</p>
                </div>
            </div>

        </c:when>
        <c:otherwise>

            <h1>No hay historias</h1>

        </c:otherwise>
    </c:choose>

</div>

<%@include file="parts/foot.html" %>
<script src="https://code.responsivevoice.org/responsivevoice.js?key=CGwXwaTU"></script>
<script>
    function parla() {
        cosa = $("#cosa").text();
        console.log(cosa);
        responsiveVoice.speak(cosa, "Catalan Male", { rate: 0.4 }, { volume: 1 }, { pitch: 5 });
        responsiveVoice.setTextReplacements([{
            searchvalue: "robot",
            newvalue: "human"
        }]);
    }
</script>

<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
<script>
    var current = 0;
    var imagenes = new Array();

    $(document).ready(function () {
        var numImages = 6;
        if (numImages <= 3) {
            $('.right-arrow').css('display', 'none');
            $('.left-arrow').css('display', 'none');
        }

        $('.left-arrow').on('click', function () {
            if (current > 0) {
                current = current - 1;
            } else {
                current = numImages - 3;
            }

            $(".carrusel").animate({ "left": -($('#product_' + current).position().left) }, 600);

            return false;
        });

        $('.left-arrow').on('hover', function () {
            $(this).css('opacity', '0.5');
        }, function () {
            $(this).css('opacity', '1');
        });

        $('.right-arrow').on('hover', function () {
            $(this).css('opacity', '0.5');
        }, function () {
            $(this).css('opacity', '1');
        });

        $('.right-arrow').on('click', function () {
            if (numImages > current + 3) {
                current = current + 1;
            } else {
                current = 0;
            }

            $(".carrusel").animate({ "left": -($('#product_' + current).position().left) }, 600);

            return false;
        });
    });
</script>