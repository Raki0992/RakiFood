package com.RakiFood.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.RakiFood.domain.PaymentVO;
import com.RakiFood.dto.Criteria;
import com.RakiFood.mapper.AdOrderMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AdOrderServiceImpl implements AdOrderService {

	private final AdOrderMapper adOrderMapper;

	@Override
	public List<PaymentVO> order_list(Criteria cri) {
		return adOrderMapper.order_list(cri); 
	}

	@Override
	public int getTotalCount(Criteria cri) {
		return adOrderMapper.getTotalCount(cri);
	}

	
}
