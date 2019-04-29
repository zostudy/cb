package com.asiainfo.rms.workflow.domain.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ALM_ASSESS")
public class BOAssess{
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="ASSESS_SEQ")
    @SequenceGenerator(sequenceName="ALM_ASSESS$SEQ",allocationSize=1,name="ASSESS_SEQ")
	@Column(name="ASSESS_ID")
	private Long assessId;
	@Column(name="ORDER_ID")
	private Long orderId;
	@Column(name="TIMELY_RATE")
	private String timelyRate;
	@Column(name="DEVELP_QUAL")
	private Long develpQual;
	@Column(name="DOCU_QUAL")
	private Long docuQual;
	@Column(name="SERV_SATI")
	private Long servSati;
	@Column(name="REQ_ID")
	private Long reqId;
	@Column(name="SATISFACTION")
	private Long satisfaction;
	@Column(name="COMMUNICATE")
	private Long communicate;
	@Column(name="RESPONSE")
	private Long response;
	@Column(name="QULITY")
	private Long qulity;
	public void setAssessId(Long assessId){
	this.assessId=assessId;
	}
	public Long getAssessId(){
		return assessId;
	}
	public void setOrderId(Long orderId){
	this.orderId=orderId;
	}
	public Long getOrderId(){
		return orderId;
	}
	public void setTimelyRate(String timelyRate){
	this.timelyRate=timelyRate;
	}
	public String getTimelyRate(){
		return timelyRate;
	}
	public void setDevelpQual(Long develpQual){
	this.develpQual=develpQual;
	}
	public Long getDevelpQual(){
		return develpQual;
	}
	public void setDocuQual(Long docuQual){
	this.docuQual=docuQual;
	}
	public Long getDocuQual(){
		return docuQual;
	}
	public void setServSati(Long servSati){
	this.servSati=servSati;
	}
	public Long getServSati(){
		return servSati;
	}
	public void setReqId(Long reqId){
	this.reqId=reqId;
	}
	public Long getReqId(){
		return reqId;
	}
	public void setSatisfaction(Long satisfaction){
	this.satisfaction=satisfaction;
	}
	public Long getSatisfaction(){
		return satisfaction;
	}
	public void setCommunicate(Long communicate){
	this.communicate=communicate;
	}
	public Long getCommunicate(){
		return communicate;
	}
	public void setResponse(Long response){
	this.response=response;
	}
	public Long getResponse(){
		return response;
	}
	public void setQulity(Long qulity){
	this.qulity=qulity;
	}
	public Long getQulity(){
		return qulity;
	}
}

