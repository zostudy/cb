package com.asiainfo.rms.workflow.common.process;

/**
 * 锯板流程
 *
 * @author joker
 */
public class SawBoardProcessTemplates {
	
	/**
	 * 流程: 锯板流程</br>
	 * 阶段: 开始</br>
	 */
	public final static Integer PHASE_300_ID = 300;
	
	/**
	 * 流程: 锯板流程</br>
	 * 阶段: 锯板</br>
	 */
	public final static Integer PHASE_301_ID = 301;
	
	/**
	 * 流程: 锯板流程</br>
	 * 阶段: 定数</br>
	 */
	public final static Integer PHASE_302_ID = 302;
	
	/**
	 * 流程: 锯板流程</br>
	 * 阶段: 结束</br>
	 */
	public final static Integer PHASE_303_ID = 303;
	
	/**
	 * 流程: 锯板流程</br>
	 * 阶段: 减板</br>
	 */
	public final static Integer PHASE_304_ID = 304;
	
	/**
	 * 流程: 锯板流程</br>
	 * 阶段: 开始</br>
	 * 环节: 锯板流程开始</br>
	 */
	public final static Integer LINK_ID_3000 = 3000;
	
	/**
	 * 流程: 锯板流程</br>
	 * 阶段: 开始</br>
	 * 环节: 锯板流程开始</br>
	 */
	public final static String LINK_NO_3000 = "SBPStart";
	
	/**
	 * 流程: 锯板流程</br>
	 * 阶段: 锯板</br>
	 * 环节: 锯板</br>
	 */
	public final static Integer LINK_ID_3001 = 3001;
	
	/**
	 * 流程: 锯板流程</br>
	 * 阶段: 锯板</br>
	 * 环节: 锯板</br>
	 */
	public final static String LINK_NO_3001 = "SBPSawBoard";
	
	/**
	 * 流程: 锯板流程</br>
	 * 阶段: 定数</br>
	 * 环节: 定数</br>
	 */
	public final static Integer LINK_ID_3002 = 3002;
	
	/**
	 * 流程: 锯板流程</br>
	 * 阶段: 定数</br>
	 * 环节: 定数</br>
	 */
	public final static String LINK_NO_3002 = "SBPDestiny";
	
	/**
	 * 流程: 锯板流程</br>
	 * 阶段: 减板</br>
	 * 环节: 减板</br>
	 */
	public final static Integer LINK_ID_3004 = 3004;
	
	/**
	 * 流程: 锯板流程</br>
	 * 阶段: 减板</br>
	 * 环节: 减板</br>
	 */
	public final static String LINK_NO_3004 = "SBPReduceBoard";
	
	/**
	 * 流程: 锯板流程</br>
	 * 阶段: 结束</br>
	 * 环节: 锯板流程结束</br>
	 */
	public final static Integer LINK_ID_3003 = 3003;
	
	/**
	 * 流程: 锯板流程</br>
	 * 阶段: 结束</br>
	 * 环节: 锯板流程结束</br>
	 */
	public final static String LINK_NO_3003 = "SBPEnd";
	
}