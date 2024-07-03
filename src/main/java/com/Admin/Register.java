package com.Admin;

import java.io.InputStream;

public class Register {
	String name, district, position;
	int age;
	InputStream profile;

	public Register(String name, int age, String district, String position, InputStream istrm) {
		super();
		this.name = name;
		this.age = age;
		this.district = district;
		this.position = position;
		this.profile = istrm;
	}
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getDistrict() {
		return district;
	}

	public String getPosition() {
		return position;
	}

	public InputStream getProfile() {
		return profile;
	}

}
