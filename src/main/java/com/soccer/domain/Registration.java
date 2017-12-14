package com.soccer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="registration")
public class Registration {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int rid;
	private int lid;
	private int pid;
	private String division;
	
	public Registration(int rid, int lid, int pid, String division) {
		this.rid = rid;
		this.lid = lid;
		this.pid = pid;
		this.division = division;
	}
	
	public Registration(int lid, int pid, String division) {
		this.lid = lid;
		this.pid = pid;
		this.division = division;
	}
	
	public Registration() {
	}
	
	public int getRid() {
		return rid;
	}
	
	public void setRid(int rid) {
		this.rid = rid;
	}
	
	public int getLid() {
		return lid;
	}
	
	public void setLid(int lid) {
		this.lid = lid;
	}
	
	public int getPid() {
		return pid;
	}
	
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	public String getDivision() {
		return division;
	}
	
	public void setDivision(String division) {
		this.division = division;
	}
	
	@Override
	public String toString() {
		return "Registration [rid=" + rid + ", lid=" + lid + ", pid=" + pid + ", division=" + division + "]";
	}
}
