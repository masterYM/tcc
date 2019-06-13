package com.tcc.consumer.service;


import com.tcc.api.ServiceException;
import com.tcc.api.entity.Transfer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@FeignClient(value = "SPRINGCLOUD-SAMPLE-CONSUMER")
public interface ITransferService {

//	String sourceAcctId, String targetAcctId, double amount
	@RequestMapping(value = "/transfer", method = RequestMethod.POST)
	public void transfer(@RequestBody Transfer transfer) throws ServiceException;

}
