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
	//��¼
	public String login(){
		User existUser = uService.login(user);
		if(existUser == null){
			//�����ڴ��û�����¼ʧ�ܣ����ô�����Ϣ�����ص�¼ҳ��
			this.addActionError("�û������������");
			return "login";
		}else{
			//��¼�ɹ������û���Ϣ�洢��session�У���ת����ҳ
			ActionContext.getContext().getSession().put("person", existUser.getPerson());
			//��ѯ���д��û���parent_id=0��Ŀ¼���浽session��
			List<Directory> directoryList = dService.findAll(existUser.getPerson().getPerson_id(),0);
			ActionContext.getContext().getSession().put("directoryList", directoryList);
			System.out.println("����id:"+existUser.getPerson().getPerson_id()+"������Ϣ��:"+existUser.getPerson().getName());
			return "success";
		}
	}
	//�˳���¼
	public String exit(){
		//���session
		return "login";
	}
	//ע��
	public String register(){
		User existUser = uService.register(user);
		if(existUser!=null){  
			//���û��Ѵ��ڣ�ע��ʧ�ܣ����ô�����Ϣ������ע��ҳ��
			this.addActionError("���û��Դ���");
			System.out.println("ע��ʧ��");
			return "register";
		}else{
			//ע��ɹ�������һ����ʼ���û���Ϣ
			Person newPerson = new Person();
			newPerson.setName(user.getUsername());//���ó�ʼ��
			Date date = new Date();
			newPerson.setCreatetime(date);  //����ʱ��
			pService.save(newPerson);
			user.setPerson(newPerson);
			ActionContext.getContext().getSession().put("person", newPerson);
			//�����û���Ϣ�����ص�¼ҳ��
			uService.save(user);
			System.out.println("ע��ɹ�");
			return "success";
		}
	}
}
