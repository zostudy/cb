package com.asiainfo.rms.system.web;

import com.asiainfo.rms.system.dto.SysStaffOrgRelatDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@RequestMapping("/system")
public interface StaffOrgRelatController {
    /**
     * 新增人员组织关系
     *
     * @param staffOrgRelatDTO
     * @return
     */
    @RequestMapping(value = "/staff_org_relat", method = RequestMethod.POST)
    String saveStaffOrgRelat(@RequestBody SysStaffOrgRelatDTO staffOrgRelatDTO);

//    /**
//     * 修改人员组织关系
//     *
//     * @param staffOrgRelatId
//     * @param staffOrgRelatDTO
//     * @return
//     */
//    @RequestMapping(value = "/staff_org_relat/{staff_org_relat_id}", method = RequestMethod.PUT)
//    String updateStaffOrgRelat(@PathVariable("staff_org_relat_id") Integer staffOrgRelatId,
//                            @RequestBody SysStaffOrgRelatDTO staffOrgRelatDTO);

    /**
     * 删除人员组织关系
     * @param staffOrgRelatId
     */
    @RequestMapping(value = "/staff_org_relat/{staff_org_relat_id}", method = RequestMethod.DELETE)
    String deleteStaffOrgRelatById(@PathVariable("staff_org_relat_id") Integer staffOrgRelatId);
//    /**
//     * 根据ID查询人员组织关系
//     *
//     * @param staffOrgRelatId
//     * @return
//     */
//    @RequestMapping(value = "/staff_org_relat/{staff_org_relat_id}", method = RequestMethod.GET)
//    SysStaffOrgRelatDTO selectByStaffOrgRelatId(@PathVariable("staff_org_relat_id") Integer staffOrgRelatId);

    /**
     * 根据staffId查询人员组织关系
     * @param staffId
     * @return
     */
    @RequestMapping(value = "/staff_org_relat/staff/{staff_id}", method = RequestMethod.GET)
    SysStaffOrgRelatDTO selectStaffOrgRelatByStaffId(@PathVariable("staff_id")Integer staffId);

}
