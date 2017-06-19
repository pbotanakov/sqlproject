package service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Order;
import model.OrderLineItem;
import repository.OrderRepository;
import security.Sanitazer;;
@Service("orderService")
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderRepository orderRep;
	@Autowired
	private Sanitazer sanitaze;
	@Transactional
	public Order save(Order order) {
		try{
			orderRep.save(order);
		} catch(Exception e){
			return null;
		}
		return order;
	}
	@Transactional
	public boolean deleteOrder(Order order) {
		boolean isSuccesfull = false;
		try{
			orderRep.delete(order);
			isSuccesfull = true;
		} catch(Exception e){
			isSuccesfull = false;
		}
		return isSuccesfull;
	}
	@Transactional
	public boolean clearOrderLis(Order order) {
		boolean isSuccesfull = false;
		try{
			Set<OrderLineItem> orderLis = new HashSet<OrderLineItem>();
			order.setOrderLis(orderLis);
			orderRep.save(order);
			isSuccesfull = true;
		} catch(Exception e){
			isSuccesfull = false;
		}
		return isSuccesfull;
	}
	@SuppressWarnings("unchecked")
	public List<Order> findOrdersByUser(String userName){
		List<Order> orders = new ArrayList<Order>();
		if(sanitaze.inputCheck(userName)) return orders;
		try{
			orders.addAll((Collection<? extends Order>) orderRep.findOrderByUser(userName));
		} catch(Exception e){
			return null;
		}
		return orders;
	}
	@SuppressWarnings("unchecked")
	public List<Order> findOrdersByProduct(String product){
		List<Order> orders = new ArrayList<Order>();
		if(sanitaze.inputCheck(product)) return orders;
		try{
			orders.addAll((Collection<? extends Order>) orderRep.findOrderContainingItem(product));
		} catch(Exception e){
			return null;
		}
		return orders;
	}
	@SuppressWarnings("unchecked")
	public List<Order> findOrdersByAddress(String address){
		List<Order> orders = new ArrayList<Order>();
		if(sanitaze.inputCheck(address)) return orders;
		try{
			orders.addAll((Collection<? extends Order>) orderRep.findOrderByAddress(address));
		} catch(Exception e){
			return null;
		}
		return orders;
	}
	@SuppressWarnings("unchecked")
	public List<Order> findOrdersByType(String type){
		List<Order> orders = new ArrayList<Order>();
		if(sanitaze.inputCheck(type)) return orders;
		try{
			orders.addAll((Collection<? extends Order>) orderRep.findOrderByType(type));
		} catch(Exception e){
			return null;
		}
		return orders;
	}

}
