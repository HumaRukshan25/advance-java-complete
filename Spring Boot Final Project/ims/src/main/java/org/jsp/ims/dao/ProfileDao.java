package org.jsp.ims.dao;

import java.util.List;

import org.jsp.ims.entity.Profile;

public interface ProfileDao {

	List<Profile> findAllProfiles();

	Profile saveProfile(Profile p);



}
