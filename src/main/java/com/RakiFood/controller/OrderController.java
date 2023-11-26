package com.RakiFood.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.RakiFood.domain.MemberVO;
import com.RakiFood.domain.OrderDetailVO;
import com.RakiFood.domain.OrderVO;
import com.RakiFood.domain.PaymentVO;
import com.RakiFood.dto.RFCartDTO;
import com.RakiFood.kakaopay.ApproveResponse;
import com.RakiFood.kakaopay.ReadyResponse;
import com.RakiFood.service.CartService;
import com.RakiFood.service.KakaoPayServiceImpl;
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
	
	private final KakaoPayServiceImpl kakaoPayServiceImpl;
	
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

	// 카카오페이 결제선택을 진행했을 경우
		// 1) 결제준비요청작업
		@GetMapping(value = "/orderPay", produces = "application/json")
		public @ResponseBody ReadyResponse payReady(String paymethod, OrderVO o_vo, OrderDetailVO od_vo, PaymentVO p_vo, int totalprice, HttpSession session) throws Exception {
			/*
			 *  // 주문테이블(OrderVO) : ord_status, payment_status 정보 존재안함, 
			 *     주문상세테이블(OrderDetailVO) : 장바구니테이블에서 데이터를 참조, 
			 *     결제테이블 : 보류 
			 *     
	    		// 카카오페이 결제에 필요한 정보구성
	    		// 스프링에서 처리할 수 있는 부분
			 */
			String raki_id = ((MemberVO) session.getAttribute("loginStatus")).getRaki_id();
			o_vo.setRaki_id(raki_id); // 아이디 저장
			
			// 시퀀스를 주문번호로 사용 : 동일한 주문번호값이 사용
			Long ord_code = (long) orderSerivce.getOrderSeq();
			o_vo.setOrd_code(ord_code); // 주문번호 저장
			
			log.info("결제방법: " + paymethod);
			log.info("주문정보: " + o_vo);
			
			o_vo.setOrd_status("주문완료");
			o_vo.setPayment_status("결제완료");
			
			List<RFCartDTO> cart_list = cartService.cart_list(raki_id);
			
			String itemName = cart_list.get(0).getPro_name() + "외" + String.valueOf(cart_list.size() -1) + "건";
			
			orderSerivce.order_insert(o_vo);	// 주문,주문상세 정보저장, 장바구니 삭제
			
			// 1)kakao Pay 호출(결제준비요청작업)
			ReadyResponse readyResponse = kakaoPayServiceImpl.payReady(o_vo.getOrd_code(), itemName, cart_list.size(), raki_id, totalprice);
			
			log.info("결제고유번호: " + readyResponse.getTid());
			log.info("결제요청URL: " + readyResponse.getNext_redirect_pc_url());
			
			// kakao Pay 결제 승인 요청작업에 필요한 정보준비
			session.setAttribute("tid", readyResponse.getTid());
			session.setAttribute("ord_code", o_vo.getOrd_code());
			
			return readyResponse; 
		}
		
		// 결제 승인 요청작업 http://localhost:9090/user/order/orderApproval
		@GetMapping("/orderApproval/")
		public String orderApproval(@RequestParam("pg_token") String pg_token, HttpSession session) {
			
			// 2) kakao Pay 결제승인요청작업
			Long ord_code = (Long) session.getAttribute("ord_code");
			String tid = (String) session.getAttribute("tid");
			String raki_id = ((MemberVO) session.getAttribute("loginStatus")).getRaki_id();
			
			ApproveResponse approveResponse = kakaoPayServiceImpl.payApprove(ord_code, tid, pg_token, raki_id); 
			
			session.removeAttribute("ord_code");
			session.removeAttribute("tid");
			
			return "redirect:/user/order/orderComplete";
		}
		
		// 결제 완료페이지	
		@GetMapping("/orderComplete/")
		public void orderComplete() {
			
		}
		
		// 결제 취소시 http://localhost:9090/user/order/orderCancel
		@GetMapping("/orderCancel/")
		public void orderCancel() {
			
		}
		
		// 결제 실패시 http://localhost:9090/user/order/orderFail
		@GetMapping("/orderFail/")
		public void orderFail() {
			
		}
	
}











