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
@Entity @Table(name="ALM_WORKFLOW_DRIVING")
public class BOAlmWorkflowDriving {

	@Id @Column(name="DRIVING_ID",length=20)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long drivingId;
	
	@Column(name="PASSIVE_POINT",length=1000)
	private String passivePoint;
	
	@Column(name="ACTIVE_POINT",length=1000)
	private String activePoint;
	
	@Column(name="PASSIVE_PROCESS_KEY",length=200)
	private String passiveProcessKey;
	
	@Column(name="ACTIVE_PROCESS_KEY",length=200)
	private String activeProcessKey;
	
	@Column(name="LINK_RELATIVE_PHASE",length=20)
	private Long linkRelativePhase;

	public Long getDrivingId() {
		return drivingId;
	}

	public void setDrivingId(Long drivingId) {
		this.drivingId = drivingId;
	}

	public String getPassivePoint() {
		return passivePoint;
	}

	public void setPassivePoint(String passivePoint) {
		this.passivePoint = passivePoint;
	}

	public String getActivePoint() {
		return activePoint;
	}

	public void setActivePoint(String activePoint) {
		this.activePoint = activePoint;
	}

	public String getPassiveProcessKey() {
		return passiveProcessKey;
	}

	public void setPassiveProcessKey(String passiveProcessKey) {
		this.passiveProcessKey = passiveProcessKey;
	}

	public String getActiveProcessKey() {
		return activeProcessKey;
	}

	public void setActiveProcessKey(String activeProcessKey) {
		this.activeProcessKey = activeProcessKey;
	}

	public Long getLinkRelativePhase() {
		return linkRelativePhase;
	}

	public void setLinkRelativePhase(Long linkRelativePhase) {
		this.linkRelativePhase = linkRelativePhase;
	}
	
}
