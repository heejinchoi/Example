package kr.co.gaia3d.service;

import java.util.List;

import kr.co.gaia3d.domain.User;

public interface UserService {

	User getUser(User userId);
	
	int insertUser(User user);
	
	/**
	 * 사용자 목록
	 * @return
	 */
	List<User> getListUser();
	
	User checkSignup(User userId);

}
