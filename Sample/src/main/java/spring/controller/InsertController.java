package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.Mem.MemDto;
import spring.service.InsertService;


@Controller //스캔하면 자동으로 bean으로 등록됨
@RequestMapping("/insert.do")
public class InsertController {

	
	InsertService service;
	@Autowired
	public void setService(InsertService service) {
		this.service = service;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String insertForm() {
		return "insertForm";
	}
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView insertSubmit(@ModelAttribute("mem") MemDto dto) {
		ModelAndView mav = new ModelAndView();
		int i = service.insertMem(dto);
		mav.addObject("i", i);//i가 가진값으로 i를 리턴
		mav.setViewName("insertResult");
		return mav;
	}
	
	
	
	
	
	/*
	 * @Autowired private InsertService insertService;
	 * 
	 * //@RequestMapping 메서드의 리턴타입이 string => return 값을 viewname으로 사용
	 * 
	 * @RequestMapping(method = RequestMethod.GET) public String form() { return
	 * "insert/insertForm";//중요!! 리턴값을 viewname으로 지정 }
	 * 
	 * @RequestMapping(method = RequestMethod.POST) // 1.dispatcher가 아티클커맨드 객체를 만든다.
	 * 다 쓰고 자동으로 모델데이터로 리턴한다. 이름을 정해도 되고 안정하면 // 타입을 그대로 이름으로 삼는다(첫글자소문자로) public
	 * String submit(MemDto dto) {// 2.리퀘스트 매핑 어노테이션이 파라미터이름과 변수와 같으면 저장
	 * 
	 * insertService.insertMem(dto);// 3.저장한걸 뷰에서 쓸 수 있는 모델데이터로 바꾼다./123은 우리가 하는게
	 * 아니라 자동으로. return "insert/insertResult";// @ModelAttribute 어떤이름으로 저장할건지 정한다.
	 * //post없는 상태에서 post 하면 상태 405 – 허용되지 않는 메소드. // 발생 }
	 * 
	 * 
	 * 
	 * public void setArticleService(InsertService insertService) {
	 * this.insertService = insertService; }
	 */
}
