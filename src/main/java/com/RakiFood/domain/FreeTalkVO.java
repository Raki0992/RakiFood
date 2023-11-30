package com.RakiFood.domain;

import java.util.Date;

import lombok.Data;

@Data
public class FreeTalkVO {
/*
	CREATE TABLE FreeTalk(
	 	FREE_NUM            NUMBER ,
		RAKI_ID             VARCHAR2(15)			,	
		RAKI_NAME           VARCHAR2(30)            NOT NULL,
		Free_title		    VARCHAR2(50)			NOT NULL,
		Free_content		VARCHAR2(100)			NOT NULL,
		Free_updatedate		 DATE DEFAULT SYSDATE   NOT NULL,
		Free_empty			VARCHAR2(15)			
);
*/
	private Integer free_num;
	private String raki_id;
	private String raki_name;
	private String free_title;
	private String free_content;
	private Date   free_updatedate;
	private String free_empty;
}
