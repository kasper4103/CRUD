/*
*
*Copyright (c) 2020, pcschool 
*/

package tw.com.pcschool.beans;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
*
*@author Lee
* 課程大綱:
*/



@Table(name="JPA_Customer")
@Entity
public class Customer {
	@Column(name = "ID" )
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer id;
	@Column(name = "NAME" )
	private String lastName;
	@Column(name = "EMAIL" , nullable=false)
	private String email;
	@Column(name = "AGE")
	private int age;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	@Temporal(TemporalType.DATE)
	private Date birth;
	
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Customer() {}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	//工具方法
	@Transient
	public  String setInfo() {
		return "Customer [id=" + id + ", lastName="+ lastName + ",email=" +email + ",age=" +age + "]";
	}
	
}
