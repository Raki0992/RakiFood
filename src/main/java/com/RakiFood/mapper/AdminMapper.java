package com.RakiFood.mapper;

import com.RakiFood.domain.AdminVO;
import com.RakiFood.domain.MemberVO;

public interface AdminMapper {

	AdminVO admin_ok(String admin_id);
	
	void loginTimeUpdate(String admin_id);
	
	void member_list(MemberVO vo);
	

}
