package service;

import model.OrderLineItem;

public interface OrderLiService {
	OrderLineItem save(OrderLineItem li);
	boolean deleteLI(OrderLineItem li);
}
