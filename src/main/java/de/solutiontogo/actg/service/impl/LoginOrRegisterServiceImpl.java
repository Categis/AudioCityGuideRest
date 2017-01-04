package de.solutiontogo.actg.service.impl;

import de.solutiontogo.actg.model.User_Credentials;
import de.solutiontogo.actg.model.User_Credentials_Repository;
import de.solutiontogo.actg.service.LoginOrRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by maheshkandhari on 1/4/2017.
 */

@Service
public class LoginOrRegisterServiceImpl implements LoginOrRegisterService{

    @Autowired
    User_Credentials_Repository userCredentialsRepository;

    @Override
    public Boolean validateUser(String userName, String password) {
        User_Credentials user_credentials = userCredentialsRepository.findByUserName(userName);
        if(user_credentials != null && password.equals(user_credentials.password)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

}
