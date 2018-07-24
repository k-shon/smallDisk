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
 * ҵ���serviceʵ���࣬����dao
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
		user.setPerson(person);  //����user��person�Ĺ���
		pDao.save(person);  //�־û�Ĭ�ϵĸ�����Ϣ
		uDao.save(user);
	}

}
