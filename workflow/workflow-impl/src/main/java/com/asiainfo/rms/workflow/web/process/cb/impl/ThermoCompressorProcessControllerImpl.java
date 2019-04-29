package com.asiainfo.rms.workflow.web.process.cb.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asiainfo.rms.workflow.dto.common.ExecuteResultDTO;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbThermoCompressorBO;
import com.asiainfo.rms.workflow.mapper.process.cb.AlmCbThermoCompressorMapper;
import com.asiainfo.rms.workflow.service.process.cb.IAlmCbThermoCompressorService;
import com.asiainfo.rms.workflow.dto.process.cb.LaunchThermoCompressorProcessDTO;
import com.asiainfo.rms.workflow.dto.process.cb.ExecuteThermoCompressorProcessDTO;
import com.asiainfo.rms.workflow.dto.process.common.WorkOrderStakeholderDTO;
import com.asiainfo.rms.workflow.web.process.cb.IThermoCompressorProcessController;
import com.asiainfo.rms.workflow.mapper.workflow.StakeholderMapper;
import com.asiainfo.rms.workflow.mapper.workflow.WorkorderMapper;
import com.asiainfo.rms.workflow.bo.process.common.LaunchProcessBO;
import com.asiainfo.rms.workflow.bo.workflow.StakeholderBO;
import com.asiainfo.rms.workflow.bo.workflow.WorkorderBO;
import com.asiainfo.rms.workflow.bo.process.common.ExecuteProcessBO;
import com.asiainfo.rms.workflow.util.ProcessUtil;
import com.asiainfo.rms.workflow.common.constance.ConstDefine;
import com.asiainfo.rms.workflow.common.constance.ThermoCompressorProcessConstDefine;
import com.asiainfo.rms.workflow.common.process.ThermoCompressorProcessTemplates;
import com.asiainfo.rms.workflow.service.api.WorkflowControllerApi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * 热压机流程
 * 
 * @author joker
 */
@Data
@Log4j
@Transactional
@RestController
@AllArgsConstructor
@RequiredArgsConstructor
@Api(tags={ "热压机流程[{404:结束,4003:TCPEnd(热压机流程结束)}]"}, value="热压机流程")
public class ThermoCompressorProcessControllerImpl implements IThermoCompressorProcessController {

	@Autowired
	private WorkflowControllerApi api;
	
	@Autowired
	IAlmCbThermoCompressorService almCbThermoCompressorService;
	
	@Override
	@ApiOperation(value="热压机流程新建工单[新建]", tags={"[{401:开始,4000:TCPStart(热压机流程开始)}]"})
	public ExecuteResultDTO saveFirstOrder(@RequestBody LaunchThermoCompressorProcessDTO launchThermoCompressorProcessDTO) throws Exception {
		log.info("[{401:开始,4000:TCPStart(热压机流程开始)}]");
		log.info("热压机流程新建工单[新建]: " + launchThermoCompressorProcessDTO.toString());
		ExecuteResultDTO executeResult = new ExecuteResultDTO();
		AlmCbThermoCompressorBO almCbThermoCompressorBO = AlmCbThermoCompressorMapper.INSTANCE.dtoToBo(launchThermoCompressorProcessDTO.getAlmCbThermoCompressorDTO());
		try {
			almCbThermoCompressorBO = almCbThermoCompressorService.save(almCbThermoCompressorBO);
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			return executeResult;
		}
		LaunchProcessBO launchProcessBO = null;
		try {
			launchProcessBO = ProcessUtil.assemblyLaunchProcess(launchThermoCompressorProcessDTO.getLaunchProcessDTO(),
					Long.valueOf(almCbThermoCompressorBO.getTcId()), ThermoCompressorProcessConstDefine.TEMPLATE_PATH,
					ThermoCompressorProcessConstDefine.TEMPLATE_KEY, ThermoCompressorProcessConstDefine.OBJ_TYPE,
					ConstDefine.STDHOLDE_TYPE_APPROVAL);
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			return executeResult;
		}
		try {
			api.saveFirstOrder(launchProcessBO);
			executeResult.setCode(1);
			executeResult.setMsg("success");
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return executeResult;
	}
	
	@Override
	@ApiOperation(value="热压机流程启动[新建和启动]", tags={"[{401:开始,4000:TCPStart(热压机流程开始)},{TCPThermoCompressor:[{link_id:4001,link_no:TCPThermoCompressor,name:热压机}]}]"})
	public ExecuteResultDTO launchProcess(@RequestBody LaunchThermoCompressorProcessDTO launchThermoCompressorProcessDTO) throws Exception {
		log.info("[{401:开始,4000:TCPStart(热压机流程开始)},{TCPThermoCompressor:[{link_id:4001,link_no:TCPThermoCompressor,name:热压机}]}]");
		log.info("热压机流程启动[新建和启动]: " + launchThermoCompressorProcessDTO.toString());
		ExecuteResultDTO executeResult = new ExecuteResultDTO();
		AlmCbThermoCompressorBO almCbThermoCompressorBO = AlmCbThermoCompressorMapper.INSTANCE.dtoToBo(launchThermoCompressorProcessDTO.getAlmCbThermoCompressorDTO());
		try {
			almCbThermoCompressorBO = almCbThermoCompressorService.save(almCbThermoCompressorBO);
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			return executeResult;
		}
		LaunchProcessBO launchProcessBO = null;
		try {
			if (CollectionUtils.isEmpty(launchThermoCompressorProcessDTO.getLaunchProcessDTO().getStds())) {
				List<StakeholderBO> result = new ArrayList<StakeholderBO>();
				List<StakeholderBO> startStakeholderBOs = api.queryStakeholder(ThermoCompressorProcessTemplates.LINK_NO_4000, Long.valueOf(ThermoCompressorProcessTemplates.LINK_ID_4000));
				for (StakeholderBO stakeholderBO : startStakeholderBOs) {
					if (stakeholderBO.getStdholderStaffId().compareTo(Long.valueOf(launchThermoCompressorProcessDTO.getLaunchProcessDTO().getStaffId())) == 0) {
						result.add(stakeholderBO);
						break;
					}
				}
				startStakeholderBOs = api.queryStakeholder(ThermoCompressorProcessTemplates.LINK_NO_4001, Long.valueOf(ThermoCompressorProcessTemplates.LINK_ID_4001));
				for (StakeholderBO stakeholderBO : startStakeholderBOs) {
					result.add(stakeholderBO);
				}
				launchThermoCompressorProcessDTO.getLaunchProcessDTO().setStds(StakeholderMapper.INSTANCE.boToDto(result));
			}
			launchProcessBO = ProcessUtil.assemblyLaunchProcess(launchThermoCompressorProcessDTO.getLaunchProcessDTO(),
					Long.valueOf(almCbThermoCompressorBO.getTcId()), ThermoCompressorProcessConstDefine.TEMPLATE_PATH,
					ThermoCompressorProcessConstDefine.TEMPLATE_KEY, ThermoCompressorProcessConstDefine.OBJ_TYPE,
					ConstDefine.STDHOLDE_TYPE_APPROVAL, ThermoCompressorProcessTemplates.LINK_NO_4001);
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			return executeResult;
		}
		try {
			api.createWorkflow(launchProcessBO);
			executeResult.setCode(1);
			executeResult.setMsg("success");
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return executeResult;
	}

	@Override
	@ApiOperation(value="热压机流程启动[保存工单和处理人]", tags={"[{401:开始,4000:TCPStart(热压机流程开始)},{TCPThermoCompressor:[{link_id:4001,link_no:TCPThermoCompressor,name:热压机}]}]"})
	public ExecuteResultDTO wsLaunchProcess(@RequestBody WorkOrderStakeholderDTO workOrderStakeholderDTO) throws Exception {
		log.info("[{401:开始,4000:TCPStart(热压机流程开始)},{TCPThermoCompressor:[{link_id:4001,link_no:TCPThermoCompressor,name:热压机}]}]");
		log.info("热压机流程启动[保存工单和处理人]: " + workOrderStakeholderDTO.toString());
		ExecuteResultDTO executeResult = new ExecuteResultDTO();
		if (workOrderStakeholderDTO != null && workOrderStakeholderDTO.getWorkorderUpdate() != null) {
			try {
				api.updateWorkorder(WorkorderMapper.INSTANCE.dtoToBo(workOrderStakeholderDTO.getWorkorderUpdate()));
			} catch (Exception e) {
				executeResult.setCode(0);
				executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
				log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
				return executeResult;
			}
		}
		if (workOrderStakeholderDTO != null && workOrderStakeholderDTO.getOprStakeholder() != null) {
			try {
				api.oprStakeholder(workOrderStakeholderDTO.getOprStakeholder().getObjId(), ConstDefine.OBJ_TYPE_BAREQ,
						StakeholderMapper.INSTANCE
								.dtoToBo(workOrderStakeholderDTO.getOprStakeholder().getStakeholderOprs()));
			} catch (Exception e) {
				executeResult.setCode(0);
				executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
				log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
				return executeResult;
			}
		}
		executeResult.setCode(1);
		executeResult.setMsg("success");
		return executeResult;
	}
	
	@Override
	@ApiOperation(value="热压机[回单]", tags={"[{402:热压,4001:TCPThermoCompressor(热压机)},{TCPAddBoard:[{link_id:4005,link_no:TCPAddBoard,name:加板}]},{TCPDestiny:[{link_id:4002,link_no:TCPDestiny,name:定数}]},{TCPReduceBoard:[{link_id:4004,link_no:TCPReduceBoard,name:减板}]}]"})
	public ExecuteResultDTO tCPThermoCompressor(@RequestBody ExecuteThermoCompressorProcessDTO executeThermoCompressorProcessDTO) throws Exception {
		log.info("[{402:热压,4001:TCPThermoCompressor(热压机)},{TCPAddBoard:[{link_id:4005,link_no:TCPAddBoard,name:加板}]},{TCPDestiny:[{link_id:4002,link_no:TCPDestiny,name:定数}]},{TCPReduceBoard:[{link_id:4004,link_no:TCPReduceBoard,name:减板}]}]");
		log.info("热压机流程.热压机[回单]: " + executeThermoCompressorProcessDTO.toString());
		ExecuteResultDTO executeResult = new ExecuteResultDTO();
		AlmCbThermoCompressorBO almCbThermoCompressorBO = AlmCbThermoCompressorMapper.INSTANCE.dtoToBo(executeThermoCompressorProcessDTO.getAlmCbThermoCompressorDTO());
		try {
			almCbThermoCompressorBO = almCbThermoCompressorService.save(almCbThermoCompressorBO);
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			return executeResult;
		}
		ExecuteProcessBO executeProcessBO = null;
		try {
			if (CollectionUtils.isEmpty(executeThermoCompressorProcessDTO.getExecuteProcessDTO().getStds())) {
				List<StakeholderBO> result = new ArrayList<StakeholderBO>();
				List<StakeholderBO> startStakeholderBOs = null;
				if (executeThermoCompressorProcessDTO.getExecuteProcessDTO().getDirection().equals(ThermoCompressorProcessTemplates.LINK_NO_4002)) {
					startStakeholderBOs = api.queryStakeholder(ThermoCompressorProcessTemplates.LINK_NO_4002, Long.valueOf(ThermoCompressorProcessTemplates.LINK_ID_4002));
				} else if (executeThermoCompressorProcessDTO.getExecuteProcessDTO().getDirection().equals(ThermoCompressorProcessTemplates.LINK_NO_4004)) {
					startStakeholderBOs = api.queryStakeholder(ThermoCompressorProcessTemplates.LINK_NO_4004, Long.valueOf(ThermoCompressorProcessTemplates.LINK_ID_4004));
				} else if (executeThermoCompressorProcessDTO.getExecuteProcessDTO().getDirection().equals(ThermoCompressorProcessTemplates.LINK_NO_4005)) {
					startStakeholderBOs = api.queryStakeholder(ThermoCompressorProcessTemplates.LINK_NO_4005, Long.valueOf(ThermoCompressorProcessTemplates.LINK_ID_4005));
				}
				for (StakeholderBO stakeholderBO : startStakeholderBOs) {
					result.add(stakeholderBO);
				}
				executeThermoCompressorProcessDTO.getExecuteProcessDTO().setStds(StakeholderMapper.INSTANCE.boToDto(result));
			}
			executeProcessBO = ProcessUtil.assemblyExecuteProcess(executeThermoCompressorProcessDTO.getExecuteProcessDTO(),
					Long.valueOf(almCbThermoCompressorBO.getTcId()), ThermoCompressorProcessConstDefine.TEMPLATE_PATH,
					ThermoCompressorProcessConstDefine.TEMPLATE_KEY, ThermoCompressorProcessConstDefine.OBJ_TYPE,
					ConstDefine.STDHOLDE_TYPE_APPROVAL, "Y");
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			return executeResult;
		}
		try {
			if (StringUtils.isBlank(executeProcessBO.getObjectId())) {
				executeProcessBO.setObjectId(String.valueOf(almCbThermoCompressorBO.getTcId()));
			}
			if (StringUtils.isBlank(executeProcessBO.getObjectTypeId())) {
				executeProcessBO.setObjectTypeId(ThermoCompressorProcessConstDefine.OBJ_TYPE);
			}
			if (executeThermoCompressorProcessDTO.getExecuteProcessDTO().getDirection().equals(ThermoCompressorProcessTemplates.LINK_NO_4002)) {
				api.finishUserTask(almCbThermoCompressorBO.getApplyStaffId(), executeProcessBO, executeThermoCompressorProcessDTO.getAlmCbFlowDTOs(), Long.valueOf(ThermoCompressorProcessTemplates.LINK_ID_4002), ThermoCompressorProcessTemplates.LINK_NO_4002);
			} else if (executeThermoCompressorProcessDTO.getExecuteProcessDTO().getDirection().equals(ThermoCompressorProcessTemplates.LINK_NO_4004)) {
				api.finishUserTask(almCbThermoCompressorBO.getApplyStaffId(), executeProcessBO, executeThermoCompressorProcessDTO.getAlmCbFlowDTOs(), Long.valueOf(ThermoCompressorProcessTemplates.LINK_ID_4004), ThermoCompressorProcessTemplates.LINK_NO_4004);
			} else if (executeThermoCompressorProcessDTO.getExecuteProcessDTO().getDirection().equals(ThermoCompressorProcessTemplates.LINK_NO_4005)) {
				api.finishUserTask(almCbThermoCompressorBO.getApplyStaffId(), executeProcessBO, executeThermoCompressorProcessDTO.getAlmCbFlowDTOs(), Long.valueOf(ThermoCompressorProcessTemplates.LINK_ID_4005), ThermoCompressorProcessTemplates.LINK_NO_4005);
			} 
			executeResult.setCode(1);
			executeResult.setMsg("success");
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		try {
			List<WorkorderBO> workOrderBOs = api.queryWorkorders(almCbThermoCompressorBO.getTcId(), Long.valueOf(ThermoCompressorProcessTemplates.LINK_ID_4001)); 
			for (WorkorderBO workorderBO : workOrderBOs) {
				if (workorderBO.getStatus().equals(ConstDefine.STDHOLDE_TYPE_APPROVAL)) {
					executeThermoCompressorProcessDTO.getExecuteProcessDTO().setOrderId(workorderBO.getOrderId());
					executeProcessBO = ProcessUtil.assemblyExecuteProcess(executeThermoCompressorProcessDTO.getExecuteProcessDTO(),
							Long.valueOf(almCbThermoCompressorBO.getTcId()), ThermoCompressorProcessConstDefine.TEMPLATE_PATH,
							ThermoCompressorProcessConstDefine.TEMPLATE_KEY, ThermoCompressorProcessConstDefine.OBJ_TYPE,
							ConstDefine.STDHOLDE_TYPE_APPROVAL);
					executeProcessBO.setOpinion("自动完成");
					api.finishUserTask(executeProcessBO);
				}
			}
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			return executeResult;
		}
		return executeResult;
	}
	
	@Override
	@ApiOperation(value="热压机[保存工单和处理人]", tags={"[{402:热压,4001:TCPThermoCompressor(热压机)},{TCPAddBoard:[{link_id:4005,link_no:TCPAddBoard,name:加板}]},{TCPDestiny:[{link_id:4002,link_no:TCPDestiny,name:定数}]},{TCPReduceBoard:[{link_id:4004,link_no:TCPReduceBoard,name:减板}]}]"})
	public ExecuteResultDTO wsTCPThermoCompressor(@RequestBody WorkOrderStakeholderDTO workOrderStakeholderDTO) throws Exception {
		log.info("[{402:热压,4001:TCPThermoCompressor(热压机)},{TCPAddBoard:[{link_id:4005,link_no:TCPAddBoard,name:加板}]},{TCPDestiny:[{link_id:4002,link_no:TCPDestiny,name:定数}]},{TCPReduceBoard:[{link_id:4004,link_no:TCPReduceBoard,name:减板}]}]");
		log.info("热压机流程.热压机[保存工单和处理人]: " + workOrderStakeholderDTO.toString());
		ExecuteResultDTO executeResult = new ExecuteResultDTO();
		if (workOrderStakeholderDTO != null && workOrderStakeholderDTO.getWorkorderUpdate() != null) {
			try {
				api.updateWorkorder(WorkorderMapper.INSTANCE.dtoToBo(workOrderStakeholderDTO.getWorkorderUpdate()));
			} catch (Exception e) {
				executeResult.setCode(0);
				executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
				log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
				return executeResult;
			}
		}
		if (workOrderStakeholderDTO != null && workOrderStakeholderDTO.getOprStakeholder() != null) {
			try {
				api.oprStakeholder(workOrderStakeholderDTO.getOprStakeholder().getObjId(), ConstDefine.OBJ_TYPE_BAREQ,
						StakeholderMapper.INSTANCE
								.dtoToBo(workOrderStakeholderDTO.getOprStakeholder().getStakeholderOprs()));
			} catch (Exception e) {
				executeResult.setCode(0);
				executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
				log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
				return executeResult;
			}
		}
		executeResult.setCode(1);
		executeResult.setMsg("success");
		return executeResult;
	}
	
	@Override
	@ApiOperation(value="定数[回单]", tags={"[{403:定数,4002:TCPDestiny(定数)},{TCPAddBoard:[{link_id:4005,link_no:TCPAddBoard,name:加板}]},{TCPEnd:[{link_id:4003,link_no:TCPEnd,name:热压机流程结束}]},{TCPDestiny:[{link_id:4002,link_no:TCPDestiny,name:定数}]},{TCPReduceBoard:[{link_id:4004,link_no:TCPReduceBoard,name:减板}]}]"})
	public ExecuteResultDTO tCPDestiny(@RequestBody ExecuteThermoCompressorProcessDTO executeThermoCompressorProcessDTO) throws Exception {
		log.info("[{403:定数,4002:TCPDestiny(定数)},{TCPAddBoard:[{link_id:4005,link_no:TCPAddBoard,name:加板}]},{TCPEnd:[{link_id:4003,link_no:TCPEnd,name:热压机流程结束}]},{TCPDestiny:[{link_id:4002,link_no:TCPDestiny,name:定数}]},{TCPReduceBoard:[{link_id:4004,link_no:TCPReduceBoard,name:减板}]}]");
		log.info("热压机流程.定数[回单]: " + executeThermoCompressorProcessDTO.toString());
		ExecuteResultDTO executeResult = new ExecuteResultDTO();
		AlmCbThermoCompressorBO almCbThermoCompressorBO = AlmCbThermoCompressorMapper.INSTANCE.dtoToBo(executeThermoCompressorProcessDTO.getAlmCbThermoCompressorDTO());
		try {
			almCbThermoCompressorBO = almCbThermoCompressorService.save(almCbThermoCompressorBO);
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			return executeResult;
		}
		ExecuteProcessBO executeProcessBO = null;
		try {
			if (CollectionUtils.isEmpty(executeThermoCompressorProcessDTO.getExecuteProcessDTO().getStds())) {
				List<StakeholderBO> result = new ArrayList<StakeholderBO>();
				List<StakeholderBO> startStakeholderBOs = new ArrayList<StakeholderBO>();;
				if (executeThermoCompressorProcessDTO.getExecuteProcessDTO().getDirection().equals(ThermoCompressorProcessTemplates.LINK_NO_4002)) {
					startStakeholderBOs = api.queryStakeholder(ThermoCompressorProcessTemplates.LINK_NO_4002, Long.valueOf(ThermoCompressorProcessTemplates.LINK_ID_4002));
				} else if (executeThermoCompressorProcessDTO.getExecuteProcessDTO().getDirection().equals(ThermoCompressorProcessTemplates.LINK_NO_4004)) {
					startStakeholderBOs = api.queryStakeholder(ThermoCompressorProcessTemplates.LINK_NO_4004, Long.valueOf(ThermoCompressorProcessTemplates.LINK_ID_4004));
				} else if (executeThermoCompressorProcessDTO.getExecuteProcessDTO().getDirection().equals(ThermoCompressorProcessTemplates.LINK_NO_4005)) {
					startStakeholderBOs = api.queryStakeholder(ThermoCompressorProcessTemplates.LINK_NO_4005, Long.valueOf(ThermoCompressorProcessTemplates.LINK_ID_4005));
				}
				for (StakeholderBO stakeholderBO : startStakeholderBOs) {
					result.add(stakeholderBO);
				}
				executeThermoCompressorProcessDTO.getExecuteProcessDTO().setStds(StakeholderMapper.INSTANCE.boToDto(result));
			}
			executeProcessBO = ProcessUtil.assemblyExecuteProcess(executeThermoCompressorProcessDTO.getExecuteProcessDTO(),
					Long.valueOf(almCbThermoCompressorBO.getTcId()), ThermoCompressorProcessConstDefine.TEMPLATE_PATH,
					ThermoCompressorProcessConstDefine.TEMPLATE_KEY, ThermoCompressorProcessConstDefine.OBJ_TYPE,
					ConstDefine.STDHOLDE_TYPE_APPROVAL, ThermoCompressorProcessTemplates.LINK_NO_4002, ThermoCompressorProcessTemplates.LINK_NO_4004, ThermoCompressorProcessTemplates.LINK_NO_4005);
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			return executeResult;
		}
		try {
			if (StringUtils.isBlank(executeProcessBO.getObjectId())) {
				executeProcessBO.setObjectId(String.valueOf(almCbThermoCompressorBO.getTcId()));
			}
			if (StringUtils.isBlank(executeProcessBO.getObjectTypeId())) {
				executeProcessBO.setObjectTypeId(ThermoCompressorProcessConstDefine.OBJ_TYPE);
			}
			if (executeThermoCompressorProcessDTO.getExecuteProcessDTO().getDirection().equals(ThermoCompressorProcessTemplates.LINK_NO_4002)) {
				api.finishUserTask(almCbThermoCompressorBO.getApplyStaffId(), executeProcessBO, executeThermoCompressorProcessDTO.getAlmCbFlowDTOs(), Long.valueOf(ThermoCompressorProcessTemplates.LINK_ID_4002), ThermoCompressorProcessTemplates.LINK_NO_4002);
			} else if (executeThermoCompressorProcessDTO.getExecuteProcessDTO().getDirection().equals(ThermoCompressorProcessTemplates.LINK_NO_4003)) {
				api.finishUserTask(almCbThermoCompressorBO.getApplyStaffId(), executeProcessBO, executeThermoCompressorProcessDTO.getAlmCbFlowDTOs(), Long.valueOf(ThermoCompressorProcessTemplates.LINK_ID_4003), ThermoCompressorProcessTemplates.LINK_NO_4003);
			} else if (executeThermoCompressorProcessDTO.getExecuteProcessDTO().getDirection().equals(ThermoCompressorProcessTemplates.LINK_NO_4004)) {
				api.finishUserTask(almCbThermoCompressorBO.getApplyStaffId(), executeProcessBO, executeThermoCompressorProcessDTO.getAlmCbFlowDTOs(), Long.valueOf(ThermoCompressorProcessTemplates.LINK_ID_4004), ThermoCompressorProcessTemplates.LINK_NO_4004);
			} else if (executeThermoCompressorProcessDTO.getExecuteProcessDTO().getDirection().equals(ThermoCompressorProcessTemplates.LINK_NO_4005)) {
				api.finishUserTask(almCbThermoCompressorBO.getApplyStaffId(), executeProcessBO, executeThermoCompressorProcessDTO.getAlmCbFlowDTOs(), Long.valueOf(ThermoCompressorProcessTemplates.LINK_ID_4005), ThermoCompressorProcessTemplates.LINK_NO_4005);
			} 
			executeResult.setCode(1);
			executeResult.setMsg("success");
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		try {
			List<WorkorderBO> workOrderBOs = api.queryWorkorders(almCbThermoCompressorBO.getTcId(), Long.valueOf(ThermoCompressorProcessTemplates.LINK_ID_4002)); 
			for (WorkorderBO workorderBO : workOrderBOs) {
				if (workorderBO.getStatus().equals(ConstDefine.STDHOLDE_TYPE_APPROVAL)) {
					executeThermoCompressorProcessDTO.getExecuteProcessDTO().setOrderId(workorderBO.getOrderId());
					executeProcessBO = ProcessUtil.assemblyExecuteProcess(executeThermoCompressorProcessDTO.getExecuteProcessDTO(),
							Long.valueOf(almCbThermoCompressorBO.getTcId()), ThermoCompressorProcessConstDefine.TEMPLATE_PATH,
							ThermoCompressorProcessConstDefine.TEMPLATE_KEY, ThermoCompressorProcessConstDefine.OBJ_TYPE,
							ConstDefine.STDHOLDE_TYPE_APPROVAL);
					executeProcessBO.setOpinion("自动完成");
					api.finishUserTask(executeProcessBO);
				}
			}
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			return executeResult;
		}
		return executeResult;
	}
	
	@Override
	@ApiOperation(value="定数[保存工单和处理人]", tags={"[{403:定数,4002:TCPDestiny(定数)},{TCPAddBoard:[{link_id:4005,link_no:TCPAddBoard,name:加板}]},{TCPEnd:[{link_id:4003,link_no:TCPEnd,name:热压机流程结束}]},{TCPDestiny:[{link_id:4002,link_no:TCPDestiny,name:定数}]},{TCPReduceBoard:[{link_id:4004,link_no:TCPReduceBoard,name:减板}]}]"})
	public ExecuteResultDTO wsTCPDestiny(@RequestBody WorkOrderStakeholderDTO workOrderStakeholderDTO) throws Exception {
		log.info("[{403:定数,4002:TCPDestiny(定数)},{TCPAddBoard:[{link_id:4005,link_no:TCPAddBoard,name:加板}]},{TCPEnd:[{link_id:4003,link_no:TCPEnd,name:热压机流程结束}]},{TCPDestiny:[{link_id:4002,link_no:TCPDestiny,name:定数}]},{TCPReduceBoard:[{link_id:4004,link_no:TCPReduceBoard,name:减板}]}]");
		log.info("热压机流程.定数[保存工单和处理人]: " + workOrderStakeholderDTO.toString());
		ExecuteResultDTO executeResult = new ExecuteResultDTO();
		if (workOrderStakeholderDTO != null && workOrderStakeholderDTO.getWorkorderUpdate() != null) {
			try {
				api.updateWorkorder(WorkorderMapper.INSTANCE.dtoToBo(workOrderStakeholderDTO.getWorkorderUpdate()));
			} catch (Exception e) {
				executeResult.setCode(0);
				executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
				log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
				return executeResult;
			}
		}
		if (workOrderStakeholderDTO != null && workOrderStakeholderDTO.getOprStakeholder() != null) {
			try {
				api.oprStakeholder(workOrderStakeholderDTO.getOprStakeholder().getObjId(), ConstDefine.OBJ_TYPE_BAREQ,
						StakeholderMapper.INSTANCE
								.dtoToBo(workOrderStakeholderDTO.getOprStakeholder().getStakeholderOprs()));
			} catch (Exception e) {
				executeResult.setCode(0);
				executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
				log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
				return executeResult;
			}
		}
		executeResult.setCode(1);
		executeResult.setMsg("success");
		return executeResult;
	}
	
	@Override
	@ApiOperation(value="减板[回单]", tags={"[{405:减板,4004:TCPReduceBoard(减板)},{TCPThermoCompressor:[{link_id:4001,link_no:TCPThermoCompressor,name:热压机}]},{TCPDestiny:[{link_id:4002,link_no:TCPDestiny,name:定数}]}]"})
	public ExecuteResultDTO tCPReduceBoard(@RequestBody ExecuteThermoCompressorProcessDTO executeThermoCompressorProcessDTO) throws Exception {
		log.info("[{405:减板,4004:TCPReduceBoard(减板)},{TCPThermoCompressor:[{link_id:4001,link_no:TCPThermoCompressor,name:热压机}]},{TCPDestiny:[{link_id:4002,link_no:TCPDestiny,name:定数}]}]");
		log.info("热压机流程.减板[回单]: " + executeThermoCompressorProcessDTO.toString());
		ExecuteResultDTO executeResult = new ExecuteResultDTO();
		AlmCbThermoCompressorBO almCbThermoCompressorBO = AlmCbThermoCompressorMapper.INSTANCE.dtoToBo(executeThermoCompressorProcessDTO.getAlmCbThermoCompressorDTO());
		try {
			almCbThermoCompressorBO = almCbThermoCompressorService.save(almCbThermoCompressorBO);
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			return executeResult;
		}
		ExecuteProcessBO executeProcessBO = null;
		try {
			if (CollectionUtils.isEmpty(executeThermoCompressorProcessDTO.getExecuteProcessDTO().getStds())) {
				List<StakeholderBO> result = new ArrayList<StakeholderBO>();
				List<StakeholderBO> startStakeholderBOs = null;
				if (executeThermoCompressorProcessDTO.getExecuteProcessDTO().getDirection().equals(ThermoCompressorProcessTemplates.LINK_NO_4001)) {
					startStakeholderBOs = api.queryStakeholder(ThermoCompressorProcessTemplates.LINK_NO_4001, Long.valueOf(ThermoCompressorProcessTemplates.LINK_ID_4001));
				} else if (executeThermoCompressorProcessDTO.getExecuteProcessDTO().getDirection().equals(ThermoCompressorProcessTemplates.LINK_NO_4002)) {
					startStakeholderBOs = api.queryStakeholder(ThermoCompressorProcessTemplates.LINK_NO_4002, Long.valueOf(ThermoCompressorProcessTemplates.LINK_ID_4002));
				}
				for (StakeholderBO stakeholderBO : startStakeholderBOs) {
					result.add(stakeholderBO);
				}
				executeThermoCompressorProcessDTO.getExecuteProcessDTO().setStds(StakeholderMapper.INSTANCE.boToDto(result));
			}
			executeProcessBO = ProcessUtil.assemblyExecuteProcess(executeThermoCompressorProcessDTO.getExecuteProcessDTO(),
					Long.valueOf(almCbThermoCompressorBO.getTcId()), ThermoCompressorProcessConstDefine.TEMPLATE_PATH,
					ThermoCompressorProcessConstDefine.TEMPLATE_KEY, ThermoCompressorProcessConstDefine.OBJ_TYPE,
					ConstDefine.STDHOLDE_TYPE_APPROVAL, "Y");
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			return executeResult;
		}
		try {
			if (StringUtils.isBlank(executeProcessBO.getObjectId())) {
				executeProcessBO.setObjectId(String.valueOf(almCbThermoCompressorBO.getTcId()));
			}
			if (StringUtils.isBlank(executeProcessBO.getObjectTypeId())) {
				executeProcessBO.setObjectTypeId(ThermoCompressorProcessConstDefine.OBJ_TYPE);
			}
			if (executeThermoCompressorProcessDTO.getExecuteProcessDTO().getDirection().equals(ThermoCompressorProcessTemplates.LINK_NO_4001)) {
				api.finishUserTask(almCbThermoCompressorBO.getApplyStaffId(), executeProcessBO, executeThermoCompressorProcessDTO.getAlmCbFlowDTOs(), Long.valueOf(ThermoCompressorProcessTemplates.LINK_ID_4001), ThermoCompressorProcessTemplates.LINK_NO_4001);
			} else if (executeThermoCompressorProcessDTO.getExecuteProcessDTO().getDirection().equals(ThermoCompressorProcessTemplates.LINK_NO_4002)) {
				api.finishUserTask(almCbThermoCompressorBO.getApplyStaffId(), executeProcessBO, executeThermoCompressorProcessDTO.getAlmCbFlowDTOs(), Long.valueOf(ThermoCompressorProcessTemplates.LINK_ID_4002), ThermoCompressorProcessTemplates.LINK_NO_4002);
			}
			executeResult.setCode(1);
			executeResult.setMsg("success");
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		try {
			List<WorkorderBO> workOrderBOs = api.queryWorkorders(almCbThermoCompressorBO.getTcId(), Long.valueOf(ThermoCompressorProcessTemplates.LINK_ID_4004)); 
			for (WorkorderBO workorderBO : workOrderBOs) {
				if (workorderBO.getStatus().equals(ConstDefine.STDHOLDE_TYPE_APPROVAL)) {
					executeThermoCompressorProcessDTO.getExecuteProcessDTO().setOrderId(workorderBO.getOrderId());
					executeProcessBO = ProcessUtil.assemblyExecuteProcess(executeThermoCompressorProcessDTO.getExecuteProcessDTO(),
							Long.valueOf(almCbThermoCompressorBO.getTcId()), ThermoCompressorProcessConstDefine.TEMPLATE_PATH,
							ThermoCompressorProcessConstDefine.TEMPLATE_KEY, ThermoCompressorProcessConstDefine.OBJ_TYPE,
							ConstDefine.STDHOLDE_TYPE_APPROVAL);
					executeProcessBO.setOpinion("自动完成");
					api.finishUserTask(executeProcessBO);
				}
			}
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			return executeResult;
		}
		return executeResult;
	}
	
	@Override
	@ApiOperation(value="减板[保存工单和处理人]", tags={"[{405:减板,4004:TCPReduceBoard(减板)},{TCPThermoCompressor:[{link_id:4001,link_no:TCPThermoCompressor,name:热压机}]},{TCPDestiny:[{link_id:4002,link_no:TCPDestiny,name:定数}]}]"})
	public ExecuteResultDTO wsTCPReduceBoard(@RequestBody WorkOrderStakeholderDTO workOrderStakeholderDTO) throws Exception {
		log.info("[{405:减板,4004:TCPReduceBoard(减板)},{TCPThermoCompressor:[{link_id:4001,link_no:TCPThermoCompressor,name:热压机}]},{TCPDestiny:[{link_id:4002,link_no:TCPDestiny,name:定数}]}]");
		log.info("热压机流程.减板[保存工单和处理人]: " + workOrderStakeholderDTO.toString());
		ExecuteResultDTO executeResult = new ExecuteResultDTO();
		if (workOrderStakeholderDTO != null && workOrderStakeholderDTO.getWorkorderUpdate() != null) {
			try {
				api.updateWorkorder(WorkorderMapper.INSTANCE.dtoToBo(workOrderStakeholderDTO.getWorkorderUpdate()));
			} catch (Exception e) {
				executeResult.setCode(0);
				executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
				log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
				return executeResult;
			}
		}
		if (workOrderStakeholderDTO != null && workOrderStakeholderDTO.getOprStakeholder() != null) {
			try {
				api.oprStakeholder(workOrderStakeholderDTO.getOprStakeholder().getObjId(), ConstDefine.OBJ_TYPE_BAREQ,
						StakeholderMapper.INSTANCE
								.dtoToBo(workOrderStakeholderDTO.getOprStakeholder().getStakeholderOprs()));
			} catch (Exception e) {
				executeResult.setCode(0);
				executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
				log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
				return executeResult;
			}
		}
		executeResult.setCode(1);
		executeResult.setMsg("success");
		return executeResult;
	}
	
	@Override
	@ApiOperation(value="加板[回单]", tags={"[{406:加板,4005:TCPAddBoard(加板)},{TCPThermoCompressor:[{link_id:4001,link_no:TCPThermoCompressor,name:热压机}]},{TCPDestiny:[{link_id:4002,link_no:TCPDestiny,name:定数}]}]"})
	public ExecuteResultDTO tCPAddBoard(@RequestBody ExecuteThermoCompressorProcessDTO executeThermoCompressorProcessDTO) throws Exception {
		log.info("[{406:加板,4005:TCPAddBoard(加板)},{TCPThermoCompressor:[{link_id:4001,link_no:TCPThermoCompressor,name:热压机}]},{TCPDestiny:[{link_id:4002,link_no:TCPDestiny,name:定数}]}]");
		log.info("热压机流程.加板[回单]: " + executeThermoCompressorProcessDTO.toString());
		ExecuteResultDTO executeResult = new ExecuteResultDTO();
		AlmCbThermoCompressorBO almCbThermoCompressorBO = AlmCbThermoCompressorMapper.INSTANCE.dtoToBo(executeThermoCompressorProcessDTO.getAlmCbThermoCompressorDTO());
		try {
			almCbThermoCompressorBO = almCbThermoCompressorService.save(almCbThermoCompressorBO);
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			return executeResult;
		}
		ExecuteProcessBO executeProcessBO = null;
		try {
			if (CollectionUtils.isEmpty(executeThermoCompressorProcessDTO.getExecuteProcessDTO().getStds())) {
				List<StakeholderBO> result = new ArrayList<StakeholderBO>();
				List<StakeholderBO> startStakeholderBOs = null;
				if (executeThermoCompressorProcessDTO.getExecuteProcessDTO().getDirection().equals(ThermoCompressorProcessTemplates.LINK_NO_4001)) {
					startStakeholderBOs = api.queryStakeholder(ThermoCompressorProcessTemplates.LINK_NO_4001, Long.valueOf(ThermoCompressorProcessTemplates.LINK_ID_4001));
				} else if (executeThermoCompressorProcessDTO.getExecuteProcessDTO().getDirection().equals(ThermoCompressorProcessTemplates.LINK_NO_4002)) {
					startStakeholderBOs = api.queryStakeholder(ThermoCompressorProcessTemplates.LINK_NO_4002, Long.valueOf(ThermoCompressorProcessTemplates.LINK_ID_4002));
				}
				for (StakeholderBO stakeholderBO : startStakeholderBOs) {
					result.add(stakeholderBO);
				}
				executeThermoCompressorProcessDTO.getExecuteProcessDTO().setStds(StakeholderMapper.INSTANCE.boToDto(result));
			}
			executeProcessBO = ProcessUtil.assemblyExecuteProcess(executeThermoCompressorProcessDTO.getExecuteProcessDTO(),
					Long.valueOf(almCbThermoCompressorBO.getTcId()), ThermoCompressorProcessConstDefine.TEMPLATE_PATH,
					ThermoCompressorProcessConstDefine.TEMPLATE_KEY, ThermoCompressorProcessConstDefine.OBJ_TYPE,
					ConstDefine.STDHOLDE_TYPE_APPROVAL, "Y");
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			return executeResult;
		}
		try {
			if (StringUtils.isBlank(executeProcessBO.getObjectId())) {
				executeProcessBO.setObjectId(String.valueOf(almCbThermoCompressorBO.getTcId()));
			}
			if (StringUtils.isBlank(executeProcessBO.getObjectTypeId())) {
				executeProcessBO.setObjectTypeId(ThermoCompressorProcessConstDefine.OBJ_TYPE);
			}
			if (executeThermoCompressorProcessDTO.getExecuteProcessDTO().getDirection().equals(ThermoCompressorProcessTemplates.LINK_NO_4001)) {
				api.finishUserTask(almCbThermoCompressorBO.getApplyStaffId(), executeProcessBO, executeThermoCompressorProcessDTO.getAlmCbFlowDTOs(), Long.valueOf(ThermoCompressorProcessTemplates.LINK_ID_4001), ThermoCompressorProcessTemplates.LINK_NO_4001);
			} else if (executeThermoCompressorProcessDTO.getExecuteProcessDTO().getDirection().equals(ThermoCompressorProcessTemplates.LINK_NO_4002)) {
				api.finishUserTask(almCbThermoCompressorBO.getApplyStaffId(), executeProcessBO, executeThermoCompressorProcessDTO.getAlmCbFlowDTOs(), Long.valueOf(ThermoCompressorProcessTemplates.LINK_ID_4002), ThermoCompressorProcessTemplates.LINK_NO_4002);
			}
			executeResult.setCode(1);
			executeResult.setMsg("success");
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		try {
			List<WorkorderBO> workOrderBOs = api.queryWorkorders(almCbThermoCompressorBO.getTcId(), Long.valueOf(ThermoCompressorProcessTemplates.LINK_ID_4005)); 
			for (WorkorderBO workorderBO : workOrderBOs) {
				if (workorderBO.getStatus().equals(ConstDefine.STDHOLDE_TYPE_APPROVAL)) {
					executeThermoCompressorProcessDTO.getExecuteProcessDTO().setOrderId(workorderBO.getOrderId());
					executeProcessBO = ProcessUtil.assemblyExecuteProcess(executeThermoCompressorProcessDTO.getExecuteProcessDTO(),
							Long.valueOf(almCbThermoCompressorBO.getTcId()), ThermoCompressorProcessConstDefine.TEMPLATE_PATH,
							ThermoCompressorProcessConstDefine.TEMPLATE_KEY, ThermoCompressorProcessConstDefine.OBJ_TYPE,
							ConstDefine.STDHOLDE_TYPE_APPROVAL);
					executeProcessBO.setOpinion("自动完成");
					api.finishUserTask(executeProcessBO);
				}
			}
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			return executeResult;
		}
		return executeResult;
	}
	
	@Override
	@ApiOperation(value="加板[保存工单和处理人]", tags={"[{406:加板,4005:TCPAddBoard(加板)},{TCPThermoCompressor:[{link_id:4001,link_no:TCPThermoCompressor,name:热压机}]},{TCPDestiny:[{link_id:4002,link_no:TCPDestiny,name:定数}]}]"})
	public ExecuteResultDTO wsTCPAddBoard(@RequestBody WorkOrderStakeholderDTO workOrderStakeholderDTO) throws Exception {
		log.info("[{406:加板,4005:TCPAddBoard(加板)},{TCPThermoCompressor:[{link_id:4001,link_no:TCPThermoCompressor,name:热压机}]},{TCPDestiny:[{link_id:4002,link_no:TCPDestiny,name:定数}]}]");
		log.info("热压机流程.加板[保存工单和处理人]: " + workOrderStakeholderDTO.toString());
		ExecuteResultDTO executeResult = new ExecuteResultDTO();
		if (workOrderStakeholderDTO != null && workOrderStakeholderDTO.getWorkorderUpdate() != null) {
			try {
				api.updateWorkorder(WorkorderMapper.INSTANCE.dtoToBo(workOrderStakeholderDTO.getWorkorderUpdate()));
			} catch (Exception e) {
				executeResult.setCode(0);
				executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
				log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
				return executeResult;
			}
		}
		if (workOrderStakeholderDTO != null && workOrderStakeholderDTO.getOprStakeholder() != null) {
			try {
				api.oprStakeholder(workOrderStakeholderDTO.getOprStakeholder().getObjId(), ConstDefine.OBJ_TYPE_BAREQ,
						StakeholderMapper.INSTANCE
								.dtoToBo(workOrderStakeholderDTO.getOprStakeholder().getStakeholderOprs()));
			} catch (Exception e) {
				executeResult.setCode(0);
				executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
				log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
				return executeResult;
			}
		}
		executeResult.setCode(1);
		executeResult.setMsg("success");
		return executeResult;
	}
}

