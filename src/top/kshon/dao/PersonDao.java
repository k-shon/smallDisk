package top.kshon.dao;

import top.kshon.pojo.Person;

public interface PersonDao{
	public Person findPersonById(Integer id);
	public void save(Person person);
	public void update(Person person);
}
