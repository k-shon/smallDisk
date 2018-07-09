package top.kshon.service;

import java.util.List;

import top.kshon.dao.DirectoryDao;
import top.kshon.pojo.Directory;

public class DirectoryService {
	
	private DirectoryDao dDao;
	public DirectoryDao getdDao() {
		return dDao;
	}
	public void setdDao(DirectoryDao dDao) {
		this.dDao = dDao;
	}
	public void save(Directory directory) {
		dDao.save(directory);
	}
	public void update(Directory directory) {
		dDao.update(directory);
	}
	public void delete(Directory directory) {
		dDao.delete(directory);
	}
	public Directory findById(Integer id) {
		return dDao.findById(id);
	}
	public List<Directory> findAll() {
		return dDao.findAll();
	}
}
