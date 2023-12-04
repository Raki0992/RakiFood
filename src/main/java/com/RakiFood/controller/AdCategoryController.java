package com.RakiFood.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.RakiFood.domain.CategoryVO;
import com.RakiFood.dto.Criteria;
import com.RakiFood.dto.PageDTO;
import com.RakiFood.service.AdCategoryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller	// ajax호출 또는 일반호출이 함께 사용하는 경우
//@RestController (@Controller + @ResponseBody)  : 모든 매핑주소가 ajax호출로 사용되는 경우
@RequiredArgsConstructor
@RequestMapping("/admin/category/*")
public class AdCategoryController {

	private final AdCategoryService adCategoryService;
	
	// 1차 카테고리 선택에 따른 2차 카테고리 정보를 클라이언트에게 제공
	// 일반주소 secondCategory?cg_parent_code=1
	// RESTful 개발론 주소 /admin/category/secondCategory/1.json
	// 주소의 일부분을 값으로 사용하고자 할 경우 {} 중괄호 사용한다.
	@ResponseBody
	@GetMapping("/secondCategory/{cg_parent_code}")
	public ResponseEntity<List<CategoryVO>> secondCategory(@PathVariable("cg_parent_code") Integer cg_parent_code) throws Exception {
		
		log.info("1차 카테고리 코드 : " + cg_parent_code);
		
		ResponseEntity<List<CategoryVO>> entity = null;
		
		entity = new ResponseEntity<List<CategoryVO>>(adCategoryService.getSecondCategoryList(cg_parent_code), HttpStatus.OK);
		
		// List<CategoryVO> list = adCategoryService.getSecondCategoryList(cg_parent_code)
		// list객체 -> JSON 로 변환하는 라이브러리 (jackson-databind 라이브러리 : pox.xml참고)
		
		return entity; 
		
	}
	
	// 카테고리 관리
	@GetMapping("/category_list")
	public void category_list(Model model, Criteria cri) throws Exception {
		
		List<CategoryVO> category_list = adCategoryService.category_list(cri);
		
		model.addAttribute("category_list", category_list);
		
		int totalCount = adCategoryService.getTotalCount(cri);
		model.addAttribute("pageMaker",  new PageDTO(cri, totalCount));
	}
	
	// 카테고리 수정페이지
	@GetMapping("/category_edit")
	public void category_edit(@ModelAttribute("cri") Criteria cri, Integer cg_code, Model model) throws Exception {
		
		CategoryVO categoryVO = adCategoryService.category_edit(cg_code);
		
		model.addAttribute("categoryVO", categoryVO);
	}
	
	// 카테고리 수정
	@PostMapping("/category_edit")
	public String category_edit(Criteria cri, CategoryVO vo, RedirectAttributes rttr) throws Exception {
		
		adCategoryService.category_edit_ok(vo);
		
		return "redirect:/admin/category/category_list";
	}
	
	// 카테고리 추가
	@GetMapping("/category_insert")
	public void category_insert() {
	}
	
	@PostMapping("/category_insert")
	public String category_insert(CategoryVO vo, RedirectAttributes rttr) throws Exception {
		
		adCategoryService.category_insert(vo);
		
		return "redirect:/admin/category/category_insert";
	}
	
	
	
	
}








