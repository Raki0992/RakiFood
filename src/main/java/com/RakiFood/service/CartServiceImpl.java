package com.RakiFood.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.RakiFood.domain.RFCartVO;
import com.RakiFood.dto.RFCartDTO;
import com.RakiFood.mapper.CartMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CartServiceImpl implements CartService {

	private final CartMapper cartMapper;

	@Override
	public void cart_add(RFCartVO vo) {
		cartMapper.cart_add(vo);
	}

	@Override
	public List<RFCartDTO> cart_list(String mbsp_id) {
		return cartMapper.cart_list(mbsp_id); 
	}

	@Override
	public void cart_amount_change(Long rfcart_code, int rfcart_amount) {
		cartMapper.cart_amount_change(rfcart_code, rfcart_amount); 
	}

	@Override
	public void cart_list_del(Long rfcart_code) {
		cartMapper.cart_list_del(rfcart_code); 
	}

	@Override
	public void cart_sel_delete(List<Long> rfcart_code_arr) {
		
		for(int i=0; i<rfcart_code_arr.size(); i++) {
			cartMapper.cart_sel_delete(rfcart_code_arr.get(i));
		}
	}

	@Override
	public void cart_sel_delete2(List<Long> rfcart_code_arr) {
		cartMapper.cart_sel_delete2(rfcart_code_arr);
	}

	

	
}
