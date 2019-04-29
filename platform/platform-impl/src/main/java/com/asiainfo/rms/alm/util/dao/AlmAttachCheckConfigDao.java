package com.asiainfo.rms.alm.util.dao;

import com.asiainfo.rms.alm.util.domain.AlmAttachCheckConfigRepository;
import com.asiainfo.rms.system.dto.SysAlmAttachCheckConfigDTO;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface AlmAttachCheckConfigDao {
    int deleteByPrimaryKey(@Param("attChkId") BigDecimal attChkId);

    int insert(AlmAttachCheckConfigRepository record);

    int insertSelective(AlmAttachCheckConfigRepository record);

    AlmAttachCheckConfigRepository selectByPrimaryKey(@Param("attChkId") BigDecimal attChkId);

    int updateByPrimaryKeySelective(AlmAttachCheckConfigRepository record);

    int updateByPrimaryKey(AlmAttachCheckConfigRepository record);
    
    List<SysAlmAttachCheckConfigDTO> selectByCond(@Param("objType") Long objType, @Param("submitLink") String submitLink, @Param("codingType") Long codingType, @Param("sysTag") String sysTag,
                                                  @Param("subSysTag") String subSysTag);
}