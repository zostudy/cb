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
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbRepairBoardBO;
import com.asiainfo.rms.workflow.mapper.process.cb.AlmCbRepairBoardMapper;
import com.asiainfo.rms.workflow.service.process.cb.IAlmCbRepairBoardService;
import com.asiainfo.rms.workflow.service.process.common.ISysAuthorWorkflowService;
import com.asiainfo.rms.workflow.service.process.common.ISysStationPrivateService;
import com.asiainfo.rms.workflow.dto.process.cb.LaunchRepairBoardProcessDTO;
import com.asiainfo.rms.workflow.dto.process.cb.ExecuteRepairBoardProcessDTO;
import com.asiainfo.rms.workflow.dto.process.common.WorkOrderStakeholderDTO;
import com.asiainfo.rms.workflow.web.process.cb.IRepairBoardProcessController;
import com.asiainfo.rms.workflow.mapper.workflow.StakeholderMapper;
import com.asiainfo.rms.workflow.mapper.workflow.WorkorderMapper;
import com.asiainfo.rms.workflow.bo.process.common.LaunchProcessBO;
import com.asiainfo.rms.workflow.bo.workflow.StakeholderBO;
import com.asiainfo.rms.workflow.bo.workflow.WorkorderBO;
import com.asiainfo.rms.workflow.bo.process.common.ExecuteProcessBO;
import com.asiainfo.rms.workflow.util.ProcessUtil;
import com.asiainfo.rms.workflow.common.constance.ConstDefine;
import com.asiainfo.rms.workflow.common.constance.RepairBoardProcessConstDefine;
import com.asiainfo.rms.workflow.common.process.RepairBoardProcessTemplates;
import com.asiainfo.rms.workflow.service.api.WorkflowControllerApi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * 修板流程
 * 
 * @author joker
 */
@Data
@Log4j
@Transactional
@RestController
@AllArgsConstructor
@RequiredArgsConstructor
@Api(tags={ "修板流程[{103:结束,1003:RBPEnd(修板流程结束)}]"}, value="修板流程")
public class RepairBoardProcessControllerImpl implements IRepairBoardProcessController {

	@Autowired
	private WorkflowControllerApi api;
	
	@Autowired
	IAlmCbRepairBoardService almCbRepairBoardService;
	
	@Autowired
	ISysAuthorWorkflowService sysAuthorWorkflowService;
	
	@Autowired
	ISysStationPrivateService sysStationPrivateService;
	
	@Override
	@ApiOperation(value="修板流程新建工单[新建]", tags={"[{100:开始,1000:RBPStart(修板流程开始)}]"})
	public ExecuteResultDTO saveFirstOrder(@RequestBody LaunchRepairBoardProcessDTO launchRepairBoardProcessDTO) throws Exception {
		log.info("[{100:开始,1000:RBPStart(修板流程开始)}]");
		log.info("修板流程新建工单[新建]: " + launchRepairBoardProcessDTO.toString());
		ExecuteResultDTO executeResult = new ExecuteResultDTO();
		AlmCbRepairBoardBO almCbRepairBoardBO = AlmCbRepairBoardMapper.INSTANCE.dtoToBo(launchRepairBoardProcessDTO.getAlmCbRepairBoardDTO());
		try {
			almCbRepairBoardBO = almCbRepairBoardService.save(almCbRepairBoardBO);
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			return executeResult;
		}
		LaunchProcessBO launchProcessBO = null;
		try {
			launchProcessBO = ProcessUtil.assemblyLaunchProcess(launchRepairBoardProcessDTO.getLaunchProcessDTO(),
					Long.valueOf(almCbRepairBoardBO.getRbId()), RepairBoardProcessConstDefine.TEMPLATE_PATH,
					RepairBoardProcessConstDefine.TEMPLATE_KEY, RepairBoardProcessConstDefine.OBJ_TYPE,
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
			return executeResult;
		}
		return executeResult;
	}
	
	@Override
	@ApiOperation(value="修板流程启动[新建和启动]", tags={"[{100:开始,1000:RBPStart(修板流程开始)},{RBPRepairBoard:[{link_id:1001,link_no:RBPRepairBoard,name:修板}]}]"})
	public ExecuteResultDTO launchProcess(@RequestBody LaunchRepairBoardProcessDTO launchRepairBoardProcessDTO) throws Exception {
		log.info("[{100:开始,1000:RBPStart(修板流程开始)},{RBPRepairBoard:[{link_id:1001,link_no:RBPRepairBoard,name:修板}]}]");
		log.info("修板流程启动[新建和启动]: " + launchRepairBoardProcessDTO.toString());
		ExecuteResultDTO executeResult = new ExecuteResultDTO();
		AlmCbRepairBoardBO almCbRepairBoardBO = AlmCbRepairBoardMapper.INSTANCE.dtoToBo(launchRepairBoardProcessDTO.getAlmCbRepairBoardDTO());
		try {
			almCbRepairBoardBO = almCbRepairBoardService.save(almCbRepairBoardBO);
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			return executeResult;
		}
		LaunchProcessBO launchProcessBO = null;
		try {
			if (CollectionUtils.isEmpty(launchRepairBoardProcessDTO.getLaunchProcessDTO().getStds())) {
				List<StakeholderBO> result = new ArrayList<StakeholderBO>();
				List<StakeholderBO> startStakeholderBOs = api.queryStakeholder(RepairBoardProcessTemplates.LINK_NO_1000, Long.valueOf(RepairBoardProcessTemplates.LINK_ID_1000));
				for (StakeholderBO stakeholderBO : startStakeholderBOs) {
					if (stakeholderBO.getStdholderStaffId().compareTo(Long.valueOf(launchRepairBoardProcessDTO.getLaunchProcessDTO().getStaffId())) == 0) {
						result.add(stakeholderBO);
						break;
					}
				}
				startStakeholderBOs = api.queryStakeholder(RepairBoardProcessTemplates.LINK_NO_1001, Long.valueOf(RepairBoardProcessTemplates.LINK_ID_1001));
				for (StakeholderBO stakeholderBO : startStakeholderBOs) {
					result.add(stakeholderBO);
				}
				launchRepairBoardProcessDTO.getLaunchProcessDTO().setStds(StakeholderMapper.INSTANCE.boToDto(result));
			}
			launchProcessBO = ProcessUtil.assemblyLaunchProcess(launchRepairBoardProcessDTO.getLaunchProcessDTO(),
					Long.valueOf(almCbRepairBoardBO.getRbId()), RepairBoardProcessConstDefine.TEMPLATE_PATH,
					RepairBoardProcessConstDefine.TEMPLATE_KEY, RepairBoardProcessConstDefine.OBJ_TYPE,
					ConstDefine.STDHOLDE_TYPE_APPROVAL, RepairBoardProcessTemplates.LINK_NO_1001);
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
			return executeResult;
		}
		return executeResult;
	}

	@Override
	@ApiOperation(value="修板流程启动[保存工单和处理人]", tags={"[{100:开始,1000:RBPStart(修板流程开始)},{RBPRepairBoard:[{link_id:1001,link_no:RBPRepairBoard,name:修板}]}]"})
	public ExecuteResultDTO wsLaunchProcess(@RequestBody WorkOrderStakeholderDTO workOrderStakeholderDTO) throws Exception {
		log.info("[{100:开始,1000:RBPStart(修板流程开始)},{RBPRepairBoard:[{link_id:1001,link_no:RBPRepairBoard,name:修板}]}]");
		log.info("修板流程启动[保存工单和处理人]: " + workOrderStakeholderDTO.toString());
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
	@ApiOperation(value="修板[回单]", tags={"[{101:修板,1001:RBPRepairBoard(修板)},{RBPReduceBoard:[{link_id:1004,link_no:RBPReduceBoard,name:减板}]},{RBPDestiny:[{link_id:1002,link_no:RBPDestiny,name:定数}]}]"})
	public ExecuteResultDTO rBPRepairBoard(@RequestBody ExecuteRepairBoardProcessDTO executeRepairBoardProcessDTO) throws Exception {
		log.info("[{101:修板,1001:RBPRepairBoard(修板)},{RBPReduceBoard:[{link_id:1004,link_no:RBPReduceBoard,name:减板}]},{RBPDestiny:[{link_id:1002,link_no:RBPDestiny,name:定数}]}]");
		log.info("修板流程.修板[回单]: " + executeRepairBoardProcessDTO.toString());
		ExecuteResultDTO executeResult = new ExecuteResultDTO();
		AlmCbRepairBoardBO almCbRepairBoardBO = AlmCbRepairBoardMapper.INSTANCE.dtoToBo(executeRepairBoardProcessDTO.getAlmCbRepairBoardDTO());
		try {
			almCbRepairBoardBO = almCbRepairBoardService.save(almCbRepairBoardBO);
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			return executeResult;
		}
		ExecuteProcessBO executeProcessBO = null;
		try {
			if (CollectionUtils.isEmpty(executeRepairBoardProcessDTO.getExecuteProcessDTO().getStds())) {
				List<StakeholderBO> result = new ArrayList<StakeholderBO>();
				List<StakeholderBO> startStakeholderBOs = null;
				if (executeRepairBoardProcessDTO.getExecuteProcessDTO().getDirection().equals(RepairBoardProcessTemplates.LINK_NO_1002)) {
					startStakeholderBOs = api.queryStakeholder(RepairBoardProcessTemplates.LINK_NO_1002, Long.valueOf(RepairBoardProcessTemplates.LINK_ID_1002));
				} else if (executeRepairBoardProcessDTO.getExecuteProcessDTO().getDirection().equals(RepairBoardProcessTemplates.LINK_NO_1004)) {
					startStakeholderBOs = api.queryStakeholder(RepairBoardProcessTemplates.LINK_NO_1004, Long.valueOf(RepairBoardProcessTemplates.LINK_ID_1004));
				}
				for (StakeholderBO stakeholderBO : startStakeholderBOs) {
					result.add(stakeholderBO);
				}
				executeRepairBoardProcessDTO.getExecuteProcessDTO().setStds(StakeholderMapper.INSTANCE.boToDto(result));
			}
			executeProcessBO = ProcessUtil.assemblyExecuteProcess(executeRepairBoardProcessDTO.getExecuteProcessDTO(),
					Long.valueOf(almCbRepairBoardBO.getRbId()), RepairBoardProcessConstDefine.TEMPLATE_PATH,
					RepairBoardProcessConstDefine.TEMPLATE_KEY, RepairBoardProcessConstDefine.OBJ_TYPE,
					ConstDefine.STDHOLDE_TYPE_APPROVAL, "Y");
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			return executeResult;
		}
		try {
			if (StringUtils.isBlank(executeProcessBO.getObjectId())) {
				executeProcessBO.setObjectId(String.valueOf(almCbRepairBoardBO.getRbId()));
			}
			if (StringUtils.isBlank(executeProcessBO.getObjectTypeId())) {
				executeProcessBO.setObjectTypeId(RepairBoardProcessConstDefine.OBJ_TYPE);
			}
			if (executeRepairBoardProcessDTO.getExecuteProcessDTO().getDirection().equals(RepairBoardProcessTemplates.LINK_NO_1002)) {
				api.finishUserTask(almCbRepairBoardBO.getApplyStaffId(), executeProcessBO, executeRepairBoardProcessDTO.getAlmCbFlowDTOs(), Long.valueOf(RepairBoardProcessTemplates.LINK_ID_1002), RepairBoardProcessTemplates.LINK_NO_1002);
			} else if (executeRepairBoardProcessDTO.getExecuteProcessDTO().getDirection().equals(RepairBoardProcessTemplates.LINK_NO_1004)) {
				api.finishUserTask(almCbRepairBoardBO.getApplyStaffId(), executeProcessBO, executeRepairBoardProcessDTO.getAlmCbFlowDTOs(), Long.valueOf(RepairBoardProcessTemplates.LINK_ID_1004), RepairBoardProcessTemplates.LINK_NO_1004);
			} 
			executeResult.setCode(1);
			executeResult.setMsg("success");
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		try {
			List<WorkorderBO> workOrderBOs = api.queryWorkorders(almCbRepairBoardBO.getRbId(), Long.valueOf(RepairBoardProcessTemplates.LINK_ID_1001)); 
			for (WorkorderBO workorderBO : workOrderBOs) {
				if (workorderBO.getStatus().equals(ConstDefine.STDHOLDE_TYPE_APPROVAL)) {
					executeRepairBoardProcessDTO.getExecuteProcessDTO().setOrderId(workorderBO.getOrderId());
					executeProcessBO = ProcessUtil.assemblyExecuteProcess(executeRepairBoardProcessDTO.getExecuteProcessDTO(),
							Long.valueOf(almCbRepairBoardBO.getRbId()), RepairBoardProcessConstDefine.TEMPLATE_PATH,
							RepairBoardProcessConstDefine.TEMPLATE_KEY, RepairBoardProcessConstDefine.OBJ_TYPE,
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
	@ApiOperation(value="修板[保存工单和处理人]", tags={"[{101:修板,1001:RBPRepairBoard(修板)},{RBPReduceBoard:[{link_id:1004,link_no:RBPReduceBoard,name:减板}]},{RBPDestiny:[{link_id:1002,link_no:RBPDestiny,name:定数}]}]"})
	public ExecuteResultDTO wsRBPRepairBoard(@RequestBody WorkOrderStakeholderDTO workOrderStakeholderDTO) throws Exception {
		log.info("[{101:修板,1001:RBPRepairBoard(修板)},{RBPReduceBoard:[{link_id:1004,link_no:RBPReduceBoard,name:减板}]},{RBPDestiny:[{link_id:1002,link_no:RBPDestiny,name:定数}]}]");
		log.info("修板流程.修板[保存工单和处理人]: " + workOrderStakeholderDTO.toString());
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
	@ApiOperation(value="定数[回单]", tags={"[{102:定数,1002:RBPDestiny(定数)},{RBPEnd:[{link_id:1003,link_no:RBPEnd,name:修板流程结束}]},{RBPReduceBoard:[{link_id:1004,link_no:RBPReduceBoard,name:减板}]},{RBPDestiny:[{link_id:1002,link_no:RBPDestiny,name:定数}]}]"})
	public ExecuteResultDTO rBPDestiny(@RequestBody ExecuteRepairBoardProcessDTO executeRepairBoardProcessDTO) throws Exception {
		log.info("[{102:定数,1002:RBPDestiny(定数)},{RBPEnd:[{link_id:1003,link_no:RBPEnd,name:修板流程结束}]},{RBPReduceBoard:[{link_id:1004,link_no:RBPReduceBoard,name:减板}]},{RBPDestiny:[{link_id:1002,link_no:RBPDestiny,name:定数}]}]");
		log.info("修板流程.定数[回单]: " + executeRepairBoardProcessDTO.toString());
		ExecuteResultDTO executeResult = new ExecuteResultDTO();
		AlmCbRepairBoardBO almCbRepairBoardBO = AlmCbRepairBoardMapper.INSTANCE.dtoToBo(executeRepairBoardProcessDTO.getAlmCbRepairBoardDTO());
		try {
			almCbRepairBoardBO = almCbRepairBoardService.save(almCbRepairBoardBO);
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			return executeResult;
		}
		ExecuteProcessBO executeProcessBO = null;
		try {
			if (CollectionUtils.isEmpty(executeRepairBoardProcessDTO.getExecuteProcessDTO().getStds())) {
				List<StakeholderBO> result = new ArrayList<StakeholderBO>();
				List<StakeholderBO> startStakeholderBOs = new ArrayList<StakeholderBO>();;
				if (executeRepairBoardProcessDTO.getExecuteProcessDTO().getDirection().equals(RepairBoardProcessTemplates.LINK_NO_1002)) {
					startStakeholderBOs = api.queryStakeholder(RepairBoardProcessTemplates.LINK_NO_1002, Long.valueOf(RepairBoardProcessTemplates.LINK_ID_1002));
				} else if (executeRepairBoardProcessDTO.getExecuteProcessDTO().getDirection().equals(RepairBoardProcessTemplates.LINK_NO_1004)) {
					startStakeholderBOs = api.queryStakeholder(RepairBoardProcessTemplates.LINK_NO_1004, Long.valueOf(RepairBoardProcessTemplates.LINK_ID_1004));
				}
				for (StakeholderBO stakeholderBO : startStakeholderBOs) {
					result.add(stakeholderBO);
				}
				executeRepairBoardProcessDTO.getExecuteProcessDTO().setStds(StakeholderMapper.INSTANCE.boToDto(result));
			}
			executeProcessBO = ProcessUtil.assemblyExecuteProcess(executeRepairBoardProcessDTO.getExecuteProcessDTO(),
					Long.valueOf(almCbRepairBoardBO.getRbId()), RepairBoardProcessConstDefine.TEMPLATE_PATH,
					RepairBoardProcessConstDefine.TEMPLATE_KEY, RepairBoardProcessConstDefine.OBJ_TYPE,
					ConstDefine.STDHOLDE_TYPE_APPROVAL, RepairBoardProcessTemplates.LINK_NO_1002, RepairBoardProcessTemplates.LINK_NO_1004);
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			return executeResult;
		}
		try {
			if (StringUtils.isBlank(executeProcessBO.getObjectId())) {
				executeProcessBO.setObjectId(String.valueOf(almCbRepairBoardBO.getRbId()));
			}
			if (StringUtils.isBlank(executeProcessBO.getObjectTypeId())) {
				executeProcessBO.setObjectTypeId(RepairBoardProcessConstDefine.OBJ_TYPE);
			}
			if (executeRepairBoardProcessDTO.getExecuteProcessDTO().getDirection().equals(RepairBoardProcessTemplates.LINK_NO_1002)) {
				api.finishUserTask(almCbRepairBoardBO.getApplyStaffId(), executeProcessBO, executeRepairBoardProcessDTO.getAlmCbFlowDTOs(), Long.valueOf(RepairBoardProcessTemplates.LINK_ID_1002), RepairBoardProcessTemplates.LINK_NO_1002);
			} else if (executeRepairBoardProcessDTO.getExecuteProcessDTO().getDirection().equals(RepairBoardProcessTemplates.LINK_NO_1003)) {
				api.finishUserTask(almCbRepairBoardBO.getApplyStaffId(), executeProcessBO, executeRepairBoardProcessDTO.getAlmCbFlowDTOs(), Long.valueOf(RepairBoardProcessTemplates.LINK_ID_1003), RepairBoardProcessTemplates.LINK_NO_1003);
			} else if (executeRepairBoardProcessDTO.getExecuteProcessDTO().getDirection().equals(RepairBoardProcessTemplates.LINK_NO_1004)) {
				api.finishUserTask(almCbRepairBoardBO.getApplyStaffId(), executeProcessBO, executeRepairBoardProcessDTO.getAlmCbFlowDTOs(), Long.valueOf(RepairBoardProcessTemplates.LINK_ID_1004), RepairBoardProcessTemplates.LINK_NO_1004);
			}
			executeResult.setCode(1);
			executeResult.setMsg("success");
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		try {
			List<WorkorderBO> workOrderBOs = api.queryWorkorders(almCbRepairBoardBO.getRbId(), Long.valueOf(RepairBoardProcessTemplates.LINK_ID_1002)); 
			for (WorkorderBO workorderBO : workOrderBOs) {
				if (workorderBO.getStatus().equals(ConstDefine.STDHOLDE_TYPE_APPROVAL)) {
					executeRepairBoardProcessDTO.getExecuteProcessDTO().setOrderId(workorderBO.getOrderId());
					executeProcessBO = ProcessUtil.assemblyExecuteProcess(executeRepairBoardProcessDTO.getExecuteProcessDTO(),
							Long.valueOf(almCbRepairBoardBO.getRbId()), RepairBoardProcessConstDefine.TEMPLATE_PATH,
							RepairBoardProcessConstDefine.TEMPLATE_KEY, RepairBoardProcessConstDefine.OBJ_TYPE,
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
	@ApiOperation(value="定数[保存工单和处理人]", tags={"[{102:定数,1002:RBPDestiny(定数)},{RBPEnd:[{link_id:1003,link_no:RBPEnd,name:修板流程结束}]},{RBPReduceBoard:[{link_id:1004,link_no:RBPReduceBoard,name:减板}]},{RBPDestiny:[{link_id:1002,link_no:RBPDestiny,name:定数}]}]"})
	public ExecuteResultDTO wsRBPDestiny(@RequestBody WorkOrderStakeholderDTO workOrderStakeholderDTO) throws Exception {
		log.info("[{102:定数,1002:RBPDestiny(定数)},{RBPEnd:[{link_id:1003,link_no:RBPEnd,name:修板流程结束}]},{RBPReduceBoard:[{link_id:1004,link_no:RBPReduceBoard,name:减板}]},{RBPDestiny:[{link_id:1002,link_no:RBPDestiny,name:定数}]}]");
		log.info("修板流程.定数[保存工单和处理人]: " + workOrderStakeholderDTO.toString());
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
	@ApiOperation(value="减板[回单]", tags={"[{104:减板,1004:RBPReduceBoard(减板)},{RBPRepairBoard:[{link_id:1001,link_no:RBPRepairBoard,name:修板}]},{RBPDestiny:[{link_id:1002,link_no:RBPDestiny,name:定数}]}]"})
	public ExecuteResultDTO rBPReduceBoard(@RequestBody ExecuteRepairBoardProcessDTO executeRepairBoardProcessDTO) throws Exception {
		log.info("[{104:减板,1004:RBPReduceBoard(减板)},{RBPRepairBoard:[{link_id:1001,link_no:RBPRepairBoard,name:修板}]},{RBPDestiny:[{link_id:1002,link_no:RBPDestiny,name:定数}]}]");
		log.info("修板流程.减板[回单]: " + executeRepairBoardProcessDTO.toString());
		ExecuteResultDTO executeResult = new ExecuteResultDTO();
		AlmCbRepairBoardBO almCbRepairBoardBO = AlmCbRepairBoardMapper.INSTANCE.dtoToBo(executeRepairBoardProcessDTO.getAlmCbRepairBoardDTO());
		try {
			almCbRepairBoardBO = almCbRepairBoardService.save(almCbRepairBoardBO);
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			return executeResult;
		}
		ExecuteProcessBO executeProcessBO = null;
		try {
			if (CollectionUtils.isEmpty(executeRepairBoardProcessDTO.getExecuteProcessDTO().getStds())) {
				List<StakeholderBO> result = new ArrayList<StakeholderBO>();
				List<StakeholderBO> startStakeholderBOs = null;
				if (executeRepairBoardProcessDTO.getExecuteProcessDTO().getDirection().equals(RepairBoardProcessTemplates.LINK_NO_1001)) {
					startStakeholderBOs = api.queryStakeholder(RepairBoardProcessTemplates.LINK_NO_1001, Long.valueOf(RepairBoardProcessTemplates.LINK_ID_1001));
				} else if (executeRepairBoardProcessDTO.getExecuteProcessDTO().getDirection().equals(RepairBoardProcessTemplates.LINK_NO_1002)) {
					startStakeholderBOs = api.queryStakeholder(RepairBoardProcessTemplates.LINK_NO_1002, Long.valueOf(RepairBoardProcessTemplates.LINK_ID_1002));
				}
				for (StakeholderBO stakeholderBO : startStakeholderBOs) {
					result.add(stakeholderBO);
				}
				executeRepairBoardProcessDTO.getExecuteProcessDTO().setStds(StakeholderMapper.INSTANCE.boToDto(result));
			}
			executeProcessBO = ProcessUtil.assemblyExecuteProcess(executeRepairBoardProcessDTO.getExecuteProcessDTO(),
					Long.valueOf(almCbRepairBoardBO.getRbId()), RepairBoardProcessConstDefine.TEMPLATE_PATH,
					RepairBoardProcessConstDefine.TEMPLATE_KEY, RepairBoardProcessConstDefine.OBJ_TYPE,
					ConstDefine.STDHOLDE_TYPE_APPROVAL, "Y");
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			return executeResult;
		}
		try {
			if (StringUtils.isBlank(executeProcessBO.getObjectId())) {
				executeProcessBO.setObjectId(String.valueOf(almCbRepairBoardBO.getRbId()));
			}
			if (StringUtils.isBlank(executeProcessBO.getObjectTypeId())) {
				executeProcessBO.setObjectTypeId(RepairBoardProcessConstDefine.OBJ_TYPE);
			}
			if (executeRepairBoardProcessDTO.getExecuteProcessDTO().getDirection().equals(RepairBoardProcessTemplates.LINK_NO_1001)) {
				api.finishUserTask(almCbRepairBoardBO.getApplyStaffId(), executeProcessBO, executeRepairBoardProcessDTO.getAlmCbFlowDTOs(), Long.valueOf(RepairBoardProcessTemplates.LINK_ID_1001), RepairBoardProcessTemplates.LINK_NO_1001);
			} else if (executeRepairBoardProcessDTO.getExecuteProcessDTO().getDirection().equals(RepairBoardProcessTemplates.LINK_NO_1002)) {
				api.finishUserTask(almCbRepairBoardBO.getApplyStaffId(), executeProcessBO, executeRepairBoardProcessDTO.getAlmCbFlowDTOs(), Long.valueOf(RepairBoardProcessTemplates.LINK_ID_1002), RepairBoardProcessTemplates.LINK_NO_1002);
			}
			executeResult.setCode(1);
			executeResult.setMsg("success");
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		try {
			List<WorkorderBO> workOrderBOs = api.queryWorkorders(almCbRepairBoardBO.getRbId(), Long.valueOf(RepairBoardProcessTemplates.LINK_ID_1004)); 
			for (WorkorderBO workorderBO : workOrderBOs) {
				if (workorderBO.getStatus().equals(ConstDefine.STDHOLDE_TYPE_APPROVAL)) {
					executeRepairBoardProcessDTO.getExecuteProcessDTO().setOrderId(workorderBO.getOrderId());
					executeProcessBO = ProcessUtil.assemblyExecuteProcess(executeRepairBoardProcessDTO.getExecuteProcessDTO(),
							Long.valueOf(almCbRepairBoardBO.getRbId()), RepairBoardProcessConstDefine.TEMPLATE_PATH,
							RepairBoardProcessConstDefine.TEMPLATE_KEY, RepairBoardProcessConstDefine.OBJ_TYPE,
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
	@ApiOperation(value="减板[保存工单和处理人]", tags={"[{104:减板,1004:RBPReduceBoard(减板)},{RBPRepairBoard:[{link_id:1001,link_no:RBPRepairBoard,name:修板}]},{RBPDestiny:[{link_id:1002,link_no:RBPDestiny,name:定数}]}]"})
	public ExecuteResultDTO wsRBPReduceBoard(@RequestBody WorkOrderStakeholderDTO workOrderStakeholderDTO) throws Exception {
		log.info("[{104:减板,1004:RBPReduceBoard(减板)},{RBPRepairBoard:[{link_id:1001,link_no:RBPRepairBoard,name:修板}]},{RBPDestiny:[{link_id:1002,link_no:RBPDestiny,name:定数}]}]");
		log.info("修板流程.减板[保存工单和处理人]: " + workOrderStakeholderDTO.toString());
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

