package com.example.springcloudseataeurekaclient02.controller;


import com.example.springcloudseataeurekaclient02.awardfeign.AwardFeign;
import com.example.springcloudseataeurekaclient02.bean.Account;
import com.example.springcloudseataeurekaclient02.mapper.AccountMapper;
import com.example.springcloudseataeurekaclient02.returnmessage.ReturnMessage;
import com.example.springcloudseataeurekaclient02.service.AccountService;
import io.seata.core.context.RootContext;
import io.seata.core.exception.TransactionException;
import io.seata.spring.annotation.GlobalTransactional;
import io.seata.tm.api.GlobalTransactionContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 王飞
 * @since 2020-09-24
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Resource
    AccountService accountService;
    @Resource
    AccountMapper accountMapper;
    @Resource
    AwardFeign awardFeign;

    @RequestMapping("/updateAccount")
    @ResponseBody
//    @GlobalTransactional
    public ReturnMessage updateAccount(@RequestBody Map<String,Object> map) throws TransactionException {
        String userId1=map.get("u1").toString();
        String userId2=map.get("u2").toString();
        String money=map.get("money").toString();
        BigDecimal zzmoney=new BigDecimal(money);//转账金额
        awardFeign.saveAward(map);//调用奖励服务  给u1用户增加积分
        Account u1Account=accountMapper.queryByUserid(Long.valueOf(userId1));
        BigDecimal u1Money=u1Account.getMoney();
        Account account=new Account();
        account.setAccount("411403");
        account.setUserId(2222L);
        account.setMoney(BigDecimal.valueOf(9999));
        accountMapper.insert(account);
        if ((u1Money.compareTo(zzmoney))<0){
            GlobalTransactionContext.reload(RootContext.getXID()).rollback();
            return ReturnMessage.failWithMsg("余额不足");
        }
        u1Account.setMoney(u1Money.subtract(zzmoney));//扣钱
        accountService.updateById(u1Account);

        Account u2Account=accountMapper.queryByUserid(Long.valueOf(userId2));
        BigDecimal u2money=u2Account.getMoney();

        u2Account.setMoney(u2money.add(zzmoney));

        accountService.updateById(u2Account);
//        awardFeign.saveAward(map);//调用奖励服务  给u1用户增加积分
        return ReturnMessage.success();
    }

}

