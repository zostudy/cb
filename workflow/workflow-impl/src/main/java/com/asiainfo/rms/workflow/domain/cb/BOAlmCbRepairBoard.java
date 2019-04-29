package com.asiainfo.rms.workflow.domain.cb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

/**
 * 
 * 
 * @author joker
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "ALM_CB_REPAIR_BOARD")
public class BOAlmCbRepairBoard {
	
	// 主键
	private Long rbId;
	// 编码
	@Length(max=225)
	private java.lang.String rbTag;
	// 申请人主键
	
	private Long applyStaffId;
	// 所处环节(link_ID)
	
	private Long curStatus;
	// 需求阶段(PHASE_ID)
	
	private Long curPhase;

	public void setRbId(Long value) {
		this.rbId = value;
	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE,generator="ALM_CB_REPAIR_BOARD_SEQ")
	@SequenceGenerator(sequenceName="ALM_CB_REPAIR_BOARD$SEQ",allocationSize=1,name="ALM_CB_REPAIR_BOARD_SEQ")
	@Column(name = "RB_ID", unique = true, nullable = false, insertable = true, updatable = true, length = 22)
	public Long getRbId() {
		return this.rbId;
	}	    
	
	@Column(name = "RB_TAG", unique = false, nullable = true, insertable = true, updatable = true, length = 225)
	public java.lang.String getRbTag() {
		return this.rbTag;
	}
	
	public void setRbTag(java.lang.String value) {
		this.rbTag = value;
	}
	
	@Column(name = "APPLY_STAFF_ID", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	public Long getApplyStaffId() {
		return this.applyStaffId;
	}
	
	public void setApplyStaffId(Long value) {
		this.applyStaffId = value;
	}
	
	@Column(name = "CUR_STATUS", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	public Long getCurStatus() {
		return this.curStatus;
	}
	
	public void setCurStatus(Long value) {
		this.curStatus = value;
	}
	
	@Column(name = "CUR_PHASE", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	public Long getCurPhase() {
		return this.curPhase;
	}
	
	public void setCurPhase(Long value) {
		this.curPhase = value;
	}
}

