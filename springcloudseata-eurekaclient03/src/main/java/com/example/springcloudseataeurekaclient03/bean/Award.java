package com.example.springcloudseataeurekaclient03.bean;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 王飞
 * @since 2020-09-27
 */
public class Award extends Model<Award> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "award_id", type = IdType.AUTO)
    private Long awardId;

    private Long userId;

    private BigDecimal integral;

    private LocalDateTime ctime;


    public Long getAwardId() {
        return awardId;
    }

    public void setAwardId(Long awardId) {
        this.awardId = awardId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getIntegral() {
        return integral;
    }

    public void setIntegral(BigDecimal integral) {
        this.integral = integral;
    }

    public LocalDateTime getCtime() {
        return ctime;
    }

    public void setCtime(LocalDateTime ctime) {
        this.ctime = ctime;
    }

    @Override
    protected Serializable pkVal() {
        return this.awardId;
    }

    @Override
    public String toString() {
        return "Award{" +
        "awardId=" + awardId +
        ", userId=" + userId +
        ", integral=" + integral +
        ", ctime=" + ctime +
        "}";
    }
}
