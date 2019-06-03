package top.sstime.curd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author chenwei
 * @date 2019年6月3日
 */
@Controller
public class HelloController {
	
	@ResponseBody
	@RequestMapping("/hello")
	public String hello(@RequestParam(value = "text") String text) {
		System.out.println(text);
		return "Hello!";
	}

}
