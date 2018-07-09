package top.kshon.service.impl;

import top.kshon.dao.UserDao;
import top.kshon.pojo.User;
import top.kshon.service.UserService;

/*
 * 业务层service实现类，调用dao
 */
public class UserServiceImpl implements UserService{

	private UserDao uDao;
	public void setuDao(UserDao uDao) {
		this.uDao = uDao;
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		User existUser = uDao.findUserByUsernameAndPassword(user);
		return existUser;
	}

	@Override
	public User register(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
