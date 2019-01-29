package library.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import library.entity.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Category> getCategories() {

		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query .... sort by last name
		Query<Category> theQuery = currentSession.createQuery("from Category order by name", Category.class);

		// execute query and get result list
		List<Category> categories = theQuery.getResultList();

		// return the results

		return categories;

	}


	@Override
	public void saveCategory(Category theCategory) {
		// TODO Auto-generated method stub
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theCategory);
	}


	@Override
	public Category getCategory(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
						
		Category theCategory = currentSession.get(Category.class, theId);
		
		return theCategory;
	}


	@Override
	public void deleteCategory(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = currentSession.createQuery("delete from Category where id=:categoryId");
		
		theQuery.setParameter("categoryId", theId);

		theQuery.executeUpdate();
		
		
	}

}
