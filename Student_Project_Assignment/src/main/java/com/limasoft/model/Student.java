package com.limasoft.model;

public class Student {
	
	private int    sdt_Id;
	private String sdt_name;
	private String sdt_fname;
	private int    sdt_age;
	private String sdt_gender;
	private String sdt_branch;
	private String sdt_addres;
	
	@Override
	public String toString() {
		return "Student [sdt_Id=" + sdt_Id + ", sdt_name=" + sdt_name + ", sdt_fname=" + sdt_fname + ", sdt_age="
				+ sdt_age + ", sdt_gender=" + sdt_gender + ", sdt_branch=" + sdt_branch + ", sdt_addres=" + sdt_addres
				+ "]";
	}

	public int getSdt_Id() {
		return sdt_Id;
	}

	public void setSdt_Id(int sdt_Id) {
		this.sdt_Id = sdt_Id;
	}

	public String getSdt_name() {
		return sdt_name;
	}

	public void setSdt_name(String sdt_name) {
		this.sdt_name = sdt_name;
	}

	public String getSdt_fname() {
		return sdt_fname;
	}

	public void setSdt_fname(String sdt_fname) {
		this.sdt_fname = sdt_fname;
	}

	public int getSdt_age() {
		return sdt_age;
	}

	public void setSdt_age(int sdt_age) {
		this.sdt_age = sdt_age;
	}

	public String getSdt_gender() {
		return sdt_gender;
	}

	public void setSdt_gender(String sdt_gender) {
		this.sdt_gender = sdt_gender;
	}

	public String getSdt_branch() {
		return sdt_branch;
	}

	public void setSdt_branch(String sdt_branch) {
		this.sdt_branch = sdt_branch;
	}

	public String getSdt_addres() {
		return sdt_addres;
	}

	public void setSdt_addres(String sdt_addres) {
		this.sdt_addres = sdt_addres;
	}
	
	
	
}
