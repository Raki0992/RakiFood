package com.RakiFood.service;

import java.util.List;

import com.RakiFood.domain.MemberVO;
import com.RakiFood.dto.Criteria;

public interface AdmemberService {

	List<MemberVO> member_list(Criteria cri);

	int getTotalCount(Criteria cri);
	
	void member_delete(String raki_id);
	
	MemberVO member_edit(String raki_id);
	
	void member_edit_ok(MemberVO vo);
	
}
