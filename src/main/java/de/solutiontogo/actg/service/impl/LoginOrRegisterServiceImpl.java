package de.solutiontogo.actg.service.impl;

import de.solutiontogo.actg.model.UserCredentials;
import de.solutiontogo.actg.model.UserCredentialsRepository;
import de.solutiontogo.actg.model.UserDetails;
import de.solutiontogo.actg.model.UserDetailsRepository;
import de.solutiontogo.actg.service.LoginOrRegisterService;
import de.solutiontogo.actg.utils.MessageCodesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by maheshkandhari on 1/4/2017.
 */

@Service
public class LoginOrRegisterServiceImpl implements LoginOrRegisterService{

    @Autowired
    UserCredentialsRepository userCredentialsRepository;

    @Autowired
    UserDetailsRepository userDetailsRepository;


    @Override
    public String validateUser(String userName, String password) {
        String result = MessageCodesUtil.messageCodes.Ox05.name();
        UserCredentials user_credentials = userCredentialsRepository.findByUserName(userName);
        if(user_credentials != null && password.equals(user_credentials.password)) {
            // Display messages should be added in properties file or enum
            result = MessageCodesUtil.messageCodes.Ox01.name();
        } else if(user_credentials!=null){
            result = MessageCodesUtil.messageCodes.Ox04.name();
        } else {
            result = MessageCodesUtil.messageCodes.Ox03.name();
        }
        return result;
    }

    @Override
    public Boolean saveUserCredentials(String userName, String password) {
        Boolean result = Boolean.FALSE;

        try {
            UserCredentials userCredentials = new UserCredentials();
            userCredentials.setUserName(userName);
            userCredentials.setPassword(password);
            userCredentialsRepository.save(userCredentials);
            result = Boolean.TRUE;
        } catch (Exception e) {
            // TODO add to log
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String saveUserDetails(String firstName, String lastName, String displayName, String phoneNumber, String email, String password) {

        String result = MessageCodesUtil.messageCodes.Ox05.name();
        UserDetails userDetails = null;

        try {
            userDetails = getUserDetailsByEmail(email);
            if(userDetails == null){
                userDetails = new UserDetails();
                userDetails.setFirstName(firstName);
                userDetails.setLastName(lastName);
                userDetails.setDisplayName(displayName);
                userDetails.setPhoneNumber(phoneNumber);
                userDetails.setEmail(email);
                if(saveUserCredentials(email, password)) {
                    userDetailsRepository.save(userDetails);
                    // Display messages should be added in properties file or enum
                    result = MessageCodesUtil.messageCodes.Ox01.name();
                }
            } else {
                result = MessageCodesUtil.messageCodes.Ox02.name();
            }
        } catch (Exception e) {
            // TODO add to log
            e.printStackTrace();
        }
        return result;

    }

    @Override
    public UserDetails getUserDetailsByEmail(String email) {
        return userDetailsRepository.getUserDetailsByEmail(email);
    }

}
