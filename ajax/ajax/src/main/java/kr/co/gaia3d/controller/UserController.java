package kr.co.gaia3d.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.AlternativeJdkIdGenerator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.gaia3d.domain.User;
import kr.co.gaia3d.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	/******************************************************************************/
	
	@RequestMapping(value ="/main", method = RequestMethod.GET)
	public String main(HttpServletRequest request) {
		logger.info("메인 페이지 준비 되었음");
		
		return "user/main";
	}
	
	
	@RequestMapping(value ="/list", method = RequestMethod.GET)
	public String listAll(Model model) {
		logger.info("목록 페이지 준비 되었음");
		
		List<User> userList = userService.getListUser();
		
		model.addAttribute("userList", userList);
		
		return "user/list";
	}
	
	
	@RequestMapping(value="/register")
	public String register(HttpServletRequest request, User user) {
		logger.info("회원가입 페이지 준비 되었음");
		
		return "user/register";
	}
	
	@RequestMapping(value="/insertUser", method = RequestMethod.POST )
	public String insertUser(HttpServletRequest request, User user) {
		logger.info("회원 가입 된 아이디: " + user.getUserId());
		userService.insertUser(user);
		
		return "user/register";
	}

	@RequestMapping(value="/login")
	public String login(HttpServletRequest request, User user) {
		logger.info("로그인 페이지 준비 되었음");
		
		return "user/login";
	}
	
	@RequestMapping(value="/modify")
	public String registerModify(HttpServletRequest request, User user) {
		logger.info("회원수정 페이지 준비 되었음");
		
		return "user/modify";
	}
	

	
	@RequestMapping(value="/ajax-register", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> ajaxRegister(Model model, User user) {
		Map<String, Object> jSONObject = new HashMap<String, Object>();
		String result = "success";
		try {
			
			logger.info("회원 가입 된 아이디: " + user.getUserId());
			userService.insertUser(user);
					
			jSONObject.put("result", result);
			
		} catch(Exception e) {
			e.printStackTrace();
			jSONObject.put("result", "fail");
		}
		return jSONObject;
	}
	
	
	
	@RequestMapping(value="/ajax-idChck", method = RequestMethod.POST)
	@ResponseBody
	public int ajaxIdCheck(HttpServletRequest request, Model model) {
	        
	        return 0;

	}
	
	
}
