package com.RakiFood.service;

import com.RakiFood.dto.EmailDTO;

public interface EmailService {

	 void sendMail(EmailDTO dto, String message);
		
	
}
