package com.example.springcloudseataeurekaclient02.bean;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 王飞
 * @since 2020-09-24
 */
public class Account extends Model<Account> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "account_id", type = IdType.AUTO)
    private Long accountId;

    private Long userId;

    private String account;

    private BigDecimal money;


    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @Override
    protected Serializable pkVal() {
        return this.accountId;
    }

    @Override
    public String toString() {
        return "Account{" +
        "accountId=" + accountId +
        ", userId=" + userId +
        ", account=" + account +
        ", money=" + money +
        "}";
    }
}
