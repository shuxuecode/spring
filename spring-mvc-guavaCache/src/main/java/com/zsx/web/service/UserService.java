package com.zsx.web.service;
import com.zsx.web.entity.User;

import java.util.List;

public interface UserService {

	User searchById(String id);
	
//	Page search(Page pager);
	
	int insert(User user);

//	int update(User user);
	
	int delete(String id);

	List<User> getAll();

	List<User> getAllFromCache();

}