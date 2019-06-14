package com.tuling.api;

import com.tuling.entity.AccountOne;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "SPRINGCLOUD-SAMPLE-PROVIDER")
public interface IAccountService {

	@RequestMapping(method = RequestMethod.POST, value = "/increase")
	void increaseAmount(@RequestBody AccountOne accountOne) throws ServiceException;


	@RequestMapping(method = RequestMethod.POST, value = "/decrease")
	void decreaseAmount(@RequestBody AccountOne accountOne) throws ServiceException;

}
