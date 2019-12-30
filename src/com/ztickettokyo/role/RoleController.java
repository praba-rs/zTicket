package com.ztickettokyo.role;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RoleController {

	@Autowired
	private RoleService service;
	
	@RequestMapping("/role/list")
	public ModelAndView home() {
		List<AppRole> list = service.listAll();
		ModelAndView mav = new ModelAndView("role/role_list");
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping("/role/new")
	public String newCustomerForm(Map<String, Object> model) {
		AppRole obj = new AppRole();
		model.put("role", obj);
		return "role/role_new";
	}
	
	@RequestMapping(value = "/role/save", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("role") AppRole obj) {
		service.save(obj);
		return "redirect:/role/list";
	}
	
	@RequestMapping("/role/edit")
	public ModelAndView editCustomerForm(@RequestParam long id) {
		ModelAndView mav = new ModelAndView("role/role_edit");
		AppRole obj = service.get(id);
		mav.addObject("role", obj);
		
		return mav;
	}
	
	@RequestMapping("/role/delete")
	public String deleteCustomerForm(@RequestParam long id) {
		service.delete(id);
		return "redirect:/role/list";		
	}
	
	@RequestMapping("/role/search")
	public ModelAndView search(@RequestParam String keyword) {
		List<AppRole> result = service.search(keyword);
		ModelAndView mav = new ModelAndView("role/role_search");
		mav.addObject("result", result);
		
		return mav;		
	}	
}
