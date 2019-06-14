package com.tuling.dao;

import com.tuling.entity.Transfer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface TransferDao {

//	@Update("update tb_account_two set amount = amount + #{amount} where acct_id = #{acctId}")
//	@Update("update tb_account_two set frozen = frozen + #{amount} where acct_id = #{acctId}")
    @Update("update tb_account_two set frozen = frozen + #{amount},amount = amount + #{amount} where acct_id = #{targetAcctId}")
	int increaseAmount(Transfer transfer);

//	@Update("update tb_account_two set amount = amount - #{amount} where acct_id = #{acctId}")
	@Update("update tb_account_two set frozen = frozen - #{amount},amount = amount - #{amount} where acct_id = #{targetAcctId}")
    int cancelIncrease(Transfer transfer);
    @Update("update tb_account_two set frozen = frozen - #{amount} where acct_id = #{targetAcctId}")
    int confirmIncrease(Transfer transfer);

}
