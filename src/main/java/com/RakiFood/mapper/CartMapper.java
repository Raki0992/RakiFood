package com.RakiFood.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.RakiFood.domain.RFCartVO;
import com.RakiFood.dto.RFCartDTO;

public interface CartMapper { 

	void cart_add(RFCartVO vo);
	
	List<RFCartDTO> cart_list(String mbsp_id);	// 여러개 가져오면 List<>사용
	
	void cart_amount_change(@Param("rfcart_code")Long rfcart_code, @Param("rfcart_amount")int rfcart_amount);
	
	void cart_list_del(Long rfcart_code);

	void cart_sel_delete(Long rfcart_code);
	
	void cart_sel_delete2(List<Long> rfcart_code_arr);
	
}
 