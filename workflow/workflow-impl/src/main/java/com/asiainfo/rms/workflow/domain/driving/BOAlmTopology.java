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
@Entity @Table(name="ALM_TOPOLOGY")
public class BOAlmTopology {

	@Id @Column(name="NO",length=15)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String no;
	
	@Column(name="FPOINT")
	private Long fpoint; 
	
	@Column(name="TPOINT")
	private Long tpoint;
	
	@Column(name="RESULT",length=4000)
	private String result;
	
	@Column(name="DRIVNOS",length=4000)
	private String drivnos;
	
	@Column(name="DRIVNO_FUN",length=4000)
	private String drivnoFun;
	
	@Column(name="IS_DEF")
	private Long isDef;

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public Long getFpoint() {
		return fpoint;
	}

	public void setFpoint(Long fpoint) {
		this.fpoint = fpoint;
	}

	public Long getTpoint() {
		return tpoint;
	}

	public void setTpoint(Long tpoint) {
		this.tpoint = tpoint;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getDrivnos() {
		return drivnos;
	}

	public void setDrivnos(String drivnos) {
		this.drivnos = drivnos;
	}

	public String getDrivnoFun() {
		return drivnoFun;
	}

	public void setDrivnoFun(String drivnoFun) {
		this.drivnoFun = drivnoFun;
	}

	public Long getIsDef() {
		return isDef;
	}

	public void setIsDef(Long isDef) {
		this.isDef = isDef;
	}
	
}
