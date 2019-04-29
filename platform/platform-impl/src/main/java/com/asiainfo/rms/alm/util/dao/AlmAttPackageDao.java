package com.asiainfo.rms.alm.util.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.asiainfo.rms.alm.util.domain.AlmAttPackageRepository;

public interface AlmAttPackageDao {
    int deleteByPrimaryKey(@Param("attPackId") Long attPackId);

    int insert(AlmAttPackageRepository record);

    int insertSelective(AlmAttPackageRepository record);

    AlmAttPackageRepository selectByPrimaryKey(@Param("attPackId") Long attPackId);

    int updateByPrimaryKeySelective(AlmAttPackageRepository record);

    int updateByPrimaryKey(AlmAttPackageRepository record);
    
    List<AlmAttPackageRepository> selectByCond(@Param("objId") Long objId, @Param("objType") Long objType);
}