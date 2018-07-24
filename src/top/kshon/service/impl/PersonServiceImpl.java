package top.kshon.service.impl;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import top.kshon.dao.PersonDao;
import top.kshon.pojo.Person;
import top.kshon.service.PersonService;
@Transactional(propagation=Propagation.REQUIRED)
public class PersonServiceImpl implements PersonService{

	private PersonDao pDao;

	public PersonDao getpDao() {
		return pDao;
	}

	public void setpDao(PersonDao pDao) {
		this.pDao = pDao;
	}

	@Override
	public Person findPersonById(Integer id) {
		// TODO Auto-generated method stub
		return pDao.findPersonById(id);
	}

	@Override
	public void save(Person person) {
		// TODO Auto-generated method stub
		pDao.save(person);
	}

	@Override
	public void update(Person person) {
		// TODO Auto-generated method stub
		pDao.update(person);
	}
}
