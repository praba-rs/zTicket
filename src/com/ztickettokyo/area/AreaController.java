package com.ztickettokyo.area;

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
public class AreaController {

	@Autowired
	private AreaService service;
	
	@RequestMapping("/area/list")
	public ModelAndView home() {
		List<Area> list = service.listAll();
		ModelAndView mav = new ModelAndView("area/area_list");
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping("/area/new")
	public String newCustomerForm(Map<String, Object> model) {
		Area obj = new Area();
		model.put("area", obj);
		return "area/area_new";
	}
	
	@RequestMapping(value = "/area/save", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("area") Area obj) {
		service.save(obj);
		return "redirect:/area/list";
	}
	
	@RequestMapping("/area/edit")
	public ModelAndView editCustomerForm(@RequestParam long id) {
		ModelAndView mav = new ModelAndView("area/area_edit");
		Area obj = service.get(id);
		mav.addObject("area", obj);
		
		return mav;
	}
	
	@RequestMapping("/area/delete")
	public String deleteCustomerForm(@RequestParam long id) {
		service.delete(id);
		return "redirect:/area/list";		
	}
	

}
