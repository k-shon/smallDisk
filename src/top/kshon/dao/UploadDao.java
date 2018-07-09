package top.kshon.dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import top.kshon.pojo.Share;
import top.kshon.pojo.Upload;
import top.kshon.pojo.User;

public class UploadDao extends HibernateDaoSupport{

	public void save(Upload upload) {
		System.out.println("daoµÄsaveÖ´ÐÐÁË...");
		this.getHibernateTemplate().save(upload);
	}
	public void update(Upload upload) {
		this.getHibernateTemplate().update(upload);
	}
	public void delete(Upload upload) {
		this.getHibernateTemplate().delete(upload);
	}
	public Upload findById(Integer id) {
		return this.getHibernateTemplate().get(Upload.class, id);
	}
	public List<Upload> findAll() {
		return (List<Upload>) this.getHibernateTemplate().find("from upload");
	}
}
