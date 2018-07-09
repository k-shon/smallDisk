package top.kshon.dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import top.kshon.pojo.Directory;
import top.kshon.pojo.Person;
import top.kshon.pojo.User;

public class DirectoryDao extends HibernateDaoSupport{

	public void save(Directory directory) {
		System.out.println("daoµÄsaveÖ´ÐÐÁË...");
		this.getHibernateTemplate().save(directory);
	}
	public void update(Directory directory) {
		this.getHibernateTemplate().update(directory);
	}
	public void delete(Directory directory) {
		this.getHibernateTemplate().delete(directory);
	}
	public Directory findById(Integer id) {
		return this.getHibernateTemplate().get(Directory.class, id);
	}
	public List<Directory> findAll() {
		return (List<Directory>) this.getHibernateTemplate().find("from directory");
	}
}
