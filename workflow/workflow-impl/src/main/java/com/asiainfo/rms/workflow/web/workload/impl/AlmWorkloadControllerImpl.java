//package com.asiainfo.rms.workflow.web.workload.impl;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.commons.lang.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.asiainfo.rms.core.api.Page;
//import com.asiainfo.rms.workflow.bo.workload.AlmAfpBO;
//import com.asiainfo.rms.workflow.bo.workload.AlmAfpConfigBO;
//import com.asiainfo.rms.workflow.bo.workload.AlmAfpConfigQueryKvBO;
//import com.asiainfo.rms.workflow.bo.workload.AlmAfpQueryPageBO;
//import com.asiainfo.rms.workflow.bo.workload.AlmHisWorkloadBO;
//import com.asiainfo.rms.workflow.bo.workload.AlmStructureDefBO;
//import com.asiainfo.rms.workflow.bo.workload.AlmWorkloadBO;
//import com.asiainfo.rms.workflow.domain.workload.BOAlmAfp;
//import com.asiainfo.rms.workflow.dto.common.ExecuteResultDTO;
//import com.asiainfo.rms.workflow.dto.workload.AlmAfpConfigQueryDTO;
//import com.asiainfo.rms.workflow.dto.workload.AlmAfpDTO;
//import com.asiainfo.rms.workflow.dto.workload.AlmAfpQueryPageDTO;
//import com.asiainfo.rms.workflow.dto.workload.AlmWorkloadDTO;
//import com.asiainfo.rms.workflow.dto.workload.AlmWorkloadQueryDTO;
//import com.asiainfo.rms.workflow.mapper.workload.AlmStructureDefMapper;
//import com.asiainfo.rms.workflow.mapper.workload.AlmWorkloadMapper;
//import com.asiainfo.rms.workflow.service.workload.impl.AlmWorkloadSVImpl;
//import com.asiainfo.rms.workflow.web.workload.IAlmWorkloadController;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.log4j.Log4j;
//
//@Data
//@Log4j
//@Transactional
//@RestController
//@AllArgsConstructor
//@RequiredArgsConstructor
//@Api(value = "工作量相关接口", tags= {"工作量相关接口"})
//public class AlmWorkloadControllerImpl implements IAlmWorkloadController{
//	@Autowired
//	private AlmWorkloadSVImpl almWorkloadSV;
//
//	@Override
//	@ApiOperation(value = "工作量基准信息查询")
//	public ExecuteResultDTO queryAfpConfigByConds(
//			@RequestParam(value = "config_id",required = false)@ApiParam(value = "主键", required = false) Long configId,
//			@RequestParam(value = "function_type",required = false)@ApiParam(value = "功能类型", required = false) Long functionType,
//			@RequestParam(value = "reform_mode",required = false)@ApiParam(value = "改造方式", required = false) Long reformMode,
//			@RequestParam(value = "complexity",required = false)@ApiParam(value = "复杂程度", required = false) Long complexity,
//			@RequestParam(value = "need_it",required = false)@ApiParam(value = "涉及联调", required = false) String needIt,
//			@RequestParam(value = "sys_tag",required = false)@ApiParam(value = "所属系统(取自alm_sys_param, 查询码sysTag)[{4: [41, 49]}, {2: 3, 6, 10, 11, [31, 32], [51, 52]}]", required = false) String sysTag,
//			@RequestParam(value = "page_no",required = false)@ApiParam(value = "查询页码(开始: 1)", required = false) Integer pageNo,
//			@RequestParam(value = "page_size",required = false)@ApiParam(value = "分页步长", required = false) Integer pageSize) {
//		AlmAfpConfigQueryDTO almAfpConfigQuery = new AlmAfpConfigQueryDTO();
//		almAfpConfigQuery.setConfigId(configId);
//		almAfpConfigQuery.setComplexity(complexity);
//		almAfpConfigQuery.setFunctionType(functionType);
//		almAfpConfigQuery.setNeedIt(needIt);
//		almAfpConfigQuery.setReformMode(reformMode);
//		almAfpConfigQuery.setSysTag(sysTag);
//		almAfpConfigQuery.setPageNo(pageNo);
//		almAfpConfigQuery.setPageSize(pageSize);
//		ExecuteResultDTO executeResultDTO = new ExecuteResultDTO();
//		try {
//			Page<AlmAfpConfigBO> almAfpConfigs = almWorkloadSV.queryAfpConfig(AlmWorkloadMapper.INSTANCE.dtoToBo(almAfpConfigQuery));
//			executeResultDTO.setCode(1);
//			executeResultDTO.setMsg("success");
//			executeResultDTO.setObj(AlmWorkloadMapper.INSTANCE.boAfpCfgToDto(almAfpConfigs));
//		} catch (Exception e) {
//			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//			executeResultDTO.setCode(0);
//			executeResultDTO.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//		}
//		return executeResultDTO;
//	}
//
//	@Override
//	@ApiOperation(value = "查询功能点信息")
//	public ExecuteResultDTO queryAfpByConds(
//			@RequestParam(value = "afp_id",required = false)@ApiParam(value = "功能点主键", required = false) Long afpId,
//			@RequestParam(value = "req_id",required = false)@ApiParam(value = "需求关联主键", required = false) Long reqId,
//			@RequestParam(value = "page_no",required = false)@ApiParam(value = "查询页码(开始: 1)", required = false) Integer pageNo,
//			@RequestParam(value = "page_size",required = false)@ApiParam(value = "分页步长", required = false) Integer pageSize) {
//		AlmAfpQueryPageDTO almAfpQueryPage = new AlmAfpQueryPageDTO();
//		almAfpQueryPage.setAfpId(afpId);
//		almAfpQueryPage.setPageNo(pageNo);
//		almAfpQueryPage.setPageSize(pageSize);
//		almAfpQueryPage.setReqId(reqId);
//		AlmAfpQueryPageBO almAfpQueryPageBO = AlmWorkloadMapper.INSTANCE.dtoToBo(almAfpQueryPage);
//		ExecuteResultDTO executeResultDTO = new ExecuteResultDTO();
//		try {
//			Page<AlmAfpBO> page = almWorkloadSV.queryAfpByConds(almAfpQueryPageBO);
//			List<AlmAfpBO> almAfps= page.getPageData();
//			if (!almAfps.isEmpty()) {
//				for(AlmAfpBO almAfp:almAfps){
//					List<AlmStructureDefBO> structureDeflist = almWorkloadSV.getStructureDef(almAfp.getAfpId());
//					String sysStructureIds="";
//					if (!structureDeflist.isEmpty()) {
//						for(AlmStructureDefBO structureDef:structureDeflist){
//							sysStructureIds+=structureDef.getStructureCode()+";";
//						}
//					}
//					if(!"".equals(sysStructureIds))sysStructureIds=sysStructureIds.substring(0, sysStructureIds.length()-1);
//					almAfp.setSysStructureIds(sysStructureIds);
//				}
//			}
//			executeResultDTO.setCode(1);
//			executeResultDTO.setMsg("success");
//			executeResultDTO.setObj(AlmWorkloadMapper.INSTANCE.boAfpToDto(page));
//		} catch (Exception e) {
//			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//			executeResultDTO.setCode(0);
//			executeResultDTO.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//		}
//		return executeResultDTO;
//	}
//
//	@Override
//	@ApiOperation(value = "保存功能点信息")
//	public ExecuteResultDTO saveAfp(@RequestBody AlmAfpDTO almAfp) {
//		ExecuteResultDTO executeResultDTO = new ExecuteResultDTO();
//		try {
//			executeResultDTO.setCode(1);
//			executeResultDTO.setMsg("success");
//			Map<String, Long> primaryKey = new HashMap<String, Long>();
//			//保存关联结构 
//			long afpId = this.generateStructureDef(almAfp.getSysStructureIds(), almAfp);
//			primaryKey.put("afp_id", afpId);
//			executeResultDTO.setObj(primaryKey);
//		} catch (Exception e) {
//			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//			executeResultDTO.setCode(0);
//			executeResultDTO.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//		}
//		return executeResultDTO;
//	}
//	
//	public long generateStructureDef(String StructureIds,AlmAfpDTO almAfp) throws Exception{
//		AlmAfpBO almAfpBO = almWorkloadSV.save(AlmWorkloadMapper.INSTANCE.dtoToBo(almAfp));
//		long afpId=almAfpBO.getAfpId();
//		if(null==StructureIds || "".equals(StructureIds)) return afpId;
//		String[] StructureIdValues = StructureIds.split(";");
//		for(int i=0;i<StructureIdValues.length;i++){
//			AlmStructureDefBO structureDefBO =new AlmStructureDefBO();
//			structureDefBO.setAfpId(afpId);
//			structureDefBO.setStructureCode(StructureIdValues[i]);
//			almWorkloadSV.saveStructureDef( structureDefBO );
//		}
//		return afpId;
//	}
//
//	@Override
//	@ApiOperation(value = "更新功能点信息")
//	public ExecuteResultDTO updateAfp(@RequestBody AlmAfpDTO almAfp) {
//		ExecuteResultDTO executeResultDTO = new ExecuteResultDTO();
//		try {
//			//保存关联结构，保存之前先删除
//			almWorkloadSV.delStructureDef(almAfp.getAfpId());
//			this.generateStructureDefupdate(almAfp.getSysStructureIds(),almAfp);
//			executeResultDTO.setCode(1);
//			executeResultDTO.setMsg("success");
//		} catch (Exception e) {
//			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//			executeResultDTO.setCode(0);
//			executeResultDTO.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//		}
//		return executeResultDTO;
//	}
//	public void generateStructureDefupdate(String StructureIds,AlmAfpDTO almAfp) throws Exception{
//		AlmAfpBO almAfpBO = almWorkloadSV.update(AlmWorkloadMapper.INSTANCE.dtoToBo(almAfp));
//		long afpId=almAfpBO.getAfpId();
//		if(null==StructureIds || "".equals(StructureIds)) return ;
//		String[] StructureIdValues = StructureIds.split(";");
//		for(int i=0;i<StructureIdValues.length;i++){
//			AlmStructureDefBO structureDefBO =new AlmStructureDefBO();
//			structureDefBO.setAfpId(afpId);
//			structureDefBO.setStructureCode(StructureIdValues[i]);
//			almWorkloadSV.saveStructureDef( structureDefBO );
//		}
//	}
//	@Override
//	@ApiOperation(value = "删除功能点信息依据主键列表")
//	public ExecuteResultDTO deleteAfp(@RequestParam(value = "afp_ids", required = true) @ApiParam(value = "功能点主键列表", required = true)String afpIds) {
//		ExecuteResultDTO executeResultDTO = new ExecuteResultDTO();
//		try {
//			//转移到历史
//			this.copyStructureDefToHis(Long.parseLong(afpIds));
//			Integer count = almWorkloadSV.deleteAfp(afpIds);
//			executeResultDTO.setCode(1);
//			executeResultDTO.setMsg("success");
//			Map<String, Integer> countMap = new HashMap<String, Integer>();
//			countMap.put("row_count", count);
//			executeResultDTO.setObj(countMap);
//		} catch (Exception e) {
//			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//			executeResultDTO.setCode(0);
//			executeResultDTO.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//		}
//		return executeResultDTO;
//	}
//	
//	public void copyStructureDefToHis(long afpId) throws Exception{
//		List<AlmStructureDefBO> list= almWorkloadSV.getStructureDef(afpId);
//		for(AlmStructureDefBO value:list){
//			almWorkloadSV.saveStructureDefHis(AlmStructureDefMapper.INSTANCE.boToHisbo(value));
//		}
//		almWorkloadSV.delStructureDef(afpId);
//	}
//
//	@Override
//	@ApiOperation(value = "查询功能点基准信息<主键, 名称>")
//	public ExecuteResultDTO queryAfpCfgKV() {
//		ExecuteResultDTO executeResultDTO = new ExecuteResultDTO();
//		try {
//			List<AlmAfpConfigQueryKvBO> almAfpConfigQueryKvs = almWorkloadSV.queryAfpConfgKv();
//			executeResultDTO.setCode(1);
//			executeResultDTO.setMsg("success");
//			executeResultDTO.setObj(AlmWorkloadMapper.INSTANCE.queryKvBosToQueryKvDtos(almAfpConfigQueryKvs));
//		} catch (Exception e) {
//			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//			executeResultDTO.setCode(0);
//			executeResultDTO.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//		}
//		return executeResultDTO;
//	}
//
//	@Override
//	@ApiOperation(value = "删除工作量信息依据主键列表")
//	public ExecuteResultDTO deleteWorkload(@RequestParam(value = "workload_ids", required = true)@ApiParam(value = "工作量主键列表", required = true) String workloadIds) {
//		ExecuteResultDTO executeResultDTO = new ExecuteResultDTO();
//		try {
//			Integer count = almWorkloadSV.deleteWorkload(workloadIds);
//			executeResultDTO.setCode(1);
//			executeResultDTO.setMsg("success");
//			Map<String, Integer> countMap = new HashMap<String, Integer>();
//			countMap.put("row_count", count);
//			executeResultDTO.setObj(countMap);
//		} catch (Exception e) {
//			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//			executeResultDTO.setCode(0);
//			executeResultDTO.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//		}
//		return executeResultDTO;
//	}
//
//	@Override
//	@ApiOperation(value = "查询工作量信息")
//	public ExecuteResultDTO queryWorkloadByConds(
//			@RequestParam(value = "workload_id",required = false)@ApiParam(value = "工作量主键", required = false) Long workloadId,
//			@RequestParam(value = "req_id",required = false)@ApiParam(value = "需求表关联主键", required = false) Long reqId,
//			@RequestParam(value = "staff_id",required = false)@ApiParam(value = "人员员工主键") Long staffId,
//			@RequestParam(value = "staff_name",required = false)@ApiParam(value = "人员员工名称") String staffName,
//			@RequestParam(value = "work_content",required = false)@ApiParam(value = "工作内容(存储格式: 功能点名称1, 功能点名称2, 功能点名称3)") String workContent,
//			@RequestParam(value = "plan_start_time_start",required = false)@ApiParam(value = "计划开始时间(开始)") String planStartTimeStart,
//			@RequestParam(value = "plan_start_time_end",required = false)@ApiParam(value = "计划开始时间(结束)") String planStartTimeEnd,
//			@RequestParam(value = "plan_end_time_start",required = false)@ApiParam(value = "计划结束时间(开始)") String planEndTimeStart,
//			@RequestParam(value = "plan_end_time_end",required = false)@ApiParam(value = "计划结束时间(结束)") String planEndTimeEnd,
//			@RequestParam(value = "real_start_time_start",required = false)@ApiParam(value = "实际开始时间(开始)") String realStartTimeStart,
//			@RequestParam(value = "real_start_time_end",required = false)@ApiParam(value = "实际开始时间(结束)") String realStartTimeEnd,
//			@RequestParam(value = "real_end_time_start",required = false)@ApiParam(value = "实际结束时间(开始)") String realEndTimeStart,
//			@RequestParam(value = "real_end_time_end",required = false)@ApiParam(value = "实际结束时间(结束)") String realEndTimeEnd,
//			@RequestParam(value = "part_id",required = false)@ApiParam(value = "业务标签") Long partId,
//			@RequestParam(value = "link_no",required = false)@ApiParam(value = "环节编码") String linkNo,
//			@RequestParam(value = "mark",required = false)@ApiParam(value = "工作量标签") String mark,
//			@RequestParam(value = "order_id",required = false)@ApiParam(value = "工单主键") Long orderId,
//			@RequestParam(value = "estimate_work_start",required = false)@ApiParam(value = "预估工作量(开始)") Double estimateWorkStart,
//			@RequestParam(value = "estimate_work_end",required = false)@ApiParam(value = "预估工作量(结束)") Double estimateWorkEnd,
//			@RequestParam(value = "real_work_start",required = false)@ApiParam(value = "实际工作量(开始)") Double realWorkStart,
//			@RequestParam(value = "real_work_end",required = false)@ApiParam(value = "实际工作量(结束)") Double realWorkEnd,
//			@RequestParam(value = "afp_ids",required = false)@ApiParam(value = "功能点主键列表(存储格式: 功能点主键1, 功能点主键2, 功能点主键3)") String afpIds,
//			@RequestParam(value = "page_no",required = false)@ApiParam(value = "查询页码(开始: 1)", required = false) Integer pageNo,
//			@RequestParam(value = "page_size",required = false)@ApiParam(value = "分页步长", required = false) Integer pageSize) {
//		ExecuteResultDTO executeResultDTO = new ExecuteResultDTO();
//		AlmWorkloadQueryDTO almWorkloadQuery = new AlmWorkloadQueryDTO();
//		almWorkloadQuery.setWorkloadId(workloadId);
//		almWorkloadQuery.setReqId(reqId);
//		almWorkloadQuery.setStaffId(staffId);
//		almWorkloadQuery.setStaffName(staffName);
//		almWorkloadQuery.setWorkContent(workContent);
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		if (!StringUtils.isBlank(planStartTimeStart)) {
//			try {
//				almWorkloadQuery.setPlanStartTimeStart(sdf.parse(planStartTimeStart));
//			} catch (ParseException e) {
//				executeResultDTO.setCode(0);
//				executeResultDTO.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//				log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//				return executeResultDTO;
//			}
//		}
//		if (!StringUtils.isBlank(planStartTimeEnd)) {
//			try {
//				almWorkloadQuery.setPlanStartTimeEnd(sdf.parse(planStartTimeEnd));
//			} catch (ParseException e) {
//				executeResultDTO.setCode(0);
//				executeResultDTO.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//				log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//				return executeResultDTO;
//			}
//		}
//		if (!StringUtils.isBlank(planEndTimeStart)) {
//			try {
//				almWorkloadQuery.setPlanEndTimeStart(sdf.parse(planEndTimeStart));
//			} catch (ParseException e) {
//				executeResultDTO.setCode(0);
//				executeResultDTO.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//				log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//				return executeResultDTO;
//			}
//		}
//		if (!StringUtils.isBlank(planEndTimeEnd)) {
//			try {
//				almWorkloadQuery.setPlanEndTimeEnd(sdf.parse(planEndTimeEnd));
//			} catch (ParseException e) {
//				executeResultDTO.setCode(0);
//				executeResultDTO.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//				log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//				return executeResultDTO;
//			}
//		}
//		if (!StringUtils.isBlank(realStartTimeStart)) {
//			try {
//				almWorkloadQuery.setRealStartTimeStart(sdf.parse(realStartTimeStart));
//			} catch (ParseException e) {
//				executeResultDTO.setCode(0);
//				executeResultDTO.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//				log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//				return executeResultDTO;
//			}
//		}
//		if (!StringUtils.isBlank(realStartTimeEnd)) {
//			try {
//				almWorkloadQuery.setRealStartTimeEnd(sdf.parse(realStartTimeEnd));
//			} catch (ParseException e) {
//				executeResultDTO.setCode(0);
//				executeResultDTO.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//				log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//				return executeResultDTO;
//			}
//		}
//		if (!StringUtils.isBlank(realEndTimeStart)) {
//			try {
//				almWorkloadQuery.setRealEndTimeStart(sdf.parse(realEndTimeStart));
//			} catch (ParseException e) {
//				executeResultDTO.setCode(0);
//				executeResultDTO.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//				log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//				return executeResultDTO;
//			}
//		}
//		if (!StringUtils.isBlank(realEndTimeEnd)) {
//			try {
//				almWorkloadQuery.setRealEndTimeEnd(sdf.parse(realEndTimeEnd));
//			} catch (ParseException e) {
//				executeResultDTO.setCode(0);
//				executeResultDTO.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//				log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//				return executeResultDTO;
//			}
//		}
//		almWorkloadQuery.setPartId(partId);
//		almWorkloadQuery.setLinkNo(linkNo);
//		almWorkloadQuery.setMark(mark);
//		almWorkloadQuery.setOrderId(orderId);
//		almWorkloadQuery.setEstimateWorkStart(estimateWorkStart);
//		almWorkloadQuery.setEstimateWorkEnd(estimateWorkEnd);
//		almWorkloadQuery.setRealWorkStart(realWorkStart);
//		almWorkloadQuery.setRealWorkEnd(realWorkEnd);
//		almWorkloadQuery.setAfpIds(afpIds);
//		almWorkloadQuery.setPageNo(pageNo);
//		almWorkloadQuery.setPageSize(pageSize);
//		try {
//			Page<AlmWorkloadBO> page = almWorkloadSV.queryWorkloadByConds(AlmWorkloadMapper.INSTANCE.dtoToBo(almWorkloadQuery));
//			executeResultDTO.setCode(1);
//			executeResultDTO.setMsg("success");
//			executeResultDTO.setObj(AlmWorkloadMapper.INSTANCE.boWorkloadToDto(page));
//		} catch (Exception e) {
//			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//			executeResultDTO.setCode(0);
//			executeResultDTO.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//		}
//		return executeResultDTO;
//	}
//
//	@Override
//	@ApiOperation(value = "工作量信息保存接口")
//	public ExecuteResultDTO save(@RequestBody AlmWorkloadDTO almWorkload) {
//		ExecuteResultDTO executeResultDTO = new ExecuteResultDTO();
//		try {
//			List<AlmWorkloadBO> boList = almWorkloadSV.queryByStaffReq(almWorkload.getStaffId(),almWorkload.getReqId(),null);
//			if(boList != null && boList.size()>0){
//				executeResultDTO.setCode(0);
//				executeResultDTO.setMsg("该开发人员已分配功能开发");
//			}else{
//				AlmWorkloadBO almWorkloadBO = almWorkloadSV.save(AlmWorkloadMapper.INSTANCE.dtoToBo(almWorkload));
//				executeResultDTO.setCode(1);
//				executeResultDTO.setMsg("success");
//				Map<String, Long> primaryKey = new HashMap<String, Long>();
//				primaryKey.put("workload_id", almWorkloadBO.getWorkloadId());
//				executeResultDTO.setObj(primaryKey);
//			}
//		} catch (Exception e) {
//			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//			executeResultDTO.setCode(0);
//			executeResultDTO.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//		}
//		return executeResultDTO;
//	}
//
//	@Override
//	@ApiOperation(value = "更新工作量信息接口")
//	public ExecuteResultDTO update(@RequestBody AlmWorkloadDTO almWorkload) {
//		ExecuteResultDTO executeResultDTO = new ExecuteResultDTO();
//		try {
//			List<AlmWorkloadBO> boList = almWorkloadSV.queryByStaffReq(almWorkload.getStaffId(),almWorkload.getReqId(),almWorkload.getWorkloadId());
//			if(boList != null && boList.size()>0){
//				executeResultDTO.setCode(0);
//				executeResultDTO.setMsg("该开发人员已分配功能开发");
//			}else{
//				almWorkloadSV.update(AlmWorkloadMapper.INSTANCE.dtoToBo(almWorkload));
//				executeResultDTO.setCode(1);
//				executeResultDTO.setMsg("success");
//			}
//		} catch (Exception e) {
//			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//			executeResultDTO.setCode(0);
//			executeResultDTO.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//		}
//		return executeResultDTO;
//	}
//
//	@Override
//	@ApiOperation(value = "查询工作量历史信息")
//	public ExecuteResultDTO queryHisWorkloadByConds(
//			@RequestParam(value = "his_worklod_id",required = false)@ApiParam(value = "工作量历史主键", required = false) Long hisWorklodId,
//			@RequestParam(value = "workload_id",required = false)@ApiParam(value = "工作量主键", required = false) Long workloadId,
//			@RequestParam(value = "req_id",required = false)@ApiParam(value = "需求表关联主键", required = false) Long reqId,
//			@RequestParam(value = "staff_id",required = false)@ApiParam(value = "人员员工主键") Long staffId,
//			@RequestParam(value = "staff_name",required = false)@ApiParam(value = "人员员工名称") String staffName,
//			@RequestParam(value = "work_content",required = false)@ApiParam(value = "工作内容(存储格式: 功能点名称1, 功能点名称2, 功能点名称3)") String workContent,
//			@RequestParam(value = "plan_start_time_start",required = false)@ApiParam(value = "计划开始时间(开始)") String planStartTimeStart,
//			@RequestParam(value = "plan_start_time_end",required = false)@ApiParam(value = "计划开始时间(结束)") String planStartTimeEnd,
//			@RequestParam(value = "plan_end_time_start",required = false)@ApiParam(value = "计划结束时间(开始)") String planEndTimeStart,
//			@RequestParam(value = "plan_end_time_end",required = false)@ApiParam(value = "计划结束时间(结束)") String planEndTimeEnd,
//			@RequestParam(value = "real_start_time_start",required = false)@ApiParam(value = "实际开始时间(开始)") String realStartTimeStart,
//			@RequestParam(value = "real_start_time_end",required = false)@ApiParam(value = "实际开始时间(结束)") String realStartTimeEnd,
//			@RequestParam(value = "real_end_time_start",required = false)@ApiParam(value = "实际结束时间(开始)") String realEndTimeStart,
//			@RequestParam(value = "real_end_time_end",required = false)@ApiParam(value = "实际结束时间(结束)") String realEndTimeEnd,
//			@RequestParam(value = "part_id",required = false)@ApiParam(value = "业务标签") Long partId,
//			@RequestParam(value = "link_no",required = false)@ApiParam(value = "环节编码") String linkNo,
//			@RequestParam(value = "mark",required = false)@ApiParam(value = "工作量标签") String mark,
//			@RequestParam(value = "order_id",required = false)@ApiParam(value = "工单主键") Long orderId,
//			@RequestParam(value = "estimate_work_start",required = false)@ApiParam(value = "预估工作量(开始)") Double estimateWorkStart,
//			@RequestParam(value = "estimate_work_end",required = false)@ApiParam(value = "预估工作量(结束)") Double estimateWorkEnd,
//			@RequestParam(value = "real_work_start",required = false)@ApiParam(value = "实际工作量(开始)") Double realWorkStart,
//			@RequestParam(value = "real_work_end",required = false)@ApiParam(value = "实际工作量(结束)") Double realWorkEnd,
//			@RequestParam(value = "afp_ids",required = false)@ApiParam(value = "功能点主键列表(存储格式: 功能点主键1, 功能点主键2, 功能点主键3)") String afpIds,
//			@RequestParam(value = "page_no",required = false)@ApiParam(value = "查询页码(开始: 1)", required = false) Integer pageNo,
//			@RequestParam(value = "page_size",required = false)@ApiParam(value = "分页步长", required = false) Integer pageSize) {
//		ExecuteResultDTO executeResultDTO = new ExecuteResultDTO();
//		AlmWorkloadQueryDTO almWorkloadQuery = new AlmWorkloadQueryDTO();
//		almWorkloadQuery.setHisWorklodId(hisWorklodId);
//		almWorkloadQuery.setWorkloadId(workloadId);
//		almWorkloadQuery.setReqId(reqId);
//		almWorkloadQuery.setStaffId(staffId);
//		almWorkloadQuery.setStaffName(staffName);
//		almWorkloadQuery.setWorkContent(workContent);
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		if (!StringUtils.isBlank(planStartTimeStart)) {
//			try {
//				almWorkloadQuery.setPlanStartTimeStart(sdf.parse(planStartTimeStart));
//			} catch (ParseException e) {
//				executeResultDTO.setCode(0);
//				executeResultDTO.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//				log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//				return executeResultDTO;
//			}
//		}
//		if (!StringUtils.isBlank(planStartTimeEnd)) {
//			try {
//				almWorkloadQuery.setPlanStartTimeEnd(sdf.parse(planStartTimeEnd));
//			} catch (ParseException e) {
//				executeResultDTO.setCode(0);
//				executeResultDTO.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//				log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//				return executeResultDTO;
//			}
//		}
//		if (!StringUtils.isBlank(planEndTimeStart)) {
//			try {
//				almWorkloadQuery.setPlanEndTimeStart(sdf.parse(planEndTimeStart));
//			} catch (ParseException e) {
//				executeResultDTO.setCode(0);
//				executeResultDTO.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//				log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//				return executeResultDTO;
//			}
//		}
//		if (!StringUtils.isBlank(planEndTimeEnd)) {
//			try {
//				almWorkloadQuery.setPlanEndTimeEnd(sdf.parse(planEndTimeEnd));
//			} catch (ParseException e) {
//				executeResultDTO.setCode(0);
//				executeResultDTO.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//				log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//				return executeResultDTO;
//			}
//		}
//		if (!StringUtils.isBlank(realStartTimeStart)) {
//			try {
//				almWorkloadQuery.setRealStartTimeStart(sdf.parse(realStartTimeStart));
//			} catch (ParseException e) {
//				executeResultDTO.setCode(0);
//				executeResultDTO.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//				log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//				return executeResultDTO;
//			}
//		}
//		if (!StringUtils.isBlank(realStartTimeEnd)) {
//			try {
//				almWorkloadQuery.setRealStartTimeEnd(sdf.parse(realStartTimeEnd));
//			} catch (ParseException e) {
//				executeResultDTO.setCode(0);
//				executeResultDTO.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//				log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//				return executeResultDTO;
//			}
//		}
//		if (!StringUtils.isBlank(realEndTimeStart)) {
//			try {
//				almWorkloadQuery.setRealEndTimeStart(sdf.parse(realEndTimeStart));
//			} catch (ParseException e) {
//				executeResultDTO.setCode(0);
//				executeResultDTO.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//				log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//				return executeResultDTO;
//			}
//		}
//		if (!StringUtils.isBlank(realEndTimeEnd)) {
//			try {
//				almWorkloadQuery.setRealEndTimeEnd(sdf.parse(realEndTimeEnd));
//			} catch (ParseException e) {
//				executeResultDTO.setCode(0);
//				executeResultDTO.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//				log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//				return executeResultDTO;
//			}
//		}
//		almWorkloadQuery.setPartId(partId);
//		almWorkloadQuery.setLinkNo(linkNo);
//		almWorkloadQuery.setMark(mark);
//		almWorkloadQuery.setOrderId(orderId);
//		almWorkloadQuery.setEstimateWorkStart(estimateWorkStart);
//		almWorkloadQuery.setEstimateWorkEnd(estimateWorkEnd);
//		almWorkloadQuery.setRealWorkStart(realWorkStart);
//		almWorkloadQuery.setRealWorkEnd(realWorkEnd);
//		almWorkloadQuery.setAfpIds(afpIds);
//		almWorkloadQuery.setPageNo(pageNo);
//		almWorkloadQuery.setPageSize(pageSize);
//		try {
//			Page<AlmHisWorkloadBO> page = almWorkloadSV.queryHisWorkloadByConds(AlmWorkloadMapper.INSTANCE.dtoToBo(almWorkloadQuery));
//			executeResultDTO.setCode(1);
//			executeResultDTO.setMsg("success");
//			executeResultDTO.setObj(AlmWorkloadMapper.INSTANCE.boHisWorkloadToDto(page));
//		} catch (Exception e) {
//			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//			executeResultDTO.setCode(0);
//			executeResultDTO.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//		}
//		return executeResultDTO;
//	}
//	
//	
//	@Override
//	@ApiOperation(value = "查询工作量预估工作量总量")
//	public ExecuteResultDTO queryWorkloadEstimateCount(
//			@RequestParam(value = "req_id",required = false)@ApiParam(value = "需求编号") Long reqId) {
//		ExecuteResultDTO executeResultDTO = new ExecuteResultDTO();
//		try {
//			double count = almWorkloadSV.queryWorkloadEstimateCount(reqId);
//			executeResultDTO.setCode(1);
//			executeResultDTO.setMsg("success");
//			executeResultDTO.setObj(count);
//		} catch (Exception e) {
//			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//			executeResultDTO.setCode(0);
//			executeResultDTO.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
//		}
//		return executeResultDTO;
//	}
//}
