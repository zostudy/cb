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
@Entity @Table(name="ALM_TOPO_FUN")
public class BOAlmTopoFun {

	@Id @Column(name="NO",length=15)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String no;
	
	@Column(name="ACTION",length=50)
	private String action;
	
	@Column(name="FUN",length=255)
	private String fun;
	
	@Column(name="SERVID",length=4000)
	private String servId;

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getFun() {
		return fun;
	}

	public void setFun(String fun) {
		this.fun = fun;
	}

	public String getServId() {
		return servId;
	}

	public void setServId(String servId) {
		this.servId = servId;
	}
	
}
