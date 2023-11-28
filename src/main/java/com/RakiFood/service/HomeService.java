package com.RakiFood.service;

import java.util.List;

import com.RakiFood.domain.FreeTalkVO;
import com.RakiFood.dto.Criteria;

public interface HomeService {

	void freetalk(FreeTalkVO vo);
	
	List<FreeTalkVO> free_list(Criteria cri);

	int getTotalCount(Criteria cri);
}
