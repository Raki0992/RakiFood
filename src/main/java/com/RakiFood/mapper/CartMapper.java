package com.RakiFood.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.RakiFood.domain.RFCartVO;
import com.RakiFood.dto.RFCartDTO;

public interface CartMapper { 

	void cart_add(RFCartVO vo);
	
	List<RFCartDTO> cart_list(String mbsp_id);	// 여러개 가져오면 List<>사용
	
	void cart_amount_change(@Param("cart_code")Long cart_code, @Param("cart_amount")int cart_amount);
	
	void cart_list_del(Long cart_code);
}
 