package com.istore.istoreproject.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VerifTokenRequest {

    private String email;
    private String token;

}
