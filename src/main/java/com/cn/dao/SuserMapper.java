package com.cn.dao;

import com.cn.dto.Suser;
import com.cn.dto.SuserExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SuserMapper {
    int countByExample(SuserExample example);

    int deleteByExample(SuserExample example);

    int deleteByPrimaryKey(String userid);

    int insert(Suser record);

    int insertSelective(Suser record);

    List<Suser> selectByExample(SuserExample example);

    Suser selectByPrimaryKey(String userid);

    int updateByExampleSelective(@Param("record") Suser record, @Param("example") SuserExample example);

    int updateByExample(@Param("record") Suser record, @Param("example") SuserExample example);

    int updateByPrimaryKeySelective(Suser record);

    int updateByPrimaryKey(Suser record);
}