package com.RakiFood.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.RakiFood.domain.FreeTalkVO;
import com.RakiFood.dto.Criteria;
import com.RakiFood.mapper.HomeMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class HomeServiceImpl implements HomeService {
	
	private final HomeMapper homeMapper;

	@Override
	public void freetalk(FreeTalkVO vo) {
		homeMapper.freetalk(vo);
	}

	@Override
	public List<FreeTalkVO> free_list(Criteria cri) {
		return homeMapper.free_list(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		return homeMapper.getTotalCount(cri);
	}

	@Override
	public void freetalk_delete(String raki_id) {
		homeMapper.freetalk_delete(raki_id);
	}

	@Override
	public FreeTalkVO freetalk_edit(String raki_id) {
		return homeMapper.freetalk_edit(raki_id);
	}

	@Override
	public void freetalk_edit_ok(FreeTalkVO vo) {
		homeMapper.freetalk_edit_ok(vo);
	}

}
