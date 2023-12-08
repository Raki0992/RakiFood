package com.RakiFood.service;

import java.util.List;

import com.RakiFood.domain.PaymentVO;
import com.RakiFood.dto.Criteria;

public interface AdOrderService {

	List<PaymentVO> order_list(Criteria cri);
	
	int getTotalCount(Criteria cri);
}
