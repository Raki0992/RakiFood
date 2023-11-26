package com.RakiFood.dto;
import java.util.Date;

import lombok.Data;

@Data
public class SetOrderDTO {
	// 상품정보
	private Integer pro_num;
	
	private Integer cg_code;	// 2차 카테고리 코드
	private String  pro_name;
	private int 	pro_price;
	private int 	pro_discount;
	private String 	pro_publisher;
	private String	pro_content;
	
	private String	pro_up_folder;	// 스프링에서 별도로 처리
	private String	pro_img;	// 스프링에서 별도로 처리
	
	private int 	pro_amount;
	private String  pro_buy;
	
	private Date	pro_date;
	private Date	pro_updatedate;
	
	private Long ord_code;	// db의 시퀀스 사용
	private String raki_id;	// 인증세션에서 참조
	
	// 주문정보
	// 주문정보페이지에서 전송받음
	private String ord_name;
	private String ord_zipcode;
	private String ord_addr_basic;
	private String ord_addr_detail;
	private String ord_tel;
	private int ord_price;
	
	private Date ord_regdate;	// sysdate
	 
	private String ord_status;
	private String payment_status;
}
