package com.RakiFood.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.RakiFood.domain.CategoryVO;
import com.RakiFood.mapper.UserCategoryMapper;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service	// bean이 생성 및 등록될 설정작업 : userCategoryServiceImpl bean생성. 
// root-context.xml에 설정필요 	<context:component-scan base-package="com.docmall.service" />
public class UserCategoryServiceImpl implements UserCategoryService{
	
	private final UserCategoryMapper userCategoryMapper;	// 주입을 정상적으로 받는다는 전제조건(관리자 카테고리 완성)
	
	@Override
	public List<CategoryVO> getSecondCategoryList(Integer cg_parent_code) {
		return userCategoryMapper.getSecondCategoryList(cg_parent_code);
	}

}
 







