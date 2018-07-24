package top.kshon.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import top.kshon.dao.PersonDao;
import top.kshon.pojo.Person;
@Transactional(readOnly=false)
public class PersonDaoImpl extends HibernateDaoSupport implements PersonDao{

	@Override
	public Person findPersonById(Integer id) {
		String hql = "from Person where person_id=?";
		List<Person> list = (List<Person>) this.getHibernateTemplate().find(hql, id);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public void save(Person person) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(person);
	}

	@Override
	public void update(Person person) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(person);
	}
}
