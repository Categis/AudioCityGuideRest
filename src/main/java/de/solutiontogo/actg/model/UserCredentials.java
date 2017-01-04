package de.solutiontogo.actg.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "user_credentials")
public class UserCredentials {

	@Id
	public String id;

	@Indexed(unique=true)
	public String userName;
    
	public String password;

}
