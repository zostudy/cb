package com.asiainfo.rms.system.service;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public interface SystemService {
//    Map saveStaff(SysStaffDTO staffDTO);
//
//    Map updateStaff(SysStaffDTO staffDTO);
//
//    Map updateStaffId(Integer staffId);
//
//    Map updateStaffPassWord(StaffPassWordDTO staffPassWordDTO);
//
//    SysStaffDTO selectByStaffId(Integer staffId);
//
//    List<SysStaffDTO> selectAllStaffs(String employeeName,String billId,Integer pageNo, Integer pageSize);
//
//    int getStaffCount(String employeeName,String billId);

    Map getImageCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

//    Map login(HttpSession session,SysLoginInfoDTO loginInfoDTO);
//
//    void loginOut(Integer logId);
//    Map saveFunction(SysFunctionDTO functionDTO);
//
//    Map updateFunction(SysFunctionDTO functionDTO);
//
//    Map updateFunctionById(Integer funcId);
//
//    SysFunctionDTO selectByFuncId(Integer funcId);
//
//    List<SysFunctionDTO> selectAllFunction(Integer state);


//    Map saveRole(SysRoleDTO sysRoleDTO);
//
//    Map updateRole(SysRoleDTO sysRoleDTO);
//
//    SysRoleDTO selectByRoleId(Integer roleId);
//
//    SysRoleDTO selectRoleInfoByStaffId(Integer staffId);

//    Map saveOrganize(SysOrganizeDTO organizeDTO);
//
//    Map updateOrganize(SysOrganizeDTO organizeDTO);
//
//    Map updateByOrganizeId(Integer organizeId);
//
//    SysOrganizeDTO selectByOrganizeId(Integer organizeId);
//
//    SysOrganizeDTO selectOrganizeByStaffId(Integer staffId);

//    Map saveOrganizeType(SysOrganizeTypeDTO organizeTypeDTO);
//
//    Map updateOrganizeType(SysOrganizeTypeDTO organizeTypeDTO);
//
//    Map updateOrganizeTypeById(Integer organizeTypeId );

//    Map saveAuthor(SysAuthorDTO authorDTO);
//
//    Map updateAuthor(SysAuthorDTO authorDTO);
//
//    SysAuthorDTO selectByAuthorId(Integer authorId);

//    Map saveStaffOrgRelat(SysStaffOrgRelatDTO staffOrgRelatDTO);
//
//    Map updateStaffOrgRelat(SysStaffOrgRelatDTO staffOrgRelatDTO);
//
//    SysStaffOrgRelatDTO selectByStaffOrgRelatId(Integer staffOrgRelatId);

//    Map saveStaffRoleAuthor(SysStaffRoleAuthorDTO staffRoleAuthorDTO);
//
//    Map updateStaffRoleAuthor(SysStaffRoleAuthorDTO staffRoleAuthorDTO);
//
//    SysStaffRoleAuthorDTO selectByStaffRoleAuthorId(Integer staffRoleAuthorId);

//    Map saveStation( SysStationDTO stationDTO);
//
//    Map updateStation(SysStationDTO stationDTO);
//
//    SysStationDTO selectByStationId(Integer stationId);
//
//    List<SysStationDTO> selectAllStation(String name,String code,Integer pageNo, Integer pageSize);
//
//    int getStationCount(String name,String code);

//    Map saveStationFunc( SysStationFuncDTO stationFuncDTO);
//
//    Map updateStationFunc(SysStationFuncDTO stationFuncDTO);
//
//    SysStationFuncDTO selectByStationFuncRelatId(Integer stationFuncRelatId);
//
//    SysStationFuncDTO selectStationFuncByStaffId(Integer staffId);

//    //操作类型
//    Map saveOpTypeDef(SysOpTypeDefDTO sysOpTypeDefDTO);
//
//    Map updateOpTypeDef(SysOpTypeDefDTO sysOpTypeDefDTO);
//
//    List<SysOpTypeDefDTO> selectAllOpType(String code,String opTypeName,Integer pageNo, Integer pageSize);
//
//    int getOpTypeCount(String code,String opTypeName);


}
