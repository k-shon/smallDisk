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
	//��¼
	public String login(){
		User existUser = uService.login(user);
		if(existUser == null){
			//�����ڴ��û�����¼ʧ�ܣ����ô�����Ϣ�����ص�¼ҳ��
			this.addActionError("�û������������");
			return "login";
		}else{
			//��¼�ɹ������û���Ϣ�洢��session�У���ת����ҳ
			ActionContext.getContext().getSession().put("existUser", existUser);
			return "success";
		}
	}
	//ע��
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
