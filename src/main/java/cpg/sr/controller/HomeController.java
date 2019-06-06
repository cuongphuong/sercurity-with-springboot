package cpg.sr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cpg.sr.security.anotations.DefaultFunctionInfo;
import cpg.sr.security.anotations.DefaultModuleInfo;

@Controller
@RestController
@RequestMapping("/home")
@DefaultModuleInfo(name = "Trang chủ")
public class HomeController {
	@DefaultFunctionInfo(name = "Dashboard", url = "/app/home", enable = true, icon = "home")
	@GetMapping(value = { "index" })
	public String index() {
		return "Hello world";
	}
}
