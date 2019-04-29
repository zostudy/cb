package com.asiainfo.rms.alm.demand.domain;

import java.util.Date;

public class AlmReqtmpSimpleParamRepository {
    private Integer arspId;//简易参数需求模板主键

    private String objTag;//对象编码

    private String objName;//对象名称

    private Integer modifyType;//对象类型

    private String onlineTime;//上线时间

    private String offlineTime;//下线时间

    private String modifyName;//修改后名称

    private String noteBefore;//修改前注释

    private String noteAfter;//修改后注释

    private String mark;//备注信息

    private Integer artId;//需求模板主题表主键

    private Integer artType;//模板类型，简易参数修改类

    private String modifyTypeCont;//对象类型内容

    private String artTag;

    private String artName;

    public String getArtTag() {
        return artTag;
    }

    public void setArtTag(String artTag) {
        this.artTag = artTag;
    }

    public String getArtName() {
        return artName;
    }

    public void setArtName(String artName) {
        this.artName = artName;
    }

    public Integer getArspId() {
        return arspId;
    }

    public void setArspId(Integer arspId) {
        this.arspId = arspId;
    }

    public String getObjTag() {
        return objTag;
    }

    public void setObjTag(String objTag) {
        this.objTag = objTag;
    }

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }

    public Integer getModifyType() {
        return modifyType;
    }

    public void setModifyType(Integer modifyType) {
        this.modifyType = modifyType;
    }

    

    public String getModifyName() {
        return modifyName;
    }

    public String getOnlineTime() {
		return onlineTime;
	}

	public void setOnlineTime(String onlineTime) {
		this.onlineTime = onlineTime;
	}

	public String getOfflineTime() {
		return offlineTime;
	}

	public void setOfflineTime(String offlineTime) {
		this.offlineTime = offlineTime;
	}

	public void setModifyName(String modifyName) {
        this.modifyName = modifyName;
    }

    public String getNoteBefore() {
        return noteBefore;
    }

    public void setNoteBefore(String noteBefore) {
        this.noteBefore = noteBefore;
    }

    public String getNoteAfter() {
        return noteAfter;
    }

    public void setNoteAfter(String noteAfter) {
        this.noteAfter = noteAfter;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Integer getArtId() {
        return artId;
    }

    public void setArtId(Integer artId) {
        this.artId = artId;
    }

    public Integer getArtType() {
        return artType;
    }

    public void setArtType(Integer artType) {
        this.artType = artType;
    }

    public String getModifyTypeCont() {
        return modifyTypeCont;
    }

    public void setModifyTypeCont(String modifyTypeCont) {
        this.modifyTypeCont = modifyTypeCont;
    }
}
