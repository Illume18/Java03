package spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.service.SearchCommand;
import spring.service.SearchResult;
import spring.service.SearchService;
import spring.service.SearchType;

@Controller
public class GameSearchController {

	@Autowired
	private SearchService searchService;
	
	@ModelAttribute("searchTypeList") //먼저실행됨. /모델이름
	public List<SearchType> referenSearchTypes(){
		List<SearchType> options = new ArrayList<SearchType>();
		options.add(new SearchType(1,"전체"));
		options.add(new SearchType(2, "뉴스"));
		options.add(new SearchType(3, "블로그"));
		return options; //리스트 객체가 모델로 추가
		
	}
	
	@ModelAttribute("popularQueryList") //먼저실행됨. /모델이름
	public String[] getPopularQueryList() {
		return new String[] {"게임", "웹툰", "뷰티"};
	}
	
	@RequestMapping("/search/main.do")
	public String main() {
		return "search/main"; //뷰네임 리턴
	}
	
	@RequestMapping("/search/game.do")
	public ModelAndView search(@ModelAttribute("command") SearchCommand command) {
		 //ModelAndView생성자 첫번째 매개변수는 view name
		ModelAndView mav = new ModelAndView("search/game");
		System.out.println("검색어 ="+ command.getQuery().toUpperCase());
		SearchResult result = searchService.search(command);
		mav.addObject("searchResult", result);
		return mav;
	}
	
	@ExceptionHandler(NullPointerException.class)
	public String handleNullPonterException(NullPointerException ex) {
		return "error/nullException";
	}
	
	public void setSearchService(SearchService searchService) {
		this.searchService = searchService;
	}
}
