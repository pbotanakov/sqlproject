package controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import model.LoginPage;
import model.User;
import service.UserService;

@Controller
@SessionAttributes("user")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "signup";
		} else if (userService.findByUsername(user.getUserName())) {
			model.addAttribute("message", "User Name exists. Try another user name");
			return "signup";
		} else {
			userService.save(user);
			model.addAttribute("message", "Saved user details");
			return "redirect:login.html";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		LoginPage login = new LoginPage();
		model.addAttribute("loginPage", login);
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@Valid @ModelAttribute("loginPage") LoginPage login, BindingResult result) {
		if (result.hasErrors()) {
			return "login";
		} else {
			boolean found = userService.findByLogin(login.getUserName(), login.getPassword());
			if (found) {
				return "orderSearch";
			} else {
				return "redirect:login.html";
			}
		}

	}
}
