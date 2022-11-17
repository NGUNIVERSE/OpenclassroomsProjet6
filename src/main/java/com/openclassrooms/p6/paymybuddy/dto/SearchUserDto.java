package com.openclassrooms.p6.paymybuddy.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SearchUserDto {

    private String name;
    @NotBlank
    private String email;

}
