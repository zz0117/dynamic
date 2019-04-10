package com.wjf.dynamic.mapper;

import com.wjf.dynamic.model.Love;
import org.apache.ibatis.annotations.*;

@Mapper
public interface LoveMapper {
    @Insert("insert into love(id,openId,dynamicsId,type) values(#{id},#{openId},#{dynamicsId},#{type})")
    @Options(useGeneratedKeys = true,keyProperty = "id")//加入该注解可以保持对象后，查看对象插入id
    int insertLove(Love love);

    @Select("select * from love where openId=#{openId}")
    Love getLoveByOpenId(String openId);

    @Update("update love set dynamicsId=#{dynamicsId},type=#{type} where openId=#{openId}")
    int updateLoveByOpenId(Love love);
}
