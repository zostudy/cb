package com.asiainfo.rms.system.dao;

import com.asiainfo.rms.system.domain.SysOrganizeRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysOrganizeDao {
    Integer saveOrganize(SysOrganizeRepository organizeRepository);

    Integer updateOrganize(SysOrganizeRepository organizeRepository);

    Integer deleteByOrganizeId(@Param("organizeId")Integer organizeId);

    SysOrganizeRepository selectByOrganizeId(@Param("organizeId")Integer organizeId);

    SysOrganizeRepository selectOrganizeByStaffId(@Param("staffId")Integer staffId);

    List<SysOrganizeRepository> selectAllOrganize(@Param("code") String code,
                                                  @Param("organizeName") String organizeName,
                                                  @Param("state")Integer state);

    List<SysOrganizeRepository> selectByParentCode(@Param("parentCode")String parentCode);

    List<SysOrganizeRepository> selectOrganizeByParentId(@Param("parentOrganizeId")Integer parentOrganizeId,
                                                         @Param("state")Integer state);

    SysOrganizeRepository selectOrganizeInfoByOrganize(@Param("tire")Integer tire,
                                                       @Param("organizeId")Integer organizeId,
                                                       @Param("organizeCode")String organizeCode);

    SysOrganizeRepository selectOrganizeInfoByStaff(@Param("tire")Integer tire,
                                                    @Param("staffId")Integer staffId,
                                                    @Param("staffCode")String staffCode);

    SysOrganizeRepository selectStaffYesOrNo(@Param("organizeId")Integer organizeId);


}
