package spring.controller;

import javax.servlet.http.HttpServletRequest;

import spring.model.Address; 
import spring.model.MemberInfo;
import spring.validator.MemberInfoValidator;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

	@Controller
	@RequestMapping("/account/create.do")
	public class CreateAccountController {

	   @ModelAttribute("command")
	   public MemberInfo formBacking(HttpServletRequest request) {
	      if (request.getMethod().equalsIgnoreCase("GET")) { //getMethod=요청방식을 가져오는거
	         MemberInfo mi = new MemberInfo();
	         Address address = new Address();
	         address.setZipcode(autoDetectZipcode(request.getRemoteAddr()));
	         //request.getRemoteAddr=접속한 클라이언트의 ip주소를 가져옴
	         mi.setAddress(address);//멤버인포객체안의 address에 저장
	         return mi; //command란 이름으로 모델데이터로 추가
	      } else {
	         return new MemberInfo();
	      }
	   }

	   private String autoDetectZipcode(String remoteAddr) {
	      return "00000";
	   }

	   @RequestMapping(method = RequestMethod.GET)
	   public String form() {
	      return "account/creationForm";
	   }

	   @RequestMapping(method = RequestMethod.POST)
	   public String submit(@ModelAttribute("command") MemberInfo memberInfo,
	         BindingResult result) {
	      new MemberInfoValidator().validate(memberInfo, result);
	      if (result.hasErrors()) { //에러가 있니? 없으면 if나와서
	         return "account/creationForm"; 
	      }
	      return "account/created";
	   }
	   
	   
	
	}
