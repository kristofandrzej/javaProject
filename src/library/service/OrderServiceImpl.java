package library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import library.dao.OrderDAO;
import library.entity.Order;
import library.entity.Reader;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	public OrderDAO orderDAO;
	


	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
	public List<Order> getOrders() {
		
		return orderDAO.getOrders();
	}


	@Override
	@Transactional
	public void saveOrder(Order theOrder) {

		orderDAO.saveOrder(theOrder);
		
	}


	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
	public Order getOrder(int theOrderId) {
	
		Order theOrder = orderDAO.getOrder(theOrderId);
		
		return theOrder;
		
	}


	@Override
	@Transactional
	public void deleteOrder(int theOrderId) {
		
		orderDAO.deleteOrder(theOrderId);
		
	}


	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
	public List<Order> getReaderOrders(int readerId) {
		// TODO Auto-generated method stub
		return orderDAO.getReaderOrders(readerId);
	}

}
