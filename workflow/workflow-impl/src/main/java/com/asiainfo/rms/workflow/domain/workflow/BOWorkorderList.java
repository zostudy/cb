package com.asiainfo.rms.workflow.domain.workflow;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ALM_WORKORDER_LIST")
public class BOWorkorderList {
	private static final long serialVersionUID = 785560655825080111L;
	@Id@Column(name="ORDER_ID",length=12)
	private Integer orderId;
	@Column(name="OBJ_ID" )
	private Integer objId;
	@Column(name="OBJ_TYPE" )
	private String objType;
	@Column(name="OBJ_TAG" )
	private String objTag;
	@Column(name="OBJ_NAME" )
	private String objName;
	@Column(name="VM_TASK_NAME" )
	private String vmTaskName;
	@Column(name="LINK_NO" )
	private String linkNo;
	@Column(name="LINK_ID" )
	private Integer linkId;
	@Column(name="EXEC_STAFF_ID" )
	private Integer execStaffId;
	@Column(name="CODE" )
	private String code;
	@Column(name="EMPLOYEE_NAME" )
	private String employeeName;
	@Temporal(TemporalType.TIME)
	@Column(name="CREATE_TIME" )
	private Date createTime;
	@Temporal(TemporalType.TIME)
	@Column(name="FINISH_TIME" )
	private Date finishTime;
	@Column(name="ORDER_TYPE" )
	private String orderType;
	@Column(name="COND" )
	private String cond;
	@Column(name="RESULT" )
	private String result;
	@Column(name="STATUS" )
	private String status;
	@Column(name="OPINION" )
	private String opinion;
	@Column(name="NEXT_LINK_PLANTIME" )
	private String nextLinkPlantime;
	@Column(name="LAST_ORDER_ID" )
	private Integer last_orderId;
	@Column(name="ACCRED" )
	private String accred;
	@Column(name="REMINE_TIME" )
	private String remineTime;
	@Column(name="PHASE_ID" )
	private String phaseId;
	@Column(name="CODING_TYPE" )
	private String codingType;
	@Column(name="TIME_CONSUM" )
	private Integer timeConsum;
	@Column(name="SUBMITSTAFFID" )
	private String submitstaffid;
	@Column(name="SUBMITSTAFFNAME" )
	private String submitStaffname;
	@Column(name="RESSTAFFID" )
	private String resstaffid;
	@Column(name="RESSTAFFNAME" )
	private String resStaffname;
	@Temporal(TemporalType.TIME)
	@Column(name="ORDER_DATE" )
	private Date orderDate;
	@Temporal(TemporalType.TIME)
	@Column(name="PROPOSE_DATE" )
	private Date proposeDate;
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getObjId() {
		return objId;
	}
	public void setObjId(Integer objId) {
		this.objId = objId;
	}
	public String getObjType() {
		return objType;
	}
	public void setObjType(String objType) {
		this.objType = objType;
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
	public String getVmTaskName() {
		return vmTaskName;
	}
	public void setVmTaskName(String vmTaskName) {
		this.vmTaskName = vmTaskName;
	}
	public String getLinkNo() {
		return linkNo;
	}
	public void setLinkNo(String linkNo) {
		this.linkNo = linkNo;
	}
	public Integer getLinkId() {
		return linkId;
	}
	public void setLinkId(Integer linkId) {
		this.linkId = linkId;
	}
	public Integer getExecStaffId() {
		return execStaffId;
	}
	public void setExecStaffId(Integer execStaffId) {
		this.execStaffId = execStaffId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getCond() {
		return cond;
	}
	public void setCond(String cond) {
		this.cond = cond;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOpinion() {
		return opinion;
	}
	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	public String getNextLinkPlantime() {
		return nextLinkPlantime;
	}
	public void setNextLinkPlantime(String nextLinkPlantime) {
		this.nextLinkPlantime = nextLinkPlantime;
	}
	public Integer getLast_orderId() {
		return last_orderId;
	}
	public void setLast_orderId(Integer last_orderId) {
		this.last_orderId = last_orderId;
	}
	public String getAccred() {
		return accred;
	}
	public void setAccred(String accred) {
		this.accred = accred;
	}
	public String getRemineTime() {
		return remineTime;
	}
	public void setRemineTime(String remineTime) {
		this.remineTime = remineTime;
	}
	public String getPhaseId() {
		return phaseId;
	}
	public void setPhaseId(String phaseId) {
		this.phaseId = phaseId;
	}
	public String getCodingType() {
		return codingType;
	}
	public void setCodingType(String codingType) {
		this.codingType = codingType;
	}
	public Integer getTimeConsum() {
		return timeConsum;
	}
	public void setTimeConsum(Integer timeConsum) {
		this.timeConsum = timeConsum;
	}
	public String getSubmitstaffname() {
		return submitStaffname;
	}
	public void setSubmitstaffname(String submitStaffname) {
		this.submitStaffname = submitStaffname;
	}
	public String getResStaffname() {
		return resStaffname;
	}
	public void setResstaffname(String resStaffname) {
		this.resStaffname = resStaffname;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Date getProposeDate() {
		return proposeDate;
	}
	public void setProposeDate(Date proposeDate) {
		this.proposeDate = proposeDate;
	}
	
	
}
