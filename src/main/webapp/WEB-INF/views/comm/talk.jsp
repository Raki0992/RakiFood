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

<!-- Main content -->
<section class="content container-fluid">

    <div class="text-center">
      <div class="box box-primary">
        <div class="box-header with-border">
        <h3 class="box-title">게시판</h3>
        </div>

    <div class="row">
                  <div class="col-md-12">
                      <div class="box">
                          <div class="box-header with-border">
                              <h3 class="box-title">Free Talk</h3>
                          </div>

                          <div class="box-body">
              <div>
                <form action="/comm/talk" method="get">	<!-- 검색은 get방식-->
                  <select name="type">	<!-- 주소에 맞게 name 입력 -->
                    <option selected>검색종류선택</option>
                    <option value="N" ${pageMaker.cri.type == 'N'? 'selected': ''}>이름</option>
                    <option value="C" ${pageMaker.cri.type == 'C'? 'selected': ''}>아이디</option>
                    <option value="P" ${pageMaker.cri.type == 'P'? 'selected': ''}>제목</option>

                  </select>
                  <input type="text" name="keyword" value="${pageMaker.cri.keyword}" />	<!-- 주소에 맞게 name 입력 -->
                  <input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}" />
                  <input type="hidden" name="amount" value="${pageMaker.cri.amount}" />
                  <button type="submit" class="btn btn-primary">검색</button>
                </form>
              </div>
                              <table class="table table-bordered">
                                  <tbody>
                                  <!-- 제목 -->
                                      <tr>
                                          <th style="width: 10%">글번호</th>
                                          <th style="width: 10%">아이디</th>
                                          <th style="width: 20%">이름</th>
                                          <th style="width: 27%">제목</th>
                                          <th style="width: 15%">내용</th>
                                          <th style="width: 10%">작성일</th>
                                      </tr>
                                      <!-- 내용 forEach안에서 id사용불가 (중복) -->
                                      <c:forEach items="${talk_list }" var="FreeTalkVO"> 
                                      <tr>
                    <td>${FreeTalkVO.free_num}</td>
                                          <td class="raki_id">${FreeTalkVO.raki_id}</td>
                                          <td>${FreeTalkVO.raki_name}</td>
                                          <td>${FreeTalkVO.free_title}</td>
                                          <td>${FreeTalkVO.free_content}</td>
                                          <td><fmt:formatDate value="${FreeTalkVO.free_updatedate }" pattern="yyyy-MM-dd" /></td>
                                      </tr>
                                      </c:forEach>
                                  </tbody>
                              </table>
                          </div>
                          
                          <div class="box-footer clearfix">
                              <div class="row">
                                   <div class="col-md-4">
                                      <!-- 1) 페이지번호 클릭할 때 사용 [이전] 1 2 3 4 5 [다음] -->
                                      <!-- 2) 목록에서 상품이미지 또는 상품명을 클릭할 때 사용	-->
                                      <form id="actionForm" action="" method="get">
                                          <input type="hidden" name="pageNum" id="pageNum" value="${pageMaker.cri.pageNum}" />
                                          <input type="hidden" name="amount" id="amount" value="${pageMaker.cri.amount}" />
                                          <input type="hidden" name="type" id="type" value="${pageMaker.cri.type}" />
                                          <input type="hidden" name="keyword" id="keyword" value="${pageMaker.cri.keyword}" />
                                      </form>
                                  </div>
                                  <div class="col-md-6 text-center">
                  
                                      <nav aria-label="...">
                                          <ul class="pagination">
                                          <!-- 이전 표시여부 작업 -->
                                          <c:if test="${pageMaker.prev }">
                                              <li class="page-item">
                                              <a href="${pageMaker.startPage - 1 }" class="page-link movepage">Previous</a>
                                              </li>
                                          </c:if>
                                          <!-- 페이지번호  출력 작업 -->
                                          <!-- 1	2	3	4	5 ... 다음 -->
                                          <!-- 이전 6	7	8	9	10 ... 다음 -->
                                          <c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="num">
                              <!-- ''사용 -->  <li class='page-item ${pageMaker.cri.pageNum == num ? "active":"" }' aria-current="page">
                                              <a class="page-link movepage" href="${num }" data-page="${num }">${num }</a>
                                              </li>
                                          </c:forEach>
                                          <!-- 다음 표시여부 -->
                                          <c:if test="${pageMaker.next }">
                                          <li class="page-item">
                                          <a href="${pageMaker.endPage + 1 }" class="page-link movepage" href="#">Next</a>
                                          </li>
                                          </c:if>
                                          
                                          </ul>
                                      </nav>
                                  </div>
                          </div>
                      </div>
                  </div>
              </div>
            
                          
              </div>
                  </div>
                      </div>
        
        
        </div>
    </div>

  </section>

  <%@include file="/WEB-INF/views/comm/footer.jsp" %>
</div>

<%@include file="/WEB-INF/views/comm/plugin.jsp" %>
<!-- 카테고리 메뉴 자바스크립트 작업 -->
<script src="/js/category_menu.js"></script>
    
  </body>
</html>
    