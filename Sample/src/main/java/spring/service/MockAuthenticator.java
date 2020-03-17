package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import spring.common.CommonLogger;

@Component
//@Service 둘 다 가능
public class MockAuthenticator  implements Authenticator{

	private CommonLogger commonLogger;
	
	public void authenticate(LoginCommand loginCommand)
	throws AuthenticationException{
		if (!loginCommand.getUserId().equals(loginCommand.getPassword())) {
			commonLogger.log("인증 에러 - "+loginCommand.getUserId());
			throw new AuthenticationException();
			//DB에 데이터 받아와서 맞는지 틀린지 확인하는 코드도 능력이 되면^^ 작성하기
		}
	}
	
	@Autowired
	public void setCommonLogger(CommonLogger commonLogger) {
		this.commonLogger = commonLogger;
	}
	
}
