package com.RakiFood.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.RakiFood.domain.FreeTalkVO;
import com.RakiFood.dto.Criteria;
import com.RakiFood.dto.PageDTO;
import com.RakiFood.service.HomeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequiredArgsConstructor
@Log4j
@RequestMapping("/comm/*")
@Controller
public class FreeTalkController {

	private final HomeService homeService;

	// 게시판
	@GetMapping("/talk")
	public void talk(FreeTalkVO vo, Criteria cri, Model model) throws Exception {
		log.info("게시판 정보" + vo) ;
		
		cri.setAmount(3);
		
		List<FreeTalkVO> talk_list = homeService.free_list(cri);
		
		model.addAttribute("talk_list", talk_list);
		
		int totalCount = homeService.getTotalCount(cri);
		model.addAttribute("pageMaker", new PageDTO(cri, totalCount));
		
	}
	
	
	
	
	
	
	
	
}
