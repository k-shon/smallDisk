package top.kshon.dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import top.kshon.pojo.Person;
import top.kshon.pojo.Share;
import top.kshon.pojo.User;

public class ShareDao extends HibernateDaoSupport{

	public void save(Share share) {
		System.out.println("daoµÄsaveÖ´ÐÐÁË...");
		this.getHibernateTemplate().save(share);
	}
	public void update(Share share) {
		this.getHibernateTemplate().update(share);
	}
	public void delete(Share share) {
		this.getHibernateTemplate().delete(share);
	}
	public Share findById(Integer id) {
		return this.getHibernateTemplate().get(Share.class, id);
	}
	public List<Share> findAll() {
		return (List<Share>) this.getHibernateTemplate().find("from share");
	}
}
