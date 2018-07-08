package top.kshon.service;

import java.util.List;

import top.kshon.pojo.User;

public interface UserService {
	public void save(User user);  //添加用户
	public void update(User user);  //更新用户
	public void delete(User user); //删除用户
	public User findById(Integer id); //根据Id查找用户
	public List<User> findAll();  //返回所有用户名
}
