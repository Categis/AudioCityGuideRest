package de.solutiontogo.actg.service.impl;

import de.solutiontogo.actg.model.UserCredentials;
import de.solutiontogo.actg.model.UserCredentialsRepository;
import de.solutiontogo.actg.model.UserDetails;
import de.solutiontogo.actg.model.UserDetailsRepository;
import de.solutiontogo.actg.service.LoginOrRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
    public Boolean validateUser(String userName, String password) {
        UserCredentials user_credentials = userCredentialsRepository.findByUserName(userName);
        if(user_credentials != null && password.equals(user_credentials.password)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean saveUserDetails(String firstName, String lastName, String displayName, String phoneNumber, String email, String profilePicPath) {

        Boolean result = Boolean.FALSE;

        try {

            UserDetails userDetails = getUserDetailsByEmail(email);
            if(userDetails == null){
                userDetails = new UserDetails();
            }

            userDetails.setFirstName(firstName);
            userDetails.setLastName(lastName);
            userDetails.setDisplayName(displayName);
            userDetails.setPhoneNumber(phoneNumber);
            userDetails.setEmail(email);

            if(!StringUtils.isEmpty(profilePicPath)){
                userDetails.setProfilePicPath(profilePicPath);
            }

            userDetailsRepository.save(userDetails);
            result = Boolean.TRUE;

        } catch (Exception e) {
            // TODO add to log later
            e.printStackTrace();
        }
        return result;

    }

    @Override
    public UserDetails getUserDetailsByEmail(String email) {
        return userDetailsRepository.getUserDetailsByEmail(email);
    }

}
