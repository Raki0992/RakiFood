package com.RakiFood.mapper;

import java.util.List;

import com.RakiFood.domain.CategoryVO;

public interface UserCategoryMapper {

	List<CategoryVO> getSecondCategoryList(Integer cg_parent_code);
}
