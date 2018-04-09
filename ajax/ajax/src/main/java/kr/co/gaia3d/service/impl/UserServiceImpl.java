package kr.co.gaia3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.gaia3d.domain.User;
import kr.co.gaia3d.persistence.UserMapper;
import kr.co.gaia3d.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	

	@Autowired
	private UserMapper userMapper;

	@Transactional(readOnly=true)
	public User getUser(User userId) {
		return userMapper.getUser(userId);
	}
	
	/**
	 * 사용자 목록
	 * @return
	 */
	@Transactional(readOnly=true)
	public List<User> getListUser() {
		return userMapper.getListUser();
	}

	@Transactional
	public int insertUser(User user) {
		return userMapper.insertUser(user);

	}
	
	@Override
	public User checkSignup(User userId) {
		return userMapper.getUser(userId);
	}




}
