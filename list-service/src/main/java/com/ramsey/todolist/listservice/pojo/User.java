package com.ramsey.todolist.listservice.pojo;

import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.With;

@With
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    
    private Long id;

    @Pattern(regexp = "^(?=.*[A-z])(?=.*[\\d])[A-z\\d]{3,}$")
    private String username;
    
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[!@#$%^&*()_+=-])[A-Za-z\\d!@#$%^&*()_+-=]{8,}$")
    private String password;

}
