package com.asiainfo.rms.system.dao;

import com.asiainfo.rms.system.domain.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysStaffDao {
    Integer saveStaff(SysStaffRepository staffRepository);

    Integer updateStaff(SysStaffRepository staffRepository);

    Integer deleteStaffById(@Param("staffId") Integer staffId);

    Integer updateStaffPassWord(SysStaffRepository staffRepository);

    SysStaffRepository selectByStaffId(@Param("staffId") Integer staffId);

    Integer updateStaffLock(@Param("staffId") Integer staffId);

//    SysStaffRepository selectByCode(@Param("code")String code);

    int getStaffCount(@Param("organizeId") Integer organizeId, @Param("keyword") String keyword, @Param("email") String email, @Param("billId") String billId);

    List<SysStaffRepository> selectAllStaffs(@Param("organizeId") Integer organizeId, @Param("keyword") String keyword, @Param("email") String email, @Param("billId") String billId, @Param("offset") Integer offset, @Param("size") Integer size);

    //登录时，根据code查询对应的密码
    SysStaffRepository selectByCode(@Param("code") String code);

    /**
     * zhangbing 添加    用于工作流干系人选择 查询干系人使用
     *
     * @param organizeId
     * @param staffCode
     * @param roleCode
     * @param wgCode
     * @return
     */
    List<SysStaffAddOrgRepository> selectStaffsForWF(@Param("organizeId") Integer organizeId, @Param("staffCode") String staffCode, @Param("roleCode") String roleCode, @Param("wgCode") String wgCode, @Param("employeeName") String employeeName);

    SysLoginUserInfoRepository selectLoginUserInfo(@Param("staffId") Integer staffId);

    List<SysStaffOrgRepository> selectStaffTotal(@Param("parentOrganizeId") Integer organizeId, @Param("roleCode") String roleCode);

    List<SysStaffAddOrgRepository> selectStaffsForOrgWF(@Param("organizeId") Integer organizeId,@Param("roleCode") String roleCode);

    List<SysStaffAddOrgRepository> selectStaffsForOrgWFByName(@Param("organizeId") Integer organizeId,  @Param("roleCode") String roleCode, @Param("keyword") String keyword);

    List<SysStaffOrgRepository> getOrganizeInfo(@Param("organizeId") Integer organizeId);
}
