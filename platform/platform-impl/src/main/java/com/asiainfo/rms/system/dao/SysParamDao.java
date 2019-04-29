package com.asiainfo.rms.system.dao;

import com.asiainfo.rms.system.domain.SysParamRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysParamDao {
    List<SysParamRepository> selectParamByType(@Param("paramType")String paramType,@Param("paramReleId")Integer paramReleId);

    List<SysParamRepository> selecParams(@Param("paramType")String paramType);
}
