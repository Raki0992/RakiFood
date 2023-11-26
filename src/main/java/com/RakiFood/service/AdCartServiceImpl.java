package com.RakiFood.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.RakiFood.dto.Criteria;
import com.RakiFood.dto.RFCartDTO;
import com.RakiFood.mapper.AdCartMapper;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class AdCartServiceImpl implements AdCartService {
	
	private final AdCartMapper adCartMapper;


}
