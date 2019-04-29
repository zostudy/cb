package com.asiainfo.rms.workflow.util;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.asiainfo.rms.workflow.bo.process.common.ExecuteProcessBO;
import com.asiainfo.rms.workflow.bo.process.common.LaunchProcessBO;
import com.asiainfo.rms.workflow.bo.workflow.StakeholderBO;
import com.asiainfo.rms.workflow.dto.process.common.ExecuteProcessDTO;
import com.asiainfo.rms.workflow.dto.process.common.LaunchProcessDTO;
import com.asiainfo.rms.workflow.dto.workflow.StakeholderDTO;
import com.asiainfo.rms.workflow.mapper.process.common.ExecuteProcessMapper;
import com.asiainfo.rms.workflow.mapper.process.common.LaunchProcessMapper;
import com.asiainfo.rms.workflow.mapper.workflow.StakeholderMapper;

import lombok.extern.log4j.Log4j;

@Log4j
public class ProcessUtil {
	
	private static String assemblyStaffid(Iterator<String> idsSet) {
		StringBuffer result = new StringBuffer();
		result.append("<staffId>");
		result.append(idsSet.next());
		result.append("</staffId>");
		return result.toString();
	}

	private static String assemblyStaffids(Iterator<String> idsSet) {
		StringBuffer result = new StringBuffer();
		result.append("<staffList>");
		while(idsSet.hasNext()) {
			result.append("<list>");
			result.append(idsSet.next());
			result.append("</list>");
		}
		result.append("</staffList>");
		return result.toString();
	}
	
	public static String assemblyConds(Map<String, List<String>> groupIds, Map<String, Object> others, String ...signFlag) throws Exception{
		StringBuffer result = new StringBuffer("<conds>");
		if (groupIds != null && !groupIds.isEmpty()) {
			boolean muiltyFlag = false;
			Iterator<String> idsSet = null;
			List<String> signFlagList = null;
			Iterator<String> keys = groupIds.keySet().iterator();
			while (keys.hasNext()) {
				String key = keys.next();
				idsSet = groupIds.get(key).iterator();
				if (signFlag != null && signFlag.length == 1 && !StringUtils.isBlank(signFlag[0]) && signFlag[0].trim().equals("Y")) {// 会签标识
					result.append(assemblyStaffids(idsSet));
				} else {
					if (!muiltyFlag) {
						signFlagList = new ArrayList<String>();
						for(int i = 0; signFlag != null && signFlag.length >= 1 && i < signFlag.length; i++) {
							if (StringUtils.isBlank(signFlag[i])) {
								log.error("第" + (i+ 1) + "个会签标识错误");
								continue;
							}
							signFlagList.add(signFlag[i].trim());
						}
						muiltyFlag = true;
					}
					if (signFlagList.contains(key)) {// 会签
						result.append(assemblyStaffids(idsSet));
					} else {
						if (groupIds.get(key).size() == 1) {// 人工
							result.append(assemblyStaffid(idsSet));
						} else {// 会签
							result.append(assemblyStaffids(idsSet));
						}
					}
				}
			}
		}
		if (others != null && !others.isEmpty()) {
			Set<String> keys = others.keySet();
			Iterator<String> keysIt= keys.iterator();
			String key = null;
			while (keysIt.hasNext()) {
				key = keysIt.next();
				result.append("<" + key + ">");
				result.append(others.get(key) == null ? "" : others.get(key));
				result.append("</" + key + ">");
			}
		}
		result.append("</conds>");
		return result.toString();
	}
	
	public static String assemblyCond(List<StakeholderDTO> stds, Map<String, Object> others, String ...signFlag) throws Exception{
		Map<String, List<String>> groupIds = null;
		List<String> ids = null;
		if (stds != null && !stds.isEmpty()) {
			groupIds = new HashMap<String, List<String>>();
			for (int i = 0; i < stds.size(); i++) {
				if (stds.get(i).getStdholderStaffId() == null) {
					log.error("处理人参数错误, 请传入StdholderStaffId");
					continue;
				}
				if (StringUtils.isBlank(stds.get(i).getLinkNo())) {
					log.error("处理人参数错误, 请传入LinkNo");
					continue;
				}
				if (groupIds.containsKey(stds.get(i).getLinkNo())) {
					ids = groupIds.get(stds.get(i).getLinkNo().trim());
				} else {
					ids = new LinkedList<String>();
				}
				ids.add(String.valueOf(stds.get(i).getStdholderStaffId()));
				groupIds.put(stds.get(i).getLinkNo().trim(), ids);
			}
		}
		return ProcessUtil.assemblyConds(groupIds, others, signFlag);
	}
	
	public static Map<String, Object> analyzeConds(String conds) throws Exception{
		Map<String, Object> result = new HashMap<String, Object>();
		if(conds != null && !"".equals(conds.trim())){
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
			DocumentBuilder builder = factory.newDocumentBuilder(); 
			Document doc = builder.parse(new InputSource(new StringReader(conds)));
			Element root = doc.getDocumentElement();   
			NodeList condList = root.getChildNodes();   
			for(int i = 0; condList.getLength() > i; i++){
				Node condNode = condList.item(i);
				NodeList childlist = condNode.getChildNodes();
				if(condNode.getNodeName().indexOf("List") != -1 || condNode.getNodeName().indexOf("list") != -1){
					List<String> list = new ArrayList<String>();
					for(int j=0;j<childlist.getLength();j++){
						list.add(childlist.item(j).getFirstChild().getNodeValue());
					}
					result.put(condNode.getNodeName(), list);
				}else if(childlist.getLength()==1)
					result.put(condNode.getNodeName(), condNode.getFirstChild().getNodeValue());
			}
		}
		return result;
	}
	

	
	public static String analyzeConds(Map<String, Object> conds) throws Exception{
		StringBuffer result = new StringBuffer("<conds>");
		if(conds != null && !conds.isEmpty()){
			Set<String> keys = conds.keySet();
			for(String key : keys) {
				result.append("<");
				result.append(key);
				result.append(">");
				if (key.indexOf("List") != -1 || key.indexOf("list") != -1) {
					@SuppressWarnings("unchecked")
					List<String> list = (List<String>)conds.get(key);
					for(int j=0;j<list.size();j++){
						result.append("<list>");
						result.append(list.get(j));
						result.append("</list>");
					}
				} else {
					result.append(conds.get(key));
				}
				result.append("</");
				result.append(key);
				result.append(">");
			}
		}
		result.append("</conds>");
		return result.toString();
	}
	
	public static LaunchProcessBO assemblyLaunchProcess(LaunchProcessDTO launchProces, Long objId, String sourcePath, String processKey, String objType, String stdholdeType, String ...signFlag) throws Exception{
		LaunchProcessBO launchProcessBO = LaunchProcessMapper.INSTANCE.dtoToBo(launchProces);
		launchProcessBO.setSourcePath(sourcePath);
		launchProcessBO.setProcessKey(processKey);
		launchProcessBO.setObjectTypeId(objType);
		launchProcessBO.setObjectId(String.valueOf(objId));
		Map<String, Object> resultOfConds = new HashMap<String, Object>();
		// 流程流转方向控制
		resultOfConds.put("verify", launchProcessBO.getDirection());
		// 环节计划完成时间
		resultOfConds.put("plantime", launchProcessBO.getPlantime() != null ? launchProcessBO.getPlantime() : "");
		List<StakeholderDTO> stds = launchProces.getStds();
		List<StakeholderBO> stdBOs = new LinkedList<StakeholderBO>();
		StakeholderBO stakeholderBO = null;
		for (int i = 0; stds != null && stds.size() >=1 && i < stds.size(); i++) {
			stakeholderBO = StakeholderMapper.INSTANCE.dtoToBo(stds.get(i));
			stakeholderBO.setObjId(objId);
			stakeholderBO.setObjType(objType);
			stakeholderBO.setProcessKey(processKey);
			stakeholderBO.setStdholdeType(stdholdeType);
			stdBOs.add(stakeholderBO);
		}
		launchProcessBO.setStds(stdBOs);
		launchProcessBO.setCond(ProcessUtil.assemblyCond(stds, resultOfConds, signFlag));
		return launchProcessBO;
	}
	
	public static ExecuteProcessBO assemblyExecuteProcess(ExecuteProcessDTO executeProces, Long objId, String sourcePath, String processKey, String objType, String stdholdeType, String ...signFlag) throws Exception{
		ExecuteProcessBO executeProcessBO = ExecuteProcessMapper.INSTANCE.dtoToBo(executeProces);
		executeProcessBO.setObjectTypeId(objType);
		executeProcessBO.setObjectId(String.valueOf(objId));
		Map<String, Object> resultOfConds = new HashMap<String, Object>();
		// 流程流转方向控制
		resultOfConds.put("verify", executeProcessBO.getDirection());
		// 环节计划完成时间
		resultOfConds.put("plantime", executeProcessBO.getPlantime() != null ? executeProcessBO.getPlantime() : "");
		List<StakeholderDTO> stds = executeProces.getStds();
		List<StakeholderBO> stdBOs = new LinkedList<StakeholderBO>();
		StakeholderBO stakeholderBO = null;
		for (int i = 0; stds != null && stds.size() >=1 && i < stds.size(); i++) {
			stakeholderBO = StakeholderMapper.INSTANCE.dtoToBo(stds.get(i));
			stakeholderBO.setObjId(objId);
			stakeholderBO.setObjType(objType);
			stakeholderBO.setProcessKey(processKey);
			stakeholderBO.setStdholdeType(stdholdeType);
			stdBOs.add(stakeholderBO);
		}
		executeProcessBO.setStds(stdBOs);
		executeProcessBO.setCond(ProcessUtil.assemblyCond(stds, resultOfConds, signFlag));
		return executeProcessBO;
	}
}
