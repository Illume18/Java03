package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {

	@RequestMapping("/search/internal.do")
	public ModelAndView searchInternal(
			String query,
			@RequestParam("p") int pageNumber) { //하나인 경우 이런식으로
		System.out.println("query="+query+", pageNumber="+pageNumber);
		return new ModelAndView("search/internal");
	}
	@RequestMapping("/search/external.do") //매개변수로 전달받은 파라미터값이 없다면 null저장
	public ModelAndView searchExternal(String query, 
			@RequestParam(value="p", defaultValue="1") int pageNumber) { //p가 null이면 defaultValue인 1이 저장
		System.out.println("query="+query+", pageNumber="+pageNumber);
		return new ModelAndView("search/external");
	}
}
