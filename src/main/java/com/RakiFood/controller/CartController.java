package com.RakiFood.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.RakiFood.domain.MemberVO;
import com.RakiFood.domain.RFCartVO;
import com.RakiFood.dto.RFCartDTO;
import com.RakiFood.service.CartService;
import com.RakiFood.util.FileUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequiredArgsConstructor
@RequestMapping("/user/cart/*")
@Controller
public class CartController {

	private final CartService cartService;
	
	@Resource(name = "uploadPath")	// servlet-context.xml의 bean이름 참조
	private String uploadPath;
	
	@ResponseBody
	@PostMapping("/cart_add")
	public ResponseEntity<String> cart_add(RFCartVO vo, HttpSession session) throws Exception {
		
		log.info("장바구니: " + vo);
		
		ResponseEntity<String> entity = null;
		 
		// ajax방식에서 상품코드, 수량 2개정보만 전송되어옴 (로그인한 사용자의 아이디정보추가작업)
		String raki_id = ((MemberVO) session.getAttribute("loginStatus")).getRaki_id();
		vo.setRaki_id(raki_id);
		
		cartService.cart_add(vo);
		
		entity = new ResponseEntity<String>("success", HttpStatus.OK);
		
		return entity;
		
	}
	
	// 장바구니 리스트
	@GetMapping("/cart_list")
	public void cart_list(HttpSession session, Model model) throws Exception {
		
		String raki_id = ((MemberVO) session.getAttribute("loginStatus")).getRaki_id();
		
		List<RFCartDTO> cart_list = cartService.cart_list(raki_id);
		
		int cart_total_price = 0;
		
//		cart_list.forEach(vo-> {
//			vo.setPro_up_folder(vo.getPro_up_folder().replace("\\", "/")); 	// 역슬래쉬를 슬래쉬로
//			
//			 // 금액 = (판매가 - (판매가 * 할인율)) * 수량
//			cart_total_price += ((double)vo.getPro_price() - (vo.getPro_price() * vo.getPro_discount() * 1/100)) * (double)vo.getCart_amount();
//		});
		
		for(int i=0; i<cart_list.size(); i++) {
			RFCartDTO vo = cart_list.get(i);
			
			vo.setPro_up_folder(vo.getPro_up_folder().replace("\\", "/"));
			cart_total_price += (vo.getPro_price() * vo.getRfcart_amount());
		}
		
		model.addAttribute("cart_list", cart_list);
		model.addAttribute("cart_total_price", cart_total_price);
		 
	}
	
	// 이미지
	@ResponseBody
	@GetMapping("/imageDisplay")	//		/user/cart/imageDisplay?dateFolderName=값1&fileName=값2
	public ResponseEntity<byte[]> imageDisplay(String dateFolderName, String fileName) throws Exception {
		
		log.info("이미지");
		
		return FileUtils.getFile(uploadPath + dateFolderName, fileName); 
	}
	
	// 장바구니 수량변경
	@PostMapping("/cart_amount_change")
	public ResponseEntity<String> cart_amount_change(Long rfcart_code, int rfcart_amount) throws Exception {
		ResponseEntity<String> entity = null;
		
		cartService.cart_amount_change(rfcart_code, rfcart_amount);
		
//		log.info("카트코드" + rfcart_code);
//		log.info("카트수량" + rfcart_amount);
		
		entity = new ResponseEntity<String>("success", HttpStatus.OK);
		
		return entity;
	}
	
	// 장바구니 목록에서 개별구매

	
	// 장바구니 목록에서 개별삭제(ajax)
	@PostMapping("/cart_list_del")
	public ResponseEntity<String> cart_list_del(Long rfcart_code) throws Exception {
		ResponseEntity<String> entity = null;
		
		cartService.cart_list_del(rfcart_code);
		
//		log.info("카트코드" + rfcart_code);
		
		entity = new ResponseEntity<String>("success", HttpStatus.OK);
		
		return entity;
	}
	
	// 장바구니 목록에서 개별삭제(nonajax)
	@GetMapping("/cart_list_del")
	public String cart_list_del2(Long rfcart_code) throws Exception {
		
		cartService.cart_list_del(rfcart_code);
		
		return "redirect:/user/cart/cart_list";
	}
	
	// 장바구니 목록에서 선택삭제  @RequestParam("pro_num_arr[]")List<Integer> pro_num_arr,
	@PostMapping("/cart_sel_delete")
	public ResponseEntity<String> cart_sel_delete(@RequestParam("rfcart_code_arr[]")List<Long> rfcart_code_arr) throws Exception {
		ResponseEntity<String> entity = null;
		
		cartService.cart_sel_delete(rfcart_code_arr);
		
//		log.info("카트코드" + rfcart_code_arr );
		
		entity = new ResponseEntity<String>("success", HttpStatus.OK);
		
		return entity;
	}
	
	@PostMapping("/cart_sel_delete2")
	public ResponseEntity<String> cart_sel_delete2(@RequestParam("rfcart_code_arr[]")List<Long> rfcart_code_arr) throws Exception {
		ResponseEntity<String> entity = null;
		
		cartService.cart_sel_delete(rfcart_code_arr);
		
		log.info("카트코드" + rfcart_code_arr );
		
		entity = new ResponseEntity<String>("success", HttpStatus.OK);
		
		return entity;
	}
	
}






