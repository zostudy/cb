package com.asiainfo.rms.system.dao;

import com.asiainfo.rms.system.domain.SysOrganizeTypeRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysOrganizeTypeDao {

    Integer saveOrganizeType(SysOrganizeTypeRepository organizeTypeRepository);

    Integer updateOrganizeType(SysOrganizeTypeRepository organizeTypeRepository);

    Integer deleteOrganizeTypeById(@Param("organizeTypeId")Integer organizeTypeId);

    List<SysOrganizeTypeRepository> selectOrganizeType(@Param("keywork")String keywork,@Param("offset") Integer offset, @Param("size") Integer size);

    List<SysOrganizeTypeRepository> selectAllCode ();

    Integer getOrganizeTypeCount(@Param("keywork")String keywork);
}
