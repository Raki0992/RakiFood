package com.RakiFood.service;

import java.util.List;

import com.RakiFood.domain.RFCartVO;
import com.RakiFood.dto.RFCartDTO;

public interface CartService {

	void cart_add(RFCartVO vo);
	
	List<RFCartDTO> cart_list(String mbsp_id);
	
	void cart_amount_change(Long cart_code, int cart_amount);
	
	void cart_list_del(Long cart_code);
}
