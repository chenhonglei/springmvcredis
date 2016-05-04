package com.bai.entity;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.BeanUtils;

public class BeanUtilTest {  
	
	
	@Test
	public void testBeanUtils() {
		Person per = new Person();  
        Student stu = new Student();  
          
        per.setName("zhangsan");  
        per.setSex("男");  
        
        stu.setAge(29);
        stu.setBirthday(new Date());  
          
        stu.setName("wuangwu");  
        stu.setAddress("北京市");
        
        
        
        BeanUtils.copyProperties(stu, per);  
        System.out.println(stu);
        System.out.println(per);
		
	}
}