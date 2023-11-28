package com.RakiFood.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.RakiFood.domain.OrderVO;
import com.RakiFood.domain.PaymentVO;
import com.RakiFood.domain.ProductVO;
import com.RakiFood.domain.RFCartVO;
import com.RakiFood.mapper.OrderMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderSerivce {
	
	private final OrderMapper orderMapper;

	@Override
	public int getOrderSeq() {
		return orderMapper.getOrderSeq();
	}

	@Transactional	// 트랜젝션 적용(중요)	root-context.xml 에서 트랜젝션 설정이 되어 있어야 적용
	@Override
	public void order_insert(OrderVO o_vo, PaymentVO p_vo) {
		orderMapper.order_insert(o_vo); 
		orderMapper.order_detail_insert(o_vo.getOrd_code(), o_vo.getRaki_id());
		orderMapper.cart_del(o_vo.getRaki_id()); 
		orderMapper.payment_insert(p_vo);
	}

	@Override
	public ProductVO directOrder(Integer pro_num) {
		return orderMapper.directOrder(pro_num);
	}

	@Override
	public void cart_amount_change(Integer pro_num, Integer pro_amount) {
		orderMapper.cart_amount_change(pro_num, pro_amount);
	}

	


}
