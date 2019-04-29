package com.asiainfo.rms.system.web;

import com.asiainfo.rms.alm.util.dto.AlmAttachmentSelectDTO;
import com.asiainfo.rms.system.dto.SysAlmAttachCheckConfigDTO;
import com.asiainfo.rms.system.dto.SysFileAttachmentsDTO;
import com.asiainfo.rms.system.service.FileUpLoadService;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j
@RestController
public class FileUpLoadControllerImpl implements FileUpLoadController {

    private final FileUpLoadService fileUpLoadService;

    public FileUpLoadControllerImpl(FileUpLoadService fileUpLoadService) {
        this.fileUpLoadService = fileUpLoadService;
    }

    @Override
    public String upLpadFileAttachments(@RequestParam("file") MultipartFile file) {
        return fileUpLoadService.upLpadFileAttachments(file);
    }

    @Override
    public String saveFileAttachments(@RequestBody SysFileAttachmentsDTO sysFileAttachmentsDTO) {
        return fileUpLoadService.saveFileAttachments(sysFileAttachmentsDTO);
    }

    @Override
    public Map<String, Object> upLoadFile(@RequestParam("file") MultipartFile file,
                                          @RequestParam(value = "obj_id") Long objId,
                                          @RequestParam(value = "obj_type") Long objType,
                                          @RequestParam(value = "wo_id", required = false) Long woId,
                                          @RequestParam(value = "att_type") String attType,
                                          @RequestParam(value = "submitter_tag") String submitterTag,
                                          @RequestParam(value = "submit_link", required = false) String submitLink) {
        Map<String, Object> map = new HashMap<>();
        try {
            if (!file.isEmpty()) {
                long size = file.getSize();
                if (size > 10 * 1048576) {
                    map.put("code", 0);
                    map.put("msg", "附件过大,请编辑后重新上传!");
                    return map;
                }
            }
            String pkgId = fileUpLoadService.upLoadFile(file, objId, objType, woId, attType, submitterTag, submitLink);
            if ("-1".equals(pkgId)) {
                map.put("code", 0);
                map.put("msg", "出现未知异常！");
            } else {
                Map<String, Object> pkgIdMap = new HashMap<>();
                pkgIdMap.put("att_pack_id", pkgId);
                map.put("code", 1);
                map.put("msg", "success");
                map.put("obj", pkgIdMap);
            }
            return map;
        } catch (Exception ex) {
            log.error(ex.getMessage());
            map.put("code", 0);
            map.put("msg", "出现未知异常！异常信息：" + ex.getMessage());
            return map;
        }
    }

    @Override
    public Map<String, Object> selectAttachByCond(@RequestParam(value = "obj_id") Long objId,
                                                  @RequestParam(value = "obj_type") Long objType) {
        Map<String, Object> map = new HashMap<>();
        try {
            List<AlmAttachmentSelectDTO> obj = fileUpLoadService.selectAttachByCond(objId, objType);
            map.put("code", 1);
            map.put("msg", "success");
            map.put("obj", obj);
            return map;
        } catch (Exception ex) {
            log.error(ex.getMessage());
            map.put("code", 0);
            map.put("msg", "出现未知异常！异常信息：" + ex.getMessage());
            return map;
        }
    }

    @Override
    public Map<String, Object> checkAttachByCond(@RequestParam(value = "obj_id") Long objId,
                                                 @RequestParam(value = "obj_type") Long objType,
                                                 @RequestParam(value = "wo_id", required = false) Long woId,
                                                 @RequestParam(value = "submit_link") String submitLink,
                                                 @RequestParam(value = "coding_type", required = false) Long codingType,
                                                 @RequestParam(value = "sys_tag", required = false) String sysTag,
                                                 @RequestParam(value = "sub_sys_tag", required = false) String subSysTag) {
        Map<String, Object> map = new HashMap<>();
        try {
            List<SysAlmAttachCheckConfigDTO> obj = fileUpLoadService.checkAttachByCond(objId, objType, woId, submitLink, codingType, sysTag, subSysTag);
            map.put("code", 1);
            map.put("msg", "success");
            map.put("obj", obj);
            return map;
        } catch (Exception ex) {
            log.error(ex.getMessage());
            map.put("code", 0);
            map.put("msg", "出现未知异常！异常信息：" + ex.getMessage());
            return map;
        }
    }

    @Override
    public Map<String, Object> selectCheckRuleByCond(@RequestParam(value = "obj_type") Long objType,
                                                     @RequestParam(value = "submit_link") String submitLink,
                                                     @RequestParam(value = "coding_type", required = false) Long codingType,
                                                     @RequestParam(value = "sys_tag", required = false) String sysTag,
                                                     @RequestParam(value = "sub_sys_tag", required = false) String subSysTag) {
        Map<String, Object> map = new HashMap<>();
        try {
            List<SysAlmAttachCheckConfigDTO> obj = fileUpLoadService.selectCheckRuleByCond(objType, submitLink, codingType, sysTag, subSysTag);
            map.put("code", 1);
            map.put("msg", "success");
            map.put("obj", obj);
            return map;
        } catch (Exception ex) {
            log.error(ex.getMessage());
            map.put("code", 0);
            map.put("msg", "出现未知异常！异常信息：" + ex.getMessage());
            return map;
        }
    }

    @Override
    public Map<String, Object> deleteAttach(@RequestParam(value = "att_pack_id") Long attPackId) {
        Map<String, Object> map = new HashMap<>();
        try {
            fileUpLoadService.deleteAttach(attPackId);
            map.put("code", 1);
            map.put("msg", "success");
            return map;
        } catch (Exception ex) {
            log.error(ex.getMessage());
            map.put("code", 0);
            map.put("msg", "出现未知异常！异常信息：" + ex.getMessage());
            return map;
        }
    }

}
