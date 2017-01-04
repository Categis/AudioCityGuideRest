package de.solutiontogo.actg.model;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserCredentialsRepository extends MongoRepository<UserCredentials, String>{

	UserCredentials findByUserName(String userName);
	
}
