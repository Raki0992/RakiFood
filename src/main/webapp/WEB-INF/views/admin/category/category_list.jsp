<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>AdminLTE 2 | Starter</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  
  <%@include file="/WEB-INF/views/admin/include/plugin1.jsp" %>
  
  <style>

    tr th {
      text-align: center;
    }

  </style>
</head>


<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <!-- Main Header -->
  <%@include file="/WEB-INF/views/admin/include/header.jsp" %>
  
  <!-- Left side column. contains the logo and sidebar -->
  <%@include file="/WEB-INF/views/admin/include/nav.jsp" %>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Page Header
        <small>Optional description</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
        <li class="active">Here</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content container-fluid">

      <div class="text-center">
        <div class="box box-primary">
          <div class="box-header with-border">
          <h3 class="box-title">카테고리 목록</h3>
          </div>

      <div class="row">
					<div class="col-md-12">
						<div class="box">
							<div class="box-header with-border">
								<h3 class="box-title">Category List</h3>
							</div>

              <form role="form" method="post" action="/admin/product/pro_insert">
							<div class="box-body">
                <div class="form-group row">
                  <label for="title" class="col-md-2 col-form-label">카테고리</label> 
                  <div class="col-md-3">
                    <select class="form-control" id="firstCategory">
                      <option>1차 카테고리 선택</option>
                      <c:forEach items="${firstCategoryList }" var="categoryVO">
                        <option value="${categoryVO.cg_code }">${categoryVO.cg_name }</option>
                      </c:forEach>
                    </select>
                  </div>

                  <div class="col-md-3">
                    <select class="form-control" id="secondCategory" name="cg_code">
                      <option>2차 카테고리 선택</option>
                    </select>
                  </div>
                </div>
              </div>
              </form>

								<table class="table table-bordered">
									<tbody>
									<!-- 제목 -->
										<tr>
											<th style="width: 10%">카테고리 코드</th>
											<th style="width: 10%">1차 카테고리</th>
											<th style="width: 20%">카테고리 이름</th>

											<th style="width: 3%">수정</th>
											<th style="width: 3%">삭제</th>
										</tr>
										<!-- 내용 forEach안에서 id사용불가 (중복) -->
										<c:forEach items="${category_list }" var="CategoryVO"> 
										<tr>
											<td class="cg_code">${CategoryVO.cg_code}</td>
											<td>${CategoryVO.cg_parent_code}</td>
											<td>${CategoryVO.cg_name}</td>
											<td><button class="btn btn-warning" name="btn_category_edit">수정</button></td>
											<td><button class="btn btn-danger btn_category_del">삭제</button></td>
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
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <!-- Main Footer -->
  <%@include file="/WEB-INF/views/admin/include/footer.jsp" %>

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Create the tabs -->
    <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
      <li class="active"><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
      <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
    </ul>
    <!-- Tab panes -->
    <div class="tab-content">
      <!-- Home tab content -->
      <div class="tab-pane active" id="control-sidebar-home-tab">
        <h3 class="control-sidebar-heading">Recent Activity</h3>
        <ul class="control-sidebar-menu">
          <li>
            <a href="javascript:;">
              <i class="menu-icon fa fa-birthday-cake bg-red"></i>

              <div class="menu-info">
                <h4 class="control-sidebar-subheading">Langdon's Birthday</h4>

                <p>Will be 23 on April 24th</p>
              </div>
            </a>
          </li>
        </ul>
        <!-- /.control-sidebar-menu -->

        <h3 class="control-sidebar-heading">Tasks Progress</h3>
        <ul class="control-sidebar-menu">
          <li>
            <a href="javascript:;">
              <h4 class="control-sidebar-subheading">
                Custom Template Design
                <span class="pull-right-container">
                    <span class="label label-danger pull-right">70%</span>
                  </span>
              </h4>

              <div class="progress progress-xxs">
                <div class="progress-bar progress-bar-danger" style="width: 70%"></div>
              </div>
            </a>
          </li>
        </ul>
        <!-- /.control-sidebar-menu -->

      </div>
      <!-- /.tab-pane -->
      <!-- Stats tab content -->
      <div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab Content</div>
      <!-- /.tab-pane -->
      <!-- Settings tab content -->
      <div class="tab-pane" id="control-sidebar-settings-tab">
        <form method="post">
          <h3 class="control-sidebar-heading">General Settings</h3>

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Report panel usage
              <input type="checkbox" class="pull-right" checked> 
            </label>

            <p>
              Some information about this general settings option
            </p>
          </div>
          <!-- /.form-group -->
        </form>
      </div>
      <!-- /.tab-pane -->
    </div>
  </aside>
  <!-- /.control-sidebar -->
  <!-- Add the sidebar's background. This div must be placed
  immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->
<%@include file="/WEB-INF/views/admin/include/plugin2.jsp" %>

<script>
  $(document).ready(function() {
    
    let actionForm = $("#actionForm");

    $(".movepage").on("click", function(e) {
      e.preventDefault(); // a태그의 링크기능을 제거. href속성에 페이지번호를 숨겨둠.

      actionForm.attr("action","/admin/category/category_list");
      actionForm.find("input[name='pageNum']").val($(this).attr("href"));
      
      actionForm.submit();
    });

    // 카테고리 삭제
    $(".btn_category_del").on("click", function() {
      
      let cg_code = $(this).parent().parent().find(".cg_code").text();

      if(!confirm("삭제하시겠습니까?")) return;
      
      actionForm.append('<input type="hidden" name="cg_code" id="cg_code" value="' + cg_code + '" />');
      
      console.log(cg_code);
      actionForm.attr("method", "post");
      actionForm.attr("action", "/admin/category/category_delete");
      actionForm.submit();
    });

      // 카테고리 수정페이지로 이동
      $("button[name='btn_category_edit']").on("click", function() {

      let cg_code = $(this).parent().parent().find(".cg_code").text();

      console.log(cg_code);
      actionForm.find("#cg_code").remove();  
      actionForm.append('<input type="hidden" name="cg_code" id="cg_code" value="' + cg_code + '" />');

      actionForm.attr("method", "get");
      actionForm.attr("action","/admin/category/category_edit");
      actionForm.submit();  // 확인하기
    });

    // 카테고리 등록페이지로 이동
    $("#btn_member_insert").on("click", function() {
      location.href ="/admin/member/member_insert";
    });

      // 1차카테고리 선택 <select class="form-control" id="firstCategory">
        $("#firstCategory").change(function() {
      // $(this) : option태그중 선택한 option태그를 가리킴
      let cg_parent_code = $(this).val();

      console.log("1차 카테고리 코드", cg_parent_code);

      // 1차 카테고리 선택에 의한 2차 카테고리 정보를 가져오는 url
      let url = "/admin/category/secondCategory/" + cg_parent_code + ".json";

      // $.getJSON() : 스프링에 요청시 데이터를 json으로 받는 기능  
      $.getJSON(url, function(secondCategoryList) {
        // console.log("2차카테고리 정보", "secondCategoryList");

        // console.log("2차카테고리 개수", secondCategoryList.length);

        // 2차카테고리 select태그 참조  <select class="form-control" id="secondCategory" name="cg_code">
          let secondCategory = $("#secondCategory"); 
          let optionStr = "";

          // find("css선택자") : 태그명, id속성이름, class속성이름
          secondCategory.find("option").remove(); // 2차카테고리의 option제거
          secondCategory.append("<option value=''>2차 카테고리 선택</option>");

          // <option value='10'>바지</option>
        for(let i=0; i<secondCategoryList.length; i++) {
          optionStr += "<option value='" + secondCategoryList[i].cg_code + "'>" + secondCategoryList[i].cg_name + "</option>";
        }

        // console.log(optionStr);
        secondCategory.append(optionStr); // 2차카테고리 <option>태그들이 추가
      });
      
    });

  }); // ready안에 입력
</script>
</body>
</html>

















