package com.RakiFood.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RakiFood.domain.MemberVO;
import com.RakiFood.domain.RFReviewVO;
import com.RakiFood.dto.Criteria;
import com.RakiFood.dto.PageDTO;
import com.RakiFood.service.ReviewService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequiredArgsConstructor
@Log4j
@RequestMapping("/user/review*")
@RestController // ajax만 사용시(jsp파일을 사용 안함)
public class ReviewController {
	
	private final ReviewService reviewService;

	// 전통적인 형태의 주소 list?pro_num=10&page=1 -> Rest API개발형태 주소 list/10/1
		@GetMapping("/list/{pro_num}/{page}")
		public ResponseEntity<Map<String, Object>> list(@PathVariable("pro_num") Integer pro_num, @PathVariable("page") Integer page) throws Exception {
			// 리턴타입에 따른 구문
			// - select문
			// ResponseEntity<Map<String, Object>> : 1) 상품후기목록 데이터 - List<ReviewVO>  2) 페이징 데이터 - PageDTO  실제작업
			// ResponseEntity<List<ReviewVO>> : 상품후기 목록 데이터 - List<ReviewVO>
			// ResponseEntity<PageDTO> : 페이징 데이터
			
			// - insert, delete, update문
			// ResponseEntity<String>
			
			ResponseEntity<Map<String, Object>> entity = null;
			Map<String, Object> map = new HashMap<String, Object>();
			
			// 1) 상품후기목록 데이터
			Criteria cri = new Criteria();
			cri.setAmount(5);	// 10 -> 5 출력
			cri.setPageNum(page); 
			
			List<RFReviewVO> list = reviewService.list(pro_num, cri);
			
			// 2) 페이징 데이터
			int listCount = reviewService.listCount(pro_num);
			PageDTO pageMaker = new PageDTO(cri, listCount);
			
			map.put("list", list); 	// 상품후기목록 데이터 - List<RFReviewVO>
			map.put("pageMaker", pageMaker); 	// 페이징 데이터 - PageDTO
			
			// jackson-databind 라이브러리에 의하여 map -> json으로 변환되어 ajax호출한 쪽으로 리턴값이 보내진다.
			entity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
			
			return entity;
	}
		
		// @RequestBody : JSON 데이터를 ReviewVO객체로 변환해주는 기능.. 참고) 반대의미 어노테이션 @ResponseBody
		@PostMapping(value = "/new", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
		public ResponseEntity<String> review_insert(@RequestBody RFReviewVO vo, HttpSession session) throws Exception {
			
			log.info("리뷰:" + vo);
			
			String raki_id = ((MemberVO) session.getAttribute("loginStatus")).getRaki_id();
			vo.setRaki_id(raki_id);
			
			ResponseEntity<String> entity = null;
			
			reviewService.review_insert(vo);
			
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
			
			return entity; 
		}
		
		@DeleteMapping("/delete/{rew_num}")		// /user/review/delete/1
		public ResponseEntity<String> delete(@PathVariable("rew_num") Long rew_num) throws Exception {
			ResponseEntity<String> entity = null;
			
			// db연동작업
			reviewService.delete(rew_num); 
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
			
			return entity;
		}
		
		@PutMapping(value = "/modify", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
		public ResponseEntity<String> review_modify(@RequestBody RFReviewVO vo, HttpSession session) throws Exception {
			
			log.info("리뷰:" + vo);
			
			String raki_id = ((MemberVO) session.getAttribute("loginStatus")).getRaki_id();
			vo.setRaki_id(raki_id);
			
			ResponseEntity<String> entity = null;
			
			// db저장
			reviewService.review_modify(vo);
			
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
			
			return entity; 
		}
		
}
