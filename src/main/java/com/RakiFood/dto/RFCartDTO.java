package com.RakiFood.dto;

import lombok.Data;

@Data
public class RFCartDTO {
	private Long rfcart_code;
	private Integer pro_num; 
	private int rfcart_amount;
	
	private String pro_name;
	private int 	pro_price;
	private String	pro_img;
	private int 	pro_discount;
	private String	pro_up_folder; 
}
