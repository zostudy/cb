package com.asiainfo.rms.system.web;

import com.asiainfo.rms.system.service.SystemService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RestController
@Transactional
public class SystemControllerImpl implements SystemController {
    private final SystemService systemService;

    public SystemControllerImpl(SystemService systemService) {
        this.systemService = systemService;
    }

    @Override
    public Map getImageCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return systemService.getImageCode(request,response);
    }

//    @Override
//    public Map login(HttpSession session,@RequestBody SysLoginInfoDTO loginInfoDTO) {
//        return systemService.login(session,loginInfoDTO);
//    }
//
//    @Override
//    public void loginOut(@RequestParam("log_id")Integer logId) {
//        systemService.loginOut(logId);
//    }

//    @Override
//    public Map saveStaff(@RequestBody SysStaffDTO staffDTO) {
//        return systemService.saveStaff(staffDTO);
//    }
//
//    @Override
//    public Map updateStaff(@PathVariable("staff_id")Integer staffId, @RequestBody SysStaffDTO staffDTO) {
//        staffDTO.setStaffId(staffId);
//        return systemService.updateStaff(staffDTO);
//    }
//
//    @Override
//    public Map updateStaffId(@PathVariable("staff_id") Integer staffId) {
//        return systemService.updateStaffId(staffId);
//    }
//
//    @Override
//    public Map updateStaffPassWord(@RequestBody StaffPassWordDTO staffPassWordDTO) {
//        return systemService.updateStaffPassWord(staffPassWordDTO);
//    }
//
//    @Override
//    public SysStaffDTO selectByStaffId(@PathVariable("staff_id") Integer staffId) {
//        return systemService.selectByStaffId(staffId);
//    }
//
//    @Override
//    public Page<SysStaffDTO> selectAllStaff(@RequestParam(value = "employee_name", required = false) String employeeName,
//                                            @RequestParam(value = "bill_id", required = false) String billId,
//                                            @RequestParam(value = "page_no") Integer pageNo,
//                                            @RequestParam(value = "page_size") Integer pageSize) {
//        Page<SysStaffDTO> page = new Page<>();
//        int cnt = systemService.getStaffCount(employeeName,billId);
//        if (cnt == 0) {
//            return page;
//        }
//        List<SysStaffDTO> items = systemService.selectAllStaffs(employeeName,billId, pageNo, pageSize);
//        if (CollectionUtils.isEmpty(items)) {
//            return page;
//        }
//        page.setRowCount(cnt);
//        page.generatePageCount(pageSize);
//        page.setPageData(items);
//        return page;
//    }



//    @Override
//    public Map saveFunction(@RequestBody SysFunctionDTO functionDTO) {
//        return systemService.saveFunction(functionDTO);
//    }
//
//    @Override
//    public Map updateFunction(@PathVariable("func_id") Integer funcId, @RequestBody SysFunctionDTO functionDTO) {
//        functionDTO.setFuncId(funcId);
//        return  systemService.updateFunction(functionDTO);
//
//    }
//
//    @Override
//    public Map updateFunctionById(Integer funcId) {
//        return systemService.updateFunctionById(funcId);
//    }
//
//    @Override
//    public SysFunctionDTO selectByFunctionId(@PathVariable("func_id") Integer funcId) {
//        return systemService.selectByFuncId(funcId);
//    }
//
//    @Override
//    public List<SysFunctionDTO> selectAllFunction(Integer state) {
//        return systemService.selectAllFunction(state);
//    }

//    @Override
//    public Map saveRole(@RequestBody SysRoleDTO roleDTO) {
//        return systemService.saveRole(roleDTO);
//    }
//
//    @Override
//    public Map updateRole(@PathVariable("role_id") Integer roleId, @RequestBody SysRoleDTO roleDTO) {
//        roleDTO.setRoleId(roleId);
//        return systemService.updateRole(roleDTO);
//    }
//
//    @Override
//    public SysRoleDTO selectByRoleId(@PathVariable("role_id") Integer roleId) {
//        return systemService.selectByRoleId(roleId);
//    }
//
//    @Override
//    public SysRoleDTO selectRoleInfoByStaffId(@PathVariable("staff_id")Integer staffId) {
//        return systemService.selectRoleInfoByStaffId(staffId);
//    }

//    @Override
//    public Map saveOrganize(@RequestBody SysOrganizeDTO organizeDTO) {
//        return systemService.saveOrganize(organizeDTO);
//    }
//
//    @Override
//    public Map updateOrganize(@PathVariable("organize_id")Integer organizeId, @RequestBody SysOrganizeDTO organizeDTO) {
//        organizeDTO.setOrganizeId(organizeId);
//        return systemService.updateOrganize(organizeDTO);
//    }
//
//    @Override
//    public Map updateByOrganizeId(Integer organizeId) {
//        return systemService.updateByOrganizeId(organizeId);
//    }
//
//    @Override
//    public SysOrganizeDTO selectByOrganizeId(@PathVariable("organize_id")Integer organizeId) {
//        return systemService.selectByOrganizeId(organizeId);
//    }
//
//    @Override
//    public SysOrganizeDTO selectOrganizeByStaffId(@PathVariable("staff_id")Integer staffId) {
//        return systemService.selectOrganizeByStaffId(staffId);
//    }
//
//    @Override
//    public Map saveOrganizeType(@RequestBody SysOrganizeTypeDTO organizeTypeDTO) {
//        return systemService.saveOrganizeType(organizeTypeDTO);
//    }
//
//    @Override
//    public Map updateOrganizeType(@PathVariable("organize_type_id") Integer organizeTypeId, @RequestBody SysOrganizeTypeDTO organizeTypeDTO) {
//        organizeTypeDTO.setOrganizeTypeId(organizeTypeId);
//        return systemService.updateOrganizeType(organizeTypeDTO);
//    }
//
//    @Override
//    public Map updateOrganizeTypeById(@PathVariable("organize_type_id")Integer organizeTypeId) {
//        return systemService.updateOrganizeTypeById(organizeTypeId);
//    }

//    @Override
//    public Map saveAuthor(@RequestBody SysAuthorDTO authorDTO) {
//        return systemService.saveAuthor(authorDTO);
//    }
//
//    @Override
//    public Map updateAuthor(@PathVariable("author_id") Integer authorId, @RequestBody SysAuthorDTO authorDTO) {
//        authorDTO.setAuthorId(authorId);
//        return systemService.updateAuthor(authorDTO);
//    }
//
//    @Override
//    public SysAuthorDTO selectByAuthorId(@PathVariable("author_id")Integer authorId) {
//        return systemService.selectByAuthorId(authorId);
//    }

//    @Override
//    public Map saveStaffOrgRelat(@RequestBody SysStaffOrgRelatDTO staffOrgRelatDTO) {
//        return systemService.saveStaffOrgRelat(staffOrgRelatDTO);
//    }
//
//    @Override
//    public Map updateStaffOrgRelat(@PathVariable("staff_org_relat_id")Integer staffOrgRelatId, @RequestBody SysStaffOrgRelatDTO staffOrgRelatDTO) {
//        staffOrgRelatDTO.setStaffOrgRelatId(staffOrgRelatId);
//        return systemService.updateStaffOrgRelat(staffOrgRelatDTO);
//    }
//
//    @Override
//    public SysStaffOrgRelatDTO selectByStaffOrgRelatId(@PathVariable("staff_org_relat_id")Integer staffOrgRelatId) {
//        return systemService.selectByStaffOrgRelatId(staffOrgRelatId);
//    }
//
//    @Override
//    public Map saveStaffRoleAuthor(@RequestBody SysStaffRoleAuthorDTO staffRoleAuthorDTO) {
//        return systemService.saveStaffRoleAuthor(staffRoleAuthorDTO);
//    }
//
//    @Override
//    public Map updateStaffRoleAuthor(@PathVariable("role_author_id")Integer roleAuthorId, @RequestBody SysStaffRoleAuthorDTO staffRoleAuthorDTO) {
//        staffRoleAuthorDTO.setRoleAuthorId(roleAuthorId);
//        return systemService.updateStaffRoleAuthor(staffRoleAuthorDTO);
//    }
//
//    @Override
//    public SysStaffRoleAuthorDTO selectByStaffRoleAuthorId(@PathVariable("staff_role_author_id")Integer staffRoleAuthorId) {
//        return systemService.selectByStaffRoleAuthorId(staffRoleAuthorId);
//    }

//    @Override
//    public Map saveStation(@RequestBody SysStationDTO stationDTO) {
//        return systemService.saveStation(stationDTO);
//    }
//
//    @Override
//    public Map updateStation(@PathVariable("station_id")Integer stationId, @RequestBody SysStationDTO stationDTO) {
//        stationDTO.setStationId(stationId);
//        return systemService.updateStation(stationDTO);
//    }
//
//    @Override
//    public SysStationDTO selectByStationId(@PathVariable("station_id")Integer stationId) {
//        return systemService.selectByStationId(stationId);
//    }
//
//    @Override
//    public Page<SysStationDTO> selectAllStation(@RequestParam(value= "name",required = false)String name,
//                                                @RequestParam(value= "code",required = false)String code,
//                                                @RequestParam(value = "page_no") Integer pageNo,
//                                                @RequestParam(value = "page_size") Integer pageSize) {
//        Page<SysStationDTO> page = new Page<>();
//        int cnt = systemService.getStationCount(name,code);
//        if (cnt == 0) {
//            return page;
//        }
//        List<SysStationDTO> stationList = systemService.selectAllStation(name,code,pageNo,pageSize);
//        if (CollectionUtils.isEmpty(stationList)) {
//            return page;
//        }
//        page.setRowCount(cnt);
//        page.generatePageCount(pageSize);
//        page.setPageData(stationList);
//        return page;
//    }

//    @Override
//    public Map saveStationFunc(@RequestBody SysStationFuncDTO stationFuncDTO) {
//        return systemService.saveStationFunc(stationFuncDTO);
//    }
//
//    @Override
//    public Map updateStationFunc(@PathVariable("station_func_relat_id")Integer stationFuncRelatId, @RequestBody SysStationFuncDTO stationFuncDTO) {
//        stationFuncDTO.setStationFuncRelatId(stationFuncRelatId);
//        return systemService.updateStationFunc(stationFuncDTO);
//    }
//
//    @Override
//    public SysStationFuncDTO selectByStationFuncRelatId(@PathVariable("station_func_relat_id")Integer stationFuncRelatId) {
//        return systemService.selectByStationFuncRelatId(stationFuncRelatId);
//    }
//
//    @Override
//    public SysStationFuncDTO selectStationFuncByStaffId(@PathVariable("staff_id")Integer staffId) {
//        return systemService.selectStationFuncByStaffId(staffId);
//    }

//    @Override
//    public Map saveOpTypeDef(@RequestBody SysOpTypeDefDTO sysOpTypeDefDTO) {
//        return systemService.saveOpTypeDef(sysOpTypeDefDTO);
//    }
//
//    @Override
//    public Map updateOpTypeDef(@PathVariable("op_type_id") Integer opTypeId, @RequestBody SysOpTypeDefDTO sysOpTypeDefDTO) {
//        sysOpTypeDefDTO.setOpTypeId(opTypeId);
//        return systemService.updateOpTypeDef(sysOpTypeDefDTO);
//    }
//
//    @Override
//    public Page<SysOpTypeDefDTO> selectAllOpType(@RequestParam(value = "code",required = false)String code,
//                                                 @RequestParam(value = "op_type_name",required = false)String opTypeName,
//                                                 @RequestParam(value = "page_no") Integer pageNo,
//                                                 @RequestParam(value = "page_size") Integer pageSize) {
//        Page<SysOpTypeDefDTO> page = new Page<>();
//        int cnt = systemService.getOpTypeCount(code,opTypeName);
//        if (cnt == 0) {
//            return page;
//        }
//        List<SysOpTypeDefDTO> opTypeDefList = systemService.selectAllOpType(code,opTypeName,pageNo,pageSize);
//        if (CollectionUtils.isEmpty(opTypeDefList)) {
//            return page;
//        }
//        page.setRowCount(cnt);
//        page.generatePageCount(pageSize);
//        page.setPageData(opTypeDefList);
//        return page;
//    }

//    @Override
//    public Map saveOpLog(SysOpLogDTO opLogDTO) {
//        return null;
//    }
//
//    @Override
//    public Map saveOpLog(SysOpLogDTO opLogDTO) {
//        return null;
//    }


}
