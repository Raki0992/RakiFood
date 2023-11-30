package com.RakiFood.service;

import org.springframework.stereotype.Service;

import com.RakiFood.domain.RFReviewVO;
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

}
