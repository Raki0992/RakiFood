package com.RakiFood.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.RakiFood.domain.RFReviewVO;
import com.RakiFood.dto.Criteria;

public interface ReviewMapper {

	void review_insert(RFReviewVO vo);
	
	List<RFReviewVO> list(@Param("pro_num") Integer pro_num, @Param("cri") Criteria cri);	// 검색기능 사용안함
	
	int listCount(Integer pro_num);
	
	void delete(Long rew_num);
	
	void review_modify(RFReviewVO vo);
}
