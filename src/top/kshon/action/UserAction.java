package top.kshon.action;

import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import top.kshon.pojo.User;
import top.kshon.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User>{

	private User user = new User();
	private UserService uService;
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	//登录
	public String login(){
		User existUser = uService.login(user);
		if(existUser == null){
			//不存在此用户，登录失败，设置错误信息，返回登录页面
			this.addActionError("用户名或密码错误");
			return "login";
		}else{
			//登录成功，将用户信息存储到session中，跳转到首页
			ActionContext.getContext().getSession().put("existUser", existUser);
			return "success";
		}
	}
	//注册
	public String register(){
		return null;
	}
	public UserService getuService() {
		return uService;
	}
	public void setuService(UserService uService) {
		this.uService = uService;
	}
	
}
