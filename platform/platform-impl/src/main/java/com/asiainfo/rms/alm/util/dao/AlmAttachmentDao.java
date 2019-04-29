package com.asiainfo.rms.alm.util.dao;

import org.apache.ibatis.annotations.Param;

import com.asiainfo.rms.alm.util.domain.AlmAttachmentRepository;

public interface AlmAttachmentDao {
    int deleteByPrimaryKey(@Param("attId") Long attId);

    int insert(AlmAttachmentRepository record);

    int insertSelective(AlmAttachmentRepository record);

    AlmAttachmentRepository selectByPrimaryKey(@Param("attId") Long attId);

    int updateByPrimaryKeySelective(AlmAttachmentRepository record);

    int updateByPrimaryKey(AlmAttachmentRepository record);
}