package com.lidd.littleApp.app.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.lidd.littleApp.app.interfaces.PhoneMsgRepository;
import com.lidd.littleApp.app.interfaces.SellerRepository;
import com.lidd.littleApp.app.models.PhoneMsg;
import com.lidd.littleApp.app.models.Result;



@RequestMapping("company")
@RestController
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CompanyController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private PhoneMsgRepository phoneMsgRepository;

	@PostMapping(value="/sendShortNum")
	public Result say(@RequestParam(value="phoneNum") String phoneNum) {

	  try {
		  	int maNum= (int)(Math.random()*10000);
		     String content="【周边订】验证码为:"+maNum;
	        SmsSingleSender sender = new SmsSingleSender(1400049697, "fa27dfc23789152ee3499732065ef908");
			SmsSingleSenderResult senderresult = sender.send(0, "86", phoneNum, content, "", "123");
			PhoneMsg pm=new PhoneMsg();
			pm.setPhoneMsg(content);
			pm.setPhoneNum(maNum+"");
			phoneMsgRepository.save(pm);
			
	 } catch (Exception e) {
		e.printStackTrace();
	 }
	  return new Result(true,1001,null,null);
	}
}
