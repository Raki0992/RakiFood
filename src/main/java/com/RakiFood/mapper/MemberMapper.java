package com.RakiFood.mapper;

import org.apache.ibatis.annotations.Param;

import com.RakiFood.domain.MemberVO;

public interface MemberMapper {
// interface는 자동으로 public제공하기 때문에 사용안해도 됨
	
	String idCheck(String raki_id);
	
	void join(MemberVO vo);
	
	MemberVO login(String raki_id);		// 비밀번호 사용안함 암호화복호화
	
	void modify(MemberVO vo);
	
	void loginTimeUpdate(String raki_id);
	
	void delete(String raki_id);
	
	String getIDEmail(@Param("raki_id") String raki_id, @Param("raki_email") String raki_email);
	
	void changePW(@Param("raki_id") String raki_id, @Param("enc_pw") String enc_pw);
	
	MemberVO getID(@Param("raki_name") String raki_name , @Param("raki_email") String raki_email);
	
}
