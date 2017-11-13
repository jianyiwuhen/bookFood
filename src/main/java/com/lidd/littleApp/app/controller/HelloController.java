package com.lidd.littleApp.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lidd.littleApp.app.models.Girl;
import com.lidd.littleApp.app.models.Seller;
import com.lidd.littleApp.app.service.SellerService;
/**
 * 商家
 * 
 * @author ldd
 *
 */
@RequestMapping("test")
@RestController
public class HelloController {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Value("content")
	private String content;
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String say(@RequestParam(value="id",required=false,defaultValue="0") Integer id) {
		 return "Id:"+id;
	}

}
