package com.example.demo.model.jwt;

import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public class JwtResponse implements Serializable {


	private final String jwttoken;

	public String getToken() {
		return this.jwttoken;
	}
}