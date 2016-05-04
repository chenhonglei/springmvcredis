package com.bai.entity;

import java.util.Date;

public class Student {  
    private String name;  
    private int age;  
    private String address;  
    private Date birthday;  
      
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
    public int getAge() {  
        return age;  
    }  
    public void setAge(int age) {  
        this.age = age;  
    }  
    public String getAddress() {  
        return address;  
    }  
    public void setAddress(String address) {  
        this.address = address;  
    }  
    public Date getBirthday() {  
        return birthday;  
    }  
    public void setBirthday(Date birthday) {  
        this.birthday = birthday;  
    }
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", address="
				+ address + ", birthday=" + birthday + "]";
	}  
      
}  