package com.lidd.littleApp.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
 
import com.lidd.littleApp.app.models.Seller;
import com.lidd.littleApp.app.service.SellerService;
/**
 * 商家
 * 
 * @author ldd
 *
 */
@RestController
@RequestMapping("seller")
public class SellerController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private SellerService sellerService;
	@PostMapping("/getAllSellers")
	public Page<Seller> getAllSellers(@RequestParam(defaultValue="0") int page, @RequestParam(defaultValue="10") int size) {  
		logger.info("pageInfo:{page:"+page+",size:"+size+"}");
		Page<Seller> page2=sellerService.getAllSeller(page,size); 
		return page2;
	}
	@PostMapping("/getSeller/{id}")
	public Seller getSeller(@PathVariable Long id) {  
		logger.info("getSeller==id:"+id);
		if (StringUtils.isEmpty(id)) {
			throw new  RuntimeException("请求数据异常");
		}
		Seller seller=sellerService.getSellerById(id,1); 
		if (seller==null) {
			throw new  RuntimeException("商家不存在");
		}
		return seller;
	}
}
