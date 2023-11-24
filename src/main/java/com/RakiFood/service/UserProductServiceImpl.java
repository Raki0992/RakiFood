package com.RakiFood.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.RakiFood.domain.ProductVO;
import com.RakiFood.domain.RFCartVO;
import com.RakiFood.dto.Criteria;
import com.RakiFood.mapper.UserProductMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserProductServiceImpl implements UserProductService {
	private final UserProductMapper userProductMapper;

	@Override
	public List<ProductVO> pro_list(Integer cg_code, Criteria cri) {
		return userProductMapper.pro_list(cg_code, cri);
	}

	@Override
	public int getTotalCount(Integer cg_code) {
		return userProductMapper.getTotalCount(cg_code);
	}

	@Override
	public ProductVO pro_detail(Integer pro_num) {
		return userProductMapper.pro_detail(pro_num);
	}

	@Override
	public void buy_now(RFCartVO rvo, Integer pro_num) {
		userProductMapper.buy_now(rvo, pro_num); 
	}

}







