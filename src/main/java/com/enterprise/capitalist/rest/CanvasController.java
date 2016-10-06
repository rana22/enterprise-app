package com.enterprise.capitalist.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class CanvasController {
	Logger log = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value = "/canvas", method =RequestMethod.GET)
	public String toCanvas(){
		log.info("returning canvas pages");
		return "canvas";
	}
	
}
