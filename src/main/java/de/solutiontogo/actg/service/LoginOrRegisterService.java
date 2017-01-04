package de.solutiontogo.actg.service;

import de.solutiontogo.actg.model.UserDetails;

/**
 * Created by maheshkandhari on 1/4/2017.
 */

public interface LoginOrRegisterService {

    Boolean validateUser(String userName, String password);

    Boolean saveUserDetails(String firstName, String lastName, String displayName, String phoneNumber, String email, String profilePicPath);

    UserDetails getUserDetailsByEmail(String email);

}
