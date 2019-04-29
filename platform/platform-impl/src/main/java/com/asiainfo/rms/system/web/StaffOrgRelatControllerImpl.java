package com.asiainfo.rms.system.web;

import com.asiainfo.rms.system.dto.SysStaffOrgRelatDTO;
import com.asiainfo.rms.system.service.StaffOrgRelatService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Transactional
public class StaffOrgRelatControllerImpl implements StaffOrgRelatController {
    private final StaffOrgRelatService staffOrgRelatService;

    public StaffOrgRelatControllerImpl(StaffOrgRelatService staffOrgRelatService) {
        this.staffOrgRelatService = staffOrgRelatService;
    }

    @Override
    public String saveStaffOrgRelat( @RequestBody SysStaffOrgRelatDTO staffOrgRelatDTO) {
        return staffOrgRelatService.saveStaffOrgRelat(staffOrgRelatDTO);
    }

//    @Override
//    public String updateStaffOrgRelat(@PathVariable("staff_org_relat_id") Integer staffOrgRelatId,
//                                   @RequestBody SysStaffOrgRelatDTO staffOrgRelatDTO) {
//        staffOrgRelatDTO.setStaffOrgRelatId(staffOrgRelatId);
//        return staffOrgRelatService.updateStaffOrgRelat(staffOrgRelatDTO);
//    }

    @Override
    public String deleteStaffOrgRelatById(@PathVariable("staff_org_relat_id")Integer staffOrgRelatId) {
        return staffOrgRelatService.deleteStaffOrgRelatById(staffOrgRelatId);
    }

//    @Override
//    public SysStaffOrgRelatDTO selectByStaffOrgRelatId(@PathVariable("staff_org_relat_id")Integer staffOrgRelatId) {
//        return staffOrgRelatService.selectByStaffOrgRelatId(staffOrgRelatId);
//    }

    @Override
    public SysStaffOrgRelatDTO selectStaffOrgRelatByStaffId(@PathVariable("staff_id")Integer staffId) {
        return staffOrgRelatService.selectStaffOrgRelatByStaffId(staffId);
    }
}
