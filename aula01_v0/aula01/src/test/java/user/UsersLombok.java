package user;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class UsersLombok {
    private String email;
    private String gender;
    private String name;
    private String status;

}
