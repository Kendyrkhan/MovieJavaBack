package kz.csse.baskino.react.baskino.dto;


import kz.csse.baskino.react.baskino.entities.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {

    private Long id;
    private String email;
    private List<Roles> roles;
    private String full_name;
}
