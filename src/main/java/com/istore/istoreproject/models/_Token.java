package com.istore.istoreproject.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class _Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_token;
    private String tokenText;
    private Date expiryDate;

    @OneToOne
    @JoinColumn(name = "id_user")
    private _User user;

}
