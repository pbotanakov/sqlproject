package model;

import java.util.Date;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "order")

public class Order {

	@Id
	@Column(name = "order_id")
	@GeneratedValue
	private Long id;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User userId;

	private String orderType, address, comment;
	@NotNull
	@Past
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date innitDate, deliveryDate;
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private Set<OrderLineItem> orderLis;

	private boolean completed;

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public Order() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getInnitDate() {
		return innitDate;
	}

	public void setInnitDate(Date innitDate) {
		this.innitDate = innitDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Set<OrderLineItem> getOrderLis() {
		return orderLis;
	}

	public void setOrderLis(Set<OrderLineItem> orderLis) {
		this.orderLis = orderLis;
	}

}
