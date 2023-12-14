package com.RakiFood.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.RakiFood.domain.OrderDetailInfoVO;
import com.RakiFood.domain.OrderDetailProductVO;
import com.RakiFood.domain.OrderVO;
import com.RakiFood.dto.Criteria;

public interface AdOrderMapper {

	List<OrderVO> order_list(@Param("cri") Criteria cri, @Param("start_date") String start_date, @Param("end_date") String end_date);
	
	int getTotalCount(@Param("cri") Criteria cri, @Param("start_date") String start_date, @Param("end_date") String end_date);
	
	List<OrderDetailInfoVO> OrderDetailInfo1(Long ord_code);
	
	// 기존클래스 2개 합쳐서 사용(OrderDetailVO, ProductVO)필드 사용 	mybatis의  resultMap 사용
	List<OrderDetailProductVO> OrderDetailInfo2(Long ord_code);
	
	void order_product_delete(@Param("ord_code") Long ord_code, @Param("pro_num") Integer pro_num);	
	
}
