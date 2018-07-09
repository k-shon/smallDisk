package top.kshon.dao;

import top.kshon.pojo.User;

public interface UserDao {

	public User findUserByUsernameAndPassword(User user);
}
