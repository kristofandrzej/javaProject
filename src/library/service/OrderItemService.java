package library.service;

import java.util.List;

import library.entity.OrderItem;



public interface OrderItemService {

	public List<OrderItem> getOrderItems();
	
	public List<OrderItem> getSpecificOrderItems(int theOrderId);

	public void saveOrderItem(OrderItem theOrder);

	public OrderItem getOrderItem(int theOrderItemId);

	public void deleteOrderItem(int theOrderItemId);
	
}
