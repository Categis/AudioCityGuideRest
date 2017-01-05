package de.solutiontogo.actg.service;

import de.solutiontogo.actg.model.UserDetails;

/**
 * Created by maheshkandhari on 1/4/2017.
 */

public interface LoginOrRegisterService {

    String validateUser(String userName, String password);

    Boolean saveUserCredentials(String userName, String password);

    String saveUserDetails(String firstName, String lastName, String displayName, String phoneNumber, String email, String password);

    UserDetails getUserDetailsByEmail(String email);

}
