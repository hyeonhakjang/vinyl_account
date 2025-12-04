package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String password;

    @Column(nullable = false, unique = true)
    private String providerId;

    @Column(nullable = true, unique = true)
    private String email;

    @Column(nullable = true)
    private String name;

    @Column(nullable = false)
    private String provider;

    @Column(nullable = true)
    private String userImgUrl;
}
