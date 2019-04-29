package com.asiainfo.rms.system.service;

import com.asiainfo.rms.alm.util.dto.AlmAttachmentSelectDTO;
import com.asiainfo.rms.system.dto.SysAlmAttachCheckConfigDTO;
import com.asiainfo.rms.system.dto.SysFileAttachmentsDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface FileUpLoadService {
    String upLpadFileAttachments(MultipartFile file);

    String saveFileAttachments(SysFileAttachmentsDTO sysFileAttachmentsDTO);

    String upLoadFile(MultipartFile file, Long objId, Long objType,Long woId, String attType,String submitterTag,String submitLink);
    
    List<AlmAttachmentSelectDTO> selectAttachByCond(Long objId, Long objType);

    List<SysAlmAttachCheckConfigDTO> checkAttachByCond(Long objId, Long objType, Long woId, String submitLink, Long codingType, String sysTag, String subSysTag);

    List<SysAlmAttachCheckConfigDTO> selectCheckRuleByCond(Long objType, String submitLink, Long codingType, String sysTag, String subSysTag);
    
    void deleteAttach(Long attPackId);
    
}
