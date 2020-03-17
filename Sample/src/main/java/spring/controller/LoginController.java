package spring.controller;

import javax.validation.Valid;

import spring.service.AuthenticationException;
import spring.service.Authenticator;
import spring.service.LoginCommand;
import spring.validator.LoginCommandValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login/login.do")
public class LoginController {

	private String formViewName	= "login/form";
	
	@Autowired
	private Authenticator authenticator;
	
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return formViewName;
	}
	
	//loginCommand
	@ModelAttribute
	public LoginCommand formBacking() {
		return new LoginCommand(); //모델데이터로 추가됨. 지정안해서 타입으로 이름지정됨 = loginCommand
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(@Valid LoginCommand loginCommand,
			BindingResult result) {
		if (result.hasErrors()) {
			return formViewName;
		}
		try { //인증
			authenticator.authenticate(loginCommand);//id,password저장된 객체 들고감
			return "redirect:/index.jsp";
		} catch (AuthenticationException e) {
			result.reject("invalidIdOrPassword", new Object[] {loginCommand
					.getUserId()}, null); //글로벌에러 추가
			return formViewName; //폼으로 돌아갈 수 있게
		}
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new LoginCommandValidator());
	}
	
	public void setAuthenticator(Authenticator loginService) {
		this.authenticator = loginService;
	}
	//@InitBinder -->@ModelAttribute -->@RequestMapping 순서로 진행
}
