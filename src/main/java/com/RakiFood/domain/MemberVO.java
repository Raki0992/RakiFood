package com.RakiFood.domain;

import java.util.Date;

import lombok.Data;
@Data
public class MemberVO {
/*
 * CREATE TABLE RAKI_TBL(
        RAKI_ID             VARCHAR2(15),
        RAKI_NAME           VARCHAR2(30)            NOT NULL,
        RAKI_EMAIL          VARCHAR2(50)            NOT NULL,
        RAKI_PASSWORD       CHAR(60)               NOT NULL,        -- 비밀번호 암호화 처리.
        RAKI_ZIPCODE        CHAR(5)                 NOT NULL,
        RAKI_ADDR           VARCHAR2(100)            NOT NULL,
        RAKI_DEADDR         VARCHAR2(100)            NOT NULL,
        RAKI_PHONE          VARCHAR2(15)            NOT NULL,
        RAKI_POINT          NUMBER DEFAULT 0        NOT NULL,
        RAKI_LASTLOGIN      DATE DEFAULT SYSDATE    NOT NULL,
        RAKI_DATESUB        DATE DEFAULT SYSDATE    NOT NULL,
        RAKI_UPDATEDATE     DATE DEFAULT SYSDATE    NOT NULL
);
 */
	/* - 주요사용되는 기능
	 * - 회원가입, 회원수정 폼, 회원수정하기
	 * - db회원테이블에서 정보를 읽어올 때 
	*/
	
	// 멤버필드	Date는 java.util 
	private String raki_id;
	private String raki_name;
	private String raki_email;
	private String raki_password;
	private String raki_zipcode;
	private String raki_addr;
	private String raki_deaddr; 
	private String raki_phone;
	private int    raki_point;
	private Date   raki_lastlogin;
	private Date   raki_datesub;
	private Date   raki_updatedate;
}
