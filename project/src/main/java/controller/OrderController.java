package controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import model.Order;
import model.SearchOrders;
import model.User;
import service.OrderService;

@Controller
@SessionAttributes("order")
public class OrderController {
	@Autowired
	OrderService orderService;

	@RequestMapping(value = "/orderSearch", method = RequestMethod.GET)
	public String orderSearch(Model model) {
		if (!model.containsAttribute("user")) {
			return "redirect:login.html";
		} else {
			SearchOrders searchPage = new SearchOrders();
			model.addAttribute("orderSearch", searchPage);
			return "orderSearch";
		}

	}
	@RequestMapping(value="/orderSearch", method=RequestMethod.POST)
	public String login(@Valid @ModelAttribute("orderSearch") SearchOrders orderSearch, BindingResult result,Model model) {
		if (result.hasErrors()) {
			return "login";
		} else {
			List<Order> orders = new ArrayList<Order>();
			if(orderSearch.getUserName() != null && !orderSearch.getUserName().isEmpty()){
				orders.addAll(orderService.findOrdersByUser(orderSearch.getUserName()));
			}
			if(orderSearch.getProduct() != null && !orderSearch.getProduct().isEmpty()){
				orders.addAll(orderService.findOrdersByProduct(orderSearch.getProduct()));
			}
			if(orderSearch.getType() != null && !orderSearch.getType().isEmpty()){
				orders.addAll(orderService.findOrdersByType(orderSearch.getType()));
			}
			if(orderSearch.getAddress() != null && !orderSearch.getAddress().isEmpty()){
				orders.addAll(orderService.findOrdersByAddress(orderSearch.getAddress()));
			}
			model.addAttribute("foundOrders", orders);
			return "listOfOrders";
		}
	}
}
