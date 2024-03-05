<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/tags.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" ></script>
<title>직원관리</title>
</head>
<body>
<%@ include file="../common/navbar.jsp" %>
<div class="container">
	<div class="row mb-3">
		<div class="col-12">
		<h1 class="fs-3">직원관리 - 직원 목록</h1>
			<form id="form-employees" method="get" action="list">
				<input type="hidden" name="page"/>
				<div class="mb-3 d-flex justify-content-between">
					<select class="form-select w-25" name="rows" onchange="changeRows()">
						<option value="5" ${param.rows eq 5 ? 'selected' : '' }> 5개씩</option>
						<option value="10" ${empty param.rows or param.rows eq 10 ? 'selected' : '' }> 10개씩</option>
						<option value="20" ${param.rows eq 20 ? 'selected' : '' }> 20개씩</option>
						<option value="50" ${param.rows eq 50 ? 'selected' : '' }> 50개씩</option>
					</select>	
					<div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" 
								type="radio" 
								name="sort" 
								value="hireDate"
								${empty param.sort or param.sort eq 'hireDate' ? 'checked' : '' } 
								onchange="changeSort()"/>
							<label class="form-check-label">입사일순</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" 
								type="radio" 
								name="sort" 
								value="name"
								${param.sort eq 'name' ? 'checked' : '' }
								onchange="changeSort()"/>
							<label class="form-check-label">이름순</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" 
								type="radio" 
								name="sort" 
								value="lowsalary"
								${param.sort eq 'lowsalary' ? 'checked' : '' }
								onchange="changeSort()"/>
							<label class="form-check-label">낮은 급여순</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" 
								type="radio" 
								name="sort" 
								value="highsalary"
								${param.sort eq 'highsalary' ? 'checked' : '' }
								onchange="changeSort()"/>
							<label class="form-check-label">높은 급여순</label>
						</div>
					</div>
				</div>
				<table class="table">
					<colgroup>
						<col width="10%">
						<col width="15%">
						<col width="15%">
						<col width="10%">
						<col width="10%">
						<col width="20%">
						<col width="20%">
					</colgroup>
					<thead>
						<tr>
							<th>번호</th>
							<th>이름</th>
							<th>부서명</th>
							<th>입사일</th>
							<th>급여</th>
							<th>전화번호</th>
							<th>이메일</th>
						</tr>
					</thead>
					<tbody>	
						<c:forEach var="emp" items="${empList }">
							<tr>
								<td>${emp.no }</td>
								<td><a href="detail?no=${emp.no}" 
									style="color: black; text-decoration: none">${emp.name }</a></td>
								<td>${emp.dept.name }</td>
								<td><fmt:formatDate value="${emp.hireDate }"/></td>
								<td>${emp.salary }</td>
								<td>${emp.tel }</td>
								<td>${emp.email }</td>
							</tr>
						</c:forEach>			
					</tbody>
				</table>
				<div class="row">
					<div class="col-12 d-flex justify-content-center">
						<!-- 조회된 전체 행의 갯수가 0이 아닌경우 -->
						<c:if test="${paging.totalRows ne 0 }"> 
							<nav class="justify-content-center">
								<ul class="pagination">
									<li class="page-item">
										<a href="list?page=${paging.currentPage - 1}" 
												class="page-link ${paging.first ? 'disabled': '' }" 							
												onclick="changePage(${paging.currentPage - 1})">이전</a>
									</li>
									<c:forEach var="num" begin="${paging.beginPage }" end="${paging.endPage }">
										<li class="page-item ${paging.currentPage eq num ? 'active' : '' }">
											<a href="list?page=${num }" class="page-link" 
													onclick="changePage(${num}, event)">${num}</a>
										</li>
									</c:forEach>
									<li class="page-item">
										<a href="list?page=${paging.currentPage + 1}" 
												class="page-link ${paging.last ? 'disabled': '' }" 
												onclick="changePage(${paging.currentPage + 1})">다음</a>
									</li>
								</ul>
							</nav>
						</c:if>
					</div>
				</div>
				<div class="row row-cols-lg-auto g-3">
					<div class="col-12">
						<select class="form-select" name="opt">
							<option value="name" ${param.opt eq 'name' ? 'selected' : '' }>이름</option>
							<option value="salary" ${param.opt eq 'salary' ? 'selected' : '' }>급여</option>
						</select>
					</div>
					<div class="col-12">
						<input type="text" class="form-control" name="keyword" value="${param.keyword }"/>
					</div>
					<div class="col-12">
						<button type="submit" class="btn btn-outline-dark">검색</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col-12">
			<div class="text-end">
				<a href="add" class="btn btn-primary">신규 직원</a>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	function changeRows() {
		let form = document.getElementById("form-employees");
		form.submit();
	}
	function changeSort() {
		document.getElementById("form-employees").submit();
	}
	function changePage(page, event) {
		event.preventDefault();
		document.querySelector("input[name=page]").value = page;
		document.getElementById("form-employees").submit();
	}
</script>
</body>
</html>