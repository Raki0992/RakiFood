package com.RakiFood.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.RakiFood.domain.FreeTalkVO;
import com.RakiFood.dto.Criteria;
import com.RakiFood.mapper.AdFreeTalkMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AdFreeTalkServiceImpl implements AdFreeTalkService {

	private final AdFreeTalkMapper adFreeTalkMapper;

	@Override
	public void freetalk(FreeTalkVO vo) {
		adFreeTalkMapper.freetalk(vo);
	}

	@Override
	public List<FreeTalkVO> free_list(Criteria cri) {
		return adFreeTalkMapper.free_list(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		return adFreeTalkMapper.getTotalCount(cri);
	}

	@Override
	public void freetalk_delete(String raki_id) {
		adFreeTalkMapper.freetalk_delete(raki_id);
	}

	@Override
	public FreeTalkVO freetalk_edit(String raki_id) {
		return adFreeTalkMapper.freetalk_edit(raki_id);
	}

	@Override
	public void freetalk_edit_ok(FreeTalkVO vo) {
		adFreeTalkMapper.freetalk_edit_ok(vo);
	}
	
	
}
