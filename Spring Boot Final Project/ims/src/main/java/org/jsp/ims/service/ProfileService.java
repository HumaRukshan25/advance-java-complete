package org.jsp.ims.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ProfileService {

	ResponseEntity<?> saveProfile(MultipartFile file);

	ResponseEntity<?> findAllProfiles();
	

}
