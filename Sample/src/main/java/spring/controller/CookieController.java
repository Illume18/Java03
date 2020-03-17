package spring.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieController {

	@RequestMapping("/cookie/make.do")
	public String make(HttpServletResponse response) {
		response.addCookie(new Cookie("auth", "abc"));
		//return "/cookie/made"; //쿠키 생성
		return "redirect:/cookie/view.do"; //위 실행하고 아래 확인하는걸 한번에. 쿠키생성->쿠키확인 
	}
	
	@RequestMapping("/cookie/view.do") //이렇게 해도 작동됨 경로찾아서
	public void view(
			@CookieValue(value = "auth", defaultValue = "0") String auth) {
		System.out.println("auth 쿠키:" + auth);
		
		//return "cookie/view";
		   //뷰이름 리다이렉트 뷰이름 지정하는 방법 
	      //리턴타입 String-> return "cookie/view";
	      //리턴타입이 void 맨 앞 /와 확장자를 제외한 나머지 부분이 사용 
	      //리다이렉트  뷰 이름에 잡두어를 붙임 return "redirect:/cookie/view.do";
	}
	
	/*@RequestMapping("/cookie/view.do")
	public String view(
			@CookieValue(value = "auth", defaultValue = "0") String auth) {
		System.out.println("auth 쿠키:" + auth);
		
		return "cookie/view"; */
}
