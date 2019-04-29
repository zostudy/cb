package com.asiainfo.rms.system.dao;

import com.asiainfo.rms.system.domain.SysFunctionRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysFunctionDao {
    Integer saveFunction(SysFunctionRepository functionRepository);

    Integer updateFunction(SysFunctionRepository functionRepository);

    Integer deleteFunctionById(@Param("funcId")Integer funcId);

    SysFunctionRepository selectByFunctionId(@Param("funcId") Integer funcId);

    List<SysFunctionRepository> selectAllFunction(@Param("state") Integer state);

//    List<SysFunctionRepository> selectAllFuncCode();

    Integer getFunctionByCode(@Param("funcCode")String funcCode);

    List<SysFunctionRepository> selectFunctionByStaffId(@Param("staffId")Integer staffId);

}
