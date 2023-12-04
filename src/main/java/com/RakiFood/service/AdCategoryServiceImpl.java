package com.RakiFood.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.RakiFood.domain.CategoryVO;
import com.RakiFood.dto.Criteria;
import com.RakiFood.mapper.AdCategoryMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdCategoryServiceImpl implements AdCategoryService {

	private final AdCategoryMapper adCategoryMapper;

	@Override
	public List<CategoryVO> getFirstCategoryList() {
		return adCategoryMapper.getFirstCategoryList();
	}

	@Override
	public List<CategoryVO> getSecondCategoryList(Integer cg_parent_code) {
		return adCategoryMapper.getSecondCategoryList(cg_parent_code);
	}

	@Override
	public CategoryVO get(Integer cg_code) {
		return adCategoryMapper.get(cg_code);
	}

	@Override
	public CategoryVO category_edit(Integer cg_code) {
		return adCategoryMapper.category_edit(cg_code);
	}

	@Override
	public void category_edit_ok(CategoryVO vo) {
		adCategoryMapper.category_edit_ok(vo);
	}

	@Override
	public List<CategoryVO> category_list(Criteria cri) {
		return adCategoryMapper.category_list(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		return adCategoryMapper.getTotalCount(cri);
	}

	@Override
	public void category_insert(CategoryVO vo) {
		adCategoryMapper.category_insert(vo);
	}

	
	
}
