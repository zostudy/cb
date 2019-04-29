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
@Table(name = "ALM_CB_SAW_BOARD")
public class BOAlmCbSawBoard {
	
	// 主键
	private Long sbId;
	// 编码
	@Length(max=225)
	private java.lang.String sbTag;
	// 申请人主键
	
	private Long applyStaffId;
	// 所处环节(link_ID)
	
	private Long curStatus;
	// 需求阶段(PHASE_ID)
	
	private Long curPhase;

	public void setSbId(Long value) {
		this.sbId = value;
	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE,generator="ALM_CB_SAW_BOARD_SEQ")
	@SequenceGenerator(sequenceName="ALM_CB_SAW_BOARD$SEQ",allocationSize=1,name="ALM_CB_SAW_BOARD_SEQ")
	@Column(name = "SB_ID", unique = true, nullable = false, insertable = true, updatable = true, length = 22)
	public Long getSbId() {
		return this.sbId;
	}	    
	
	@Column(name = "SB_TAG", unique = false, nullable = true, insertable = true, updatable = true, length = 225)
	public java.lang.String getSbTag() {
		return this.sbTag;
	}
	
	public void setSbTag(java.lang.String value) {
		this.sbTag = value;
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

