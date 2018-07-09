package top.kshon.service;

import top.kshon.pojo.User;

public interface UserService {
	public User login(User user);
	public User register(User user);
}
