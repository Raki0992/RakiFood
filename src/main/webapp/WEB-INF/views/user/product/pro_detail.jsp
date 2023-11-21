<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!-- 날짜, 금액, 시간 등... -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
  <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="https://jqueryui.com/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
  
<script>
  $( function() {
    $( "#tabs" ).tabs();
  } );
  </script>

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
<p>2차카테고리 : ${cg_name}</p>
</div>

<div class="container">
  <div class="card-deck mb-3 text-center row">
  
    <div class="col-md-6">
      상품이미지
      <img class="btn_pro_img" data-pro_num="${productVO.pro_num}" width="100%" height="200" src="/user/product/imageDisplay?dateFolderName=${productVO.pro_up_folder }&fileName=${productVO.pro_img }">
    </div>
    <div class="col-md-6">
      <div class="row">
        <div class="col">
          상품이름: ${productVO.pro_name }
        </div>
      </div>

      <div class="row">
        <div class="col">
          가격: ${productVO.pro_price }
        </div>
      </div>

      <div class="row">
        <div class="col">
          수량:	<input type="number" value="1">
        </div>
      </div>

      <div class="row">
        <div class="col">
          총상품금액: 계산
        </div>
      </div>

      <div class="row">
        <div class="col-md-6">
          <button type="button" class="btn btn-dark">구매하기</button>
        </div>
        <div class="col-md-6">
          <button type="button" class="btn btn-light">장바구니</button>
        </div>
      </div>
      
    </div>
  </div>
  
	<div class="row">
		<div class="col-md-12">
      <div id="tabs">
        <ul>
          <li><a href="#tabs-1">상품설명</a></li>
          <li><a href="#tabs-2">상품후기</a></li>
        </ul>
        <div id="tabs-1">
          <p>Proin elit arcu, rutrum commodo, vehicula tempus, commodo a, risus. Curabitur nec arcu. Donec sollicitudin mi sit amet mauris. Nam elementum quam ullamcorper ante. Etiam aliquet massa et lorem. Mauris dapibus lacus auctor risus. Aenean tempor ullamcorper leo. Vivamus sed magna quis ligula eleifend adipiscing. Duis orci. Aliquam sodales tortor vitae ipsum. Aliquam nulla. Duis aliquam molestie erat. Ut et mauris vel pede varius sollicitudin. Sed ut dolor nec orci tincidunt interdum. Phasellus ipsum. Nunc tristique tempus lectus.</p>
        </div>
        <div id="tabs-2">
          <p>Morbi tincidunt, dui sit amet facilisis feugiat, odio metus gravida ante, ut pharetra massa metus id nunc. Duis scelerisque molestie turpis. Sed fringilla, massa eget luctus malesuada, metus eros molestie lectus, ut tempus eros massa ut dolor. Aenean aliquet fringilla sem. Suspendisse sed ligula in ligula suscipit aliquam. Praesent in eros vestibulum mi adipiscing adipiscing. Morbi facilisis. Curabitur ornare consequat nunc. Aenean vel metus. Ut posuere viverra nulla. Aliquam erat volutpat. Pellentesque convallis. Maecenas feugiat, tellus pellentesque pretium posuere, felis lorem euismod felis, eu ornare leo nisi vel felis. Mauris consectetur tortor et purus.</p>
        </div>
        <div id="tabs-3">
          <p>Mauris eleifend est et turpis. Duis id erat. Suspendisse potenti. Aliquam vulputate, pede vel vehicula accumsan, mi neque rutrum erat, eu congue orci lorem eget lorem. Vestibulum non ante. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Fusce sodales. Quisque eu urna vel enim commodo pellentesque. Praesent eu risus hendrerit ligula tempus pretium. Curabitur lorem enim, pretium nec, feugiat nec, luctus a, lacus.</p>
          <p>Duis cursus. Maecenas ligula eros, blandit nec, pharetra at, semper at, magna. Nullam ac lacus. Nulla facilisi. Praesent viverra justo vitae neque. Praesent blandit adipiscing velit. Suspendisse potenti. Donec mattis, pede vel pharetra blandit, magna ligula faucibus eros, id euismod lacus dolor eget odio. Nam scelerisque. Donec non libero sed nulla mattis commodo. Ut sagittis. Donec nisi lectus, feugiat porttitor, tempor ac, tempor vitae, pede. Aenean vehicula velit eu tellus interdum rutrum. Maecenas commodo. Pellentesque nec elit. Fusce in lacus. Vivamus a libero vitae lectus hendrerit hendrerit.</p>
        </div>
      </div>
    </div>
  </div>

  						<div class="row text-center">
                 					<div class="col-md-12">
										<!-- 1) 페이지번호 클릭할 때 사용 [이전] 1 2 3 4 5 [다음] -->
										<!-- 2) 목록에서 상품이미지 또는 상품명을 클릭할 때 사용	-->
										<form id="actionForm" action="" method="get">
											<input type="hidden" name="pageNum" id="pageNum" value="${pageMaker.cri.pageNum}" />
											<input type="hidden" name="amount" id="amount" value="${pageMaker.cri.amount}" />
											<input type="hidden" name="type" id="type" value="${pageMaker.cri.type}" />
											<input type="hidden" name="keyword" id="keyword" value="${pageMaker.cri.keyword}" />
											
											<input type="hidden" name="cg_code" id="cg_code" value="${cg_code}" />
											<input type="hidden" name="cg_name" id="cg_name" value="${cg_name}" />
										</form>
									</div>
							</div>
  

  <%@include file="/WEB-INF/views/comm/footer.jsp" %>
</div>

<%--<%@include file="/WEB-INF/views/comm/plugin.jsp" %> --%>
<!-- 카테고리 메뉴 자바스크립트 작업 -->
<script src="/js/category_menu.js"></script>

<script>
$(document).ready(function() {
	let actionForm = $("#actionForm");

// [이전] 1 2 3 4 5 [다음] 클릭 이벤트 설정. <a>태그
$(".movepage").on("click", function(e) {
  e.preventDefault(); // a태그의 링크기능을 제거. href속성에 페이지번호를 숨겨둠.

  actionForm.attr("action","/user/product/pro_list");
  actionForm.find("input[name='pageNum']").val($(this).attr("href"));

  actionForm.submit();
	});

  // 장바구니 추가
  $("button[name='btn_cart_add']").on("click", function() {
    console.log("장바구니");

    $.ajax({
      url: '/user/cart/cart_add',
      type: 'post',
      data: {pro_num : $(this).data("pro_num"), cart_amount : 1},
      dataType: 'text',
      success: function(result) {
        if(result == "success") {
          alert("장바구니에 추가됨");
          if(confirm("장바구니로 이동하시겠습니까?")) {
            location.href = "/user/cart/cart_list";
          }
        }
      }
    });

  });

  // 상품이미지 또는 상품명 클릭시 상품상세로 보내는 작업
  $(".btn_pro_img").on("click", function() {
    console.log('상품상세설명');

    actionForm.attr("action","/user/product/pro_detail");

    let pro_num = $(this).data("pro_num");

    actionForm.find("input[name='pro_num']").remove();
    // <input type='hidden' name='pro_num' value='상품코드'>
    actionForm.append("<input type='hidden' name='pro_num' value='" + pro_num + "'>");
    actionForm.submit();
  });

}); // ready


</script>
  </body>
</html>
    