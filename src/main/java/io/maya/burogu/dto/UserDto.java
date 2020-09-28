package io.maya.burogu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private int id;
    private String userName;
    private String password;
    private String email;
    private String biography;
    private String avatar;
    private Boolean active;
}
