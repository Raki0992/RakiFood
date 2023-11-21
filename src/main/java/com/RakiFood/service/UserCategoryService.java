package com.RakiFood.service;

import java.util.List;

import com.RakiFood.domain.CategoryVO;

public interface UserCategoryService {

	List<CategoryVO> getSecondCategoryList(Integer cg_parent_code);
}
