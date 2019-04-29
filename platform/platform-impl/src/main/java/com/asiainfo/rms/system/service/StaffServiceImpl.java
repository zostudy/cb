package com.asiainfo.rms.system.service;

import com.asiainfo.rms.core.exception.BusinessException;
import com.asiainfo.rms.system.convert.SysStaffAddOrgConvert;
import com.asiainfo.rms.system.convert.SysStaffConvert;
import com.asiainfo.rms.system.convert.SysStaffOrgConvert;
import com.asiainfo.rms.system.dao.SysStaffDao;
import com.asiainfo.rms.system.dao.SysStaffOrgRelatDao;
import com.asiainfo.rms.system.domain.SysStaffAddOrgRepository;
import com.asiainfo.rms.system.domain.SysStaffOrgRelatRepository;
import com.asiainfo.rms.system.domain.SysStaffOrgRepository;
import com.asiainfo.rms.system.domain.SysStaffRepository;
import com.asiainfo.rms.system.dto.StaffPassWordDTO;
import com.asiainfo.rms.system.dto.SysStaffAddOrgDTO;
import com.asiainfo.rms.system.dto.SysStaffDTO;
import com.asiainfo.rms.system.dto.SysStaffOrgDTO;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//import static com.asiainfo.rms.core.api.MD5Util.string2MD5;

@Component
@Transactional
public class StaffServiceImpl implements StaffService {
    private final SysStaffDao sysStaffDao;
    private final SysStaffOrgRelatDao staffOrgRelatDao;

    public StaffServiceImpl(SysStaffDao sysStaffDao, SysStaffOrgRelatDao staffOrgRelatDao) {
        this.sysStaffDao = sysStaffDao;
        this.staffOrgRelatDao = staffOrgRelatDao;
    }
//    @Autowired
//    SysStaffDao sysStaffDao;
//    @Autowired
//    SysStaffOrgRelatDao staffOrgRelatDao;


    @Override
    public String saveStaff(SysStaffDTO staffDTO) {
        JSONObject json = new JSONObject();
        //新增
        String pswStr = staffDTO.getPassword();
        String code = staffDTO.getCode();
        String phone = staffDTO.getBillId();
        String name = staffDTO.getEmployeeName();

        if (phone == null || "".equals(phone)) {
            throw new BusinessException("手机号码不能为空!");
        } else if (name == null || "".equals(name)) {
            throw new BusinessException("姓名不能为空!");
        } else if (pswStr == null || "".equals(pswStr)) {
            throw new BusinessException("密码不能为空!");
        } else if (code == null || "".equals(code)) {
            throw new BusinessException("工号不能为空!");
        } else {
            //判断code是否存在
            SysStaffRepository staffInfo;
            staffInfo = sysStaffDao.selectByCode(code.toUpperCase());
            try {
                if (staffInfo == null) {
                    staffDTO.setCode(code.toUpperCase());
                    staffDTO.setPassword(pswStr);
                    staffDTO.setLockFlag(0);
                    staffDTO.setState(1);
                    SysStaffRepository staffRepository;
                    staffRepository = SysStaffConvert.INSTANCE.toSYS(staffDTO);
                    if(sysStaffDao.saveStaff(staffRepository)>0){
                        Integer staffId = staffRepository.getStaffId();
                        //查询该用户是否有组织关联关系
                        if((staffOrgRelatDao.selectCountByStaffId(staffId))>0){
                            staffOrgRelatDao.deleteStaffByStaffId(staffId);
                        }

                        SysStaffOrgRelatRepository staffOrgRelatRepository = new SysStaffOrgRelatRepository() ;
                        staffOrgRelatRepository.setOrganizeId(staffRepository.getOrganizeId());
                        staffOrgRelatRepository.setStaffId(staffId);
                        staffOrgRelatRepository.setCreateTime(new java.sql.Date(new java.util.Date().getTime()));
                        staffOrgRelatRepository.setState(1);
                        if (staffOrgRelatDao.saveStaffOrgRelat(staffOrgRelatRepository) > 0){

                            Integer staffOrgRelatId = staffOrgRelatRepository.getStaffOrgRelatId();
                            json.put("code", 1);
                            json.put("msg", "success");
                            json.put("staff_id", staffId);
                            json.put("staff_org_relat_id",staffOrgRelatId);
                        }
                    }

                } else {
                    json.put("code", 0);
                    json.put("msg", "该工号已经存在，请修改后重新提交！");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

    @Override
    public String updateStaff(SysStaffDTO staffDTO) {
        JSONObject json = new JSONObject();
        SysStaffRepository staffRepository = SysStaffConvert.INSTANCE.toSYS(staffDTO);
        String pswinfo = staffRepository.getPassword();
        if(StringUtils.isNotBlank(pswinfo)){
            //做密码修改操作
            String staffCode = staffRepository.getCode();
            SysStaffRepository staffInfo = sysStaffDao.selectByCode(staffCode);
            if(null == staffInfo){
                //做密码校验
                throw new BusinessException("员工code无效");
            }else{
                //原始密码
                String passWord = staffInfo.getPassword();
                if(passWord.equals(pswinfo)){
                    throw new BusinessException("修改密码与原密码相同，请重新输入!");
                }else{
                    staffRepository.setRecentPassword(passWord);
                    //给新密码加密
                    staffRepository.setPassword(pswinfo);
                    staffRepository.setRecentTime(new java.sql.Date(new java.util.Date().getTime()));
                }

            }

        }
        if(sysStaffDao.updateStaff(staffRepository)>0) {
            SysStaffOrgRelatRepository staffOrgRelatRepository = new SysStaffOrgRelatRepository() ;
            staffOrgRelatRepository.setStaffId(staffRepository.getStaffId());
            staffOrgRelatRepository.setOrganizeId(staffRepository.getOrganizeId());
            if(staffOrgRelatDao.updateStaffOrgRelat(staffOrgRelatRepository)>0){
                try {
                    json.put("code", 1);
                    json.put("msg", "success");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return json.toString();
    }

    @Override
    public String deleteStaffById(Integer staffId) {
        JSONObject json = new JSONObject();
        Integer count = sysStaffDao.deleteStaffById(staffId);
        if(count >0) {
            try {
                json.put("code", 1);
                json.put("msg", "success");
                json.put("row_count", count);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

    @Override
    public String updateStaffPassWord(StaffPassWordDTO staffPassWordDTO) {
        JSONObject json = new JSONObject();
        SysStaffRepository staffInfo;
        String staffCode = staffPassWordDTO.getCode();
        //根据Code查询员工信息
        staffInfo = sysStaffDao.selectByCode(staffCode);

        if (staffInfo == null) {
            throw new BusinessException("用户名或密码错误，请重新输入!！");
        } else {
            try {
                //输入的密码
                String pswinfo = staffInfo.getPassword();
                //原始密码
                String centPswInfo = staffPassWordDTO.getPassWord();
                //修改密码
                String revisePassWordInof = staffPassWordDTO.getRevisePassWord();
                //确认密码
//            String confirmPswInfo = string2MD5(staffPassWordDTO.getConfirmPassWord());
                if (pswinfo.equals(centPswInfo)) {
                    if (pswinfo.equals(revisePassWordInof)) {
                        throw new BusinessException("修改密码与原密码相同，请重新输入!");
                    } else {
                        SysStaffRepository staffRepository = new SysStaffRepository();
                        staffRepository.setStaffId(staffInfo.getStaffId());
                        staffRepository.setPassword(staffPassWordDTO.getRevisePassWord());
                        staffRepository.setRecentPassword(staffPassWordDTO.getPassWord());
                        staffRepository.setRecentTime(new java.sql.Date(new java.util.Date().getTime()));
                        if(sysStaffDao.updateStaffPassWord(staffRepository)>0) {

                            json.put("code", 1);
                            json.put("msg", "修改密码成功！");
                        }
                    }
                } else {
                    json.put("code", 0);
                    json.put("msg", "用户名或密码错误，请重新输入!！");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return json.toString();
    }

    @Override
    public SysStaffDTO selectByStaffId(Integer staffId) {
        return SysStaffConvert.INSTANCE.toDTO(sysStaffDao.selectByStaffId(staffId));
    }

    @Override
    public List<SysStaffDTO> selectAllStaffs(Integer organizeId, String keyword,String email, String billId, Integer pageNo, Integer pageSize) {
        Integer offset = null;
        if ((pageNo != null) && (pageSize != null)) {
            offset = pageNo;

        }
        List<SysStaffRepository> staffList = sysStaffDao.selectAllStaffs(organizeId, keyword,email, billId, offset, pageSize);
        if (staffList.size() > 0) {
            return SysStaffConvert.INSTANCE.toDTOs(staffList);
        } else {
            return null;
        }
    }

    @Override
    public int getStaffCount(Integer organizeId,String keyword,String email, String billId) {
        return sysStaffDao.getStaffCount(organizeId,keyword,email, billId);
    }
    
    @Override
    public List<SysStaffAddOrgDTO> selectStaffsForWF(Integer organizeId, String staffCode, String roleCode, String wgCode, String employeeName){
        List<SysStaffAddOrgRepository> staffList = sysStaffDao.selectStaffsForWF(organizeId, staffCode, roleCode, wgCode, employeeName);
        if (staffList.size() > 0) {
            return SysStaffAddOrgConvert.INSTANCE.toDTOs(staffList);
        } else {
            return null;
        }
    }

    @Override
    public List<SysStaffOrgDTO> selectStaffTotal(Integer parentOrganizeId, String roleCode) {
        List<SysStaffOrgRepository> staffList = sysStaffDao.selectStaffTotal(parentOrganizeId,roleCode);
        if (staffList.size() > 0) {
            return SysStaffOrgConvert.INSTANCE.toDTOs(staffList);
        } else {
            return null;
        }
    }

    @Override
    public List<SysStaffAddOrgDTO> selectStaffsForOrgWF(Integer organizeId, String roleCode) {
        List<SysStaffAddOrgRepository> staffList = sysStaffDao.selectStaffsForOrgWF(organizeId, roleCode);
        if (staffList.size() > 0) {
            return SysStaffAddOrgConvert.INSTANCE.toDTOs(staffList);
        } else {
            return null;
        }
    }

    @Override
    public List<SysStaffAddOrgDTO> selectStaffsForOrgWFByName(Integer organizeId, String roleCode, String keyword) {
        List<SysStaffAddOrgRepository> staffList = sysStaffDao.selectStaffsForOrgWFByName(organizeId,  roleCode,keyword);
        if (staffList.size() > 0) {
            return SysStaffAddOrgConvert.INSTANCE.toDTOs(staffList);
        } else {
            return null;
        }
    }


}
