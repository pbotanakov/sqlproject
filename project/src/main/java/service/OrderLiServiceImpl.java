package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.OrderLineItem;
import repository.OrderLIRepository;
@Service("orderLIService")
public class OrderLiServiceImpl implements OrderLiService {
	@Autowired
	private OrderLIRepository orderLIRep;

	@Transactional
	public OrderLineItem save(OrderLineItem li) {
		try {
			return orderLIRep.save(li);
		} catch (Exception e) {
			return null;
		}
	}

	@Transactional
	public boolean deleteLI(OrderLineItem li) {
		boolean isSuccessfull = false;
		try {
			orderLIRep.delete(li);
			isSuccessfull = true;
		} catch (Exception e) {
		}
		return isSuccessfull;
	}

}
