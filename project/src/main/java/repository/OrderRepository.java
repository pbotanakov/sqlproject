package repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import model.Order;

/**
 * 
 * @author botanakov
 *	Interface containing manual queries to DB
 */
@Repository("orderRepository")
public interface OrderRepository extends JpaRepository<Order, Long> {
	@Query("select o from order o inner join user u on o.userid = u.id where u.username = :userName")
	Order findOrderByUser(@Param("userName") String userName);
	@Query("select o from order o where o.type = :type")
	Order findOrderByType(@Param("type") String orderType);
	@Query("select o from order o where o.address like '%:address%'")
	Order findOrderByAddress(@Param("address") String address);
	@Query("select o from order o inner join orderlineitem li on o.id = li.orderId where li.name like '%:product%'")
	Order findOrderContainingItem(@Param("product") String product);
}
