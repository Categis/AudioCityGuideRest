package de.solutiontogo.actg.model;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by maheshkandhari on 1/4/2017.
 */
public interface UserDetailsRepository extends MongoRepository<UserDetails, String> {

    UserDetails getUserDetailsByEmail(String email);

}