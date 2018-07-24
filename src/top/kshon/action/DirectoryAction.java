package top.kshon.action;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import top.kshon.pojo.Directory;
import top.kshon.pojo.Person;
import top.kshon.service.DirectoryService;

public class DirectoryAction extends ActionSupport implements ModelDriven<Directory>{

	private Directory directory = new Directory();
	private DirectoryService dService;
	private InputStream inputStream;
	public InputStream getInputStream() {
		return inputStream;
	}
	public Directory getDirectory() {
		return directory;
	}
	public void setDirectory(Directory directory) {
		this.directory = directory;
	}
	public void setdService(DirectoryService dService) {
		this.dService = dService;
	}
	@Override
	public Directory getModel() {
		// TODO Auto-generated method stub
		return directory;
	}
	public String create(){
		Person person = (Person) ActionContext.getContext().getSession().get("person");
		directory.setPerson(person);
		System.out.println("�½��ļ�:"+directory.getPerson().getName());
		Date date = new Date();
		directory.setCreatetime(date);  //���ô���ʱ��
		dService.create(directory);
		//ͨ�����ķ�ʽ��id���ص�ҳ�棬��ajax����
		String id = String.valueOf(directory.getDirectory_id());
		try {
			inputStream = new ByteArrayInputStream(id.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("�½��ļ���:"+directory.getDirectory_id()+"�û�Id:"+directory.getPerson().getPerson_id());
		return "success";
	}
	public void update(){
		Date date = new Date();
		directory.setCreatetime(date);  //���ô���ʱ��
		dService.update(directory);
		System.out.println("������:"+directory.getDirectory_id());
	}
	//�����ļ���
	public String joinDirectory(){
		Person person = (Person) ActionContext.getContext().getSession().get("person");
		//��ȡ���Ӧ��������Ŀ¼,��Ŀ¼��parent_id��Ӧdirectory��id
		List<Directory> directoryList = dService.findAll(person.getPerson_id(), directory.getDirectory_id());
		if(directoryList!=null){
			ActionContext.getContext().getSession().put("directoryList", directoryList);
		}else{
			ActionContext.getContext().getSession().put("directoryList", null);
		}
		System.out.println("������Ŀ¼�ɹ���"+directory.getDirectory_id());
		return "join";
	}
	//ȫ���ļ�
	public String allDirectory(){
		Person person = (Person) ActionContext.getContext().getSession().get("person");
		//��ȡ���Ӧ��������Ŀ¼,��Ŀ¼��parent_id��Ӧdirectory��id
		List<Directory> directoryList = dService.findAll(person.getPerson_id(), 0);
		if(directoryList!=null){
			ActionContext.getContext().getSession().put("directoryList", directoryList);
		}else{
			ActionContext.getContext().getSession().put("directoryList", null);
		}
		System.out.println("��ȡȫ���ļ�");
		return "all";
	}
}
