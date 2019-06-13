package com.tcc.consumer.dao;

import com.tcc.api.entity.Transfer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface TransferDao {

//	@Update("update tb_account_two set amount = amount + #{amount} where acct_id = #{acctId}")
	@Update("update tb_account_two set frozen = frozen + #{amount} where acct_id = #{acctId}")
	int increaseAmount(Transfer transfer);

	@Update("update tb_account_two set amount = amount - #{amount} where acct_id = #{acctId}")
	public int cancelIncrease(Transfer transfer);

	public int confirmIncrease(Transfer transfer);

}
