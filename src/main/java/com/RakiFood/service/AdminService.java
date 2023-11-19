package com.RakiFood.service;

import com.RakiFood.domain.AdminVO;

public interface AdminService {

	AdminVO admin_ok(String admin_id);
	
	void loginTimeUpdate(String admin_id);
	

}
