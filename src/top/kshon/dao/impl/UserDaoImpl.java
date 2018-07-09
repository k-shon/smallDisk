package top.kshon.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import top.kshon.dao.UserDao;
import top.kshon.pojo.User;
/*
 * ���ݿ������dao�̳�HibernateDaoSupport
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

	@Override
	public User findUserByUsernameAndPassword(User user) {
		// TODO Auto-generated method stub
		String hql = "from User where username=? and password=?";  //UserΪ����
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql, user.getUsername(),user.getPassword());
		if(list.size()>0){
			//��ѯ�ɹ������ص�һ������
			return list.get(0); 
		}
		return null;  //���򷵻�null
	}

}
