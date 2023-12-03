package com.RakiFood.mapper;

import java.util.List;

import com.RakiFood.domain.CategoryVO;
import com.RakiFood.dto.Criteria;

public interface AdCategoryMapper {

	List<CategoryVO> getFirstCategoryList();
	
	// 1차 카테고리 받아오기
	List<CategoryVO> getSecondCategoryList(Integer cg_parent_code);
	
	CategoryVO get(Integer cg_code);
	
	List<CategoryVO> category_list(Criteria cri);
	
	int getTotalCount(Criteria cri);
	
	CategoryVO category_edit(Integer cg_code);
	
	void category_edit_ok(CategoryVO vo);
}
 