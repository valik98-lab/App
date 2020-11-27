package utm.md.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter

public class User {
      String firstName;
     String  lastName;

    public User (String firstName,String lastName){
        this.firstName=firstName;
        this.lastName=lastName;

    }
}
