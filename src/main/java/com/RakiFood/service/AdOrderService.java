package com.RakiFood.service;

import java.util.List;

import com.RakiFood.domain.OrderDetailInfoVO;
import com.RakiFood.domain.OrderDetailProductVO;
import com.RakiFood.domain.OrderVO;
import com.RakiFood.dto.Criteria;

public interface AdOrderService {

	List<OrderVO> order_list(Criteria cri, String start_date, String end_date);
	
	int getTotalCount(Criteria cri, String start_date, String end_date);
	
	List<OrderDetailInfoVO> OrderDetailInfo1(Long ord_code);
	
	List<OrderDetailProductVO> OrderDetailInfo2(Long ord_code);
	
	void order_product_delete(Long ord_code, Integer pro_num);
}
