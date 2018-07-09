package top.kshon.service;

import java.util.List;

import top.kshon.dao.UploadDao;
import top.kshon.pojo.Person;
import top.kshon.pojo.Upload;

public class UploadService {

	private UploadDao uploadDao;

	public void save(Upload upload){
		uploadDao.save(upload);
	}
	public void update(Upload upload){
		uploadDao.update(upload);
	}
	public void delete(Upload upload){
		uploadDao.delete(upload);
	}
	public Upload findById(Integer id){
		return uploadDao.findById(id);
	}
	public List<Upload> findAll() {
		return uploadDao.findAll();
	}
	public UploadDao getUploadDao() {
		return uploadDao;
	}

	public void setUploadDao(UploadDao uploadDao) {
		this.uploadDao = uploadDao;
	}
}
