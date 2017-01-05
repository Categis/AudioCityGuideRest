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
	public String userLogin(@RequestParam String userName, @RequestParam String password){

	    return loginOrRegisterService.validateUser(userName, password);
	}

    @RequestMapping(value = "/userRegister", method = RequestMethod.POST)
    public String userRegister(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String displayName,
                    @RequestParam String phoneNumber, @RequestParam String email, @RequestParam String password){

		return loginOrRegisterService.saveUserDetails(firstName, lastName, displayName, phoneNumber, email, password);
    }
}
