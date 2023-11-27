package com.RakiFood.mapper;

import org.apache.ibatis.annotations.Param;

import com.RakiFood.domain.OrderVO;
import com.RakiFood.domain.PaymentVO;
import com.RakiFood.domain.RFCartVO;

public interface OrderMapper {

	int getOrderSeq(); // 주문번호
	
	// 주문하기 1)
	void order_insert(OrderVO o_vo); // 주문테이블 저장
	
	// 2) 주문상세테이블 저장 -> 장바구니테이블 참조
	void order_detail_insert(@Param("ord_code") Long ord_code,@Param("raki_id") String raki_id);	// 주문상세테이블 저장(장바구니테이블 참조)
		
	// 장바구니 테이블 삭제
	void cart_del(String raki_id);
	
	// 결제테이블 저장
	void payment_insert(PaymentVO vo);
	
	// 바로구매
	RFCartVO directOrder(RFCartVO vo);
}
