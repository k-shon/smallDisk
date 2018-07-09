package top.kshon.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import top.kshon.dao.UserDao;
import top.kshon.pojo.User;
/*
 * 数据库操作类dao继承HibernateDaoSupport
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

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

}
