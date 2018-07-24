package top.kshon.action;

import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import top.kshon.pojo.Person;
import top.kshon.pojo.User;
import top.kshon.service.PersonService;

public class PersonAction extends ActionSupport implements ModelDriven<Person>{

	private Person person = new Person();
	private PersonService pService;
	public PersonService getpService() {
		return pService;
	}
	public void setpService(PersonService pService) {
		this.pService = pService;
	}
	@Override
	public Person getModel() {
		// TODO Auto-generated method stub
		return person;
	}
	public String update(){
		System.out.println("�޸ĸ�����Ϣ");
		Date date = new Date();
		person.setCreatetime(date);
		pService.update(person);
		return "update";
	}
	//�༭������Ϣ����ת���༭ҳ��
	public String edit(){
		return "edit";
	}
}
