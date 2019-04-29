package com.asiainfo.rms.workflow.bo.process.common;

/**
 * 
 * 
 * @author joker
 */
public class AlmWorkorderListQueryPageBO {
	
	/**
	 * (开始)
	 */
	private java.lang.Long orderIdBegin;
	
	/**
	 * (结束)
	 */
	private java.lang.Long orderIdEnd;
	
	/**
	 * 
	 */
	private java.lang.String objType;
	
	/**
	 * 
	 */
	private java.lang.String vmTaskName;
	
	/**
	 * 
	 */
	private java.lang.String linkNo;
	
	/**
	 * (开始)
	 */
	private java.lang.Long linkIdBegin;
	
	/**
	 * (结束)
	 */
	private java.lang.Long linkIdEnd;
	
	/**
	 * (结束)
	 */
	private java.lang.String linkIds;
	
	/**
	 * (开始)
	 */
	private java.lang.Long execStaffIdBegin;
	
	/**
	 * (结束)
	 */
	private java.lang.Long execStaffIdEnd;
	
	/**
	 * 
	 */
	private java.lang.String execStaffCode;
	
	/**
	 * 
	 */
	private java.lang.String execEmployeeName;
	
	/**
	 * 
	 */
	private java.lang.String lockOpinion;
	
	/**
	 * (开始)
	 */
	private java.util.Date createTimeBegin;
	
	/**
	 * (结束)
	 */
	private java.util.Date createTimeEnd;
	
	/**
	 * (开始)
	 */
	private java.util.Date finishTimeBegin;
	
	/**
	 * (结束)
	 */
	private java.util.Date finishTimeEnd;
	
	/**
	 * 
	 */
	private java.lang.String orderType;
	
	/**
	 * 
	 */
	private java.lang.String cond;
	
	/**
	 * 
	 */
	private java.lang.String result;
	
	/**
	 * 
	 */
	private java.lang.String status;
	
	/**
	 * 
	 */
	private java.lang.String opinion;
	
	/**
	 * 
	 */
	private java.lang.String nextLinkPlantime;
	
	/**
	 * (开始)
	 */
	private java.lang.Long procInstIdBegin;
	
	/**
	 * (结束)
	 */
	private java.lang.Long procInstIdEnd;
	
	/**
	 * (开始)
	 */
	private java.lang.Long lastOrderIdBegin;
	
	/**
	 * (结束)
	 */
	private java.lang.Long lastOrderIdEnd;
	
	/**
	 * (开始)
	 */
	private Long remineTimeBegin;
	
	/**
	 * (结束)
	 */
	private Long remineTimeEnd;
	
	/**
	 * 
	 */
	private java.lang.String phaseId;
	
	/**
	 * (开始)
	 */
	private Long timeConsumBegin;
	
	/**
	 * (结束)
	 */
	private Long timeConsumEnd;
	
	/**
	 * (开始)
	 */
	private Long objIdBegin;
	
	/**
	 * (结束)
	 */
	private Long objIdEnd;
	
	/**
	 * 
	 */
	private java.lang.String objTag;
	
	/**
	 * (开始)
	 */
	private Long applyStaffIdBegin;
	
	/**
	 * (结束)
	 */
	private Long applyStaffIdEnd;
	
	/**
	 * 
	 */
	private java.lang.String applyStaffName;
	
	/**
	 * 
	 */
	private java.lang.String applyStaffCode;
	
	/**
	 * 分页页码
	 */
	private Integer pageNo;
	
	/**
	 * 分页步长
	 */
	private Integer pageSize;
	public java.lang.String getLinkIds() {
		return linkIds;
	}

	public void setLinkIds(java.lang.String linkIds) {
		this.linkIds = linkIds;
	}

	public java.lang.Long getOrderIdBegin() {
		return this.orderIdBegin;
	}
	
	public void setOrderIdBegin(java.lang.Long value) {
		this.orderIdBegin = value;
	}
	
	public java.lang.Long getOrderIdEnd() {
		return this.orderIdEnd;
	}
	
	public void setOrderIdEnd(java.lang.Long value) {
		this.orderIdEnd = value;
	}
	public java.lang.String getObjType() {
		return this.objType;
	}
	
	public void setObjType(java.lang.String value) {
		this.objType = value;
	}	    	
	public java.lang.String getVmTaskName() {
		return this.vmTaskName;
	}
	
	public void setVmTaskName(java.lang.String value) {
		this.vmTaskName = value;
	}	    	
	public java.lang.String getLinkNo() {
		return this.linkNo;
	}
	
	public void setLinkNo(java.lang.String value) {
		this.linkNo = value;
	}	    	
	public java.lang.Long getLinkIdBegin() {
		return this.linkIdBegin;
	}
	
	public void setLinkIdBegin(java.lang.Long value) {
		this.linkIdBegin = value;
	}
	
	public java.lang.Long getLinkIdEnd() {
		return this.linkIdEnd;
	}
	
	public void setLinkIdEnd(java.lang.Long value) {
		this.linkIdEnd = value;
	}
	public java.lang.Long getExecStaffIdBegin() {
		return this.execStaffIdBegin;
	}
	
	public void setExecStaffIdBegin(java.lang.Long value) {
		this.execStaffIdBegin = value;
	}
	
	public java.lang.Long getExecStaffIdEnd() {
		return this.execStaffIdEnd;
	}
	
	public void setExecStaffIdEnd(java.lang.Long value) {
		this.execStaffIdEnd = value;
	}
	public java.lang.String getExecStaffCode() {
		return this.execStaffCode;
	}
	
	public void setExecStaffCode(java.lang.String value) {
		this.execStaffCode = value;
	}	    	
	public java.lang.String getExecEmployeeName() {
		return this.execEmployeeName;
	}
	
	public void setExecEmployeeName(java.lang.String value) {
		this.execEmployeeName = value;
	}	    	
	public java.lang.String getLockOpinion() {
		return this.lockOpinion;
	}
	
	public void setLockOpinion(java.lang.String value) {
		this.lockOpinion = value;
	}	    	
	public java.util.Date getCreateTimeBegin() {
		return this.createTimeBegin;
	}
	
	public void setCreateTimeBegin(java.util.Date value) {
		this.createTimeBegin = value;
	}
	
	public java.util.Date getCreateTimeEnd() {
		return this.createTimeEnd;
	}
	
	public void setCreateTimeEnd(java.util.Date value) {
		this.createTimeEnd = value;
	}
	public java.util.Date getFinishTimeBegin() {
		return this.finishTimeBegin;
	}
	
	public void setFinishTimeBegin(java.util.Date value) {
		this.finishTimeBegin = value;
	}
	
	public java.util.Date getFinishTimeEnd() {
		return this.finishTimeEnd;
	}
	
	public void setFinishTimeEnd(java.util.Date value) {
		this.finishTimeEnd = value;
	}
	public java.lang.String getOrderType() {
		return this.orderType;
	}
	
	public void setOrderType(java.lang.String value) {
		this.orderType = value;
	}	    	
	public java.lang.String getCond() {
		return this.cond;
	}
	
	public void setCond(java.lang.String value) {
		this.cond = value;
	}	    	
	public java.lang.String getResult() {
		return this.result;
	}
	
	public void setResult(java.lang.String value) {
		this.result = value;
	}	    	
	public java.lang.String getStatus() {
		return this.status;
	}
	
	public void setStatus(java.lang.String value) {
		this.status = value;
	}	    	
	public java.lang.String getOpinion() {
		return this.opinion;
	}
	
	public void setOpinion(java.lang.String value) {
		this.opinion = value;
	}	    	
	public java.lang.String getNextLinkPlantime() {
		return this.nextLinkPlantime;
	}
	
	public void setNextLinkPlantime(java.lang.String value) {
		this.nextLinkPlantime = value;
	}	    	
	public java.lang.Long getProcInstIdBegin() {
		return this.procInstIdBegin;
	}
	
	public void setProcInstIdBegin(java.lang.Long value) {
		this.procInstIdBegin = value;
	}
	
	public java.lang.Long getProcInstIdEnd() {
		return this.procInstIdEnd;
	}
	
	public void setProcInstIdEnd(java.lang.Long value) {
		this.procInstIdEnd = value;
	}
	public java.lang.Long getLastOrderIdBegin() {
		return this.lastOrderIdBegin;
	}
	
	public void setLastOrderIdBegin(java.lang.Long value) {
		this.lastOrderIdBegin = value;
	}
	
	public java.lang.Long getLastOrderIdEnd() {
		return this.lastOrderIdEnd;
	}
	
	public void setLastOrderIdEnd(java.lang.Long value) {
		this.lastOrderIdEnd = value;
	}
	public Long getRemineTimeBegin() {
		return this.remineTimeBegin;
	}
	
	public void setRemineTimeBegin(Long value) {
		this.remineTimeBegin = value;
	}
	
	public Long getRemineTimeEnd() {
		return this.remineTimeEnd;
	}
	
	public void setRemineTimeEnd(Long value) {
		this.remineTimeEnd = value;
	}
	public java.lang.String getPhaseId() {
		return this.phaseId;
	}
	
	public void setPhaseId(java.lang.String value) {
		this.phaseId = value;
	}	    	
	public Long getTimeConsumBegin() {
		return this.timeConsumBegin;
	}
	
	public void setTimeConsumBegin(Long value) {
		this.timeConsumBegin = value;
	}
	
	public Long getTimeConsumEnd() {
		return this.timeConsumEnd;
	}
	
	public void setTimeConsumEnd(Long value) {
		this.timeConsumEnd = value;
	}
	public Long getObjIdBegin() {
		return this.objIdBegin;
	}
	
	public void setObjIdBegin(Long value) {
		this.objIdBegin = value;
	}
	
	public Long getObjIdEnd() {
		return this.objIdEnd;
	}
	
	public void setObjIdEnd(Long value) {
		this.objIdEnd = value;
	}
	public java.lang.String getObjTag() {
		return this.objTag;
	}
	
	public void setObjTag(java.lang.String value) {
		this.objTag = value;
	}	    	
	public Long getApplyStaffIdBegin() {
		return this.applyStaffIdBegin;
	}
	
	public void setApplyStaffIdBegin(Long value) {
		this.applyStaffIdBegin = value;
	}
	
	public Long getApplyStaffIdEnd() {
		return this.applyStaffIdEnd;
	}
	
	public void setApplyStaffIdEnd(Long value) {
		this.applyStaffIdEnd = value;
	}
	public java.lang.String getApplyStaffName() {
		return this.applyStaffName;
	}
	
	public void setApplyStaffName(java.lang.String value) {
		this.applyStaffName = value;
	}	    	
	public java.lang.String getApplyStaffCode() {
		return this.applyStaffCode;
	}
	
	public void setApplyStaffCode(java.lang.String value) {
		this.applyStaffCode = value;
	}	    	
	
	public Integer getPageNo() {
		return this.pageNo;
	}
	
	public Integer getPageSize() {
		return this.pageSize;
	}
	
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}

