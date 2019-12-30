package com.ztickettokyo.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

	
	@RequestMapping("/accessDenied")
	public String access() {
		return "common/accessDenied";
	}
	

}
