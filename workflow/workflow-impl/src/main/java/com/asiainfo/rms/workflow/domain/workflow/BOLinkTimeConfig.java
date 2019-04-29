package com.asiainfo.rms.workflow.domain.workflow;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ALM_LINK_TIME_CONFIG")
public class BOLinkTimeConfig {
	/**
	 * 
	 */
	private static final long serialVersionUID = 785560655825080111L;

	@Id@Column(name="ALTC_ID",length=12)
	@GeneratedValue(generator="linkTimeConfigSeq",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(sequenceName="ALM_WORKFLOW$SEQ",name="linkTimeConfigSeq",initialValue=1,allocationSize=1)
	private Long altcId;
	
	@Column(name="LINK_NO",length=32)
	private String linkNo;
	
	@Column(name="CODING_TYPE",length=2)
	private String codingType;
	
	@Column(name="TIME_CONU",length=10)
	private String timeConu;

	public Long getAltcId() {
		return altcId;
	}

	public void setAltcId(Long altcId) {
		this.altcId = altcId;
	}

	public String getLinkNo() {
		return linkNo;
	}

	public void setLinkNo(String linkNo) {
		this.linkNo = linkNo;
	}

	

	public String getCodingType() {
		return codingType;
	}

	public void setCodingType(String codingType) {
		this.codingType = codingType;
	}

	public String getTimeConu() {
		return timeConu;
	}

	public void setTimeConu(String timeConu) {
		this.timeConu = timeConu;
	}

	
	
	
}
