package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.Role;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class UserController {

	private final UserService userService;

	private final RoleService roleService;

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
	public String getUserById(ModelMap map) {
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
	public String addUser(@RequestParam String username,
						  @RequestParam String password,
						  @RequestParam Long[] role_id,
						  @RequestParam String firstName,
						  @RequestParam String lastName){
		Set<Role> roles = Arrays.stream(role_id).map(roleService::getRoleById).collect(Collectors.toSet());
		userService.addUser(new User(username, password, firstName, lastName, roles));
		return "redirect:/admin";
	}

	@PostMapping("/admin/updateUser")
	public String editUser(@RequestParam Long id,
						   @RequestParam String username,
						   @RequestParam String password,
						   @RequestParam Long[] role_id,
						   @RequestParam String firstName,
						   @RequestParam String lastName) {
		Set<Role> roles = Arrays.stream(role_id).map(roleService::getRoleById).collect(Collectors.toSet());
		userService.updateUser(new User(id, username, password, firstName, lastName, roles));
		return "redirect:/admin";
	}

	@PostMapping("/admin/deleteUser")
	public String deleteUser(@RequestParam Long id){
		userService.deleteUser(id);
		return "redirect:/admin";
	}

}