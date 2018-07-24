package top.kshon.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import top.kshon.dao.UserDao;
import top.kshon.pojo.User;
/*
 * 数据库操作类dao继承HibernateDaoSupport
 */
@Transactional(readOnly=false)
public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

	@Override
	public User findUserByUsername(User user) {
		// TODO Auto-generated method stub
		String hql = "from User where username=?";
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql, user.getUsername());
		if(list.size()>0){
			//查询成功，返回第一条数据
			return list.get(0); 
		}
		return null;  //否则返回null
	}

	@Override
	public User findUserByUsernameAndPassword(User user) {
		// TODO Auto-generated method stub
		String hql = "from User where username=? and password=?";  //User为对象
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql, user.getUsername(),user.getPassword());
		if(list.size()>0){
			//查询成功，返回第一条数据
			return list.get(0); 
		}
		return null;  //否则返回null
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		Date date = new Date();
		user.setRegistertime(date);  //设置注册时间
		this.getHibernateTemplate().save(user);
	}

}
