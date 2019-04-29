package com.asiainfo.rms.workflow.common.process;

/**
 * 薪酬流程
 *
 * @author joker
 */
public class SalaryProcessTemplates {
	
	/**
	 * 流程: 薪酬流程</br>
	 * 阶段: 开始</br>
	 */
	public final static Integer PHASE_200_ID = 200;
	
	/**
	 * 流程: 薪酬流程</br>
	 * 阶段: 结束</br>
	 */
	public final static Integer PHASE_201_ID = 201;
	
	/**
	 * 流程: 薪酬流程</br>
	 * 阶段: 薪酬</br>
	 */
	public final static Integer PHASE_202_ID = 202;
	
	/**
	 * 流程: 薪酬流程</br>
	 * 阶段: 开始</br>
	 * 环节: 薪酬流程开始</br>
	 */
	public final static Integer LINK_ID_2000 = 2000;
	
	/**
	 * 流程: 薪酬流程</br>
	 * 阶段: 开始</br>
	 * 环节: 薪酬流程开始</br>
	 */
	public final static String LINK_NO_2000 = "SPStart";
	
	/**
	 * 流程: 薪酬流程</br>
	 * 阶段: 薪酬</br>
	 * 环节: 薪酬</br>
	 */
	public final static Integer LINK_ID_2002 = 2002;
	
	/**
	 * 流程: 薪酬流程</br>
	 * 阶段: 薪酬</br>
	 * 环节: 薪酬</br>
	 */
	public final static String LINK_NO_2002 = "SPSalary";
	
	/**
	 * 流程: 薪酬流程</br>
	 * 阶段: 结束</br>
	 * 环节: 薪酬流程结束</br>
	 */
	public final static Integer LINK_ID_2001 = 2001;
	
	/**
	 * 流程: 薪酬流程</br>
	 * 阶段: 结束</br>
	 * 环节: 薪酬流程结束</br>
	 */
	public final static String LINK_NO_2001 = "SPEnd";
	
}