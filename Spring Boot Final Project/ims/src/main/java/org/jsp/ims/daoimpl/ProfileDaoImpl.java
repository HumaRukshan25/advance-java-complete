package org.jsp.ims.daoimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.ims.dao.ProfileDao;
import org.jsp.ims.entity.Profile;
import org.jsp.ims.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileDaoImpl  implements ProfileDao{
	
	@Autowired
	private ProfileRepository repository;
	
	public Profile saveProfile(Profile profile) {
		return  repository.save(profile);
	}
	
	public List<Profile> findAllProfiles(){
		return repository.findAll();
	}
	
	public Optional<Profile> findProfileById(int id){
		return repository.findById(id);
		
		
	}
	
	

}
