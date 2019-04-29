package com.asiainfo.rms.system.dao;

import com.asiainfo.rms.system.domain.SysAlmAttachCheckConfigRepostitory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysAlmAttachCheckConfigDao {
    List<SysAlmAttachCheckConfigRepostitory> selectCheckRuleByConds(@Param("objType") Long objType,
                                                                    @Param("submitLink") String submitLink,
                                                                    @Param("codingType") Long codingType,
                                                                    @Param("sysTag") String sysTag,
                                                                    @Param("subSysTag") String subSysTag);

}
