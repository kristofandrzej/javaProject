package library.service;

import java.util.List;

import library.entity.Order;
import library.entity.Reader;



public interface OrderService {

	public List<Order> getOrders();
	
	public List<Order> getReaderOrders(int readerId);

	public void saveOrder(Order theOrder);

	public Order getOrder(int theOrderId);

	public void deleteOrder(int theOrderId);
	
}
