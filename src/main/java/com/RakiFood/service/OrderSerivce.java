package com.RakiFood.service;

import com.RakiFood.domain.OrderVO;
import com.RakiFood.domain.PaymentVO;
import com.RakiFood.domain.ProductVO;

public interface OrderSerivce {

	int getOrderSeq(); // 주문번호
	
	// 주문하기 1)
	void order_insert(OrderVO o_vo, PaymentVO p_vo); // 주문테이블 저장
	
	ProductVO directOrder(ProductVO vo);
}
