package org.jsp.ims.serviceimpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jsp.ims.dao.ProfileDao;
import org.jsp.ims.entity.Profile;
import org.jsp.ims.responsestructure.ResponseStructure;
import org.jsp.ims.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileDao dao;

	private static final String FOLDER_PATH = "C:\\Users\\Sania Mir\\OneDrive\\Desktop\\uploaded images\\";
	


	@Override
	public ResponseEntity<?> saveProfile(MultipartFile file) {
		String name = file.getOriginalFilename();
		String filePath = FOLDER_PATH + name;
	
	

		try {
			file.transferTo(new File(filePath));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		


		Profile profile = dao.saveProfile(Profile.builder().name(name).filePath(filePath).build());

		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("profile saved successsfully").body(profile).build());

	}

	@Override
	public ResponseEntity<?> findAllProfiles() {
		List<Profile> profiles = dao.findAllProfiles();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("profile saved successsfully").body(dao.findAllProfiles()).build());

	}

}
