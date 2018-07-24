package top.kshon.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import top.kshon.dao.DirectoryDao;
import top.kshon.pojo.Directory;
import top.kshon.service.DirectoryService;

@Transactional(propagation=Propagation.REQUIRED)
public class DirectoryServiceImpl implements DirectoryService{

	private DirectoryDao dDao;

	public void setdDao(DirectoryDao dDao) {
		this.dDao = dDao;
	}

	@Override
	public void create(Directory directory) {
		// TODO Auto-generated method stub
		dDao.save(directory);
	}

	@Override
	public void update(Directory directory) {
		// TODO Auto-generated method stub
		dDao.update(directory);
	}

	@Override
	public List<Directory> findAll(Integer person_id,Integer parent_id){
		// TODO Auto-generated method stub
		List<Directory> list = dDao.findAll(person_id,parent_id);
		if(list.size()>0){
			return list;
		}
		return null;
	}

	@Override
	public Directory findDirectoryByName(String name) {
		// TODO Auto-generated method stub
		return dDao.findDirectoryByName(name);
	}

	@Override
	public Directory findDirectoryById(Integer id) {
		// TODO Auto-generated method stub
		return dDao.findDirectoryById(id);
	}
}
