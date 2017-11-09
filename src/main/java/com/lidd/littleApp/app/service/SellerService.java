package com.lidd.littleApp.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service; 
 
import com.lidd.littleApp.app.interfaces.SellerRepository;
import com.lidd.littleApp.app.models.Seller;
/**
 * 商家服务
 * 
 * @author ldd
 *
 */
@Service
public class SellerService {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private SellerRepository sellerRepository;

	public Page<Seller> getAllSeller(int page, int size) {
		Pageable pageble = new PageRequest(page, size);		 
		Page<Seller> page2=sellerRepository.findAll(pageble); 
		logger.info(page2.getContent().toString());
		return page2;
	}

	public Seller getSellerById(Long id,int state) {
		 
		return sellerRepository.findByIdAndState(id, state);
	}
}
