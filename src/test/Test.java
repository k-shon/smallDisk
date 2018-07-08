package test;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import top.kshon.pojo.User;
import top.kshon.service.UserService;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService =(UserService) ac.getBean("userService"); 
		User user = new User();
		user.setUsername("kshon");
		user.setPassword("1109");
		Date date = new Date();
		user.setRegistertime(date);
		userService.save(user);
	}

}
