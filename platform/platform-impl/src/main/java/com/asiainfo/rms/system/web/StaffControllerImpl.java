package com.asiainfo.rms.system.web;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.system.dto.StaffPassWordDTO;
import com.asiainfo.rms.system.dto.SysStaffAddOrgDTO;
import com.asiainfo.rms.system.dto.SysStaffDTO;
import com.asiainfo.rms.system.dto.SysStaffOrgDTO;
import com.asiainfo.rms.system.service.StaffService;

import lombok.extern.log4j.Log4j;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Log4j
@RestController
@Transactional
public class StaffControllerImpl implements StaffController {
    private final StaffService staffService;

    public StaffControllerImpl(StaffService staffService) {
        this.staffService = staffService;
    }

//    @Autowired
//    StaffService staffService;

    @Override
    public String saveStaff(@RequestBody SysStaffDTO staffDTO) {
        return staffService.saveStaff(staffDTO);
    }

    @Override
    public String updateStaff(@PathVariable("staff_id")Integer staffId, @RequestBody SysStaffDTO staffDTO) {
        staffDTO.setStaffId(staffId);
        return staffService.updateStaff(staffDTO);
    }

    @Override
    public String deleteStaffById(@PathVariable("staff_id") Integer staffId) {
        return staffService.deleteStaffById(staffId);
    }

    @Override
    public String updateStaffPassWord(@RequestBody StaffPassWordDTO staffPassWordDTO) {
        return staffService.updateStaffPassWord(staffPassWordDTO);
    }

    @Override
    public SysStaffDTO selectByStaffId(@PathVariable("staff_id") Integer staffId) {
        return staffService.selectByStaffId(staffId);
    }

    @Override
    public Page<SysStaffDTO> selectAllStaff(@RequestParam(value = "organize_id",required = false) Integer organizeId,
                                            @RequestParam(value = "keyword",required = false)String keyword,
                                            @RequestParam(value = "email",required = false)String email,
                                            @RequestParam(value = "bill_id", required = false) String billId,
                                            @RequestParam(value = "page_no") Integer pageNo,
                                            @RequestParam(value = "page_size") Integer pageSize) {
        Page<SysStaffDTO> page = new Page<>();
        int cnt = staffService.getStaffCount(organizeId,keyword,email,billId);
        if (cnt == 0) {
            return page;
        }
        List<SysStaffDTO> items = staffService.selectAllStaffs(organizeId,keyword,email,billId, pageNo, pageSize);
        if (CollectionUtils.isEmpty(items)) {
            return page;
        }
        page.setRowCount(cnt);
        page.generatePageCount(pageSize);
        page.setPageData(items);
        return page;
    }
    
    
    @Override
    public Map<String,Object> selectStaffsForWF(@RequestParam(value = "organize_id",required = false) Integer organizeId,
                                            @RequestParam(value = "staff_code",required = false)String staffCode,
                                            @RequestParam(value = "role_code",required = false)String roleCode,
                                            @RequestParam(value = "wg_code", required = false) String wgCode,
												@RequestParam(value = "employee_name", required = false) String employeeName) {
    	Map<String,Object> res = new HashMap<String,Object>();
    	try{
    		List<SysStaffAddOrgDTO> items = staffService.selectStaffsForWF(organizeId,staffCode,roleCode,wgCode, employeeName);
    		res.put("code", "1");
    		res.put("msg","");
    		res.put("obj", items);
    		return res;
    	}catch(Exception ex){
    		ex.printStackTrace();
    		log.error(ex.getMessage());
    		res.put("code", "0");
    		res.put("msg", ex.getMessage());
            return res;
    	}

    }

    @Override
    public Map<String, Object> selectStaffTotal(Integer parentOrganizeId, String roleCode) {
        Map<String,Object> res = new HashMap<String,Object>();
        try{
            List<SysStaffOrgDTO> items = staffService.selectStaffTotal(parentOrganizeId,roleCode);
            res.put("code", "1");
            res.put("msg","");
            res.put("obj", items);
            return res;
        }catch(Exception ex){
            ex.printStackTrace();
            log.error(ex.getMessage());
            res.put("code", "0");
            res.put("msg", ex.getMessage());
            return res;
        }
    }

    @Override
    public Map<String, Object> selectStaffsForOrgWF(Integer organizeId, String roleCode) {
        Map<String,Object> res = new HashMap<String,Object>();
        try{
            List<SysStaffAddOrgDTO> items = staffService.selectStaffsForOrgWF(organizeId,roleCode);
            res.put("code", "1");
            res.put("msg","");
            res.put("obj", items);
            return res;
        }catch(Exception ex){
            ex.printStackTrace();
            log.error(ex.getMessage());
            res.put("code", "0");
            res.put("msg", ex.getMessage());
            return res;
        }
    }

    @Override
    public Map<String, Object> selectStaffsForOrgWFByName(Integer organizeId, String roleCode, String keyword) {
        Map<String,Object> res = new HashMap<String,Object>();
        try{
            List<SysStaffAddOrgDTO> items = staffService.selectStaffsForOrgWFByName(organizeId,roleCode,keyword);
            res.put("code", "0");
            res.put("msg","");
            res.put("obj", items);
            return res;
        }catch(Exception ex){
            ex.printStackTrace();
            log.error(ex.getMessage());
            res.put("code", "0");
            res.put("msg", ex.getMessage());
            return res;
        }
    }
}
