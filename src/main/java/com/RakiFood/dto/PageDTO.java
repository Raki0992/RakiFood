package com.RakiFood.dto;

import lombok.Getter;
import lombok.ToString;

// 페이징기능 목적클래스.	[prev] 1 2 3 4 5 6 7 8 9 10 [next]

@Getter
@ToString
public class PageDTO {

	private int startPage;	// 각 블럭에서 출력할 시작페이지번호
	private int endPage;	// 각 블럭에서 출력할 종료페이지번호
	
	private boolean prev, next;	// 이전, 다음 표시여부
	
	private int total;	// 테이블의 데이터 총 개수
	
	private Criteria cri;	// 1) 페이징 : pageNum,amount		2) 검색 : type,keyword
	
	public PageDTO(Criteria cri, int total) {
		
		/* 나머지가 존재하면, 페이지 1개 필요
		 * total : 13개
		 * amount : 5개
		 * 페이지 수 : 3
		 * 
		 * 나머지가 존재안하면, 페이지 1개 불필요
		 * total : 10개
		 * amount : 5개
		 * 페이지 수 : 2
		 * 
		 */
		this.cri = cri;	// 1) 검색조건이 없을 경우 
		this.total = total;
		
		int pageSize = 10;	// 블럭에 보여줄 페이지번호의 개수	1 2 3 4 5 6 7 8 9 10
		int endPageInfo = pageSize -1;	// 9
		
		//this.endPage = (int) (Math.ceil(1 / 10.0)) * 10;
		this.endPage = (int) (Math.ceil(cri.getPageNum() / (double) pageSize)) * pageSize;
		
		this.startPage = this.endPage - endPageInfo;
		
		int readEnd = (int) (Math.ceil((total * 1.0) / cri.getAmount()));
		
		if(readEnd <= this.endPage) {
			this.endPage = readEnd;
		}
		
		this.prev = this.startPage > 1;
		
		this.next = this.endPage < readEnd;
		
		// cri : pageNum=1, amount=10, type=null, keyword=null
		// startPage, endPage, prev, next, 
	}
	
}
