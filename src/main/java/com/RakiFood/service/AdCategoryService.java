package com.RakiFood.service;

import java.util.List;

import com.RakiFood.domain.CategoryVO;
import com.RakiFood.dto.Criteria;

public interface AdCategoryService {

	List<CategoryVO> getFirstCategoryList();
	
	List<CategoryVO> getSecondCategoryList(Integer cg_parent_code);
	
	CategoryVO get(Integer cg_code);
	
	List<CategoryVO> category_list(Criteria cri);
	
	int getTotalCount(Criteria cri);
	
	CategoryVO category_edit(Integer cg_code);
	
	void category_edit_ok(CategoryVO vo);
	
	void category_insert(CategoryVO vo);
}
