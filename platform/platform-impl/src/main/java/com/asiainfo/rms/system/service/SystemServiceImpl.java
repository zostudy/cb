package com.asiainfo.rms.system.service;

import com.asiainfo.rms.core.api.VerifyCode;
import com.asiainfo.rms.system.util.RedisDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;
import java.util.Map;


@Component
@Transactional
public class SystemServiceImpl implements SystemService {
    @Autowired
    RedisDao redisDao;

    private static Logger logger = LoggerFactory.getLogger(SystemServiceImpl.class);

    @Override
    public Map getImageCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VerifyCode vc = new VerifyCode();//创建VerifyCode类的对象
        BufferedImage bi = vc.getImage();//调用getImge()方法获得一个BufferedImage对象
//        VerifyCode.output(bi, new FileOutputStream("WebRoot/img/yzm.jpg"));//调用静态方法output()方法将图片保存在文件输出流中
        logger.debug("生成的验证码为：" + vc.getText());

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //将验证码存入session
        HttpSession session = request.getSession(true);
        session.setAttribute("randCheckCode", vc.getText());

        InputStream inputStream;
        byte[] data = null;

        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageOutputStream imageOutput = ImageIO.createImageOutputStream(byteArrayOutputStream);
            ImageIO.write(bi, "png", imageOutput);
            inputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            long length = imageOutput.length();

//            inputStream = new FileInputStream("WebRoot/img/yzm.jpg");
            data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 加密
        BASE64Encoder encoder = new BASE64Encoder();
//        System.out.println(encoder.encode(data));
        Map<String, Serializable> imgMap = new HashMap<>();
        if (data == null) throw new AssertionError();


        String value="";
        String model = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        char[] m = model.toCharArray();
        for(int i=0;i<6;i++){
            char c = m[(int)(Math.random()*52)];
            value = value + c;
        }

        redisDao.setKey(value, vc.getText());

        imgMap.put("code", 1);
        imgMap.put("checkCode",vc.getText());
        imgMap.put("img", encoder.encode(data));
        imgMap.put("key",value);

        return imgMap;
    }

//    /**
//     * 用户登陆
//     */
//    @Override
//    public Map login(HttpSession session, SysLoginInfoDTO loginInfoDTO) {
//        //????当用户密码错误五次之后，此用户上锁。
//        Integer loginLogId;
//        String sessionCode = null;
//        Map<Object, Object> reqMap = new HashMap<>();
//        if (!(session.getAttribute("randCheckCode") == null)) {
//            sessionCode = session.getAttribute("randCheckCode").toString().toLowerCase();
//        } else {
//            reqMap.put("code", "0");
//            reqMap.put("msg", "请刷新验证码后重新输入！");
//        }
//
//        String verCode = loginInfoDTO.getVerificationCode().toLowerCase();
//        //判空
//        if (StringUtils.isEmpty(loginInfoDTO.getCode()) || StringUtils.isEmpty(loginInfoDTO.getPassWord())) {
//            reqMap.put("code", 0);
//            reqMap.put("msg", "用户名或密码不能为空!");
//        } else if (!(verCode.equals(sessionCode))) {
//            reqMap.put("code", "0");
//            reqMap.put("msg", "验证码输入有误，请重新输入!");
//        } else {
//            //根据code查询对应的密码
//            SysStaffRepository staffInfo = sysStaffDao.selectByCode((loginInfoDTO.getCode()).toUpperCase());
//            if (staffInfo == null) {
//                reqMap.put("code", 0);
//                reqMap.put("msg", "用户名或密码不正确，请重新输入!");
//            } else {
//                String pswinfo = staffInfo.getPassword();
//                if (pswinfo.equals(string2MD5(loginInfoDTO.getPassWord()))) {
//                    //记录日志
//                    SysLoginLogRepository loginLogRepository = new SysLoginLogRepository();
//                    loginLogRepository.setIp(loginInfoDTO.getIp());
//                    loginLogRepository.setMac(loginInfoDTO.getMac());
//                    loginLogRepository.setStaffCode(loginInfoDTO.getCode());
//                    loginLogRepository.setSessionId(loginInfoDTO.getSessionId());
//                    loginLogRepository.setState("1");//登陆
//                    loginLogRepository.setLoginDate(new java.sql.Date(new java.util.Date().getTime()));
//
//                    loginLogDao.saveLoginLog(loginLogRepository);
//                    //获取主键
//                    loginLogId = loginLogRepository.getLogId();
//                    reqMap.put("code", 1);
//                    reqMap.put("msg", "登陆成功！");
//                    reqMap.put("logId", loginLogId.toString());
//                } else {
//                    reqMap.put("code", 0);
//                    reqMap.put("msg", "用户名或密码不正确，请重新输入!");
//                }
//            }
//        }
//        return reqMap;
//    }
//
//    @Override
//    public void loginOut(Integer logId) {
//        //记录日志
//        SysLoginLogRepository loginLogRepository = new SysLoginLogRepository();
//        loginLogRepository.setLogId(logId);
//        loginLogRepository.setState("0");//登出
//        loginLogRepository.setLogoutDate(new java.sql.Date(new java.util.Date().getTime()));
//
//        loginLogDao.updateLoginLog(loginLogRepository);
//    }

//    @Override
//    public Map saveStaff(SysStaffDTO staffDTO) {
//        Map<Object, Object> reqMap = new HashMap<>();
//        //新增
//        if (staffDTO.getOperateType().equals("C")) {
//            String pswStr = staffDTO.getPassword();
//            String code = staffDTO.getCode();
//            String phone = staffDTO.getBillId();
//            String name = staffDTO.getEmployeeName();
//
//            if(phone == null || "".equals(phone)){
//                reqMap.put("code", 0);
//                reqMap.put("msg", "电话不能为空!");
//            }else if(name == null || "".equals(name)){
//                reqMap.put("code", 0);
//                reqMap.put("msg", "姓名不能为空!");
//            }else if(pswStr == null || "".equals(pswStr)){
//                reqMap.put("code", 0);
//                reqMap.put("msg", "密码不能为空!");
//            }else if(code == null || "".equals(code)){
//                reqMap.put("code", 0);
//                reqMap.put("msg", "工号不能为空!");
//            } else {
//                //判断code是否存在
//                SysStaffRepository staffInfo;
//                staffInfo = sysStaffDao.selectByCode(code.toUpperCase());
//                if (staffInfo == null) {
//                    staffDTO.setCode(code.toUpperCase());
//                    staffDTO.setPassword(string2MD5(pswStr));
//                    staffDTO.setLockFlag(0);
//                    staffDTO.setState(1);
//                    sysStaffDao.saveStaff(SysStaffConvert.INSTANCE.toSYS(staffDTO));
//
//                    reqMap.put("code", 1);
//                    reqMap.put("msg", "用户新增成功！");
//                    //修改
//                } else {
//                    reqMap.put("code", 0);
//                    reqMap.put("msg", "该工号已经存在，请修改后重新提交！");
//                }
//            }
//            }else {
//            reqMap.put("code", 0);
//            reqMap.put("msg", "所传标识有误！");
//        }
//        return reqMap;
//    }
//
//    @Override
//    public Map updateStaff(SysStaffDTO staffDTO) {
//        Map<Object, Object> reqMap = new HashMap<>();
//        String flag = staffDTO.getOperateType();
//        if (flag.equals("U")) {
//            staffDTO.setLockFlag(0);
//            staffDTO.setState(1);
//            sysStaffDao.updateStaff(SysStaffConvert.INSTANCE.toSYS(staffDTO));
//            reqMap.put("code", 1);
//            reqMap.put("msg", "用户修改成功！");
//        } else {
//            reqMap.put("code", 0);
//            reqMap.put("msg", "所传标识有误！");
//        }
//        return reqMap;
//    }
//
//    @Override
//    public Map updateStaffId(Integer staffId) {
//        Integer count = sysStaffDao.updateStaffById(staffId);
//        return verdictCount(count);
//    }
//
//    //修改密码
//    @Override
//    public Map updateStaffPassWord(StaffPassWordDTO staffPassWordDTO) {
//        Map<Object, Object> reqMap = new HashMap<>();
//        SysStaffRepository staffInfo;
//        String staffCode = staffPassWordDTO.getCode();
//        //根据Code查询员工信息
//        staffInfo = sysStaffDao.selectByCode(staffCode);
//
//        if (staffInfo == null) {
//            reqMap.put("code", 0);
//            reqMap.put("msg", "用户名或密码错误，请重新输入!！");
//        } else {
//            //输入的密码
//            String pswinfo = staffInfo.getPassword();
//            //原始密码
//            String centPswInfo = string2MD5(staffPassWordDTO.getPassWord());
//            //修改密码
//            String revisePassWordInof = string2MD5(staffPassWordDTO.getRevisePassWord());
//            //确认密码
////            String confirmPswInfo = string2MD5(staffPassWordDTO.getConfirmPassWord());
//            if (pswinfo.equals(centPswInfo)) {
//                if (pswinfo.equals(revisePassWordInof)) {
//                    reqMap.put("code", 0);
//                    reqMap.put("msg", "修改密码与原密码相同，请重新输入!");
//                } else {
//                    SysStaffRepository staffRepository = new SysStaffRepository();
//                    staffRepository.setStaffId(staffInfo.getStaffId());
//                    staffRepository.setPassword(string2MD5(staffPassWordDTO.getRevisePassWord()));
//                    staffRepository.setRecentPassword(string2MD5(staffPassWordDTO.getPassWord()));
//                    staffRepository.setRecentTime(new java.sql.Date(new java.util.Date().getTime()));
//                    sysStaffDao.updateStaffPassWord(staffRepository);
//
//                    reqMap.put("code", 1);
//                    reqMap.put("msg", "修改密码成功！");
//                }
//            } else {
//                reqMap.put("code", 0);
//                reqMap.put("msg", "用户名或密码错误，请重新输入!！");
//            }
//        }
//
//        return reqMap;
//    }
//
//    @Override
//    public SysStaffDTO selectByStaffId(Integer staffId) {
//        return SysStaffConvert.INSTANCE.toDTO(sysStaffDao.selectByStaffId(staffId));
//    }
//
//    @Override
//    public List<SysStaffDTO> selectAllStaffs(String employeeName,String billId, Integer pageNo, Integer pageSize) {
//        Integer offset = null;
//        if ((pageNo != null) && (pageSize != null)) {
//            offset = pageNo;
////            if (pageNo > 1) {
////                offset = (pageNo - 1) * pageSize+1;
////            }
//        }
//        List<SysStaffRepository>  staffList = sysStaffDao.selectAllStaffs(employeeName,billId, offset, pageSize);
//        if(staffList.size()>0){
//            return SysStaffConvert.INSTANCE.toDTOs(staffList);
//        }else{
//            return  null;
//        }
//    }
//
//    @Override
//    public int getStaffCount(String employeeName,String billId) {
//        return sysStaffDao.getStaffCount(employeeName,billId);
//    }


//    @Override
//    public Map saveFunction(SysFunctionDTO functionDTO) {
//        Map<String, Serializable> reqMap = new HashMap<>();
//        String flag = functionDTO.getOperateType();
//        if (flag.equals("C")) {
//            functionDTO.setState(1);
//            functionDao.saveFunction(SysFunction.INSTANCE.toSYS(functionDTO));
//            reqMap.put("code", 0);
//            reqMap.put("msg", "菜单新增成功！");
//        } else {
//            reqMap.put("code", 0);
//            reqMap.put("msg", "所传标识有误！");
//        }
//
//        return reqMap;
//    }

//    @Override
//    public Map updateFunction(SysFunctionDTO functionDTO) {
//        Map<String, Serializable> reqMap = new HashMap<>();
//        String flag = functionDTO.getOperateType();
//        switch (flag) {
//            case "U":
//                functionDTO.setState(1);
//                functionDao.updateFunction(SysFunction.INSTANCE.toSYS(functionDTO));
//                reqMap.put("code", 1);
//                reqMap.put("msg", "菜单修改成功！");
//                break;
//            case "D":
//                functionDTO.setState(0);
//                functionDao.updateFunction(SysFunction.INSTANCE.toSYS(functionDTO));
//                reqMap.put("code", 1);
//                reqMap.put("msg", "菜单删除成功！");
//                break;
//            default:
//                reqMap.put("code", 0);
//                reqMap.put("msg", "所传标识有误！");
//                break;
//        }
//        return reqMap;
//    }

//    @Override
//    public Map updateFunctionById(Integer funcId) {
//        Integer count = functionDao.updateFunctionById(funcId);
//        return verdictCount(count);
//    }


//    @Override
//    public SysFunctionDTO selectByFuncId(Integer funcId) {
//        return SysFunction.INSTANCE.toDTO(functionDao.selectByFunctionId(funcId));
//    }

//    @Override
//    public List<SysFunctionDTO> selectAllFunction(Integer state) {
//        if(state ==null){
//            state =1;
//        }
//        return SysFunction.INSTANCE.toDTOs(functionDao.selectAllFunction(state));
//    }

//    @Override
//    public Map saveRole(SysRoleDTO sysRoleDTO) {
//        Map<String, Serializable> reqMap = new HashMap<>();
//        String flag = sysRoleDTO.getOperateType();
//        if (flag.equals("C")) {
//
//            SysRoleRepository roleRepository;
//            roleRepository = SysRoleConvert.INSTANCE.toSYS(sysRoleDTO);
//            roleRepository.setCreateTime(new java.sql.Date(new java.util.Date().getTime()));
//            roleDao.saveRole(roleRepository);
//
//            reqMap.put("code", 1);
//            reqMap.put("msg", "新增成功！");
//        } else {
//            reqMap.put("code", 0);
//            reqMap.put("msg", "无效的标识！");
//        }
//
//        return reqMap;
//
//    }

//    @Override
//    public Map updateRole(SysRoleDTO sysRoleDTO) {
//        Map<String, Serializable> reqMap = new HashMap<>();
//        String flag = sysRoleDTO.getOperateType();
//        switch (flag) {
//            case "U":
//                roleDao.updateRole(SysRoleConvert.INSTANCE.toSYS(sysRoleDTO));
//                reqMap.put("code", 1);
//                reqMap.put("msg", "修改成功！");
//                break;
//            case "D":
//                sysRoleDTO.setState(0);
//                roleDao.updateRole(SysRoleConvert.INSTANCE.toSYS(sysRoleDTO));
//                reqMap.put("code", 1);
//                reqMap.put("msg", "删除成功！");
//                break;
//            default:
//                reqMap.put("code", 0);
//                reqMap.put("msg", "无效的标识！");
//                break;
//        }
//
//        return reqMap;
//    }

//    @Override
//    public SysRoleDTO selectByRoleId(Integer roleId) {
//        return SysRoleConvert.INSTANCE.toDTO(roleDao.selectByRoleId(roleId));
//    }
//
//    @Override
//    public SysRoleDTO selectRoleInfoByStaffId(Integer staffId) {
//        return SysRoleConvert.INSTANCE.toDTO(roleDao.selectRoleInfoByStaffId(staffId));
//    }

//    @Override
//    public Map saveOrganize(SysOrganizeDTO organizeDTO) {
//        Map<String, Serializable> reqMap = new HashMap<>();
//        String flag = organizeDTO.getOperateType();
//        if (flag.equals("C")) {
//            SysOrganizeRepository organizeRepository;
//            organizeRepository = SysOrganizeConvert.INSTANCE.toSYS(organizeDTO);
//            organizeRepository.setCreateDate(new java.sql.Date(new java.util.Date().getTime()));
//
//            organizeDao.saveOrganize(organizeRepository);
//
//            reqMap.put("code", 1);
//            reqMap.put("msg", "新增成功！");
//        } else {
//            reqMap.put("code", 0);
//            reqMap.put("msg", "无效的标识！");
//        }
//
//
//        return reqMap;
//    }
//
//    @Override
//    public Map updateOrganize(SysOrganizeDTO organizeDTO) {
//        Map<String, Serializable> reqMap = new HashMap<>();
//        String flag = organizeDTO.getOperateType();
//        switch (flag) {
//            case "U":
//                organizeDao.updateOrganize(SysOrganizeConvert.INSTANCE.toSYS(organizeDTO));
//                reqMap.put("code", 1);
//                reqMap.put("msg", "修改成功！");
//                break;
//            case "D":
//                organizeDTO.setState(0);
//                organizeDao.updateOrganize(SysOrganizeConvert.INSTANCE.toSYS(organizeDTO));
//                reqMap.put("code", 1);
//                reqMap.put("msg", "修改成功！");
//                break;
//            default:
//                reqMap.put("code", 0);
//                reqMap.put("msg", "无效的标识！");
//                break;
//        }
//
//        return reqMap;
//    }

//    @Override
//    public Map updateByOrganizeId(Integer organizeId) {
//        Integer count = organizeDao.updateByOrganizeId(organizeId);
//        return verdictCount(count);
//    }
//
//    @Override
//    public SysOrganizeDTO selectByOrganizeId(Integer organizeId) {
//        return SysOrganizeConvert.INSTANCE.toDTO(organizeDao.selectByOrganizeId(organizeId));
//    }
//
//    @Override
//    public SysOrganizeDTO selectOrganizeByStaffId(Integer staffId) {
//        return SysOrganizeConvert.INSTANCE.toDTO(organizeDao.selectOrganizeByStaffId(staffId));
//    }

//    @Override
//    public Map saveOrganizeType(SysOrganizeTypeDTO organizeTypeDTO) {
//        Map<String, Serializable> reqMap = new HashMap<>();
//        SysOrganizeTypeRepository organizeTypeRepository;
//        organizeTypeRepository = SysOrganizeTypeConvert.INSTANCE.toSYS(organizeTypeDTO);
//        organizeTypeRepository.setCreateDate(new java.sql.Date(new java.util.Date().getTime()));
//        organizeTypeDao.saveOrganizeType(organizeTypeRepository);
//
//        reqMap.put("code", 1);
//        reqMap.put("msg", "新增成功！");
//
//        return reqMap;
//    }

//    @Override
//    public Map updateOrganizeType(SysOrganizeTypeDTO organizeTypeDTO) {
//        Map<String, Serializable> reqMap = new HashMap<>();
//        SysOrganizeTypeRepository organizeTypeRepository;
//        organizeTypeRepository = SysOrganizeTypeConvert.INSTANCE.toSYS(organizeTypeDTO);
//        organizeTypeDao.updateOrganizeType(organizeTypeRepository);
//
//        reqMap.put("code", 1);
//        reqMap.put("msg", "新增成功！");
//
//        return reqMap;
//    }

//    @Override
//    public Map updateOrganizeTypeById(Integer organizeTypeId) {
//        Integer count = organizeTypeDao.updateOrganizeTypeById(organizeTypeId);
//
//        return verdictCount(count);
//    }

//    @Override
//    public Map saveAuthor(SysAuthorDTO authorDTO) {
//        Map<String, Serializable> reqMap = new HashMap<>();
//        String flag = authorDTO.getOperateType();
//        SysAuthorRepository authorRepository;
//        if (flag.equals("C")) {
//            authorRepository = SysAuthorConvert.INSTANCE.toSYS(authorDTO);
//            authorRepository.setState(1);
//            authorRepository.setCreateTime(new java.sql.Date(new java.util.Date().getTime()));
//            authorDao.saveAuthor(authorRepository);
//
//            reqMap.put("code", 1);
//            reqMap.put("msg", "新增成功！");
//        } else {
//            reqMap.put("code", 0);
//            reqMap.put("msg", "无效的标识！");
//        }
//        return reqMap;
//    }

//    @Override
//    public Map updateAuthor(SysAuthorDTO authorDTO) {
//        Map<String, Serializable> reqMap = new HashMap<>();
//        String flag = authorDTO.getOperateType();
//        switch (flag) {
//            case "U":
//                authorDao.updateAuthor(SysAuthorConvert.INSTANCE.toSYS(authorDTO));
//                reqMap.put("code", 1);
//                reqMap.put("msg", "修改成功！");
//                break;
//            case "D":
//                authorDTO.setState(0);
//                authorDao.updateAuthor(SysAuthorConvert.INSTANCE.toSYS(authorDTO));
//                reqMap.put("code", 1);
//                reqMap.put("msg", "删除成功！");
//                break;
//            default:
//                reqMap.put("code", 0);
//                reqMap.put("msg", "无效的标识！");
//                break;
//        }
//
//        return reqMap;
//    }

//    @Override
//    public SysAuthorDTO selectByAuthorId(Integer authorId) {
//        return SysAuthorConvert.INSTANCE.toDTO(authorDao.selectByAuthorId(authorId));
//    }

//    @Override
//    public Map saveStaffOrgRelat(SysStaffOrgRelatDTO staffOrgRelatDTO) {
//        Map<String, Serializable> reqMap = new HashMap<>();
//        String flag = staffOrgRelatDTO.getOperateType();
//        if (flag.equals("C")) {
//            SysStaffOrgRelatRepository staffOrgRelatRepository;
//            staffOrgRelatRepository = SysStaffOrgRelatConvert.INSTANCE.toSYS(staffOrgRelatDTO);
//            staffOrgRelatRepository.setCreateTime(new java.sql.Date(new java.util.Date().getTime()));
//            staffOrgRelatRepository.setState(1);
//
//            staffOrgRelatDao.saveStaffOrgRelat(staffOrgRelatRepository);
//            reqMap.put("code", 1);
//            reqMap.put("msg", "新增成功！");
//        } else {
//            reqMap.put("code", 0);
//            reqMap.put("msg", "无效的标识！");
//        }
//
//
//        return reqMap;
//    }

//    @Override
//    public Map updateStaffOrgRelat(SysStaffOrgRelatDTO staffOrgRelatDTO) {
//        Map<String, Serializable> reqMap = new HashMap<>();
//        String flag = staffOrgRelatDTO.getOperateType();
//        switch (flag) {
//            case "U":
//                staffOrgRelatDao.updateStaffOrgRelat(SysStaffOrgRelatConvert.INSTANCE.toSYS(staffOrgRelatDTO));
//                reqMap.put("code", 1);
//                reqMap.put("msg", "修改成功！");
//                break;
//            case "D":
//                staffOrgRelatDTO.setState(0);
//                staffOrgRelatDao.updateStaffOrgRelat(SysStaffOrgRelatConvert.INSTANCE.toSYS(staffOrgRelatDTO));
//                reqMap.put("code", 1);
//                reqMap.put("msg", "删除成功！");
//
//                break;
//            default:
//                reqMap.put("code", 0);
//                reqMap.put("msg", "无效的标识！");
//                break;
//        }
//        return reqMap;
//    }

//    @Override
//    public SysStaffOrgRelatDTO selectByStaffOrgRelatId(Integer staffOrgRelatId) {
//        return SysStaffOrgRelatConvert.INSTANCE.toDTO(staffOrgRelatDao.selectByStaffOrgRelatId(staffOrgRelatId));
//    }

//    @Override
//    public Map saveStaffRoleAuthor(SysStaffRoleAuthorDTO staffRoleAuthorDTO) {
//        Map<String, Serializable> reqMap = new HashMap<>();
//        String flag = staffRoleAuthorDTO.getOperateType();
//        if (flag.equals("C")) {
//            SysStaffRoleAuthorRepository staffRoleAuthorRepository;
//            staffRoleAuthorRepository = SysStaffRoleAuthorConvert.INSTANCE.toSYS(staffRoleAuthorDTO);
//            staffRoleAuthorRepository.setState(1);
//            staffRoleAuthorRepository.setCreateTime(new java.sql.Date(new java.util.Date().getTime()));
//            staffRoleAuthorDao.saveStaffRoleAuthor(staffRoleAuthorRepository);
//            reqMap.put("code", 1);
//            reqMap.put("msg", "新增成功！");
//        } else {
//            reqMap.put("code", 0);
//            reqMap.put("msg", "无效的标识！");
//        }
//        return reqMap;
//    }
//
//    @Override
//    public Map updateStaffRoleAuthor(SysStaffRoleAuthorDTO staffRoleAuthorDTO) {
//        Map<String, Serializable> reqMap = new HashMap<>();
//        String flag = staffRoleAuthorDTO.getOperateType();
//        switch (flag) {
//            case "U":
//                staffRoleAuthorDao.updateStaffRoleAuthor(SysStaffRoleAuthorConvert.INSTANCE.toSYS(staffRoleAuthorDTO));
//                reqMap.put("code", 1);
//                reqMap.put("msg", "修改成功！");
//                break;
//            case "D":
//                staffRoleAuthorDTO.setState(0);
//                staffRoleAuthorDao.updateStaffRoleAuthor(SysStaffRoleAuthorConvert.INSTANCE.toSYS(staffRoleAuthorDTO));
//                reqMap.put("code", 1);
//                reqMap.put("msg", "删除成功！");
//
//                break;
//            default:
//                reqMap.put("code", 0);
//                reqMap.put("msg", "无效的标识！");
//                break;
//        }
//        return reqMap;
//    }
//
//    @Override
//    public SysStaffRoleAuthorDTO selectByStaffRoleAuthorId(Integer staffRoleAuthorId) {
//        return SysStaffRoleAuthorConvert.INSTANCE.toDTO(staffRoleAuthorDao.selectByStaffRoleAuthorId(staffRoleAuthorId));
//    }

//    @Override
//    public Map saveStation(SysStationDTO stationDTO) {
//        Map<String, Serializable> reqMap = new HashMap<>();
//        String flag = stationDTO.getOperateType();
//        if (flag.equals("C")) {
//            stationDTO.setState(1);
//            stationDao.saveStation(SysStationConvert.INSTANCE.toSYS(stationDTO));
//            reqMap.put("code", 1);
//            reqMap.put("msg", "新增成功！");
//        } else {
//            reqMap.put("code", 0);
//            reqMap.put("msg", "无效的标识！");
//        }
//
//        return reqMap;
//    }
//
//    @Override
//    public Map updateStation(SysStationDTO stationDTO) {
//        Map<String, Serializable> reqMap = new HashMap<>();
//        String flag = stationDTO.getOperateType();
//        switch (flag) {
//            case "U":
//                stationDao.updateStation(SysStationConvert.INSTANCE.toSYS(stationDTO));
//                reqMap.put("code", 1);
//                reqMap.put("msg", "修改成功！");
//                break;
//            case "D":
//                stationDTO.setState(0);
//                stationDao.updateStation(SysStationConvert.INSTANCE.toSYS(stationDTO));
//                reqMap.put("code", 1);
//                reqMap.put("msg", "删除成功！");
//
//                break;
//            default:
//                reqMap.put("code", 0);
//                reqMap.put("msg", "无效的标识！");
//                break;
//        }
//
//        return reqMap;
//    }
//
//    @Override
//    public SysStationDTO selectByStationId(Integer stationId) {
//        return SysStationConvert.INSTANCE.toDTO(stationDao.selectByStationId(stationId));
//    }
//
//    @Override
//    public List<SysStationDTO> selectAllStation(String name, String code, Integer pageNo, Integer pageSize) {
//        Integer offset = null;
//        if ((pageNo != null) && (pageSize != null)) {
//            offset = pageNo;
//        }
//        List<SysStationRepository> stationList = stationDao.selectAllStation(name,code,offset,pageSize);
//        if(stationList.size()>0){
//            return SysStationConvert.INSTANCE.toDTOs(stationList);
//        }else{
//            return  null;
//        }
//    }
//
//    @Override
//    public int getStationCount(String name, String code) {
//        return stationDao.getStationCount(name,code);
//    }

//    @Override
//    public Map saveStationFunc(SysStationFuncDTO stationFuncDTO) {
//        Map<String, Serializable> reqMap = new HashMap<>();
//        String flag = stationFuncDTO.getOperateType();
//        if (flag.equals("C")) {
//            SysStationFuncRepository stationFuncRepository;
//            stationFuncRepository = SysStationFuncConvert.INSTANCE.toSYS(stationFuncDTO);
//            stationFuncRepository.setState(1);
//            stationFuncRepository.setCreateTime(new java.sql.Date(new java.util.Date().getTime()));
//
//            stationFuncDao.saveStationFunc(stationFuncRepository);
//            reqMap.put("code", 1);
//            reqMap.put("msg", "新增成功！");
//        } else {
//            reqMap.put("code", 0);
//            reqMap.put("msg", "无效的标识！");
//        }
//        return reqMap;
//    }

//    @Override
//    public Map updateStationFunc(SysStationFuncDTO stationFuncDTO) {
//        Map<String, Serializable> reqMap = new HashMap<>();
//        String flag = stationFuncDTO.getOperateType();
//        switch (flag) {
//            case "U":
//                stationFuncDao.updateStationFunc(SysStationFuncConvert.INSTANCE.toSYS(stationFuncDTO));
//                reqMap.put("code", 1);
//                reqMap.put("msg", "修改成功！");
//                break;
//            case "D":
//                stationFuncDTO.setState(0);
//                stationFuncDao.updateStationFunc(SysStationFuncConvert.INSTANCE.toSYS(stationFuncDTO));
//                reqMap.put("code", 1);
//                reqMap.put("msg", "删除成功！");
//
//                break;
//            default:
//                reqMap.put("code", 0);
//                reqMap.put("msg", "无效的标识！");
//                break;
//        }
//        return reqMap;
//    }

//    @Override
//    public SysStationFuncDTO selectByStationFuncRelatId(Integer stationFuncRelatId) {
//        return SysStationFuncConvert.INSTANCE.toDTO(stationFuncDao.selectByStationFuncRelatId(stationFuncRelatId));
//    }
//
//    @Override
//    public SysStationFuncDTO selectStationFuncByStaffId(Integer staffId) {
//        return SysStationFuncConvert.INSTANCE.toDTO(stationFuncDao.selectStationFuncByStaffId(staffId));
//    }

//    @Override
//    public Map saveOpTypeDef(SysOpTypeDefDTO sysOpTypeDefDTO) {
//        Map<String, Serializable> reqMap = new HashMap<>();
//        String flag = sysOpTypeDefDTO.getOperateType();
//        if(flag.equals("C")){
//            SysOpTypeDefRepository sysOpTypeDefRepository;
//            sysOpTypeDefRepository = SysOpTypeDefConvert.INSTANCE.toSYS(sysOpTypeDefDTO);
//            sysOpTypeDefRepository.setState(1);
//
//            opTypeDefDao.saveOpTypeDef(sysOpTypeDefRepository);
//
//            reqMap.put("code", 1);
//            reqMap.put("msg", "新增成功！");
//        }else{
//            reqMap.put("code", 0);
//            reqMap.put("msg", "无效的标识！");
//        }
//        return reqMap;
//    }
//
//    @Override
//    public Map updateOpTypeDef(SysOpTypeDefDTO sysOpTypeDefDTO) {
//        Map<String, Serializable> reqMap = new HashMap<>();
//        String flag = sysOpTypeDefDTO.getOperateType();
//        switch (flag){
//            case "U":
//                opTypeDefDao.updateOpTypeDef(SysOpTypeDefConvert.INSTANCE.toSYS(sysOpTypeDefDTO));
//                reqMap.put("code", 1);
//                reqMap.put("msg", "修改成功！");
//                break;
//            case "D":
//                sysOpTypeDefDTO.setState(0);
//                opTypeDefDao.updateOpTypeDef(SysOpTypeDefConvert.INSTANCE.toSYS(sysOpTypeDefDTO));
//                reqMap.put("code", 1);
//                reqMap.put("msg", "删除成功！");
//                break;
//            default:
//                reqMap.put("code", 0);
//                reqMap.put("msg", "无效的标识！");
//                break;
//        }
//        return reqMap;
//    }

//    @Override
//    public List<SysOpTypeDefDTO> selectAllOpType(String code, String opTypeName, Integer pageNo, Integer pageSize) {
//        Integer offset = null;
//        if ((pageNo != null) && (pageSize != null)) {
//            offset = pageNo;
//        }
//        List<SysOpTypeDefRepository> opTypeDefList = opTypeDefDao.selectAllOpType(code,opTypeName,offset,pageSize);
//        if(opTypeDefList.size() >0){
//            return SysOpTypeDefConvert.INSTANCE.toDTOs(opTypeDefList);
//        }else{
//            return null;
//        }
//    }

//    @Override
//    public int getOpTypeCount(String code, String opTypeName) {
//        return opTypeDefDao.getOpTypeCount(code,opTypeName);
//    }

//    private Map verdictCount(Integer count){
//        Map<String, Serializable> reqMap = new HashMap<>();
//        if(count >0){
//            reqMap.put("code",1);
//            reqMap.put("msg","删除成功!");
//            reqMap.put("row_count",count);
//        }else{
//            reqMap.put("code",0);
//            reqMap.put("msg","删除失败!");
//            reqMap.put("row_count",0);
//        }
//        return reqMap;
//    }
}
