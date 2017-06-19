package service;

import java.util.List;

import model.Order;

public interface OrderService {
	Order save(Order order);

	boolean deleteOrder(Order order);

	boolean clearOrderLis(Order order);

	public List<Order> findOrdersByUser(String userName);

	public List<Order> findOrdersByProduct(String product);

	public List<Order> findOrdersByAddress(String address);

	public List<Order> findOrdersByType(String type);

}
