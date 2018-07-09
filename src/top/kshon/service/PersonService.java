package top.kshon.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import top.kshon.dao.PersonDao;
import top.kshon.pojo.Person;

@Transactional(propagation=Propagation.REQUIRED)
public class PersonService {

    private PersonDao pDao;
	
	public PersonDao getpDao() {
	    return pDao;
    }
    public void setpDao(PersonDao pDao) {
	    this.pDao = pDao;
    }
	public void save(Person person) {
		System.out.println("serviceµÄsaveÖ´ÐÐÁË...");
		pDao.save(person);
	}
	public void update(Person person) {
		pDao.update(person);
	}

	public void delete(Person person) {
		pDao.delete(person);
	}

	public Person findById(Integer id) {
		return pDao.findById(id);
	}

	public List<Person> findAll() {
		return pDao.findAll();
	}

}
