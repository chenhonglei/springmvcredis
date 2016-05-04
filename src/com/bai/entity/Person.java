package com.bai.entity;

import java.util.Date;

public class Person {  
    private String name;  
    private String sex;  
    private int age;  
    private Date birthday;  
  
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    public String getSex() {  
        return sex;  
    }  
  
    public void setSex(String sex) {  
        this.sex = sex;  
    }  
  
    public int getAge() {  
        return age;  
    }  
  
    public void setAge(int age) {  
        this.age = age;  
    }  
  
    public Date getBirthday() {  
        return birthday;  
    }  
  
    public void setBirthday(Date birthday) {  
        this.birthday = birthday;  
    }

	@Override
	public String toString() {
		return "Person [name=" + name + ", sex=" + sex + ", age=" + age
				+ ", birthday=" + birthday + "]";
	}
}  