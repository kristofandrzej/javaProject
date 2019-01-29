package library.dao;

import java.util.List;

import library.entity.OrderItem;


public interface OrderItemDAO {

	public List<OrderItem> getOrderItems();
	
	public List<OrderItem> getSpecificOrderItems(int OrderId);

	public void saveOrderItem(OrderItem theOrderItem);

	public OrderItem getOrderItem(int theOrderItemId);

	public void deleteOrderItem(int theOrderItemId);

	
	
}
