package com.asiainfo.rms.system.service;

import com.asiainfo.rms.system.dto.StaffPassWordDTO;
import com.asiainfo.rms.system.dto.SysStaffAddOrgDTO;
import com.asiainfo.rms.system.dto.SysStaffDTO;
import com.asiainfo.rms.system.dto.SysStaffOrgDTO;

import java.util.List;

public interface StaffService {
    String saveStaff(SysStaffDTO staffDTO);

    String updateStaff(SysStaffDTO staffDTO);

    String deleteStaffById(Integer staffId);

    String updateStaffPassWord(StaffPassWordDTO staffPassWordDTO);

    SysStaffDTO selectByStaffId(Integer staffId);

    List<SysStaffDTO> selectAllStaffs(Integer organizeId,String keyword,String email, String billId, Integer pageNo, Integer pageSize);

    int getStaffCount(Integer organizeId,String keyword,String email,String billId);

    List<SysStaffAddOrgDTO> selectStaffsForWF(Integer organizeId, String staffCode, String roleCode, String wgCode, String employeeName);

    List<SysStaffOrgDTO> selectStaffTotal(Integer parentOrganizeId, String roleCode);

    List<SysStaffAddOrgDTO> selectStaffsForOrgWF(Integer organizeId, String roleCode);
    List<SysStaffAddOrgDTO> selectStaffsForOrgWFByName(Integer organizeId, String roleCode, String keyword);
}
