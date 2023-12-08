package com.RakiFood.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.RakiFood.domain.MemberVO;
import com.RakiFood.mapper.AdmemberMapper;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class AdmemberServiceImpl implements AdmemberService {

	private final AdmemberMapper admemberMapper;

	@Override
	public List<com.RakiFood.domain.MemberVO> member_list(com.RakiFood.dto.Criteria cri) {
		return admemberMapper.member_list(cri);
	}

	@Override
	public int getTotalCount(com.RakiFood.dto.Criteria cri) {
		return admemberMapper.getTotalCount(cri);
	}

	@Override
	public void member_delete(String raki_id) {
		admemberMapper.member_delete(raki_id);
	}

	@Override
	public com.RakiFood.domain.MemberVO member_edit(String raki_id) {
		return admemberMapper.member_edit(raki_id);
	}

	@Override
	public void member_edit_ok(MemberVO vo) {
		admemberMapper.member_edit_ok(vo);
	}

	

	


	
	

	
}
