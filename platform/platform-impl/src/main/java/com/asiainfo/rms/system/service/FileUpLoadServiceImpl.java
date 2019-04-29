package com.asiainfo.rms.system.service;

import com.asiainfo.rms.alm.util.convert.AlmAttachmentSelectConvert;
import com.asiainfo.rms.alm.util.dao.AlmAttPackageDao;
import com.asiainfo.rms.alm.util.dao.AlmAttachCheckConfigDao;
import com.asiainfo.rms.alm.util.dao.AlmAttachmentDao;
import com.asiainfo.rms.alm.util.domain.AlmAttPackageRepository;
import com.asiainfo.rms.alm.util.domain.AlmAttachmentRepository;
import com.asiainfo.rms.alm.util.dto.AlmAttachmentSelectDTO;
import com.asiainfo.rms.core.exception.BusinessException;
import com.asiainfo.rms.system.convert.SysAlmAttachCheckConfigConvert;
import com.asiainfo.rms.system.convert.SysFileAttachmentsConvert;
import com.asiainfo.rms.system.dao.SysAlmAttachCheckConfigDao;
import com.asiainfo.rms.system.dao.SysFileAttachmentsDao;
import com.asiainfo.rms.system.domain.SysFileAttachmentsRepostitory;
import com.asiainfo.rms.system.dto.SysAlmAttachCheckConfigDTO;
import com.asiainfo.rms.system.dto.SysFileAttachmentsDTO;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional
public class FileUpLoadServiceImpl implements FileUpLoadService {
    @Value("${basePath}")
    private String basePath;

    @Value("${baseImagePath}")
    private String baseImagePath;

    @Value("${baseOfficePath}")
    private String baseOfficePath;

    @Value("${ftpPath}")
    private String ftpPath;


    private final AlmAttachmentDao almAttachmentDao;

    private final AlmAttPackageDao almAttPackageDao;

    private final AlmAttachCheckConfigDao almAttachCheckConfigDao;

    private final SysFileAttachmentsDao sysFileAttachmentsDao;

    private final SysAlmAttachCheckConfigDao sysAlmAttachCheckConfigDao;

    public FileUpLoadServiceImpl(AlmAttachmentDao almAttachmentDao, AlmAttPackageDao almAttPackageDao, AlmAttachCheckConfigDao almAttachCheckConfigDao, SysFileAttachmentsDao sysFileAttachmentsDao, SysAlmAttachCheckConfigDao sysAlmAttachCheckConfigDao) {
        this.almAttachmentDao = almAttachmentDao;
        this.almAttPackageDao = almAttPackageDao;
        this.almAttachCheckConfigDao = almAttachCheckConfigDao;
        this.sysFileAttachmentsDao = sysFileAttachmentsDao;
        this.sysAlmAttachCheckConfigDao = sysAlmAttachCheckConfigDao;
    }

    private static final Logger logger = LoggerFactory.getLogger(FileUpLoadServiceImpl.class);

    @Override
    public String upLpadFileAttachments(MultipartFile file) {
        JSONObject json = new JSONObject();
        if (file.isEmpty()) {
            return "文件为空";
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + fileName);

        //生成计划批次号
        long l = System.currentTimeMillis();
        Random random = new Random();
        int randomCount = 99;
        int i = random.nextInt(randomCount);

        Date date = new Date(l);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
        logger.info("上传的后缀名为：" + suffixName);

        fileName = dateFormat.format(date) + i + "." + suffixName;
        // 文件上传后的路径

        File dest;
        String filePath;
        String ftpFilePath = ftpPath;
        if (suffixName.matches("^[(jpg)|(png)|(gif)|(jpeg)|(svg)]+$")) {
            filePath = baseImagePath;
            dest = new File(filePath + fileName);
            ftpPath = ftpFilePath + "image/" + fileName;
            logger.info("文件上传地址为：" + filePath + fileName);
        } else {
            filePath = baseOfficePath;
            dest = new File(filePath + fileName);
            ftpPath = ftpFilePath + "office/" + fileName;
            logger.info("文件上传地址为：" + filePath + fileName);
        }
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            dest.delete();
            file.transferTo(dest);
            json.put("code", 1);
            json.put("msg", "上传成功");
            json.put("file_path", ftpPath);
            ftpPath = "";
        } catch (IllegalStateException | JSONException | IOException e) {
            e.printStackTrace();
            logger.error("上传异常", e);
        }
        return json.toString();
    }

    @Override
    public String saveFileAttachments(SysFileAttachmentsDTO sysFileAttachmentsDTO) {
        JSONObject json = new JSONObject();
        SysFileAttachmentsRepostitory fileAttachmentsRepostitory = SysFileAttachmentsConvert.INSTANCE.toSYS(sysFileAttachmentsDTO);
        fileAttachmentsRepostitory.setCreateTime(new java.sql.Date(new java.util.Date().getTime()));
        if (sysFileAttachmentsDao.saveFileAttachments(fileAttachmentsRepostitory) > 0) {
            try {
                json.put("code", 1);
                json.put("msg", "保存成功");
                json.put("id", fileAttachmentsRepostitory.getId());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

    @Override
    public String upLoadFile(MultipartFile file, Long objId, Long objType, Long woId, String attType, String submitterTag, String submitLink) {
        if (file.isEmpty()) {
            return "文件为空";
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + fileName);

        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("上传的后缀名为：" + suffixName);
        if (!".exe".equals(suffixName) || !".EXE".equals(suffixName)) {
            String uuid = UUID.randomUUID().toString(); //获取UUID并转化为String对象
            //uuid = uuid.replace("-", "");               //因为UUID本身为32位只是生成时多了“-”，所以将它们去点就可  
            String uuidFileName = uuid + fileName.substring(fileName.lastIndexOf("."));
            // 文件上传后的路径
            String filePath = basePath;
            File dest = new File(filePath + uuidFileName);
            logger.info("上传的完整路径为：" + dest);
            // 检测是否存在目录
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }

            try {
                dest.delete();
                file.transferTo(dest);

                AlmAttachmentRepository almAttachmentRepository = new AlmAttachmentRepository();
                almAttachmentRepository.setAttType(attType);
                almAttachmentRepository.setSubmitterTag(submitterTag);
                almAttachmentRepository.setSubmitLink(submitLink);
                almAttachmentRepository.setSubmitTime(new Date());
                almAttachmentRepository.setAttName(fileName);
                almAttachmentRepository.setAttPath(uuidFileName);
                almAttachmentDao.insert(almAttachmentRepository);
                AlmAttPackageRepository almAttPackageRepository = new AlmAttPackageRepository();
                almAttPackageRepository.setObjId(objId);
                almAttPackageRepository.setObjType(objType);
                almAttPackageRepository.setWoId(woId);
                almAttPackageRepository.setAttId(almAttachmentRepository.getAttId());
                almAttPackageRepository.setAttPackDesc(attType);
                almAttPackageDao.insert(almAttPackageRepository);
                return almAttPackageRepository.getAttPackId().toString();
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
                logger.error("上传异常", e);
                return "-1";
            }
        } else {
            throw new BusinessException("请勿上传EXE格式文件！");
        }
    }

    @Override
    public List<AlmAttachmentSelectDTO> selectAttachByCond(Long objId, Long objType) {
        List<AlmAttachmentSelectDTO> asList = new ArrayList<AlmAttachmentSelectDTO>();
        List<AlmAttPackageRepository> attPackageList = almAttPackageDao.selectByCond(objId, objType);
        for (AlmAttPackageRepository ap : attPackageList) {
            AlmAttachmentRepository ar = almAttachmentDao.selectByPrimaryKey(ap.getAttId());
            AlmAttachmentSelectDTO as = AlmAttachmentSelectConvert.INSTANCE.toDTO(ar, ap);
            asList.add(as);
        }
        return asList;
    }

    @Override
    public List<SysAlmAttachCheckConfigDTO> checkAttachByCond(Long objId, Long objType, Long woId, String submitLink, Long codingType,
                                                              String sysTag, String subSysTag) {
        List<AlmAttPackageRepository> aprList = almAttPackageDao.selectByCond(objId, objType);
        Map<Integer, Integer> live = new HashMap<Integer, Integer>();
        for (AlmAttPackageRepository apr : aprList) {
            AlmAttachmentRepository ar = almAttachmentDao.selectByPrimaryKey(apr.getAttId());
            if (submitLink != null && !"".equals(submitLink) && submitLink.equals(ar.getSubmitLink())) {
                String[] arr = apr.getAttPackDesc().trim().split(",");
                for (String i : arr) {
                    live.put(Integer.valueOf(i), Integer.valueOf(i));
                }

            }
        }
        List<SysAlmAttachCheckConfigDTO> attrCheck = this.selectCheckRuleByCond(objType, submitLink, codingType, sysTag, subSysTag);
        List<SysAlmAttachCheckConfigDTO> temp = new ArrayList<SysAlmAttachCheckConfigDTO>();
        live.forEach((k, v) -> {
            for (SysAlmAttachCheckConfigDTO o : attrCheck) {
                if (o.getAttType().equals(String.valueOf(k))) {
                	temp.add(o);
                }
            }

        });
        temp.forEach(item->attrCheck.remove(item));
        
        return attrCheck;
    }

    @Override
    public List<SysAlmAttachCheckConfigDTO> selectCheckRuleByCond(Long objType, String submitLink, Long codingType, String sysTag,
                                                                  String subSysTag) {

        return SysAlmAttachCheckConfigConvert.INSTANCE.toDTOs(sysAlmAttachCheckConfigDao.selectCheckRuleByConds(objType, submitLink, codingType, sysTag, subSysTag));

    }

    @Override
    public void deleteAttach(Long attPackId) {
        AlmAttPackageRepository attPackage = almAttPackageDao.selectByPrimaryKey(attPackId);
        if (attPackage != null) {
            almAttPackageDao.deleteByPrimaryKey(attPackage.getAttPackId());
            almAttachmentDao.deleteByPrimaryKey(attPackage.getAttId());
        }
    }

}
