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
		System.out.println("新建文件:"+directory.getPerson().getName());
		Date date = new Date();
		directory.setCreatetime(date);  //设置创建时间
		dService.create(directory);
		//通过流的方式将id返回到页面，由ajax接收
		String id = String.valueOf(directory.getDirectory_id());
		try {
			inputStream = new ByteArrayInputStream(id.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("新建文件夹:"+directory.getDirectory_id()+"用户Id:"+directory.getPerson().getPerson_id());
		return "success";
	}
	public void update(){
		Date date = new Date();
		directory.setCreatetime(date);  //设置创建时间
		dService.update(directory);
		System.out.println("重命名:"+directory.getDirectory_id());
	}
	//进入文件夹
	public String joinDirectory(){
		Person person = (Person) ActionContext.getContext().getSession().get("person");
		//获取其对应的所有子目录,子目录的parent_id对应directory的id
		List<Directory> directoryList = dService.findAll(person.getPerson_id(), directory.getDirectory_id());
		if(directoryList!=null){
			ActionContext.getContext().getSession().put("directoryList", directoryList);
		}else{
			ActionContext.getContext().getSession().put("directoryList", null);
		}
		System.out.println("进入子目录成功："+directory.getDirectory_id());
		return "join";
	}
	//全部文件
	public String allDirectory(){
		Person person = (Person) ActionContext.getContext().getSession().get("person");
		//获取其对应的所有子目录,子目录的parent_id对应directory的id
		List<Directory> directoryList = dService.findAll(person.getPerson_id(), 0);
		if(directoryList!=null){
			ActionContext.getContext().getSession().put("directoryList", directoryList);
		}else{
			ActionContext.getContext().getSession().put("directoryList", null);
		}
		System.out.println("获取全部文件");
		return "all";
	}
}
