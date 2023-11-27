package com.RakiFood.service;

import java.util.List;

import com.RakiFood.domain.RFCartVO;
import com.RakiFood.dto.RFCartDTO;

public interface CartService {

	void cart_add(RFCartVO vo);
	
	List<RFCartDTO> cart_list(String raki_id);
	
	void cart_amount_change(Long rfcart_code, int rfcart_amount);
	
	void cart_list_del(Long rfcart_code);
	
	void cart_sel_delete(List<Long> rfcart_code_arr);
	
	void cart_sel_delete2(List<Long> rfcart_code_arr);
	
}
	
