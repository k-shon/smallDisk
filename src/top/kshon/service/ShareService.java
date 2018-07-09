package top.kshon.service;

import java.util.List;

import top.kshon.dao.ShareDao;
import top.kshon.pojo.Share;

public class ShareService {

	private ShareDao sDao;

	public void save(Share share){
		sDao.save(share);
	}
	public void update(Share share){
		sDao.update(share);
	}
	public void delete(Share share){
		sDao.delete(share);
	}
	public Share findById(Integer id){
		return sDao.findById(id);
	}
	public List<Share> findAll() {
		return sDao.findAll();
	}
	public ShareDao getsDao() {
		return sDao;
	}
	public void setsDao(ShareDao sDao) {
		this.sDao = sDao;
	}
}
