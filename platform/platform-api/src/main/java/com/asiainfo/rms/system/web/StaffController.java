package com.asiainfo.rms.system.web;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.system.dto.StaffPassWordDTO;
import com.asiainfo.rms.system.dto.SysStaffAddOrgDTO;
import com.asiainfo.rms.system.dto.SysStaffDTO;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/system")
public interface StaffController {
    /**
     * 用户信息新增
     *
     * @param staffDTO
     * @return
     */
    @RequestMapping(value = "/staff", method = RequestMethod.POST)
    String saveStaff(@RequestBody SysStaffDTO staffDTO);

    /**
     * 修改用户资料
     *
     * @param staffId
     * @param staffDTO
     * @return
     */
    @RequestMapping(value = "/staff/{staff_id}", method = RequestMethod.PUT)
    String updateStaff(@PathVariable("staff_id") Integer staffId, @RequestBody SysStaffDTO staffDTO);

    /**
     * 删除用户资料
     *
     * @param staffId
     * @return
     */
    @RequestMapping(value = "/staff/{staff_id}", method = RequestMethod.DELETE)
    String deleteStaffById(@PathVariable("staff_id") Integer staffId);

    /**
     * 修改用户密码
     *
     * @param staffPassWordDTO
     * @return
     */
    @RequestMapping(value = "/staff/psw", method = RequestMethod.PUT)
    String updateStaffPassWord(@RequestBody StaffPassWordDTO staffPassWordDTO);

    /**
     * 根据staffId查询用户资料
     *
     * @param staffId
     * @return
     */
    @RequestMapping(value = "/staff/{staff_id}", method = RequestMethod.GET)
    SysStaffDTO selectByStaffId(@PathVariable("staff_id") Integer staffId);


    /**
     * 查询所有的用户信息（带分页）
     * @param organizeId
     * @param keyword
     * @param email
     * @param billId
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/staff/all", method = RequestMethod.GET)
    Page<SysStaffDTO> selectAllStaff(@RequestParam(value = "organize_id",required = false) Integer organizeId,
                                     @RequestParam(value = "keyword",required = false)String keyword,
                                     @RequestParam(value = "email",required = false)String email,
                                     @RequestParam(value = "bill_id", required = false) String billId,
                                     @RequestParam(value = "page_no") Integer pageNo,
                                     @RequestParam(value = "page_size") Integer pageSize);
    
    /**
     * 查询环节处理干系人列表信息
     * @param organizeId
     * @param staffCode
     * @param roleCode
     * @param wgCode
     * @return
     */
    @RequestMapping(value = "/staff/wf", method = RequestMethod.GET)
    Map<String,Object> selectStaffsForWF(@RequestParam(value = "organize_id",required = false) Integer organizeId,
									          @RequestParam(value = "staff_code",required = false)String staffCode,
									          @RequestParam(value = "role_code",required = true)String roleCode,
									          @RequestParam(value = "wg_code", required = false) String wgCode,
                                            @RequestParam(value = "employee_name", required = false) String employeeName);



    @RequestMapping(value = "/org/staffTotal", method = RequestMethod.GET)
    Map<String,Object> selectStaffTotal(@RequestParam(value = "parent_organize_id") Integer parentOrganizeId,
                                        @RequestParam(value = "role_code") String roleCode);

    @RequestMapping(value = "/org/getStaffs", method = RequestMethod.GET)
    Map<String,Object> selectStaffsForOrgWF(@RequestParam(value = "organize_id",required = false) Integer organizeId,
                                        @RequestParam(value = "role_code") String roleCode);


    @RequestMapping(value = "/org/getStaffsByName", method = RequestMethod.GET)
    Map<String,Object> selectStaffsForOrgWFByName(@RequestParam(value = "organize_id",required = false) Integer organizeId,
                                            @RequestParam(value = "role_code") String roleCode,
                                            @RequestParam(value = "keyword",required = false) String keyword);


}
