package com.RakiFood.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.RakiFood.domain.ProductVO;
import com.RakiFood.dto.Criteria;
import com.RakiFood.dto.ProductDTO;

public interface AdProductMapper {

	void pro_insert(ProductVO vo);
	
	List<ProductVO> pro_list(Criteria cri);
	
	int getTotalCount(Criteria cri);
	
	// 파라미터가 2개이상 사용되는 경우 @Param사용	단위별로 받기위해 arr배열 지움	버튼 1
	void pro_checked_modify1(
			@Param("pro_num") Integer pro_num,
			@Param("pro_price") Integer pro_price,
			@Param("pro_buy") String pro_buy
			);
	
	// 버튼 2
	void pro_checked_modify2(List<ProductDTO> pro_modify_list);
	
	// 수정
	ProductVO pro_edit(Integer pro_num);
	
	// 상품수정
	void pro_edit_ok(ProductVO vo); 
	
	// 상품삭제
	void pro_delete(Integer pro_num);
}









