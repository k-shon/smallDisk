package top.kshon.dao;

import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;

import top.kshon.pojo.User;

public class UserDaoImpl implements UserDao{

	private HibernateTemplate ht;
	
	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		ht.save(user);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		ht.update(user);
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		ht.delete(user);
	}

	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return ht.get(User.class, id);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return (List<User>) ht.find("from User");
	}

}
