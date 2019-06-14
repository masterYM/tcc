package com.tuling.controller;

import com.tuling.api.ServiceException;
import com.tuling.entity.Transfer;
import com.tuling.service.ITransferService;
import org.bytesoft.compensable.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Compensable(
		interfaceClass = ITransferService.class,
		confirmableKey = "transferServiceConfirm",
		cancellableKey = "transferServiceCancel")
public class TransferController {

	@Autowired
	private ITransferService iTransferService;

	@RequestMapping(value = "/transfer", method = RequestMethod.POST)
	public void transfer(@RequestBody Transfer transfer) throws ServiceException {
		iTransferService.transfer(transfer);
	}


}
