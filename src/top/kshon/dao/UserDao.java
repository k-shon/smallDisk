package top.kshon.dao;

import top.kshon.pojo.User;

public interface UserDao {

	public User findUserByUsername(User user);
	public User findUserByUsernameAndPassword(User user);
	public void save(User user);
}
