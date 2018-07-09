package top.kshon.action;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import top.kshon.pojo.Person;
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
	public void modify(){
		System.out.println("修改个人信息");
		Date date = new Date();
		person.setCreatetime(date);
		System.out.println(person.getUser().getUsername());
		pService.save(person);
	}
}
