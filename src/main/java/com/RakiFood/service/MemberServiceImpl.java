package com.RakiFood.service;

import org.springframework.stereotype.Service;

import com.RakiFood.domain.MemberVO;
import com.RakiFood.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@Service
public class MemberServiceImpl implements MemberService {
	// 자동주입
	// @RequiredArgsConstructor : memberMapper필드를 매개변수로 하는 생성자 메소드가 생성된다.
	// private MemberServiceImpl(MemberMapper memberMapper) {
	//		this.memberMapper = memberMapper;
	//	}
	private final MemberMapper memberMapper;
 
	@Override
	public String idCheck(String raki_id) {
		return memberMapper.idCheck(raki_id);
	}

	@Override
	public void join(MemberVO vo) {
		 memberMapper.join(vo);
		
	}

	@Override
	public MemberVO login(String raki_id) {
		return memberMapper.login(raki_id); 
	}

	@Override
	public void modify(MemberVO vo) {
		memberMapper.modify(vo);
	}

	@Override
	public void loginTimeUpdate(String raki_id) {
		memberMapper.loginTimeUpdate(raki_id);
	}

	@Override
	public void delete(String raki_id) {
		memberMapper.delete(raki_id); 
	}

	@Override
	public String getIDEmail(String raki_id, String raki_email) {
		return memberMapper.getIDEmail(raki_id, raki_email); 
	}

	@Override
	public void changePW(String raki_id, String enc_pw) {
		memberMapper.changePW(raki_id, enc_pw);
	}

	@Override
	public MemberVO getID(String raki_name ,String raki_email) {
		return memberMapper.getID(raki_name, raki_email);
	}

	

	
}
