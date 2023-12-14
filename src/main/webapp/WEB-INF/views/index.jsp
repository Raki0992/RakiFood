<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.101.0">
    <title>Pricing example · Bootstrap v4.6</title>

    <!-- Bootstrap core CSS -->
<%@include file="/WEB-INF/views/comm/plugin2.jsp" %>



    <!-- Favicons -->


    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>

  </head>
  <body>
    
<%@include file="/WEB-INF/views/comm/header.jsp" %>

<%@include file="/WEB-INF/views/comm/category_menu.jsp" %>

<div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
  <h1 class="display-4">RakiFood</h1>
  <p class="lead">Quickly build an effective pricing table for your potential customers with this Bootstrap example.(부트스트랩) </p>
          <!-- 로그인 안한 상태에서 버튼생기고 클릭시 이동 -->
        <c:if test="${sessionScope.loginStatus == null }">
        <a href="/member/join">
        <button type="button" class="btn btn-lg btn-block btn-outline-primary" >Sign up for free</button>
        </a>
        </c:if>
</div>

<div class="container">
  <div class="card-deck mb-3 text-center">
    <div class="card mb-4 shadow-sm">
      <div class="card-header">
        <h4 class="my-0 font-weight-normal">국밥</h4>
      </div>
      <div class="card-body">
        <figure>
          <img src="/resources/image/국밥.jpg" alt="국밥" style="width: 200px; height: 200px;" ></img>
		</figure>
        <h1 class="card-title pricing-card-title"> <small class="text-muted">￦8,000</small></h1>
      </div>
    </div>

    <div class="card mb-4 shadow-sm">
      <div class="card-header">
        <h4 class="my-0 font-weight-normal">김치찌개</h4>
      </div>
      <div class="card-body">
        <figure>
          <img src="/resources/image/김치찌개.jpg" alt="김치찌개" style="width: 200px; height: 200px;" ></img>
		</figure>
        <h1 class="card-title pricing-card-title"><small class="text-muted">￦10,000</small></h1>
      </div>
    </div>

    <div class="card mb-4 shadow-sm">
      <div class="card-header">
        <h4 class="my-0 font-weight-normal">삼겹살</h4>
      </div>
      <div class="card-body">
        <figure>
          <img src="/resources/image/삼겹살.jpg" alt="삼겹살" style="width: 200px; height: 200px;" ></img>
		</figure>
        <h1 class="card-title pricing-card-title"><small class="text-muted">￦18,000</small></h1>
      </div>
    </div>

  </div>

  <%@include file="/WEB-INF/views/comm/footer.jsp" %>
</div>

<%@include file="/WEB-INF/views/comm/plugin.jsp" %>
<!-- 카테고리 메뉴 자바스크립트 작업 -->
<script src="/js/category_menu.js"></script>
    
  </body>
</html>
    