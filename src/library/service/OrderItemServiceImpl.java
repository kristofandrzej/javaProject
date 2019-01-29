package library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import library.dao.OrderItemDAO;
import library.entity.OrderItem;

@Service
@Transactional
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	public OrderItemDAO orderItemDAO;
	


	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
	public List<OrderItem> getOrderItems() {
		
		return orderItemDAO.getOrderItems();
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
	public List<OrderItem> getSpecificOrderItems(int theOrderId) {
		
		return orderItemDAO.getSpecificOrderItems(theOrderId);
	}


	@Override
	@Transactional
	public void saveOrderItem(OrderItem theOrderItem) {

		orderItemDAO.saveOrderItem(theOrderItem);
		
	}


	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
	public OrderItem getOrderItem(int theOrderItemId) {
	
		OrderItem theOrderItem = orderItemDAO.getOrderItem(theOrderItemId);
		
		return theOrderItem;
		
	}


	@Override
	@Transactional
	public void deleteOrderItem(int theOrderItemId) {
		
		orderItemDAO.deleteOrderItem(theOrderItemId);
		
	}

}
