package com.asiainfo.rms.system.dao;

import com.asiainfo.rms.system.domain.SysOpTypeDefRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysOpTypeDefDao {
    Integer saveOpTypeDef(SysOpTypeDefRepository opTypeDefRepository);

    Integer updateOpTypeDef(SysOpTypeDefRepository opTypeDefRepository);

    Integer deleteOpTypeDefById(@Param("opTypeId") Integer opTypeId);

    List<SysOpTypeDefRepository> selectAllOpType(@Param("code")String code,@Param("OpTypeName")String OpTypeName,@Param("offset") Integer offset, @Param("size") Integer size);

    int getOpTypeCount(@Param("code")String code,@Param("OpTypeName")String OpTypeName);

    List<SysOpTypeDefRepository> selectAllCode();

}
