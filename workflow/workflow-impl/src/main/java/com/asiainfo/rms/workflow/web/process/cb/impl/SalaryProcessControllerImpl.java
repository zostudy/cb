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
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbSalaryBO;
import com.asiainfo.rms.workflow.mapper.process.cb.AlmCbSalaryMapper;
import com.asiainfo.rms.workflow.service.process.cb.IAlmCbSalaryService;
import com.asiainfo.rms.workflow.dto.process.cb.LaunchSalaryProcessDTO;
import com.asiainfo.rms.workflow.dto.process.cb.ExecuteSalaryProcessDTO;
import com.asiainfo.rms.workflow.dto.process.common.WorkOrderStakeholderDTO;
import com.asiainfo.rms.workflow.web.process.cb.ISalaryProcessController;
import com.asiainfo.rms.workflow.mapper.workflow.StakeholderMapper;
import com.asiainfo.rms.workflow.mapper.workflow.WorkorderMapper;
import com.asiainfo.rms.workflow.bo.process.common.LaunchProcessBO;
import com.asiainfo.rms.workflow.bo.workflow.StakeholderBO;
import com.asiainfo.rms.workflow.bo.workflow.WorkorderBO;
import com.asiainfo.rms.workflow.bo.process.common.ExecuteProcessBO;
import com.asiainfo.rms.workflow.util.ProcessUtil;
import com.asiainfo.rms.workflow.common.constance.ConstDefine;
import com.asiainfo.rms.workflow.common.constance.SalaryProcessConstDefine;
import com.asiainfo.rms.workflow.common.process.SalaryProcessTemplates;
import com.asiainfo.rms.workflow.service.api.WorkflowControllerApi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * 薪酬流程
 * 
 * @author joker
 */
@Data
@Log4j
@Transactional
@RestController
@AllArgsConstructor
@RequiredArgsConstructor
@Api(tags={ "薪酬流程[{201:结束,2001:SPEnd(薪酬流程结束)}]"}, value="薪酬流程")
public class SalaryProcessControllerImpl implements ISalaryProcessController {

	@Autowired
	private WorkflowControllerApi api;
	
	@Autowired
	IAlmCbSalaryService almCbSalaryService;
	
	@Override
	@ApiOperation(value="薪酬流程新建工单[新建]", tags={"[{200:开始,2000:SPStart(薪酬流程开始)}]"})
	public ExecuteResultDTO saveFirstOrder(@RequestBody LaunchSalaryProcessDTO launchSalaryProcessDTO) throws Exception {
		log.info("[{200:开始,2000:SPStart(薪酬流程开始)}]");
		log.info("薪酬流程新建工单[新建]: " + launchSalaryProcessDTO.toString());
		ExecuteResultDTO executeResult = new ExecuteResultDTO();
		AlmCbSalaryBO almCbSalaryBO = AlmCbSalaryMapper.INSTANCE.dtoToBo(launchSalaryProcessDTO.getAlmCbSalaryDTO());
		try {
			almCbSalaryBO = almCbSalaryService.save(almCbSalaryBO);
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			return executeResult;
		}
		LaunchProcessBO launchProcessBO = null;
		try {
			launchProcessBO = ProcessUtil.assemblyLaunchProcess(launchSalaryProcessDTO.getLaunchProcessDTO(),
					Long.valueOf(almCbSalaryBO.getSid()), SalaryProcessConstDefine.TEMPLATE_PATH,
					SalaryProcessConstDefine.TEMPLATE_KEY, SalaryProcessConstDefine.OBJ_TYPE,
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
	@ApiOperation(value="薪酬流程启动[新建和启动]", tags={"[{200:开始,2000:SPStart(薪酬流程开始)},{SPSalary:[{link_id:2002,link_no:SPSalary,name:薪酬}]}]"})
	public ExecuteResultDTO launchProcess(@RequestBody LaunchSalaryProcessDTO launchSalaryProcessDTO) throws Exception {
		log.info("[{200:开始,2000:SPStart(薪酬流程开始)},{SPSalary:[{link_id:2002,link_no:SPSalary,name:薪酬}]}]");
		log.info("薪酬流程启动[新建和启动]: " + launchSalaryProcessDTO.toString());
		ExecuteResultDTO executeResult = new ExecuteResultDTO();
		AlmCbSalaryBO almCbSalaryBO = AlmCbSalaryMapper.INSTANCE.dtoToBo(launchSalaryProcessDTO.getAlmCbSalaryDTO());
		try {
			almCbSalaryBO = almCbSalaryService.save(almCbSalaryBO);
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			return executeResult;
		}
		LaunchProcessBO launchProcessBO = null;
		try {
			if (CollectionUtils.isEmpty(launchSalaryProcessDTO.getLaunchProcessDTO().getStds())) {
				List<StakeholderBO> result = new ArrayList<StakeholderBO>();
				List<StakeholderBO> startStakeholderBOs = api.queryStakeholder(SalaryProcessTemplates.LINK_NO_2000, Long.valueOf(SalaryProcessTemplates.LINK_ID_2000));
				for (StakeholderBO stakeholderBO : startStakeholderBOs) {
					if (stakeholderBO.getStdholderStaffId().compareTo(Long.valueOf(launchSalaryProcessDTO.getLaunchProcessDTO().getStaffId())) == 0) {
						result.add(stakeholderBO);
						break;
					}
				}
				startStakeholderBOs = api.queryStakeholder(SalaryProcessTemplates.LINK_NO_2002, Long.valueOf(SalaryProcessTemplates.LINK_ID_2002));
				for (StakeholderBO stakeholderBO : startStakeholderBOs) {
					result.add(stakeholderBO);
				}
				launchSalaryProcessDTO.getLaunchProcessDTO().setStds(StakeholderMapper.INSTANCE.boToDto(result));
			}
			launchProcessBO = ProcessUtil.assemblyLaunchProcess(launchSalaryProcessDTO.getLaunchProcessDTO(),
					Long.valueOf(almCbSalaryBO.getSid()), SalaryProcessConstDefine.TEMPLATE_PATH,
					SalaryProcessConstDefine.TEMPLATE_KEY, SalaryProcessConstDefine.OBJ_TYPE,
					ConstDefine.STDHOLDE_TYPE_APPROVAL, SalaryProcessTemplates.LINK_NO_2002);
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
	@ApiOperation(value="薪酬流程启动[保存工单和处理人]", tags={"[{200:开始,2000:SPStart(薪酬流程开始)},{SPSalary:[{link_id:2002,link_no:SPSalary,name:薪酬}]}]"})
	public ExecuteResultDTO wsLaunchProcess(@RequestBody WorkOrderStakeholderDTO workOrderStakeholderDTO) throws Exception {
		log.info("[{200:开始,2000:SPStart(薪酬流程开始)},{SPSalary:[{link_id:2002,link_no:SPSalary,name:薪酬}]}]");
		log.info("薪酬流程启动[保存工单和处理人]: " + workOrderStakeholderDTO.toString());
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
	@ApiOperation(value="薪酬[回单]", tags={"[{202:薪酬,2002:SPSalary(薪酬)},{SPEnd:[{link_id:2001,link_no:SPEnd,name:薪酬流程结束}]}]"})
	public ExecuteResultDTO sPSalary(@RequestBody ExecuteSalaryProcessDTO executeSalaryProcessDTO) throws Exception {
		log.info("[{202:薪酬,2002:SPSalary(薪酬)},{SPEnd:[{link_id:2001,link_no:SPEnd,name:薪酬流程结束}]}]");
		log.info("薪酬流程.薪酬[回单]: " + executeSalaryProcessDTO.toString());
		ExecuteResultDTO executeResult = new ExecuteResultDTO();
		AlmCbSalaryBO almCbSalaryBO = AlmCbSalaryMapper.INSTANCE.dtoToBo(executeSalaryProcessDTO.getAlmCbSalaryDTO());
		try {
			almCbSalaryBO = almCbSalaryService.save(almCbSalaryBO);
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			return executeResult;
		}
		ExecuteProcessBO executeProcessBO = null;
		try {
			executeProcessBO = ProcessUtil.assemblyExecuteProcess(executeSalaryProcessDTO.getExecuteProcessDTO(),
					Long.valueOf(almCbSalaryBO.getSid()), SalaryProcessConstDefine.TEMPLATE_PATH,
					SalaryProcessConstDefine.TEMPLATE_KEY, SalaryProcessConstDefine.OBJ_TYPE,
					ConstDefine.STDHOLDE_TYPE_APPROVAL);
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			return executeResult;
		}
		try {
			if (StringUtils.isBlank(executeProcessBO.getObjectId())) {
				executeProcessBO.setObjectId(String.valueOf(almCbSalaryBO.getSid()));
			}
			if (StringUtils.isBlank(executeProcessBO.getObjectTypeId())) {
				executeProcessBO.setObjectTypeId(SalaryProcessConstDefine.OBJ_TYPE);
			}
			api.finishUserTask(almCbSalaryBO.getApplyStaffId(), executeProcessBO, executeSalaryProcessDTO.getAlmCbFlowDTOs(), Long.valueOf(SalaryProcessTemplates.LINK_ID_2002), SalaryProcessTemplates.LINK_NO_2002);
			executeResult.setCode(1);
			executeResult.setMsg("success");
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		try {
			List<WorkorderBO> workOrderBOs = api.queryWorkorders(almCbSalaryBO.getSid(), Long.valueOf(SalaryProcessTemplates.LINK_ID_2002));
			for (WorkorderBO workorderBO : workOrderBOs) {
				if (workorderBO.getStatus().equals(ConstDefine.STDHOLDE_TYPE_APPROVAL)) {
					executeSalaryProcessDTO.getExecuteProcessDTO().setOrderId(workorderBO.getOrderId());
					executeProcessBO = ProcessUtil.assemblyExecuteProcess(executeSalaryProcessDTO.getExecuteProcessDTO(),
							Long.valueOf(almCbSalaryBO.getSid()), SalaryProcessConstDefine.TEMPLATE_PATH,
							SalaryProcessConstDefine.TEMPLATE_KEY, SalaryProcessConstDefine.OBJ_TYPE,
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
	@ApiOperation(value="薪酬[保存工单和处理人]", tags={"[{202:薪酬,2002:SPSalary(薪酬)},{SPEnd:[{link_id:2001,link_no:SPEnd,name:薪酬流程结束}]}]"})
	public ExecuteResultDTO wsSPSalary(@RequestBody WorkOrderStakeholderDTO workOrderStakeholderDTO) throws Exception {
		log.info("[{202:薪酬,2002:SPSalary(薪酬)},{SPEnd:[{link_id:2001,link_no:SPEnd,name:薪酬流程结束}]}]");
		log.info("薪酬流程.薪酬[保存工单和处理人]: " + workOrderStakeholderDTO.toString());
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

