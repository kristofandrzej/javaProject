package library.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import library.entity.OrderItem;



@Repository
public class OrderItemDAOImpl implements OrderItemDAO {

	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public List<OrderItem> getOrderItems() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query .... sort by last name
		Query<OrderItem> theQuery = currentSession.createQuery("from OrderItem order by plannedReturnDate", OrderItem.class);

		// execute query and get result list
		List<OrderItem> orderItems = theQuery.getResultList();		

		// return the results
		return orderItems;
	}
	
	@Override
	public List<OrderItem> getSpecificOrderItems(int theOrderId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query .... sort by last name
		Query<OrderItem> theQuery = currentSession.createQuery("from OrderItem where id_order=:id_order order by plannedReturnDate", OrderItem.class);

		theQuery.setParameter("id_order", theOrderId);
		
		// execute query and get result list
		List<OrderItem> orderItems = theQuery.getResultList();		

		// return the results
		return orderItems;
	}


	@Override
	public void saveOrderItem(OrderItem theOrderItem) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theOrderItem);
	}


	@Override
	public OrderItem getOrderItem(int theOrderItemId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		OrderItem theOrderItem = currentSession.get(OrderItem.class, theOrderItemId);
		
		return theOrderItem;
	}


	@Override
	public void deleteOrderItem(int theOrderItemId) {
		
		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = currentSession.createQuery("delete from OrderItem where id=:id");
		
		theQuery.setParameter("id", theOrderItemId);

		theQuery.executeUpdate();
		
		
	}



}
