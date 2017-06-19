package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.OrderLineItem;
@Repository("orderLIRepository")
public interface OrderLIRepository extends JpaRepository<OrderLineItem, Long> { 

}
