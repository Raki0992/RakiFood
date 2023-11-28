package com.RakiFood.mapper;

import java.util.List;

import com.RakiFood.domain.FreeTalkVO;
import com.RakiFood.dto.Criteria;

public interface HomeMapper {

	// 글쓰기
	void freetalk(FreeTalkVO vo);
	
	List<FreeTalkVO> free_list(Criteria cri);

	int getTotalCount(Criteria cri);
}
