package com.RakiFood.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.RakiFood.domain.MemberVO;
import com.RakiFood.dto.Criteria;
import com.RakiFood.dto.PageDTO;
import com.RakiFood.service.AdProductService;
import com.RakiFood.service.AdmemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequiredArgsConstructor
@Log4j
@RequestMapping("/admin/member/*")
@Controller
public class AdmemberController {

	private final AdmemberService admemberService;
	
	private final AdProductService adProductService;
	
	// 회원목록 페이지
		@GetMapping("/member_list")
		public void member_list(Criteria cri, Model model) throws Exception {

			// 출력할 데이터 수 변경안하면 10	 (Criteria)
			cri.setAmount(2);
			
			List<MemberVO> member_list = admemberService.member_list(cri);
			
			model.addAttribute("member_list", member_list);
			
			int totalCount = adProductService.getTotalCount(cri);
			model.addAttribute("pageMaker", new PageDTO(cri, totalCount));
			
		}
		
		// 회원삭제
		@PostMapping("/member_delete")
		public String member_delete(Criteria cri, String raki_id) throws Exception {
			
			admemberService.member_delete(raki_id);
			
			return "redirect:/admin/member/member_list";
		}
		
		// 상품수정 페이지
		@GetMapping("/member_edit")
		public void member_edit(@ModelAttribute("cri") Criteria cri, String raki_id, Model model) throws Exception {
			
			MemberVO memberVO = admemberService.member_edit(raki_id);	// 선택한 상품 정보
			
			model.addAttribute("MemberVO", memberVO);
			
		}
		
		// 회원수정
		@PostMapping("/member_edit")
		public String member_edit(Criteria cri, MemberVO vo, RedirectAttributes rttr) throws Exception {
			
			log.info("회원정보1"+ vo);
			
			admemberService.member_edit_ok(vo);
			
			return "redirect:/admin/member/member_list";
		}
		
}
