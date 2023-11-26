package com.RakiFood.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.RakiFood.domain.OrderVO;
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

	@Transactional	// 트랜젝션 적용(중요)
	@Override
	public void order_insert(OrderVO o_vo) {
		orderMapper.order_insert(o_vo); 
		orderMapper.order_detail_insert(o_vo.getOrd_code(), o_vo.getRaki_id());
		orderMapper.cart_del(o_vo.getRaki_id()); 
	}

}
