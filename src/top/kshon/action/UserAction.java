package top.kshon.action;

import java.util.Date;
import java.util.List;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import top.kshon.pojo.Directory;
import top.kshon.pojo.Person;
import top.kshon.pojo.User;
import top.kshon.service.DirectoryService;
import top.kshon.service.PersonService;
import top.kshon.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User>{

	private User user = new User();
	private UserService uService;
	private PersonService pService;
	private DirectoryService dService;
	public void setdService(DirectoryService dService) {
		this.dService = dService;
	}
	public void setpService(PersonService pService) {
		this.pService = pService;
	}
	public void setuService(UserService uService) {
		this.uService = uService;
	}
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
			ActionContext.getContext().getSession().put("person", existUser.getPerson());
			//查询所有此用户且parent_id=0的目录并存到session中
			List<Directory> directoryList = dService.findAll(existUser.getPerson().getPerson_id(),0);
			ActionContext.getContext().getSession().put("directoryList", directoryList);
			System.out.println("个人id:"+existUser.getPerson().getPerson_id()+"个人信息名:"+existUser.getPerson().getName());
			return "success";
		}
	}
	//退出登录
	public String exit(){
		//清空session
		return "login";
	}
	//注册
	public String register(){
		User existUser = uService.register(user);
		if(existUser!=null){  
			//此用户已存在，注册失败，设置错误信息，返回注册页面
			this.addActionError("此用户以存在");
			System.out.println("注册失败");
			return "register";
		}else{
			//注册成功，创建一个初始的用户信息
			Person newPerson = new Person();
			newPerson.setName(user.getUsername());//设置初始名
			Date date = new Date();
			newPerson.setCreatetime(date);  //设置时间
			pService.save(newPerson);
			user.setPerson(newPerson);
			ActionContext.getContext().getSession().put("person", newPerson);
			//保存用户信息，返回登录页面
			uService.save(user);
			System.out.println("注册成功");
			return "success";
		}
	}
}
