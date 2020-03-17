package spring.validator;

import org.springframework.validation.Errors;
import spring.model.Address;
import spring.model.MemberInfo;

public class MemberInfoValidator {

	public boolean supports(Class<?> clazz) {
	      return MemberInfo.class.isAssignableFrom(clazz); //해당타입에 대해서만 검증
	   }

	   public void validate(Object target, Errors errors) {
	      MemberInfo memberInfo = (MemberInfo) target; //오브젝트로 받은거 맴버인포로 바꿔저장
	      if (memberInfo.getId() == null || memberInfo.getId().trim().isEmpty()) {
	         errors.rejectValue("id", "required"); //id란 필드에 대한  required
	      }
	      if (memberInfo.getName() == null || memberInfo.getName().trim().isEmpty()) {
	         errors.rejectValue("name", "required");
	      }
	      Address address = memberInfo.getAddress();
	      if (address == null) {
	         errors.rejectValue("address", "required");
	      }
	      if (address != null) {
	         errors.pushNestedPath("address");
	         try {
	            if (address.getZipcode() == null || address.getZipcode().trim().isEmpty()) {
	               errors.rejectValue("zipcode", "required");
	            }
	            if (address.getAddress1() == null || address.getAddress1().trim().isEmpty()) {
	               errors.rejectValue("address1", "required");
	            }
	         } finally {
	            errors.popNestedPath();
	         }
	      }
	   }
	}

