package com.asiainfo.rms.system.web;

import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RequestMapping("/system")
public interface SystemController {
    /**
     * 获取随机验证码
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = "/image", method = RequestMethod.GET)
    Map getImageCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

//    /**
//     * 登陆
//     *
//     * @param session
//     * @param loginInfoDTO
//     * @return
//     */
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    Map login(HttpSession session, @RequestBody SysLoginInfoDTO loginInfoDTO);
//
//    /**
//     * 登出
//     *
//     * @param logId
//     */
//    @RequestMapping(value = "/loginout", method = RequestMethod.POST)
//    void loginOut(@RequestParam("log_id") Integer logId);

//    /**
//     * 用户信息新增
//     *
//     * @param staffDTO
//     * @return
//     */
//    @RequestMapping(value = "/staff", method = RequestMethod.POST)
//    Map saveStaff(@RequestBody SysStaffDTO staffDTO);
//
//    /**
//     * 修改用户资料
//     *
//     * @param staffId
//     * @param staffDTO
//     * @return
//     */
//    @RequestMapping(value = "/staff/{staff_id}", method = RequestMethod.PUT)
//    Map updateStaff(@PathVariable("staff_id") Integer staffId, @RequestBody SysStaffDTO staffDTO);
//
//    /**
//     * 删除用户资料
//     *
//     * @param staffId
//     * @return
//     */
//    @RequestMapping(value = "/staff/{staff_id}", method = RequestMethod.DELETE)
//    Map updateStaffId(@PathVariable("staff_id") Integer staffId);
//
//    /**
//     * 修改用户密码
//     *
//     * @param staffPassWordDTO
//     * @return
//     */
//    @RequestMapping(value = "/staff/psw", method = RequestMethod.PUT)
//    Map updateStaffPassWord(@RequestBody StaffPassWordDTO staffPassWordDTO);
//
//    /**
//     * 根据staffId查询用户资料
//     *
//     * @param staffId
//     * @return
//     */
//    @RequestMapping(value = "/staff/{staff_id}", method = RequestMethod.GET)
//    SysStaffDTO selectByStaffId(@PathVariable("staff_id") Integer staffId);
//
//
//    /**
//     * 查询所有的用户信息（带分页）
//     *
//     * @param employeeName
//     * @param billId
//     * @param pageNo
//     * @param pageSize
//     * @return
//     */
//    @RequestMapping(value = "/staff/all", method = RequestMethod.GET)
//    Page<SysStaffDTO> selectAllStaff(@RequestParam(value = "employee_name", required = false) String employeeName,
//                                     @RequestParam(value = "bill_id", required = false) String billId,
//                                     @RequestParam(value = "page_no") Integer pageNo,
//                                     @RequestParam(value = "page_size") Integer pageSize);

//    /**
//     * 新增功能菜单
//     *
//     * @param functionDTO
//     * @return
//     */
//    @RequestMapping(value = "/function", method = RequestMethod.POST)
//    Map saveFunction(@RequestBody SysFunctionDTO functionDTO);
//
//    /**
//     * 修改/删除菜单
//     *
//     * @param funcId
//     * @param functionDTO
//     * @return
//     */
//    @RequestMapping(value = "/function/{func_id}", method = RequestMethod.PUT)
//    Map updateFunction(@PathVariable("func_id") Integer funcId, @RequestBody SysFunctionDTO functionDTO);
//
//    /**
//     * 删除菜单
//     *
//     * @param funcId
//     * @return
//     */
//    @RequestMapping(value = "/function/{func_id}", method = RequestMethod.DELETE)
//    Map updateFunctionById(@PathVariable("func_id") Integer funcId);
//
//    /**
//     * 根据funcId查询菜单
//     *
//     * @param funcId
//     * @return
//     */
//    @RequestMapping(value = "/function/{func_id}", method = RequestMethod.GET)
//    SysFunctionDTO selectByFunctionId(@PathVariable("func_id") Integer funcId);
//
//    /**
//     * 查询所有菜单
//     *
//     * @param state
//     * @return
//     */
//    @RequestMapping(value = "/functions", method = RequestMethod.GET)
//    List<SysFunctionDTO> selectAllFunction(@RequestParam(value = "state", required = false, defaultValue = "1") Integer state);

//    /**
//     * 新增角色
//     * @param roleDTO
//     * @return
//     */
//    @RequestMapping(value = "/role", method = RequestMethod.POST)
//    Map saveRole(@RequestBody SysRoleDTO roleDTO);
//
//    /**
//     * 修改/删除角色信息
//     * @param roleId
//     * @param roleDTO
//     * @return
//     */
//    @RequestMapping(value = "/role/{role_id}", method = RequestMethod.PUT)
//    Map updateRole(@PathVariable("role_id") Integer roleId, @RequestBody SysRoleDTO roleDTO);
//
//    /**
//     * 根据roleId查询角色信息
//     * @param roleId
//     * @return
//     */
//    @RequestMapping(value = "/role/{role_id}", method = RequestMethod.GET)
//    SysRoleDTO selectByRoleId(@PathVariable("role_id") Integer roleId);
//
//    /**
//     * 根据staffId查询角色信息
//     * @param staffId
//     * @return
//     */
//    @RequestMapping(value="/role/staff/{staff_id}",method = RequestMethod.GET)
//    SysRoleDTO selectRoleInfoByStaffId(@PathVariable("staff_id") Integer staffId);

//    /**
//     * 新增组织信息
//     *
//     * @param organizeDTO
//     * @return
//     */
//    @RequestMapping(value = "/organize", method = RequestMethod.POST)
//    Map saveOrganize(@RequestBody SysOrganizeDTO organizeDTO);
//
//    /**
//     * 修改组织信息
//     *
//     * @param organizeId
//     * @param organizeDTO
//     * @return
//     */
//    @RequestMapping(value = "/organize/{organize_id}", method = RequestMethod.PUT)
//    Map updateOrganize(@PathVariable("organize_id") Integer organizeId, @RequestBody SysOrganizeDTO organizeDTO);
//
//    /**
//     * 删除组织信息
//     *
//     * @param organizeId
//     * @return
//     */
//    @RequestMapping(value = "/organize/{organize_id}", method = RequestMethod.DELETE)
//    Map updateByOrganizeId(@PathVariable("organize_id") Integer organizeId);
//
//    /**
//     * 根据organizeId查询组织信息
//     *
//     * @param organizeId
//     * @return
//     */
//    @RequestMapping(value = "/organize/{organize_id}", method = RequestMethod.GET)
//    SysOrganizeDTO selectByOrganizeId(@PathVariable("organize_id") Integer organizeId);
//
//    /**
//     * 根据staffId查询组织结构
//     *
//     * @param staffId
//     * @return
//     */
//    @RequestMapping(value = "/organize/staff/{staff_id}", method = RequestMethod.GET)
//    SysOrganizeDTO selectOrganizeByStaffId(@PathVariable("staff_id") Integer staffId);
//
//    /**
//     * 保存组织类型
//     * @param organizeTypeDTO
//     * @return
//     */
//    @RequestMapping(value="/organize_type",method = RequestMethod.POST)
//    Map saveOrganizeType(@RequestBody SysOrganizeTypeDTO organizeTypeDTO);
//
//    /**
//     * 修改组织类型
//     * @param organizeTypeId
//     * @param organizeTypeDTO
//     * @return
//     */
//    @RequestMapping(value="/organize_type/{organize_type_id}",method = RequestMethod.PUT)
//    Map updateOrganizeType(@PathVariable("organize_type_id")Integer organizeTypeId,@RequestBody SysOrganizeTypeDTO organizeTypeDTO);
//
//    /**
//     * 删除组织类型
//     * @param organizeTypeId
//     * @return
//     */
//    @RequestMapping(value="/organize_type/{organize_type_id}",method = RequestMethod.DELETE)
//    Map updateOrganizeTypeById(@PathVariable("organize_type_id")Integer organizeTypeId);


//    /**
//     * 新增岗位权限
//     *
//     * @param authorDTO
//     * @return
//     */
//    @RequestMapping(value = "/author", method = RequestMethod.POST)
//    Map saveAuthor(@RequestBody SysAuthorDTO authorDTO);
//
//    /**
//     * 修改/删除岗位权限
//     *
//     * @param authorId
//     * @param authorDTO
//     * @return
//     */
//    @RequestMapping(value = "/author/{author_id}", method = RequestMethod.PUT)
//    Map updateAuthor(@PathVariable("author_id") Integer authorId, @RequestBody SysAuthorDTO authorDTO);
//
//    /**
//     * 根据authorId查询岗位权限
//     *
//     * @param authorId
//     * @return
//     */
//    @RequestMapping(value = "/author/{author_id}", method = RequestMethod.GET)
//    SysAuthorDTO selectByAuthorId(@PathVariable("author_id") Integer authorId);

//    /**
//     * 新增人员组织关系
//     *
//     * @param staffOrgRelatDTO
//     * @return
//     */
//    @RequestMapping(value = "/staff_org_relat", method = RequestMethod.POST)
//    Map saveStaffOrgRelat(@RequestBody SysStaffOrgRelatDTO staffOrgRelatDTO);
//
//    /**
//     * 修改/删除人员组织关系
//     *
//     * @param staffOrgRelatId
//     * @param staffOrgRelatDTO
//     * @return
//     */
//    @RequestMapping(value = "/staff_org_relat/{staff_org_relat_id}", method = RequestMethod.PUT)
//    Map updateStaffOrgRelat(@PathVariable("staff_org_relat_id") Integer staffOrgRelatId,
//                            @RequestBody SysStaffOrgRelatDTO staffOrgRelatDTO);
//
//    /**
//     * 根据ID查询人员组织关系
//     *
//     * @param staffOrgRelatId
//     * @return
//     */
//    @RequestMapping(value = "/staff_org_relat/{staff_org_relat_id}", method = RequestMethod.GET)
//    SysStaffOrgRelatDTO selectByStaffOrgRelatId(@PathVariable("staff_org_relat_id") Integer staffOrgRelatId);

//    /**
//     * 新增员工角色权限
//     *
//     * @param staffRoleAuthorDTO
//     * @return
//     */
//    @RequestMapping(value = "/staff_role_author", method = RequestMethod.POST)
//    Map saveStaffRoleAuthor(@RequestBody SysStaffRoleAuthorDTO staffRoleAuthorDTO);
//
//    /**
//     * 修改/删除员工角色信息
//     *
//     * @param roleAuthorId
//     * @param staffRoleAuthorDTO
//     * @return
//     */
//    @RequestMapping(value = "/staff_role_author/{role_author_id}", method = RequestMethod.PUT)
//    Map updateStaffRoleAuthor(@PathVariable("role_author_id") Integer roleAuthorId,
//                              @RequestBody SysStaffRoleAuthorDTO staffRoleAuthorDTO);
//
//    /**
//     * 根据ID查询员工角色信息
//     *
//     * @param roleAuthorId
//     * @return
//     */
//    @RequestMapping(value = "/staff_role_author/{role_author_id}", method = RequestMethod.GET)
//    SysStaffRoleAuthorDTO selectByStaffRoleAuthorId(@PathVariable("role_author_id") Integer roleAuthorId);

//    /**
//     * 新增岗位信息
//     *
//     * @param stationDTO
//     * @return
//     */
//    @RequestMapping(value = "/station", method = RequestMethod.POST)
//    Map saveStation(@RequestBody SysStationDTO stationDTO);
//
//    /**
//     * 修改/删除岗位信息
//     *
//     * @param stationId
//     * @param stationDTO
//     * @return
//     */
//    @RequestMapping(value = "/station/{station_id}", method = RequestMethod.PUT)
//    Map updateStation(@PathVariable("station_id") Integer stationId,
//                      @RequestBody SysStationDTO stationDTO);
//
//    /**
//     * 根据id查询岗位信息
//     *
//     * @param stationId
//     * @return
//     */
//    @RequestMapping(value = "/station/{station_id}", method = RequestMethod.GET)
//    SysStationDTO selectByStationId(@PathVariable("station_id") Integer stationId);
//
//    /**
//     * 查询所有的岗位信息
//     *
//     * @param name
//     * @param code
//     * @param pageNo
//     * @param pageSize
//     * @return
//     */
//
//    @RequestMapping(value = "/station/all", method = RequestMethod.GET)
//    Page<SysStationDTO> selectAllStation(@RequestParam(value = "name", required = false) String name,
//                                         @RequestParam(value = "code", required = false) String code,
//                                         @RequestParam(value = "page_no") Integer pageNo,
//                                         @RequestParam(value = "page_size") Integer pageSize);

//    /**
//     * 新增岗位菜单权限信息
//     *
//     * @param stationFuncDTO
//     * @return
//     */
//    @RequestMapping(value = "/station_function", method = RequestMethod.POST)
//    Map saveStationFunc(@RequestBody SysStationFuncDTO stationFuncDTO);
//
//    /**
//     * 修改/删除岗位菜单权限
//     *
//     * @param stationFuncRelatId
//     * @param stationFuncDTO
//     * @return
//     */
//    @RequestMapping(value = "/station_function/{station_func_relat_id }", method = RequestMethod.PUT)
//    Map updateStationFunc(@PathVariable("station_func_relat_id ") Integer stationFuncRelatId,
//                          @RequestBody SysStationFuncDTO stationFuncDTO);
//
//    /**
//     * 根据id查询岗位菜单权限
//     *
//     * @param stationFuncRelatId
//     * @return
//     */
//    @RequestMapping(value = "/station_function/{station_func_relat_id}", method = RequestMethod.GET)
//    SysStationFuncDTO selectByStationFuncRelatId(@PathVariable("station_func_relat_id") Integer stationFuncRelatId);
//
//    /**
//     * 根据staffId查询岗位菜单权限
//     *
//     * @param staffId
//     * @return
//     */
//    @RequestMapping(value = "/station_function/staff/{staff_id}", method = RequestMethod.GET)
//    SysStationFuncDTO selectStationFuncByStaffId(@PathVariable("staff_id") Integer staffId);


//    /**
//     * 新增操作类型
//     *
//     * @param sysOpTypeDefDTO
//     * @return
//     */
//    @RequestMapping(value = "/op_type_def", method = RequestMethod.POST)
//    Map saveOpTypeDef(@RequestBody SysOpTypeDefDTO sysOpTypeDefDTO);
//
//    /**
//     * 修改/删除操作类型
//     *
//     * @param opTypeId
//     * @param sysOpTypeDefDTO
//     * @return
//     */
//    @RequestMapping(value = "op_type_def/{op_type_id}", method = RequestMethod.PUT)
//    Map updateOpTypeDef(@PathVariable("op_type_id") Integer opTypeId,
//                        @RequestBody SysOpTypeDefDTO sysOpTypeDefDTO);
//
//    /**
//     * 带分页查询所有操作类型
//     *
//     * @return
//     */
//    @RequestMapping(value = "op_type_def/all", method = RequestMethod.GET)
//    Page<SysOpTypeDefDTO> selectAllOpType(@RequestParam(value = "code", required = false) String code,
//                                          @RequestParam(value = "op_type_name", required = false) String opTypeName,
//                                          @RequestParam(value = "page_no") Integer pageNo,
//                                          @RequestParam(value = "page_size") Integer pageSize);

//    /**
//     * 保存操作日志
//     * @param opLogDTO
//     * @return
//     */
//    Map saveOpLog(@RequestBody SysOpLogDTO opLogDTO);

//    Page<SysOpLogDTO> selectAllOpLog();


//    /**
//     * 新增数据权限表
//     * @param sysDataRoleDTO
//     * @return
//     */
//    @RequestMapping(value="/data_role",method = RequestMethod.POST)
//    Map saveDataRole(@RequestBody SysDataRoleDTO sysDataRoleDTO);
//
//    /**
//     * 修改/删除 数据权限
//     * @param dataRoleId
//     * @param sysDataRoleDTO
//     * @return
//     */
//    @RequestMapping(value="/data_role/{data_role_id}",method = RequestMethod.PUT)
//    Map updateDataRole(@PathVariable("data_role_id")Integer dataRoleId,@RequestBody SysDataRoleDTO sysDataRoleDTO);


}
