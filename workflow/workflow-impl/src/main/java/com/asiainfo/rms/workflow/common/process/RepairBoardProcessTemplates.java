package com.asiainfo.rms.workflow.common.process;

/**
 * 修板流程
 *
 * @author joker
 */
public class RepairBoardProcessTemplates {
	
	/**
	 * 流程: 修板流程</br>
	 * 阶段: 开始</br>
	 */
	public final static Integer PHASE_100_ID = 100;
	
	/**
	 * 流程: 修板流程</br>
	 * 阶段: 修板</br>
	 */
	public final static Integer PHASE_101_ID = 101;
	
	/**
	 * 流程: 修板流程</br>
	 * 阶段: 定数</br>
	 */
	public final static Integer PHASE_102_ID = 102;
	
	/**
	 * 流程: 修板流程</br>
	 * 阶段: 结束</br>
	 */
	public final static Integer PHASE_103_ID = 103;
	
	/**
	 * 流程: 修板流程</br>
	 * 阶段: 减板</br>
	 */
	public final static Integer PHASE_104_ID = 104;
	
	/**
	 * 流程: 修板流程</br>
	 * 阶段: 开始</br>
	 * 环节: 修板流程开始</br>
	 */
	public final static Integer LINK_ID_1000 = 1000;
	
	/**
	 * 流程: 修板流程</br>
	 * 阶段: 开始</br>
	 * 环节: 修板流程开始</br>
	 */
	public final static String LINK_NO_1000 = "RBPStart";
	
	/**
	 * 流程: 修板流程</br>
	 * 阶段: 修板</br>
	 * 环节: 修板</br>
	 */
	public final static Integer LINK_ID_1001 = 1001;
	
	/**
	 * 流程: 修板流程</br>
	 * 阶段: 修板</br>
	 * 环节: 修板</br>
	 */
	public final static String LINK_NO_1001 = "RBPRepairBoard";
	
	/**
	 * 流程: 修板流程</br>
	 * 阶段: 定数</br>
	 * 环节: 定数</br>
	 */
	public final static Integer LINK_ID_1002 = 1002;
	
	/**
	 * 流程: 修板流程</br>
	 * 阶段: 定数</br>
	 * 环节: 定数</br>
	 */
	public final static String LINK_NO_1002 = "RBPDestiny";
	
	/**
	 * 流程: 修板流程</br>
	 * 阶段: 减板</br>
	 * 环节: 减板</br>
	 */
	public final static Integer LINK_ID_1004 = 1004;
	
	/**
	 * 流程: 修板流程</br>
	 * 阶段: 减板</br>
	 * 环节: 减板</br>
	 */
	public final static String LINK_NO_1004 = "RBPReduceBoard";
	
	/**
	 * 流程: 修板流程</br>
	 * 阶段: 结束</br>
	 * 环节: 修板流程结束</br>
	 */
	public final static Integer LINK_ID_1003 = 1003;
	
	/**
	 * 流程: 修板流程</br>
	 * 阶段: 结束</br>
	 * 环节: 修板流程结束</br>
	 */
	public final static String LINK_NO_1003 = "RBPEnd";
	
}