package top.kshon.dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import top.kshon.pojo.Person;
import top.kshon.pojo.User;

public class PersonDao extends HibernateDaoSupport{
	public void save(Person person) {
		System.out.println("daoµÄsaveÖ´ÐÐÁË...");
		this.getHibernateTemplate().save(person);
	}
	public void update(Person person) {
		this.getHibernateTemplate().update(person);
	}
	public void delete(Person person) {
		this.getHibernateTemplate().delete(person);
	}
	public Person findById(Integer id) {
		return this.getHibernateTemplate().get(Person.class, id);
	}
	public List<Person> findAll() {
		return (List<Person>) this.getHibernateTemplate().find("from person");
	}
}
