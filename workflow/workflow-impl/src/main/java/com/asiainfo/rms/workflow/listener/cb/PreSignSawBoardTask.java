package com.asiainfo.rms.workflow.listener.cb;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.asiainfo.rms.workflow.bo.workflow.WorkflowBO;
import com.asiainfo.rms.workflow.service.workflow.IAlmWorkflowSV;
import com.asiainfo.rms.workflow.dao.CommonDAO;
import com.asiainfo.rms.workflow.listener.baseLinstener.CreateSignTaskListener;

import lombok.extern.log4j.Log4j;

/**
 * 热压机流程
 * 
 * @author joker
 */
@Log4j
@Transactional(rollbackOn = Exception.class)
@Component("createSawBoardProcessSignTaskListener")
public class PreSignSawBoardTask extends CreateSignTaskListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource(name="workflowSV")
	private IAlmWorkflowSV workflowSV;
	
	@Resource(name="commonDao")
	private CommonDAO dao;
	
	@Override
	public void updateObjCurPhaseAndCurStatus(String objId, String objType, String linkId) throws Exception {
		Map<Integer, Object> param = new HashMap<Integer, Object>();
		param.put(1, new Integer(linkId));
		WorkflowBO workflowBO = workflowSV.getWorkflowByLinkId(Long.valueOf(linkId));
		param.put(2, new Integer(workflowBO.getPhaseId()));
		param.put(3, Long.valueOf(objId));
		String hql = "UPDATE ALM_CB_Saw_Board SET CUR_STATUS=?, CUR_PHASE=? WHERE sb_ID=?";
		log.info("UPDATE ALM_CB_Saw_Board SET CUR_STATUS="+linkId+", CUR_PHASE="+workflowBO.getPhaseId()+" WHERE sb_ID="+objId);
		int count = dao.updateBySql(hql, param);
		log.info("更新条目: " + count);
	}

	@Override
	public void extraMethod(long orderId, String objId, String objType, String methodType) throws Exception {}

}
