package library.dao;

import java.util.List;

import library.entity.Order;
import library.entity.Reader;


public interface OrderDAO {

	public List<Order> getOrders();
	
	public List<Order> getReaderOrders(int theReaderId);

	public void saveOrder(Order theOrder);

	public Order getOrder(int theOrderId);

	public void deleteOrder(int theOrderId);

	
	
}
