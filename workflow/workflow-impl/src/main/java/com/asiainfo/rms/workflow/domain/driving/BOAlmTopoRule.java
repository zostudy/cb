package com.asiainfo.rms.workflow.domain.driving;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author 刘超
 *
 */
@Entity @Table(name="ALM_TOPO_RULE")
public class BOAlmTopoRule {

	@Id @Column(name="NO",length=15)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String no;
	
	@Column(name="TOPO_NO",length=15)
	private String topoNo;
	
	@Column(name="TOPO_CON_NO",length=15)
	private String topoConNo;
	
	@Column(name="STIME")@Temporal(TemporalType.DATE)
	private Date stime;
	
	@Column(name="ETIME")@Temporal(TemporalType.DATE)
	private Date etime;
	
	@Column(name="DRIV_CON_NO",length=15)
	private String drivConNo;

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getTopoNo() {
		return topoNo;
	}

	public void setTopoNo(String topoNo) {
		this.topoNo = topoNo;
	}

	public String getTopoConNo() {
		return topoConNo;
	}

	public void setTopoConNo(String topoConNo) {
		this.topoConNo = topoConNo;
	}

	public Date getStime() {
		return stime;
	}

	public void setStime(Date stime) {
		this.stime = stime;
	}

	public Date getEtime() {
		return etime;
	}

	public void setEtime(Date etime) {
		this.etime = etime;
	}

	public String getDrivConNo() {
		return drivConNo;
	}

	public void setDrivConNo(String drivConNo) {
		this.drivConNo = drivConNo;
	}
	
}
