package in.aj.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

	@GetMapping("index")
	public String showIndexPage()
	{
		return "index";
	}
	@GetMapping("/register")
	public String registerUser(Model model)
	{
		UserDto userDto = new UserDto;
		model.addAttribute(userDto);
		return "user/register";
	}
}
