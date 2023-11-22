package com.RakiFood.domain;

import lombok.Data;

@Data
public class RFCartVO {
/*	
 * CREATE TABLE RF_CART_TBL(
    RFCART_CODE        NUMBER,
    PRO_NUM         NUMBER          NOT NULL,
    RAKI_ID         VARCHAR2(15)    NOT NULL,
    RFCART_AMOUNT      NUMBER          NOT NULL
);
 */
	
	private Long rfcart_code;
	
	private Integer pro_num;
	private String raki_id;
	
	private int rfcart_amount;
	
}
