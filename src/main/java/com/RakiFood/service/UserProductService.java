package com.RakiFood.service;

import java.util.List;

import com.RakiFood.domain.OrderVO;
import com.RakiFood.domain.ProductVO;
import com.RakiFood.dto.Criteria;

public interface UserProductService {

	List<ProductVO> pro_list(
			Integer cg_code, 
			Criteria cri
			);
	
	int getTotalCount(Integer cg_code);
	
	ProductVO pro_detail(Integer pro_num);
	
	void buy_now(OrderVO o_vo);
}
