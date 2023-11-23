package com.tangerineAPI.dto;

import com.tangerineAPI.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;

    private String nome;

    public UserDTO(User user) {
        id = user.getId();
        nome = user.getName();
    }
}
