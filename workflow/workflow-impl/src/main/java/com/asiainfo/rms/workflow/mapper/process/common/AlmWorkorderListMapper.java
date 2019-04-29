package com.asiainfo.rms.workflow.mapper.process.common;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.common.AlmWorkorderListBO;
import com.asiainfo.rms.workflow.bo.process.common.AlmWorkorderListQueryPageBO;
import com.asiainfo.rms.workflow.domain.common.BOAlmWorkorderList;
import com.asiainfo.rms.workflow.dto.process.common.AlmWorkorderListDTO;
import com.asiainfo.rms.workflow.dto.process.common.AlmWorkorderListQueryPageDTO;

/**
 * 
 * 
 * @author joker
 */
@Mapper
public interface AlmWorkorderListMapper {
	
	AlmWorkorderListMapper INSTANCE = Mappers.getMapper(AlmWorkorderListMapper.class);

	@Mappings({
        @Mapping(source = "createTime", target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
        @Mapping(source = "finishTime", target = "finishTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
	})
	public AlmWorkorderListDTO boToDto(AlmWorkorderListBO almWorkorderListBO);
	
	public List<AlmWorkorderListDTO> boToDto(List<AlmWorkorderListBO> almWorkorderListBOs);
	
	public Page<AlmWorkorderListDTO> boToDto(Page<AlmWorkorderListBO> almWorkorderListBOs);

	@Mappings({
		@Mapping(source = "order_id_begin", target = "orderIdBegin"),
		@Mapping(source = "order_id_end", target = "orderIdEnd"),
		@Mapping(source = "obj_type", target = "objType"),
		@Mapping(source = "vm_task_name", target = "vmTaskName"),
		@Mapping(source = "link_no", target = "linkNo"),
		@Mapping(source = "link_id_begin", target = "linkIdBegin"),
		@Mapping(source = "link_id_end", target = "linkIdEnd"),
		@Mapping(source = "link_ids", target = "linkIds"),
		@Mapping(source = "exec_staff_id_begin", target = "execStaffIdBegin"),
		@Mapping(source = "exec_staff_id_end", target = "execStaffIdEnd"),
		@Mapping(source = "exec_staff_code", target = "execStaffCode"),
		@Mapping(source = "exec_employee_name", target = "execEmployeeName"),
		@Mapping(source = "lock_opinion", target = "lockOpinion"),
		@Mapping(source = "create_time_begin", target = "createTimeBegin", dateFormat = "yyyy-MM-dd HH:mm:ss"),
		@Mapping(source = "create_time_end", target = "createTimeEnd", dateFormat = "yyyy-MM-dd HH:mm:ss"),
		@Mapping(source = "finish_time_begin", target = "finishTimeBegin", dateFormat = "yyyy-MM-dd HH:mm:ss"),
		@Mapping(source = "finish_time_end", target = "finishTimeEnd", dateFormat = "yyyy-MM-dd HH:mm:ss"),
		@Mapping(source = "order_type", target = "orderType"),
		@Mapping(source = "cond", target = "cond"),
		@Mapping(source = "result", target = "result"),
		@Mapping(source = "status", target = "status"),
		@Mapping(source = "opinion", target = "opinion"),
		@Mapping(source = "next_link_plantime", target = "nextLinkPlantime"),
		@Mapping(source = "proc_inst_id_begin", target = "procInstIdBegin"),
		@Mapping(source = "proc_inst_id_end", target = "procInstIdEnd"),
		@Mapping(source = "last_order_id_begin", target = "lastOrderIdBegin"),
		@Mapping(source = "last_order_id_end", target = "lastOrderIdEnd"),
		@Mapping(source = "remine_time_begin", target = "remineTimeBegin"),
		@Mapping(source = "remine_time_end", target = "remineTimeEnd"),
		@Mapping(source = "phase_id", target = "phaseId"),
		@Mapping(source = "time_consum_begin", target = "timeConsumBegin"),
		@Mapping(source = "time_consum_end", target = "timeConsumEnd"),
		@Mapping(source = "obj_id_begin", target = "objIdBegin"),
		@Mapping(source = "obj_id_end", target = "objIdEnd"),
		@Mapping(source = "obj_tag", target = "objTag"),
		@Mapping(source = "apply_staff_id_begin", target = "applyStaffIdBegin"),
		@Mapping(source = "apply_staff_id_end", target = "applyStaffIdEnd"),
		@Mapping(source = "apply_staff_name", target = "applyStaffName"),
		@Mapping(source = "apply_staff_code", target = "applyStaffCode"),
        @Mapping(source = "page_no", target = "pageNo"),
        @Mapping(source = "page_size", target = "pageSize")
    })
	public AlmWorkorderListQueryPageBO dtoToBo(AlmWorkorderListQueryPageDTO almWorkorderListQueryPageDTO);
	
	@Mappings({
        @Mapping(source = "createTime", target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
        @Mapping(source = "finishTime", target = "finishTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
	})
	public AlmWorkorderListBO dtoToBo(AlmWorkorderListDTO almWorkorderListDTO);

	@Mappings({
        @Mapping(source = "createTime", target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
        @Mapping(source = "finishTime", target = "finishTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
	})
	public BOAlmWorkorderList boToDomain(AlmWorkorderListBO almWorkorderListBO);

	@Mappings({
        @Mapping(source = "createTime", target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
        @Mapping(source = "finishTime", target = "finishTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
	})
	public AlmWorkorderListBO domainToBo(BOAlmWorkorderList boAlmWorkorderList);
	
	public List<AlmWorkorderListBO> domainToBo(List<BOAlmWorkorderList> boAlmWorkorderLists);
	
	public Page<AlmWorkorderListBO> domainToBo(Page<BOAlmWorkorderList> boAlmWorkorderLists);
}