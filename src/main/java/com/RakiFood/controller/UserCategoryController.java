package com.RakiFood.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.RakiFood.domain.CategoryVO;
import com.RakiFood.service.UserCategoryService;

// bean : userCategoryController 생성 및 등록 . servlet-context.xml 파일 	<context:component-scan base-package="com.docmall.controller" />
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequiredArgsConstructor
@RestController	// ajax만 사용		jsp파일은 사용이 안됨. jsp파일에서 사용하기위한 데이터 자겅ㅂ	
@RequestMapping("/category/*")
public class UserCategoryController {

	private final UserCategoryService userCategoryService; 
	
	// 2차 카테고리 정보
	@ResponseBody
	@GetMapping("/secondCategory/{cg_parent_code}")
	public ResponseEntity<List<CategoryVO>> secondCategory(@PathVariable("cg_parent_code") Integer cg_parent_code) throws Exception {
		
		log.info("1차 카테고리 코드 : " + cg_parent_code);
		
		ResponseEntity<List<CategoryVO>> entity = null;
		
		entity = new ResponseEntity<List<CategoryVO>>(userCategoryService.getSecondCategoryList(cg_parent_code), HttpStatus.OK);
		
		// List<CategoryVO> list = adCategoryService.getSecondCategoryList(cg_parent_code)
		// list객체 -> JSON 로 변환하는 라이브러리 (jackson-databind 라이브러리 : pox.xml참고)
		
		return entity; 
	
	
	
	}
}












