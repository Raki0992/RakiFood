package com.RakiFood.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.RakiFood.domain.RFReviewVO;
import com.RakiFood.dto.Criteria;
import com.RakiFood.mapper.ReviewMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {
	
	private final ReviewMapper reviewMapper;

	@Override
	public void review_insert(RFReviewVO vo) {
		reviewMapper.review_insert(vo);
	}

	@Override
	public List<RFReviewVO> list(Integer pro_num, Criteria cri) {
		return reviewMapper.list(pro_num, cri);
	}

	@Override
	public int listCount(Integer pro_num) {
		return reviewMapper.listCount(pro_num);
	}

	@Override
	public void delete(Long rew_num) {
		reviewMapper.delete(rew_num);
	}

	@Override
	public void review_modify(RFReviewVO vo) {
		reviewMapper.review_modify(vo); 
	}

}
