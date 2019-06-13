package com.tcc.consumer.controller;

import com.tcc.api.ServiceException;
import com.tcc.api.entity.Transfer;
import com.tcc.consumer.service.ITransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransferController{

	@Autowired
	private ITransferService iTransferService;

	@ResponseBody
	@RequestMapping(value = "/transfer", method = RequestMethod.POST)
	@Transactional
//	public void transfer(
// @RequestParam String sourceAcctId,
// @RequestParam String targetAcctId,
// @RequestParam double amount) throws ServiceException {
	public void transfer(Transfer transfer) throws ServiceException {
		iTransferService.transfer(transfer);
	}


}
