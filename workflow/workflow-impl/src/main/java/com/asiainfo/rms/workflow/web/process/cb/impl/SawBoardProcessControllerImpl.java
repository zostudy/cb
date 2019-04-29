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
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbSawBoardBO;
import com.asiainfo.rms.workflow.mapper.process.cb.AlmCbSawBoardMapper;
import com.asiainfo.rms.workflow.service.process.cb.IAlmCbSawBoardService;
import com.asiainfo.rms.workflow.dto.process.cb.LaunchSawBoardProcessDTO;
import com.asiainfo.rms.workflow.dto.process.cb.ExecuteSawBoardProcessDTO;
import com.asiainfo.rms.workflow.dto.process.common.WorkOrderStakeholderDTO;
import com.asiainfo.rms.workflow.web.process.cb.ISawBoardProcessController;
import com.asiainfo.rms.workflow.mapper.workflow.StakeholderMapper;
import com.asiainfo.rms.workflow.mapper.workflow.WorkorderMapper;
import com.asiainfo.rms.workflow.bo.process.common.LaunchProcessBO;
import com.asiainfo.rms.workflow.bo.workflow.StakeholderBO;
import com.asiainfo.rms.workflow.bo.workflow.WorkorderBO;
import com.asiainfo.rms.workflow.bo.process.common.ExecuteProcessBO;
import com.asiainfo.rms.workflow.util.ProcessUtil;
import com.asiainfo.rms.workflow.common.constance.ConstDefine;
import com.asiainfo.rms.workflow.common.constance.SawBoardProcessConstDefine;
import com.asiainfo.rms.workflow.common.process.SawBoardProcessTemplates;
import com.asiainfo.rms.workflow.service.api.WorkflowControllerApi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * 锯板流程
 * 
 * @author joker
 */
@Data
@Log4j
@Transactional
@RestController
@AllArgsConstructor
@RequiredArgsConstructor
@Api(tags={ "锯板流程[{303:结束,3003:SBPEnd(锯板流程结束)}]"}, value="锯板流程")
public class SawBoardProcessControllerImpl implements ISawBoardProcessController {

	@Autowired
	private WorkflowControllerApi api;
	
	@Autowired
	IAlmCbSawBoardService almCbSawBoardService;
	
	@Override
	@ApiOperation(value="锯板流程新建工单[新建]", tags={"[{300:开始,3000:SBPStart(锯板流程开始)}]"})
	public ExecuteResultDTO saveFirstOrder(@RequestBody LaunchSawBoardProcessDTO launchSawBoardProcessDTO) throws Exception {
		log.info("[{300:开始,3000:SBPStart(锯板流程开始)}]");
		log.info("锯板流程新建工单[新建]: " + launchSawBoardProcessDTO.toString());
		ExecuteResultDTO executeResult = new ExecuteResultDTO();
		AlmCbSawBoardBO almCbSawBoardBO = AlmCbSawBoardMapper.INSTANCE.dtoToBo(launchSawBoardProcessDTO.getAlmCbSawBoardDTO());
		try {
			almCbSawBoardBO = almCbSawBoardService.save(almCbSawBoardBO);
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			return executeResult;
		}
		LaunchProcessBO launchProcessBO = null;
		try {
			launchProcessBO = ProcessUtil.assemblyLaunchProcess(launchSawBoardProcessDTO.getLaunchProcessDTO(),
					Long.valueOf(almCbSawBoardBO.getSbId()), SawBoardProcessConstDefine.TEMPLATE_PATH,
					SawBoardProcessConstDefine.TEMPLATE_KEY, SawBoardProcessConstDefine.OBJ_TYPE,
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
	@ApiOperation(value="锯板流程启动[新建和启动]", tags={"[{300:开始,3000:SBPStart(锯板流程开始)},{SBPSawBoard:[{link_id:3001,link_no:SBPSawBoard,name:锯板}]}]"})
	public ExecuteResultDTO launchProcess(@RequestBody LaunchSawBoardProcessDTO launchSawBoardProcessDTO) throws Exception {
		log.info("[{300:开始,3000:SBPStart(锯板流程开始)},{SBPSawBoard:[{link_id:3001,link_no:SBPSawBoard,name:锯板}]}]");
		log.info("锯板流程启动[新建和启动]: " + launchSawBoardProcessDTO.toString());
		ExecuteResultDTO executeResult = new ExecuteResultDTO();
		AlmCbSawBoardBO almCbSawBoardBO = AlmCbSawBoardMapper.INSTANCE.dtoToBo(launchSawBoardProcessDTO.getAlmCbSawBoardDTO());
		try {
			almCbSawBoardBO = almCbSawBoardService.save(almCbSawBoardBO);
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			return executeResult;
		}
		LaunchProcessBO launchProcessBO = null;
		try {
			if (CollectionUtils.isEmpty(launchSawBoardProcessDTO.getLaunchProcessDTO().getStds())) {
				List<StakeholderBO> result = new ArrayList<StakeholderBO>();
				List<StakeholderBO> startStakeholderBOs = api.queryStakeholder(SawBoardProcessTemplates.LINK_NO_3000, Long.valueOf(SawBoardProcessTemplates.LINK_ID_3000));
				for (StakeholderBO stakeholderBO : startStakeholderBOs) {
					if (stakeholderBO.getStdholderStaffId().compareTo(Long.valueOf(launchSawBoardProcessDTO.getLaunchProcessDTO().getStaffId())) == 0) {
						result.add(stakeholderBO);
						break;
					}
				}
				startStakeholderBOs = api.queryStakeholder(SawBoardProcessTemplates.LINK_NO_3001, Long.valueOf(SawBoardProcessTemplates.LINK_ID_3001));
				for (StakeholderBO stakeholderBO : startStakeholderBOs) {
					result.add(stakeholderBO);
				}
				launchSawBoardProcessDTO.getLaunchProcessDTO().setStds(StakeholderMapper.INSTANCE.boToDto(result));
			}
			launchProcessBO = ProcessUtil.assemblyLaunchProcess(launchSawBoardProcessDTO.getLaunchProcessDTO(),
					Long.valueOf(almCbSawBoardBO.getSbId()), SawBoardProcessConstDefine.TEMPLATE_PATH,
					SawBoardProcessConstDefine.TEMPLATE_KEY, SawBoardProcessConstDefine.OBJ_TYPE,
					ConstDefine.STDHOLDE_TYPE_APPROVAL, SawBoardProcessTemplates.LINK_NO_3001);
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
	@ApiOperation(value="锯板流程启动[保存工单和处理人]", tags={"[{300:开始,3000:SBPStart(锯板流程开始)},{SBPSawBoard:[{link_id:3001,link_no:SBPSawBoard,name:锯板}]}]"})
	public ExecuteResultDTO wsLaunchProcess(@RequestBody WorkOrderStakeholderDTO workOrderStakeholderDTO) throws Exception {
		log.info("[{300:开始,3000:SBPStart(锯板流程开始)},{SBPSawBoard:[{link_id:3001,link_no:SBPSawBoard,name:锯板}]}]");
		log.info("锯板流程启动[保存工单和处理人]: " + workOrderStakeholderDTO.toString());
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
	@ApiOperation(value="锯板[回单]", tags={"[{301:锯板,3001:SBPSawBoard(锯板)},{SBPReduceBoard:[{link_id:3004,link_no:SBPReduceBoard,name:减板}]},{SBPDestiny:[{link_id:3002,link_no:SBPDestiny,name:定数}]}]"})
	public ExecuteResultDTO sBPSawBoard(@RequestBody ExecuteSawBoardProcessDTO executeSawBoardProcessDTO) throws Exception {
		log.info("[{301:锯板,3001:SBPSawBoard(锯板)},{SBPReduceBoard:[{link_id:3004,link_no:SBPReduceBoard,name:减板}]},{SBPDestiny:[{link_id:3002,link_no:SBPDestiny,name:定数}]}]");
		log.info("锯板流程.锯板[回单]: " + executeSawBoardProcessDTO.toString());
		ExecuteResultDTO executeResult = new ExecuteResultDTO();
		AlmCbSawBoardBO almCbSawBoardBO = AlmCbSawBoardMapper.INSTANCE.dtoToBo(executeSawBoardProcessDTO.getAlmCbSawBoardDTO());
		try {
			almCbSawBoardBO = almCbSawBoardService.save(almCbSawBoardBO);
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			return executeResult;
		}
		ExecuteProcessBO executeProcessBO = null;
		try {
			if (CollectionUtils.isEmpty(executeSawBoardProcessDTO.getExecuteProcessDTO().getStds())) {
				List<StakeholderBO> result = new ArrayList<StakeholderBO>();
				List<StakeholderBO> startStakeholderBOs = null;
				if (executeSawBoardProcessDTO.getExecuteProcessDTO().getDirection().equals(SawBoardProcessTemplates.LINK_NO_3002)) {
					startStakeholderBOs = api.queryStakeholder(SawBoardProcessTemplates.LINK_NO_3002, Long.valueOf(SawBoardProcessTemplates.LINK_ID_3002));
				} else if (executeSawBoardProcessDTO.getExecuteProcessDTO().getDirection().equals(SawBoardProcessTemplates.LINK_NO_3004)) {
					startStakeholderBOs = api.queryStakeholder(SawBoardProcessTemplates.LINK_NO_3004, Long.valueOf(SawBoardProcessTemplates.LINK_ID_3004));
				}
				for (StakeholderBO stakeholderBO : startStakeholderBOs) {
					result.add(stakeholderBO);
				}
				executeSawBoardProcessDTO.getExecuteProcessDTO().setStds(StakeholderMapper.INSTANCE.boToDto(result));
			}
			executeProcessBO = ProcessUtil.assemblyExecuteProcess(executeSawBoardProcessDTO.getExecuteProcessDTO(),
					Long.valueOf(almCbSawBoardBO.getSbId()), SawBoardProcessConstDefine.TEMPLATE_PATH,
					SawBoardProcessConstDefine.TEMPLATE_KEY, SawBoardProcessConstDefine.OBJ_TYPE,
					ConstDefine.STDHOLDE_TYPE_APPROVAL, "Y");
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			return executeResult;
		}
		try {
			if (StringUtils.isBlank(executeProcessBO.getObjectId())) {
				executeProcessBO.setObjectId(String.valueOf(almCbSawBoardBO.getSbId()));
			}
			if (StringUtils.isBlank(executeProcessBO.getObjectTypeId())) {
				executeProcessBO.setObjectTypeId(SawBoardProcessConstDefine.OBJ_TYPE);
			}
			if (executeSawBoardProcessDTO.getExecuteProcessDTO().getDirection().equals(SawBoardProcessTemplates.LINK_NO_3002)) {
				api.finishUserTask(almCbSawBoardBO.getApplyStaffId(), executeProcessBO, executeSawBoardProcessDTO.getAlmCbFlowDTOs(), Long.valueOf(SawBoardProcessTemplates.LINK_ID_3002), SawBoardProcessTemplates.LINK_NO_3002);
			} else if (executeSawBoardProcessDTO.getExecuteProcessDTO().getDirection().equals(SawBoardProcessTemplates.LINK_NO_3004)) {
				api.finishUserTask(almCbSawBoardBO.getApplyStaffId(), executeProcessBO, executeSawBoardProcessDTO.getAlmCbFlowDTOs(), Long.valueOf(SawBoardProcessTemplates.LINK_ID_3004), SawBoardProcessTemplates.LINK_NO_3004);
			} 
			executeResult.setCode(1);
			executeResult.setMsg("success");
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		try {
			List<WorkorderBO> workOrderBOs = api.queryWorkorders(almCbSawBoardBO.getSbId(), Long.valueOf(SawBoardProcessTemplates.LINK_ID_3001)); 
			for (WorkorderBO workorderBO : workOrderBOs) {
				if (workorderBO.getStatus().equals(ConstDefine.STDHOLDE_TYPE_APPROVAL)) {
					executeSawBoardProcessDTO.getExecuteProcessDTO().setOrderId(workorderBO.getOrderId());
					executeProcessBO = ProcessUtil.assemblyExecuteProcess(executeSawBoardProcessDTO.getExecuteProcessDTO(),
							Long.valueOf(almCbSawBoardBO.getSbId()), SawBoardProcessConstDefine.TEMPLATE_PATH,
							SawBoardProcessConstDefine.TEMPLATE_KEY, SawBoardProcessConstDefine.OBJ_TYPE,
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
	@ApiOperation(value="锯板[保存工单和处理人]", tags={"[{301:锯板,3001:SBPSawBoard(锯板)},{SBPReduceBoard:[{link_id:3004,link_no:SBPReduceBoard,name:减板}]},{SBPDestiny:[{link_id:3002,link_no:SBPDestiny,name:定数}]}]"})
	public ExecuteResultDTO wsSBPSawBoard(@RequestBody WorkOrderStakeholderDTO workOrderStakeholderDTO) throws Exception {
		log.info("[{301:锯板,3001:SBPSawBoard(锯板)},{SBPReduceBoard:[{link_id:3004,link_no:SBPReduceBoard,name:减板}]},{SBPDestiny:[{link_id:3002,link_no:SBPDestiny,name:定数}]}]");
		log.info("锯板流程.锯板[保存工单和处理人]: " + workOrderStakeholderDTO.toString());
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
	@ApiOperation(value="定数[回单]", tags={"[{302:定数,3002:SBPDestiny(定数)},{SBPReduceBoard:[{link_id:3004,link_no:SBPReduceBoard,name:减板}]},{SBPDestiny:[{link_id:3002,link_no:SBPDestiny,name:定数}]},{SBPEnd:[{link_id:3003,link_no:SBPEnd,name:锯板流程结束}]}]"})
	public ExecuteResultDTO sBPDestiny(@RequestBody ExecuteSawBoardProcessDTO executeSawBoardProcessDTO) throws Exception {
		log.info("[{302:定数,3002:SBPDestiny(定数)},{SBPReduceBoard:[{link_id:3004,link_no:SBPReduceBoard,name:减板}]},{SBPDestiny:[{link_id:3002,link_no:SBPDestiny,name:定数}]},{SBPEnd:[{link_id:3003,link_no:SBPEnd,name:锯板流程结束}]}]");
		log.info("锯板流程.定数[回单]: " + executeSawBoardProcessDTO.toString());
		ExecuteResultDTO executeResult = new ExecuteResultDTO();
		AlmCbSawBoardBO almCbSawBoardBO = AlmCbSawBoardMapper.INSTANCE.dtoToBo(executeSawBoardProcessDTO.getAlmCbSawBoardDTO());
		try {
			almCbSawBoardBO = almCbSawBoardService.save(almCbSawBoardBO);
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			return executeResult;
		}
		ExecuteProcessBO executeProcessBO = null;
		try {
			if (CollectionUtils.isEmpty(executeSawBoardProcessDTO.getExecuteProcessDTO().getStds())) {
				List<StakeholderBO> result = new ArrayList<StakeholderBO>();
				List<StakeholderBO> startStakeholderBOs = new ArrayList<StakeholderBO>();
				if (executeSawBoardProcessDTO.getExecuteProcessDTO().getDirection().equals(SawBoardProcessTemplates.LINK_NO_3002)) {
					startStakeholderBOs = api.queryStakeholder(SawBoardProcessTemplates.LINK_NO_3002, Long.valueOf(SawBoardProcessTemplates.LINK_ID_3002));
				} else if (executeSawBoardProcessDTO.getExecuteProcessDTO().getDirection().equals(SawBoardProcessTemplates.LINK_NO_3004)) {
					startStakeholderBOs = api.queryStakeholder(SawBoardProcessTemplates.LINK_NO_3004, Long.valueOf(SawBoardProcessTemplates.LINK_ID_3004));
				}
				for (StakeholderBO stakeholderBO : startStakeholderBOs) {
					result.add(stakeholderBO);
				}
				executeSawBoardProcessDTO.getExecuteProcessDTO().setStds(StakeholderMapper.INSTANCE.boToDto(result));
			}
			executeProcessBO = ProcessUtil.assemblyExecuteProcess(executeSawBoardProcessDTO.getExecuteProcessDTO(),
					Long.valueOf(almCbSawBoardBO.getSbId()), SawBoardProcessConstDefine.TEMPLATE_PATH,
					SawBoardProcessConstDefine.TEMPLATE_KEY, SawBoardProcessConstDefine.OBJ_TYPE,
					ConstDefine.STDHOLDE_TYPE_APPROVAL, SawBoardProcessTemplates.LINK_NO_3002, SawBoardProcessTemplates.LINK_NO_3004);
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			return executeResult;
		}
		try {
			if (StringUtils.isBlank(executeProcessBO.getObjectId())) {
				executeProcessBO.setObjectId(String.valueOf(almCbSawBoardBO.getSbId()));
			}
			if (StringUtils.isBlank(executeProcessBO.getObjectTypeId())) {
				executeProcessBO.setObjectTypeId(SawBoardProcessConstDefine.OBJ_TYPE);
			}
			if (executeSawBoardProcessDTO.getExecuteProcessDTO().getDirection().equals(SawBoardProcessTemplates.LINK_NO_3002)) {
				api.finishUserTask(almCbSawBoardBO.getApplyStaffId(), executeProcessBO, executeSawBoardProcessDTO.getAlmCbFlowDTOs(), Long.valueOf(SawBoardProcessTemplates.LINK_ID_3002), SawBoardProcessTemplates.LINK_NO_3002);
			} else if (executeSawBoardProcessDTO.getExecuteProcessDTO().getDirection().equals(SawBoardProcessTemplates.LINK_NO_3003)) {
				api.finishUserTask(almCbSawBoardBO.getApplyStaffId(), executeProcessBO, executeSawBoardProcessDTO.getAlmCbFlowDTOs(), Long.valueOf(SawBoardProcessTemplates.LINK_ID_3003), SawBoardProcessTemplates.LINK_NO_3003);
			} else if (executeSawBoardProcessDTO.getExecuteProcessDTO().getDirection().equals(SawBoardProcessTemplates.LINK_NO_3004)) {
				api.finishUserTask(almCbSawBoardBO.getApplyStaffId(), executeProcessBO, executeSawBoardProcessDTO.getAlmCbFlowDTOs(), Long.valueOf(SawBoardProcessTemplates.LINK_ID_3004), SawBoardProcessTemplates.LINK_NO_3004);
			} 
			executeResult.setCode(1);
			executeResult.setMsg("success");
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		try {
			List<WorkorderBO> workOrderBOs = api.queryWorkorders(almCbSawBoardBO.getSbId(), Long.valueOf(SawBoardProcessTemplates.LINK_ID_3002)); 
			for (WorkorderBO workorderBO : workOrderBOs) {
				if (workorderBO.getStatus().equals(ConstDefine.STDHOLDE_TYPE_APPROVAL)) {
					executeSawBoardProcessDTO.getExecuteProcessDTO().setOrderId(workorderBO.getOrderId());
					executeProcessBO = ProcessUtil.assemblyExecuteProcess(executeSawBoardProcessDTO.getExecuteProcessDTO(),
							Long.valueOf(almCbSawBoardBO.getSbId()), SawBoardProcessConstDefine.TEMPLATE_PATH,
							SawBoardProcessConstDefine.TEMPLATE_KEY, SawBoardProcessConstDefine.OBJ_TYPE,
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
	@ApiOperation(value="定数[保存工单和处理人]", tags={"[{302:定数,3002:SBPDestiny(定数)},{SBPReduceBoard:[{link_id:3004,link_no:SBPReduceBoard,name:减板}]},{SBPDestiny:[{link_id:3002,link_no:SBPDestiny,name:定数}]},{SBPEnd:[{link_id:3003,link_no:SBPEnd,name:锯板流程结束}]}]"})
	public ExecuteResultDTO wsSBPDestiny(@RequestBody WorkOrderStakeholderDTO workOrderStakeholderDTO) throws Exception {
		log.info("[{302:定数,3002:SBPDestiny(定数)},{SBPReduceBoard:[{link_id:3004,link_no:SBPReduceBoard,name:减板}]},{SBPDestiny:[{link_id:3002,link_no:SBPDestiny,name:定数}]},{SBPEnd:[{link_id:3003,link_no:SBPEnd,name:锯板流程结束}]}]");
		log.info("锯板流程.定数[保存工单和处理人]: " + workOrderStakeholderDTO.toString());
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
	@ApiOperation(value="减板[回单]", tags={"[{304:减板,3004:SBPReduceBoard(减板)},{SBPSawBoard:[{link_id:3001,link_no:SBPSawBoard,name:锯板}]},{SBPDestiny:[{link_id:3002,link_no:SBPDestiny,name:定数}]}]"})
	public ExecuteResultDTO sBPReduceBoard(@RequestBody ExecuteSawBoardProcessDTO executeSawBoardProcessDTO) throws Exception {
		log.info("[{304:减板,3004:SBPReduceBoard(减板)},{SBPSawBoard:[{link_id:3001,link_no:SBPSawBoard,name:锯板}]},{SBPDestiny:[{link_id:3002,link_no:SBPDestiny,name:定数}]}]");
		log.info("锯板流程.减板[回单]: " + executeSawBoardProcessDTO.toString());
		ExecuteResultDTO executeResult = new ExecuteResultDTO();
		AlmCbSawBoardBO almCbSawBoardBO = AlmCbSawBoardMapper.INSTANCE.dtoToBo(executeSawBoardProcessDTO.getAlmCbSawBoardDTO());
		try {
			almCbSawBoardBO = almCbSawBoardService.save(almCbSawBoardBO);
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			return executeResult;
		}
		ExecuteProcessBO executeProcessBO = null;
		try {
			if (CollectionUtils.isEmpty(executeSawBoardProcessDTO.getExecuteProcessDTO().getStds())) {
				List<StakeholderBO> result = new ArrayList<StakeholderBO>();
				List<StakeholderBO> startStakeholderBOs = null;
				if (executeSawBoardProcessDTO.getExecuteProcessDTO().getDirection().equals(SawBoardProcessTemplates.LINK_NO_3001)) {
					startStakeholderBOs = api.queryStakeholder(SawBoardProcessTemplates.LINK_NO_3001, Long.valueOf(SawBoardProcessTemplates.LINK_ID_3001));
				} else if (executeSawBoardProcessDTO.getExecuteProcessDTO().getDirection().equals(SawBoardProcessTemplates.LINK_NO_3002)) {
					startStakeholderBOs = api.queryStakeholder(SawBoardProcessTemplates.LINK_NO_3002, Long.valueOf(SawBoardProcessTemplates.LINK_ID_3002));
				}
				for (StakeholderBO stakeholderBO : startStakeholderBOs) {
					result.add(stakeholderBO);
				}
				executeSawBoardProcessDTO.getExecuteProcessDTO().setStds(StakeholderMapper.INSTANCE.boToDto(result));
			}
			executeProcessBO = ProcessUtil.assemblyExecuteProcess(executeSawBoardProcessDTO.getExecuteProcessDTO(),
					Long.valueOf(almCbSawBoardBO.getSbId()), SawBoardProcessConstDefine.TEMPLATE_PATH,
					SawBoardProcessConstDefine.TEMPLATE_KEY, SawBoardProcessConstDefine.OBJ_TYPE,
					ConstDefine.STDHOLDE_TYPE_APPROVAL, "Y");
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			return executeResult;
		}
		try {
			if (StringUtils.isBlank(executeProcessBO.getObjectId())) {
				executeProcessBO.setObjectId(String.valueOf(almCbSawBoardBO.getSbId()));
			}
			if (StringUtils.isBlank(executeProcessBO.getObjectTypeId())) {
				executeProcessBO.setObjectTypeId(SawBoardProcessConstDefine.OBJ_TYPE);
			}
			if (executeSawBoardProcessDTO.getExecuteProcessDTO().getDirection().equals(SawBoardProcessTemplates.LINK_NO_3001)) {
				api.finishUserTask(almCbSawBoardBO.getApplyStaffId(), executeProcessBO, executeSawBoardProcessDTO.getAlmCbFlowDTOs(), Long.valueOf(SawBoardProcessTemplates.LINK_ID_3001), SawBoardProcessTemplates.LINK_NO_3001);
			} else if (executeSawBoardProcessDTO.getExecuteProcessDTO().getDirection().equals(SawBoardProcessTemplates.LINK_NO_3002)) {
				api.finishUserTask(almCbSawBoardBO.getApplyStaffId(), executeProcessBO, executeSawBoardProcessDTO.getAlmCbFlowDTOs(), Long.valueOf(SawBoardProcessTemplates.LINK_ID_3002), SawBoardProcessTemplates.LINK_NO_3002);
			}
			executeResult.setCode(1);
			executeResult.setMsg("success");
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		try {
			List<WorkorderBO> workOrderBOs = api.queryWorkorders(almCbSawBoardBO.getSbId(), Long.valueOf(SawBoardProcessTemplates.LINK_ID_3004)); 
			for (WorkorderBO workorderBO : workOrderBOs) {
				if (workorderBO.getStatus().equals(ConstDefine.STDHOLDE_TYPE_APPROVAL)) {
					executeSawBoardProcessDTO.getExecuteProcessDTO().setOrderId(workorderBO.getOrderId());
					executeProcessBO = ProcessUtil.assemblyExecuteProcess(executeSawBoardProcessDTO.getExecuteProcessDTO(),
							Long.valueOf(almCbSawBoardBO.getSbId()), SawBoardProcessConstDefine.TEMPLATE_PATH,
							SawBoardProcessConstDefine.TEMPLATE_KEY, SawBoardProcessConstDefine.OBJ_TYPE,
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
	@ApiOperation(value="减板[保存工单和处理人]", tags={"[{304:减板,3004:SBPReduceBoard(减板)},{SBPSawBoard:[{link_id:3001,link_no:SBPSawBoard,name:锯板}]},{SBPDestiny:[{link_id:3002,link_no:SBPDestiny,name:定数}]}]"})
	public ExecuteResultDTO wsSBPReduceBoard(@RequestBody WorkOrderStakeholderDTO workOrderStakeholderDTO) throws Exception {
		log.info("[{304:减板,3004:SBPReduceBoard(减板)},{SBPSawBoard:[{link_id:3001,link_no:SBPSawBoard,name:锯板}]},{SBPDestiny:[{link_id:3002,link_no:SBPDestiny,name:定数}]}]");
		log.info("锯板流程.减板[保存工单和处理人]: " + workOrderStakeholderDTO.toString());
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

