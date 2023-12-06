package com.RakiFood.mapper;

import java.util.List;

import com.RakiFood.domain.FreeTalkVO;
import com.RakiFood.dto.Criteria;

public interface AdFreeTalkMapper {
	void freetalk(FreeTalkVO vo);

	List<FreeTalkVO> free_list(Criteria cri);

	int getTotalCount(Criteria cri);
	
	void freetalk_delete(String raki_id);
	
	FreeTalkVO freetalk_edit(String raki_id);
	
	void freetalk_edit_ok(FreeTalkVO vo);
}
