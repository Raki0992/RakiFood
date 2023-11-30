package com.RakiFood.service;

import java.util.List;

import com.RakiFood.domain.RFReviewVO;
import com.RakiFood.dto.Criteria;

public interface ReviewService {

	void review_insert(RFReviewVO vo);
	
	List<RFReviewVO> list(Integer pro_num, Criteria cri);	// 검색기능 사용안함
	
	int listCount(Integer pro_num);
	
	void delete(Long rew_num);
	
	void review_modify(RFReviewVO vo);
}
