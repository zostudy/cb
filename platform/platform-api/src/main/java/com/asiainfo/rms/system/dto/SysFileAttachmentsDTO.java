package com.asiainfo.rms.system.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class SysFileAttachmentsDTO {
    private Integer id;

    private String filePath;

    private String fileName;

    private String fileType;

    private String fileResource;

    private Integer submitStaffId;

    private String createTime;

    private MultipartFile file;
}
