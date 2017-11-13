package com.lidd.littleApp.app.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import com.lidd.littleApp.app.models.PhoneMsg;
import com.lidd.littleApp.app.models.Seller;
/**
 * 商家
 * 
 * @author ldd
 *
 */
public interface PhoneMsgRepository extends Repository<PhoneMsg, Long> {
	Page<Seller> findAll(Pageable pageable);
	PhoneMsg findByPhoneNum(String phoneMsg);
	PhoneMsg save(PhoneMsg pm);
}
