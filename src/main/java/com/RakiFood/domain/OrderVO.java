package com.RakiFood.domain;

import java.util.Date;

import lombok.Data;

@Data
public class OrderVO {
	/*
	CREATE TABLE RF_ORDER_TBL(
        ORD_CODE            NUMBER                  PRIMARY KEY,
        RAKI_ID             VARCHAR2(15)            NOT NULL,
        ORD_NAME            VARCHAR2(30)            NOT NULL,
        ORD_ZIPCODE         CHAR(5)                 NOT NULL,
        ORD_ADDR_BASIC      VARCHAR2(50)            NOT NULL,
        ORD_ADDR_DETAIL     VARCHAR2(50)            NOT NULL,
        ORD_TEL             VARCHAR2(20)            NOT NULL,
        ORD_PRICE           NUMBER                  NOT NULL,  -- 총주문금액. 선택
        ORD_REGDATE         DATE DEFAULT SYSDATE    NOT NULL,
        ORD_STATUS          VARCHAR2(20)            NOT NULL,  -- 주문상태
        PAYMENT_STATUS      VARCHAR2(20)            NOT NULL,  -- 결제상태
        FOREIGN KEY(RAKI_ID) REFERENCES RAKI_TBL(RAKI_ID)
);
	*/
	private Long ord_code;	// db의 시퀀스 사용
	private String raki_id;	// 인증세션에서 참조
	
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
