package com.RakiFood.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.RakiFood.domain.OrderDetailInfoVO;
import com.RakiFood.domain.OrderDetailProductVO;
import com.RakiFood.domain.OrderVO;
import com.RakiFood.dto.Criteria;
import com.RakiFood.mapper.AdOrderMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AdOrderServiceImpl implements AdOrderService {

	private final AdOrderMapper adOrderMapper;

	@Override
	public List<OrderVO> order_list(Criteria cri, String start_date, String end_date) {
		return adOrderMapper.order_list(cri, start_date, end_date); 
	}

	@Override
	public int getTotalCount(Criteria cri, String start_date, String end_date) {
		return adOrderMapper.getTotalCount(cri, start_date, end_date);
	}

	@Override
	public List<OrderDetailInfoVO> OrderDetailInfo1(Long ord_code) {
		return adOrderMapper.OrderDetailInfo1(ord_code);
	}

	@Override
	public List<OrderDetailProductVO> OrderDetailInfo2(Long ord_code) {
		return adOrderMapper.OrderDetailInfo2(ord_code);
	}
	
	@Override
	public void order_product_delete(Long ord_code, Integer pro_num) {
		adOrderMapper.order_product_delete(ord_code, pro_num);
	}


	
}
