package com.asiainfo.rms.workflow.listener.cb;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.asiainfo.rms.workflow.listener.baseLinstener.CompleteSignTaskListener;

import lombok.extern.log4j.Log4j;

/**
 * 热压机流程
 * 
 * @author joker
 */
@Log4j
@Transactional(rollbackOn = Exception.class)
@Component("deleteThermoCompressorProcessSignTaskListener")
public class RareSignThermoCompressorTask extends CompleteSignTaskListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void extraMethod(long orderId, String objId, String objType, String methodType) throws Exception {
		if (log.isInfoEnabled()) {
			log.info("后置任务extraMethod:"+orderId+",业务ID:"+objId+",业务类型:"+objType);
		}
	}

}
