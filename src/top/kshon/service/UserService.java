package top.kshon.service;

import java.util.List;

import top.kshon.pojo.User;

public interface UserService {
	public void save(User user);  //����û�
	public void update(User user);  //�����û�
	public void delete(User user); //ɾ���û�
	public User findById(Integer id); //����Id�����û�
	public List<User> findAll();  //���������û���
}
