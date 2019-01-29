package library.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import library.entity.Book;
import library.entity.Order;
import library.entity.Reader;
import library.entity.User;

@Repository
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Order> getOrders() {

		Session currentSession = sessionFactory.getCurrentSession();

		// create a query .... sort by last name
		Query<Order> theQuery = currentSession.createQuery("from Order order by dateOrder", Order.class);

		// execute query and get result list
		List<Order> orders = theQuery.getResultList();
		
		for (Order order : orders) {
			System.out.println("Oto zamowienia pobrane przez Dao: " + order.getId());
		}

		// return the results
		return orders;
	}

	@Override
	public void saveOrder(Order theOrder) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();

		System.out.println("Check dao " + theOrder.getDateReceipt() + " " + theOrder.getStatus() + " "
				+ theOrder.getReader().getId());

		currentSession.saveOrUpdate(theOrder);
	}

	@Override
	public Order getOrder(int theOrderId) {

		Session currentSession = sessionFactory.getCurrentSession();

		Order theOrder = currentSession.get(Order.class, theOrderId);

		return theOrder;
	}

	@Override
	public void deleteOrder(int theOrderId) {

		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = currentSession.createQuery("delete from Order where id=:id");

		theQuery.setParameter("id", theOrderId);

		theQuery.executeUpdate();

	}

	@Override
	public List<Order> getReaderOrders(int theReaderId) {
		
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query .... sort by last name
		Query<Order> theQuery = currentSession.createQuery("from Order where id_reader=:id_reader order by dateOrder", Order.class);

		// setting the readerId to parameter
		theQuery.setParameter("id_reader", theReaderId);
		
		// execute query and get result list
		List<Order> readerOrders = theQuery.getResultList();

		// return the results
		return readerOrders;
	}

}
