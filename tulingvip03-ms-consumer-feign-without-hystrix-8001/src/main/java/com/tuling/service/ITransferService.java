package com.tuling.service;


import com.tuling.api.ServiceException;
import com.tuling.entity.Transfer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "SPRINGCLOUD-SAMPLE-CONSUMER")
public interface ITransferService {

//	String sourceAcctId, String targetAcctId, double amount
	@RequestMapping(value = "test/transfer", method = RequestMethod.POST)
	void transfer(@RequestBody Transfer transfer) throws ServiceException;

}
