package com.soccer.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pid;
	private String name;
	private String address;
	private String city;
	private String email;
	public Player(int pid, String name, String address, String city, String email) {
		this.pid = pid;
		this.name = name;
		this.address = address;
		this.city = city;
		this.email = email;
	}
	public Player(String name, String address, String city, String email) {
		this.name = name;
		this.address = address;
		this.city = city;
		this.email = email;
	}
	public Player() {
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Player [pid=" + pid + ", name=" + name + ", address=" + address + ", city=" + city + ", email=" + email
				+ "]";
	}
		
}
