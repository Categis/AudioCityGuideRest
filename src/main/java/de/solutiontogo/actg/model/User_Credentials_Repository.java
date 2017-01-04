package de.solutiontogo.actg.model;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface User_Credentials_Repository extends MongoRepository<User_Credentials, String>{

	User_Credentials findByUserName(String userName);
	
}
