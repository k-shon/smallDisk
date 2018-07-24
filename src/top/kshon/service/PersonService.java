package top.kshon.service;

import top.kshon.pojo.Person;

public interface PersonService {

	public Person findPersonById(Integer id);
	public void save(Person person);
	public void update(Person person);
}
