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
@Table(name = "ALM_CB_THERMO_COMPRESSOR")
public class BOAlmCbThermoCompressor {
	
	// 主键
	private Long tcId;
	// 编码
	@Length(max=225)
	private java.lang.String tcTag;
	// 申请人主键
	
	private Long applyStaffId;
	// 所处环节(link_ID)
	
	private Long curStatus;
	// 需求阶段(PHASE_ID)
	
	private Long curPhase;

	public void setTcId(Long value) {
		this.tcId = value;
	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE,generator="ALM_CB_THERMO_COMPRESSOR_SEQ")
	@SequenceGenerator(sequenceName="ALM_CB_THERMO_COMPRESSOR$SEQ",allocationSize=1,name="ALM_CB_THERMO_COMPRESSOR_SEQ")
	@Column(name = "TC_ID", unique = true, nullable = false, insertable = true, updatable = true, length = 22)
	public Long getTcId() {
		return this.tcId;
	}	    
	
	@Column(name = "TC_TAG", unique = false, nullable = true, insertable = true, updatable = true, length = 225)
	public java.lang.String getTcTag() {
		return this.tcTag;
	}
	
	public void setTcTag(java.lang.String value) {
		this.tcTag = value;
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

