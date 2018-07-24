package top.kshon.service.impl;

import java.util.Date;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import top.kshon.dao.UserDao;
import top.kshon.dao.PersonDao;
import top.kshon.pojo.Person;
import top.kshon.pojo.User;
import top.kshon.service.UserService;

/*
 * 业务层service实现类，调用dao
 */
@Transactional(propagation=Propagation.REQUIRED)
public class UserServiceImpl implements UserService{

	private UserDao uDao;
	private PersonDao pDao;
	
	public void setpDao(PersonDao pDao) {
		this.pDao = pDao;
	}

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
		User existUser = uDao.findUserByUsername(user);
		return existUser;
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		Person person = new Person();
		person.setName(user.getUsername());
		Date date = new Date();
		person.setCreatetime(date);
		user.setPerson(person);  //设置user与person的关联
		pDao.save(person);  //持久化默认的个人信息
		uDao.save(user);
	}

}
