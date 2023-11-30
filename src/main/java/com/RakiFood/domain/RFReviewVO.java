package com.RakiFood.domain;

import java.util.Date;

import lombok.Data;

@Data
public class RFReviewVO {
	/*
	 * CREATE TABLE RFREVIEW_TBL(
        REW_NUM         NUMBER,
        RAKI_ID         VARCHAR2(15)                NOT NULL,
        PRO_NUM         NUMBER                      NOT NULL,
        REW_CONTENT     VARCHAR2(200)               NOT NULL,
        REW_SCORE       NUMBER                      NOT NULL,
        REW_REGDATE     DATE DEFAULT SYSDATE        NOT NULL
);
	 */
	private Long	rew_num;
	private String	raki_id;
	private Integer pro_num;
	private String  rew_content;
	private int		rew_score;
	private Date	rew_regdate;
	
}
