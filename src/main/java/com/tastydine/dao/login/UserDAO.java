package com.tastydine.dao.login;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.tastydine.vo.User;

/**
 * @author mankri
 * This User based files belong to Hibernate where Login based files are from SpringJdbcTemplate
 *
 */
@Transactional
public class UserDAO {
	
	SessionFactory sFactory;
	
	public void setTemplate(SessionFactory sFactory) {
		this.sFactory = sFactory;
	}
	
	public void saveUser(User e){
		sFactory.getCurrentSession().save(e);
	}

	public void updateUser(User e){
		sFactory.getCurrentSession().update(e);
	}

	public void deleteUser(User e){
		sFactory.getCurrentSession().delete(e);
	}
	//method to return one User of given id  
	public User getById(int id){  
	    User e=(User)sFactory.getCurrentSession().get(User.class,id);  
	    return e;  
	}  
	public User getByName(String userName){ 
		Criteria cri = sFactory.getCurrentSession().createCriteria(User.class);
		cri.add(Restrictions.eq("userName", userName));
		return (User)cri.list().get(0);
	} 
}
