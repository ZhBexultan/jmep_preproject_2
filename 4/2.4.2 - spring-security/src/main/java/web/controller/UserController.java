package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Role;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class UserController {

	private final UserService userService;

	private final RoleService roleService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	public UserController(UserService userService, RoleService roleService) {
		this.userService = userService;
		this.roleService = roleService;
	}

	@GetMapping("/hello")
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Spring MVC-SECURITY application");
		messages.add("5.2.0 version by sep'19 ");
		model.addAttribute("messages", messages);
		return "hello";
	}

	@GetMapping("/login")
    public String loginPage() {
        return "login";
    }

	@GetMapping("/user")
	public String getUserById(@AuthenticationPrincipal Principal user, ModelMap map) {
		map.addAttribute("user", user);
		return "user";
	}

	@GetMapping({"/", "/admin"})
	public String getUsers(ModelMap map) {
		List<User> users = userService.getAllUsers();
		map.addAttribute("users", users);
		return "admin";
	}

	@GetMapping("/admin/user/{id}")
	public String getUserByIdUpdate(@PathVariable Long id,
							  ModelMap map) {
		User user = userService.getUserById(id);
		map.addAttribute("user", user);
		return "editUser";
	}

	@PostMapping("/admin/user")
	public String addUser(@ModelAttribute User user,
						  @RequestParam Set<Long> roles_id){
		Set<Role> roles = roles_id.stream().map(roleService::getRoleById).collect(Collectors.toSet());
		user.setRoles(roles);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userService.addUser(user);
		return "redirect:/admin";
	}

	@PostMapping("/admin/updateUser")
	public String editUser(@ModelAttribute User user,
						   @RequestParam Set<Long> roles_id) {
		Set<Role> roles = roles_id.stream().map(roleService::getRoleById).collect(Collectors.toSet());
		user.setRoles(roles);
		userService.updateUser(user);
		return "redirect:/admin";
	}

	@PostMapping("/admin/deleteUser")
	public String deleteUser(@RequestParam Long id){
		userService.deleteUser(id);
		return "redirect:/admin";
	}

}