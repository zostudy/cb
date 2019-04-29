package com.asiainfo.rms.system.service;

import com.asiainfo.rms.system.dto.SysStaffOrgRelatDTO;

import java.util.Map;

public interface StaffOrgRelatService {
    String saveStaffOrgRelat(SysStaffOrgRelatDTO staffOrgRelatDTO);

//    String updateStaffOrgRelat(SysStaffOrgRelatDTO staffOrgRelatDTO);

    String deleteStaffOrgRelatById(Integer staffOrgRelatId);

//    SysStaffOrgRelatDTO selectByStaffOrgRelatId(Integer staffOrgRelatId);

    SysStaffOrgRelatDTO selectStaffOrgRelatByStaffId(Integer staffId);
}
