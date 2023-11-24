package com.RakiFood.mapper;

import com.RakiFood.domain.OrderVO;

public interface OrderMapper {

	int getOrderSeq(); // 주문번호
	
	// 주문하기 1)
	void order_insert(OrderVO o_vo); // 주문테이블 저장
}
