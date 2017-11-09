package com.lidd.littleApp.app.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import com.lidd.littleApp.app.models.Seller;
/**
 * 商家
 * 
 * @author ldd
 *
 */
public interface SellerRepository extends Repository<Seller, Long> {
	Page<Seller> findAll(Pageable pageable);
	Seller findByIdAndState(Long id,int state);
}
