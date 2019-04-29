package com.asiainfo.rms.workflow.common.process;

/**
 * 热压机流程
 *
 * @author joker
 */
public class ThermoCompressorProcessTemplates {
	
	/**
	 * 流程: 热压机流程</br>
	 * 阶段: 开始</br>
	 */
	public final static Integer PHASE_401_ID = 401;
	
	/**
	 * 流程: 热压机流程</br>
	 * 阶段: 热压</br>
	 */
	public final static Integer PHASE_402_ID = 402;
	
	/**
	 * 流程: 热压机流程</br>
	 * 阶段: 定数</br>
	 */
	public final static Integer PHASE_403_ID = 403;
	
	/**
	 * 流程: 热压机流程</br>
	 * 阶段: 结束</br>
	 */
	public final static Integer PHASE_404_ID = 404;
	
	/**
	 * 流程: 热压机流程</br>
	 * 阶段: 减板</br>
	 */
	public final static Integer PHASE_405_ID = 405;
	
	/**
	 * 流程: 热压机流程</br>
	 * 阶段: 加板</br>
	 */
	public final static Integer PHASE_406_ID = 406;
	
	/**
	 * 流程: 热压机流程</br>
	 * 阶段: 开始</br>
	 * 环节: 热压机流程开始</br>
	 */
	public final static Integer LINK_ID_4000 = 4000;
	
	/**
	 * 流程: 热压机流程</br>
	 * 阶段: 开始</br>
	 * 环节: 热压机流程开始</br>
	 */
	public final static String LINK_NO_4000 = "TCPStart";
	
	/**
	 * 流程: 热压机流程</br>
	 * 阶段: 热压</br>
	 * 环节: 热压机</br>
	 */
	public final static Integer LINK_ID_4001 = 4001;
	
	/**
	 * 流程: 热压机流程</br>
	 * 阶段: 热压</br>
	 * 环节: 热压机</br>
	 */
	public final static String LINK_NO_4001 = "TCPThermoCompressor";
	
	/**
	 * 流程: 热压机流程</br>
	 * 阶段: 定数</br>
	 * 环节: 定数</br>
	 */
	public final static Integer LINK_ID_4002 = 4002;
	
	/**
	 * 流程: 热压机流程</br>
	 * 阶段: 定数</br>
	 * 环节: 定数</br>
	 */
	public final static String LINK_NO_4002 = "TCPDestiny";
	
	/**
	 * 流程: 热压机流程</br>
	 * 阶段: 减板</br>
	 * 环节: 减板</br>
	 */
	public final static Integer LINK_ID_4004 = 4004;
	
	/**
	 * 流程: 热压机流程</br>
	 * 阶段: 减板</br>
	 * 环节: 减板</br>
	 */
	public final static String LINK_NO_4004 = "TCPReduceBoard";
	
	/**
	 * 流程: 热压机流程</br>
	 * 阶段: 加板</br>
	 * 环节: 加板</br>
	 */
	public final static Integer LINK_ID_4005 = 4005;
	
	/**
	 * 流程: 热压机流程</br>
	 * 阶段: 加板</br>
	 * 环节: 加板</br>
	 */
	public final static String LINK_NO_4005 = "TCPAddBoard";
	
	/**
	 * 流程: 热压机流程</br>
	 * 阶段: 结束</br>
	 * 环节: 热压机流程结束</br>
	 */
	public final static Integer LINK_ID_4003 = 4003;
	
	/**
	 * 流程: 热压机流程</br>
	 * 阶段: 结束</br>
	 * 环节: 热压机流程结束</br>
	 */
	public final static String LINK_NO_4003 = "TCPEnd";
	
}