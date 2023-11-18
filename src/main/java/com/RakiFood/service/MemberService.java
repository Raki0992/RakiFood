package com.RakiFood.service;

import org.apache.ibatis.annotations.Param;

import com.RakiFood.domain.MemberVO;

public interface MemberService{
	String idCheck(String raki_id);
	
	void join(MemberVO vo);
	
	MemberVO login(String raki_id);
	
	void modify(MemberVO vo);
	
	void loginTimeUpdate(String raki_id);
	
	void delete(String raki_id);
	
	String getIDEmail(@Param("raki_id") String raki_id, @Param("raki_email") String raki_email);
	
	void changePW(@Param("raki_id") String raki_id, @Param("enc_pw") String enc_pw);
	
	MemberVO getID(String raki_name ,String raki_email);
} 
