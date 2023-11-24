package com.RakiFood.service;

import org.springframework.stereotype.Service;

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

	@Override
	public void order_insert(OrderVO o_vo) {
		orderMapper.order_insert(o_vo); 
	}

}
