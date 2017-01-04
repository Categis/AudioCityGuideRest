package de.solutiontogo.actg.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by maheshkandhari on 1/4/2017.
 */

@Data
@Document(collection = "user_details")
public class UserDetails {
    @Id
    public String id;

    public String firstName;

    public String lastName;

    public String displayName;

    public String phoneNumber;

    @Indexed(unique=true)
    public String email;

    public String profilePicPath;
}