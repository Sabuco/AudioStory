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

    <h1>Stories</h1>
    <br>

    <div id="carrusel">
        <a href="#" class="left-arrow"><img src="/images/left-arrow.png" alt="" width="20px" height="20px" /></a>
        <a href="#" class="right-arrow"><img src="/images/right-arrow.png" alt="" width="20px" height="20px" /></a>
        <div class="carrusel">


            <c:forEach items="${storiesToShow}" var="story" begin="0" end="2">
                <div class="product">
                    <img src="${story.cover}" width="195" height="100" />
                    <h5>${story.title}</h5>
                    <p>${story.category}</p>
                </div>
            </c:forEach>



            <!--<div class="product" id="product_0">
                <img src="/images/prueba.jpg" width="195" height="100" />
                <h5>Lorem ipsum 1</h5>
                <p>Terror</p>
            </div>
            <div class="product" id="product_1">
                <img src="/images/lechera2.jpg" width="195" height="100" />
                <h5>Lorem ipsum 2</h5>
                <p>Terror</p>
            </div>
            <div class="product" id="product_2">
                <img src="/images/prueba.jpg" width="195" height="100" />
                <h5>Lorem ipsum 3</h5>
                <p>Terror</p>
            </div>
            <div class="product" id="product_3">
                <img src="/images/lechera3.jpg" width="195" height="100" />
                <h5>Lorem ipsum 4</h5>
                <p>Terror</p>
            </div>
            <div class="product" id="product_4">
                <img src="/images/prueba.jpg" width="195" height="100" />
                <h5>Lorem ipsum 5</h5>
                <p>Terror</p>
            </div>
            <div class="product" id="product_5">
                <img src="/images/lechera1.jpg" width="195" height="100" />
                <h5>Lorem ipsum 6</h5>
                <p>Terror</p>
            </div>-->
        </div>
    </div>

    <!-- leidos de todos los tiempos-->
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <div class="jumbotron">
        <h2>Los más leídos de todos los tiempos</h2>
    </div>


    <table class="table">

        <tbody>

            <div class="row">
                <c:forEach items="${story}" var="story" begin="0" end="2">
                    <div class="col-md-4">
                        <h2> ${story.title}</h2>
                        <br>
                        <p> ${story.sinopsis} </p>
                        <br>
                        <p><a class="btn btn-outline-danger" href="/story/${story.id}" role="button">View details</a>
                        </p>
                    </div>
                </c:forEach>
            </div>

        </tbody>

    </table>


    <!-- los más leídos este mes-->
    <div class="jumbotron">
        <h2>Los más leídos este mes</h2>

    </div>

    <table class="table">

        <tbody>

            <div class="row">
                <c:forEach items="${story}" var="story" begin="3" end="5">
                    <div class="col-md-4">
                        <h2> ${story.title}</h2>
                        <br>
                        <p> ${story.sinopsis} </p>
                        <br>
                        <p><a class="btn btn-outline-danger" href="/story/${story.id}" role="button">View details</a>
                        </p>
                    </div>
                </c:forEach>
            </div>

        </tbody>

    </table>

    <!--Los más leídos esta semana-->
    <div class="jumbotron">
        <h2>Los más leídos esta semana</h2>

    </div>
    <table class="table">

        <tbody>

            <div class="row">
                <c:forEach items="${story}" var="story" begin="6" end="8">
                    <div class="col-md-4">
                        <h2> ${story.title}</h2>
                        <br>
                        <p> ${story.sinopsis} </p>
                        <br>
                        <p><a class="btn btn-outline-danger" href="/story/${story.id}" role="button">View details</a>
                        </p>
                    </div>
                </c:forEach>
            </div>

        </tbody>

    </table>

</div>


<%@include file="parts/foot.html" %>

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