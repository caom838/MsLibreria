package MsLibreria.co.ud.libreria.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api
@RestController
@RequestMapping("test/")
public class TestControlador {
	
	@RequestMapping(value = "index")
	public String index() {
		return "index";
	}
}
