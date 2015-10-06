package org.essilab.exercices.bases.sort;

import java.util.Date;

public class Person {
	private String firstname;
	private String lastname;
	private Date birthdate;
	
	public Person(String f, String l, Date b)
	{
		this.setFirstname(f);
		this.setLastname(l);
		this.setBirthdate(b);
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}
