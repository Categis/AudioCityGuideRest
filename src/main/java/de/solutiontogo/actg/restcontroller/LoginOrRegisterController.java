package de.solutiontogo.actg.restcontroller;

import de.solutiontogo.actg.service.LoginOrRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginOrRegisterController {
	
	@Autowired
    LoginOrRegisterService loginOrRegisterService;

	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	public Boolean userLogin(@RequestParam String userName, @RequestParam String password){
		if(!(StringUtils.isEmpty(userName) && StringUtils.isEmpty(password))){
            return loginOrRegisterService.validateUser(userName, password);
		}
		return Boolean.FALSE;
	}

    @RequestMapping(value = "/userRegister", method = RequestMethod.POST)
    public Boolean userRegister(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String displayName,
                    @RequestParam long phoneNumber, @RequestParam String email, @RequestParam String profilePicPath){

	    // code for adding user details to db

        return Boolean.FALSE;
    }
}
