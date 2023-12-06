package com.RakiFood.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.RakiFood.domain.FreeTalkVO;
import com.RakiFood.dto.Criteria;
import com.RakiFood.dto.PageDTO;
import com.RakiFood.service.AdFreeTalkService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequiredArgsConstructor
@Log4j
@RequestMapping("/admin/talk/*")
@Controller
public class AdFreeTalkController {
	
	private final AdFreeTalkService adFreeTalkService;

	@GetMapping("/talk_list")
	public void talk(FreeTalkVO vo, Criteria cri, Model model) throws Exception {
		
		cri.setAmount(3);
		
		List<FreeTalkVO> talk_list = adFreeTalkService.free_list(cri);
		
		model.addAttribute("talk_list", talk_list);
		
		int totalCount = adFreeTalkService.getTotalCount(cri);
		model.addAttribute("pageMaker", new PageDTO(cri, totalCount));
		
	}
	
	@PostMapping("/talk_delete")
	public String talk_delete(Criteria cri, String raki_id) throws Exception {
		adFreeTalkService.freetalk_delete(raki_id);
		
		return "redirect:admin/talk/talk_delete";
	}
	
	@GetMapping("/talk_edit")
	public void talk_edit(@ModelAttribute("cri") Criteria cri, String raki_id, Model model) throws Exception {
		FreeTalkVO talk_edit_page = adFreeTalkService.freetalk_edit(raki_id);
		
		model.addAttribute("talk_edit_page", talk_edit_page);
	}
	
	@PostMapping("/talk_edit")
	public String talk_edit(Criteria cri, FreeTalkVO vo, RedirectAttributes rttr) throws Exception {
		adFreeTalkService.freetalk_edit_ok(vo);
		
		return "redirect:/admin/talk/talk_list";
	}
	 
}
