package top.kshon.pojo;

import java.util.Date;

public class Directory {

	private int directory_id;
	private String name;
	private int parent_id;
	private Person person;
	private Date createtime;
	public int getDirectory_id() {
		return directory_id;
	}
	public void setDirectory_id(int directory_id) {
		this.directory_id = directory_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createTime) {
		this.createtime = createTime;
	}
}
