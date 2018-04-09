package kr.co.gaia3d.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.gaia3d.domain.User;

/**
 * 사용자
 * @author jeongdae
 *
 */
@Repository
public interface UserMapper {

	/**
	 * 사용자
	 * @param userInfo
	 * @return
	 */

	User getUser(User user);
	
	List<User> getListUser();

	int insertUser(User user);

	
	
}
