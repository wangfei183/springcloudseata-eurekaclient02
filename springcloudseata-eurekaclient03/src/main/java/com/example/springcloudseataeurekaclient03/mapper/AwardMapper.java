package com.example.springcloudseataeurekaclient03.mapper;

import com.example.springcloudseataeurekaclient03.bean.Award;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 王飞
 * @since 2020-09-27
 */
@Mapper
public interface AwardMapper extends BaseMapper<Award> {
    @Select("select * from award where user_id=#{userid}")
    Award queryByUserId(Long userid);




}
