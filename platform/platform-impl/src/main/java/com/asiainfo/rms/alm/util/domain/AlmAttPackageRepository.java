package com.asiainfo.rms.alm.util.domain;

public class AlmAttPackageRepository {
    private Long attPackId;

    private Long objId;

    private Long objType;

    private Long woId;

    private String attPackDesc;

    private Long attId;

    private String objNo;

    public Long getAttPackId() {
        return attPackId;
    }

    public void setAttPackId(Long attPackId) {
        this.attPackId = attPackId;
    }

    public Long getObjId() {
        return objId;
    }

    public void setObjId(Long objId) {
        this.objId = objId;
    }

    public Long getObjType() {
        return objType;
    }

    public void setObjType(Long objType) {
        this.objType = objType;
    }

    public Long getWoId() {
        return woId;
    }

    public void setWoId(Long woId) {
        this.woId = woId;
    }

    public String getAttPackDesc() {
        return attPackDesc;
    }

    public void setAttPackDesc(String attPackDesc) {
        this.attPackDesc = attPackDesc == null ? null : attPackDesc.trim();
    }

    public Long getAttId() {
        return attId;
    }

    public void setAttId(Long attId) {
        this.attId = attId;
    }

    public String getObjNo() {
        return objNo;
    }

    public void setObjNo(String objNo) {
        this.objNo = objNo == null ? null : objNo.trim();
    }
}