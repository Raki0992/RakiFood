package com.RakiFood.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.RakiFood.domain.MemberVO;
import com.RakiFood.dto.RFCartDTO;
import com.RakiFood.service.CartService;
import com.RakiFood.service.OrderSerivce;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/user/order/*")
public class OrderController {
	
	private final OrderSerivce orderSerivce;
	
	private final CartService cartService;
	
	// 주문페이지
	@GetMapping("/order_info")
	public void order_info(HttpSession session, Model model) throws Exception {
		
		// 주문정보
		String raki_id = ((MemberVO) session.getAttribute("loginStatus")).getRaki_id();
		
		List<RFCartDTO> order_info = cartService.cart_list(raki_id);
		
		int order_price = 0;
			
		for(int i=0; i<order_info.size(); i++) {
			RFCartDTO vo = order_info.get(i);
			
			vo.setPro_up_folder(vo.getPro_up_folder().replace("\\", "/"));
			
			order_price += (vo.getPro_price()* vo.getRfcart_amount());
		}
				
		model.addAttribute("order_info", order_info);
		model.addAttribute("order_price", order_price);
	}

}











