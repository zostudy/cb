package com.asiainfo.rms.system.domain;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public class SysFileAttachmentsRepostitory {
    private Integer id;

    private String filePath;

    private String fileName;

    private String fileType;

    private String fileResource;

    private Integer submitStaffId;

    private Date createTime;

    private MultipartFile file;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileResource() {
        return fileResource;
    }

    public void setFileResource(String fileResource) {
        this.fileResource = fileResource;
    }

    public Integer getSubmitStaffId() {
        return submitStaffId;
    }

    public void setSubmitStaffId(Integer submitStaffId) {
        this.submitStaffId = submitStaffId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
