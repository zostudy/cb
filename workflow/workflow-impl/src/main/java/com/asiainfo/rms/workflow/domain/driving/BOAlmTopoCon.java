package com.asiainfo.rms.workflow.domain.driving;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author 刘超
 *
 */
@Entity @Table(name="ALM_TOPO_CON")
public class BOAlmTopoCon {

	@Id@Column(name="NO",length=15)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String no;
	
	@Column(name="FUN_NO",length=15)
	private String funNo;
	
	@Column(name="COND",length=4000)
	private String cond;

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getFunNo() {
		return funNo;
	}

	public void setFunNo(String funNo) {
		this.funNo = funNo;
	}

	public String getCond() {
		return cond;
	}

	public void setCond(String cond) {
		this.cond = cond;
	}
	
}
