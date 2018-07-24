package top.kshon.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import top.kshon.dao.DirectoryDao;
import top.kshon.pojo.Directory;

public class DirectoryDaoImpl extends HibernateDaoSupport implements DirectoryDao{

	@Override
	public void save(Directory directory) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(directory);
	}

	@Override
	public void update(Directory directory) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(directory);
	}

	@Override
	public List<Directory> findAll(Integer person_id,Integer parent_id) {
		// TODO Auto-generated method stub
		String hql = "from Directory where person_id=? and parent_id=?";
		List<Directory> list = (List<Directory>) this.getHibernateTemplate().find(hql,person_id,parent_id);
		return list;
	}

	@Override
	public Directory findDirectoryByName(String name) {
		// TODO Auto-generated method stub
		String hql = "from Directory where name=?";
		Directory directory = (Directory) this.getHibernateTemplate().find(hql, name);
		return directory;
	}

	@Override
	public Directory findDirectoryById(Integer id) {
		// TODO Auto-generated method stub
		String hql = "from Directory where directory_id=?";
		Directory directory = (Directory) this.getHibernateTemplate().find(hql, id);
		return directory;
	}
}
