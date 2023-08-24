package com.achyutha.bankingapp.auth.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * JwtResponse DTO.
 */
@Getter
@Setter
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class JwtResponse {

    private String token;

    private Long id;

    private String employeeId;

    private String name;

    private List<String> roles;
}
