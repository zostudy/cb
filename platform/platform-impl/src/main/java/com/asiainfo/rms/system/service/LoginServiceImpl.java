package com.asiainfo.rms.system.service;

//import com.asiainfo.rms.core.api.MD5Util;
import com.asiainfo.rms.system.convert.SysFunction;
import com.asiainfo.rms.system.convert.SysLoginUserInfoConvert;
import com.asiainfo.rms.system.dao.SysFunctionDao;
import com.asiainfo.rms.system.dao.SysLoginLogDao;
import com.asiainfo.rms.system.dao.SysOrganizeDao;
import com.asiainfo.rms.system.dao.SysStaffDao;
import com.asiainfo.rms.system.domain.*;
import com.asiainfo.rms.system.dto.SysFunctionDTO;
import com.asiainfo.rms.system.dto.SysLoginInfoDTO;
import com.asiainfo.rms.system.dto.SysLoginUserInfoDTO;
import com.asiainfo.rms.system.util.RedisDao;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
@Transactional
public class LoginServiceImpl implements LoginService {


    @Autowired
    private SysLoginLogDao loginLogDao;
    @Autowired
    private SysStaffDao staffDao;
    @Autowired
    private SysFunctionDao functionDao;
    @Autowired
    private SysOrganizeDao organizeDao;

    private Integer count = 0;

    @Autowired
    RedisDao redisDao;

    private static Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Override
    public Map<Object, Object> oaLogin(SysLoginInfoDTO loginInfoDTO) {
        Map<Object, Object> reqMap = new HashMap<>();

        String validcode = redisDao.getValue(loginInfoDTO.getValidKey());
        if (StringUtils.isBlank(validcode)) {
            reqMap.put("code", "0");
            reqMap.put("msg", "请刷新验证码后重新输入！");
            return reqMap;
        }

        if(logger.isDebugEnabled()) {
            logger.debug("获取的验证码是：" + validcode.toLowerCase());
        }

        String verCode = loginInfoDTO.getVerificationCode().toLowerCase();
        if(logger.isDebugEnabled()) {
            logger.debug("前台输入的验证码是：" + verCode);
        }

        //判空
        if (StringUtils.isBlank(loginInfoDTO.getCode()) || StringUtils.isBlank(loginInfoDTO.getPassWord())) {
            reqMap.put("code", "0");
            reqMap.put("msg", "用户名和密码不能为空!");
            return reqMap;
        }

        if (!validcode.toLowerCase().equals(verCode)) {
            reqMap.put("code", "0");
            reqMap.put("msg", "验证码输入有误，请重新输入!");
            return reqMap;
        }

        //根据code查询对应的密码
        SysStaffRepository staffInfo = staffDao.selectByCode((loginInfoDTO.getCode()).toUpperCase());
        if (staffInfo == null) {
            reqMap.put("code", "0");
            reqMap.put("msg", "用户名或密码不正确，请重新输入!");
            return reqMap;
        }

        if (staffInfo.getLockFlag().equals(1)) {
            reqMap.put("code", "0");
            reqMap.put("msg", "该用户已经被锁定，请联系管理员!");
            return reqMap;
        }

        String pswinfo = staffInfo.getPassword();
        if(!pswinfo.equals(loginInfoDTO.getPassWord())) {
            reqMap.put("code", "0");
            reqMap.put("msg", "用户名或密码不正确，请重新输入!");
            return reqMap;
        }

        //记录日志
        SysLoginLogRepository loginLogRepository = new SysLoginLogRepository();
        loginLogRepository.setIp(loginInfoDTO.getIp());
        loginLogRepository.setMac(loginInfoDTO.getMac());
        loginLogRepository.setStaffCode(loginInfoDTO.getCode().toUpperCase());
        loginLogRepository.setSessionId(loginInfoDTO.getSessionId());
        loginLogRepository.setState("1");//登陆
        loginLogRepository.setLoginDate(new java.sql.Date(System.currentTimeMillis()));

        loginLogDao.saveLoginLog(loginLogRepository);

        reqMap.put("code", "1");
        reqMap.put("msg", "success");
        reqMap.put("login_log_id", loginLogRepository.getLogId());
        reqMap.put("staff_id", staffInfo.getStaffId());

        return reqMap;
    }

    @Override
    public Map<Object, Object> ssoLogin(SysLoginInfoDTO sysLoginInfoDTO) {
        Map<Object, Object> reqMap = new HashMap<>();

        SysStaffRepository staffInfo = staffDao.selectByCode(sysLoginInfoDTO.getCode().toUpperCase());
        if(staffInfo == null) {
            reqMap.put("code", "0");
            reqMap.put("msg", "用户名或密码不正确，请重新输入!");
            return reqMap;
        }

        if (staffInfo.getLockFlag().equals(1)) {
            reqMap.put("code", "0");
            reqMap.put("msg", "该用户已经被锁定，请联系管理员!");
            return reqMap;
        }

        //记录日志
        SysLoginLogRepository loginLogRepository = new SysLoginLogRepository();
        loginLogRepository.setIp(sysLoginInfoDTO.getIp());
        loginLogRepository.setMac(sysLoginInfoDTO.getMac());
        loginLogRepository.setStaffCode(sysLoginInfoDTO.getCode().toUpperCase());
        loginLogRepository.setSessionId(sysLoginInfoDTO.getSessionId());
        loginLogRepository.setState("1");//登陆
        loginLogRepository.setLoginDate(new java.sql.Date(System.currentTimeMillis()));

        loginLogDao.saveLoginLog(loginLogRepository);

        reqMap.put("code", "1");
        reqMap.put("msg", "success");
        reqMap.put("login_log_id", loginLogRepository.getLogId());
        reqMap.put("staff_id", staffInfo.getStaffId());

        return reqMap;
    }

    @Override
    public void loginOut(Integer logId) {
        //记录日志
        SysLoginLogRepository loginLogRepository = new SysLoginLogRepository();
        loginLogRepository.setLogId(logId);
        loginLogRepository.setState("0");//登出
        loginLogRepository.setLogoutDate(new java.sql.Date(new java.util.Date().getTime()));

        loginLogDao.updateLoginLog(loginLogRepository);
    }

    @Override
    public SysLoginUserInfoDTO selectLoginUserInfo(Integer staffId) {
        SysLoginUserInfoRepository loginUserInfoRepository = staffDao.selectLoginUserInfo(staffId);

        //判断该用户是否属于分公司
//        SysOrganizeRepository organizeRepository = organizeDao.selectStaffYesOrNo(loginUserInfoRepository.getOrganizeId());
//
//        if (organizeRepository != null) {
//            loginUserInfoRepository.setFlag("1");
//        } else {
//            loginUserInfoRepository.setFlag("0");
//        }
//        if (loginUserInfoRepository != null) {
//            SysLoginLogRepository loginLogRepository;
//            loginLogRepository = loginLogDao.selectLogIdByUser(loginUserInfoRepository.getCode().toUpperCase());
//            if (loginLogRepository != null) {
//                loginUserInfoRepository.setLogId(loginLogRepository.getLogId());
//            }
//        }

        List<SysFunctionDTO> functionDTOS;
        functionDTOS = SysFunction.INSTANCE.toDTOs(functionDao.selectFunctionByStaffId(staffId));

        if (functionDTOS != null) {
            if (loginUserInfoRepository != null) {
                loginUserInfoRepository.setFunctionDTO(functionDTOS);
            }
        }

        return SysLoginUserInfoConvert.INSTANCE.toDTO(loginUserInfoRepository);
    }

    @Override
    public Map<Object, Object> getOrganizeInfo(Integer staffId) {
        Map<Object, Object> reqMap = new HashMap<>();
       // logger.info("-----staffId : "+staffId);

        SysLoginUserInfoRepository loginUserInfoRepository = staffDao.selectLoginUserInfo(staffId);
        //logger.info("-----loginUserInfoRepository : "+loginUserInfoRepository);
        Integer organizeId = loginUserInfoRepository.getOrganizeId();

        List<SysStaffOrgRepository> organizeList = staffDao.getOrganizeInfo(organizeId);

       // logger.info("****organizeList : "+organizeList);
        String organizeName = "";

        for(int i=organizeList.size()-1;i>=0;i--){
            organizeName = organizeName+organizeList.get(i).getOrganizeName()+"-";
        }

        reqMap.put("organizeName",StringUtils.substringBeforeLast(organizeName,"-"));

        reqMap.put("organizeId", organizeId);
        
        

        return reqMap;
    }
}
