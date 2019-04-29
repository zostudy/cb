package com.asiainfo.rms.workflow.mapper.process.common;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.common.SysAuthorWorkflowBO;
import com.asiainfo.rms.workflow.bo.process.common.SysAuthorWorkflowQueryPageBO;
import com.asiainfo.rms.workflow.domain.common.BOSysAuthorWorkflow;
import com.asiainfo.rms.workflow.dto.process.common.SysAuthorWorkflowDTO;
import com.asiainfo.rms.workflow.dto.process.common.SysAuthorWorkflowQueryPageDTO;

/**
 * 岗位与工作流关联表
 * 
 * @author joker
 */
@Mapper
public interface SysAuthorWorkflowMapper {
	
	SysAuthorWorkflowMapper INSTANCE = Mappers.getMapper(SysAuthorWorkflowMapper.class);

	@Mappings({
        @Mapping(source = "createDate", target = "createDate", dateFormat = "yyyy-MM-dd HH:mm:ss"),
        @Mapping(source = "endDate", target = "endDate", dateFormat = "yyyy-MM-dd HH:mm:ss")
	})
	public SysAuthorWorkflowDTO boToDto(SysAuthorWorkflowBO sysAuthorWorkflowBO);
	
	public List<SysAuthorWorkflowDTO> boToDto(List<SysAuthorWorkflowBO> sysAuthorWorkflowBOs);
	
	public Page<SysAuthorWorkflowDTO> boToDto(Page<SysAuthorWorkflowBO> sysAuthorWorkflowBOs);

	@Mappings({
		@Mapping(source = "saw_id_begin", target = "sawIdBegin"),
		@Mapping(source = "saw_id_end", target = "sawIdEnd"),
		@Mapping(source = "staff_id_begin", target = "staffIdBegin"),
		@Mapping(source = "staff_id_end", target = "staffIdEnd"),
		@Mapping(source = "code", target = "code"),
		@Mapping(source = "employee_name", target = "employeeName"),
		@Mapping(source = "bill_id", target = "billId"),
		@Mapping(source = "organize_id_begin", target = "organizeIdBegin"),
		@Mapping(source = "organize_id_end", target = "organizeIdEnd"),
		@Mapping(source = "organize_name", target = "organizeName"),
		@Mapping(source = "org_type_begin", target = "orgTypeBegin"),
		@Mapping(source = "org_type_end", target = "orgTypeEnd"),
		@Mapping(source = "create_date_begin", target = "createDateBegin", dateFormat = "yyyy-MM-dd HH:mm:ss"),
		@Mapping(source = "create_date_end", target = "createDateEnd", dateFormat = "yyyy-MM-dd HH:mm:ss"),
		@Mapping(source = "end_date_begin", target = "endDateBegin", dateFormat = "yyyy-MM-dd HH:mm:ss"),
		@Mapping(source = "end_date_end", target = "endDateEnd", dateFormat = "yyyy-MM-dd HH:mm:ss"),
		@Mapping(source = "station_id_begin", target = "stationIdBegin"),
		@Mapping(source = "station_id_end", target = "stationIdEnd"),
		@Mapping(source = "name", target = "name"),
		@Mapping(source = "notes", target = "notes"),
		@Mapping(source = "obj_type", target = "objType"),
		@Mapping(source = "obj_id_begin", target = "objIdBegin"),
		@Mapping(source = "obj_id_end", target = "objIdEnd"),
		@Mapping(source = "link_id_begin", target = "linkIdBegin"),
		@Mapping(source = "link_id_end", target = "linkIdEnd"),
		@Mapping(source = "link_no", target = "linkNo"),
		@Mapping(source = "phase_id", target = "phaseId"),
		@Mapping(source = "phase_name", target = "phaseName"),
		@Mapping(source = "obj_tag", target = "objTag"),
		@Mapping(source = "station_money", target = "stationMoney"),
		@Mapping(source = "station_amount", target = "stationAmount"),
		@Mapping(source = "station_aggregate", target = "stationAggregate"),
		@Mapping(source = "type_begin", target = "typeBegin"),
		@Mapping(source = "type_end", target = "typeEnd"),
		@Mapping(source = "station_people", target = "stationPeople"),
        @Mapping(source = "page_no", target = "pageNo"),
        @Mapping(source = "page_size", target = "pageSize")
    })
	public SysAuthorWorkflowQueryPageBO dtoToBo(SysAuthorWorkflowQueryPageDTO sysAuthorWorkflowQueryPageDTO);
	
	@Mappings({
        @Mapping(source = "createDate", target = "createDate", dateFormat = "yyyy-MM-dd HH:mm:ss"),
        @Mapping(source = "endDate", target = "endDate", dateFormat = "yyyy-MM-dd HH:mm:ss")
	})
	public SysAuthorWorkflowBO dtoToBo(SysAuthorWorkflowDTO sysAuthorWorkflowDTO);

	@Mappings({
        @Mapping(source = "createDate", target = "createDate", dateFormat = "yyyy-MM-dd HH:mm:ss"),
        @Mapping(source = "endDate", target = "endDate", dateFormat = "yyyy-MM-dd HH:mm:ss")
	})
	public BOSysAuthorWorkflow boToDomain(SysAuthorWorkflowBO sysAuthorWorkflowBO);

	@Mappings({
        @Mapping(source = "createDate", target = "createDate", dateFormat = "yyyy-MM-dd HH:mm:ss"),
        @Mapping(source = "endDate", target = "endDate", dateFormat = "yyyy-MM-dd HH:mm:ss")
	})
	public SysAuthorWorkflowBO domainToBo(BOSysAuthorWorkflow boSysAuthorWorkflow);
	
	public List<SysAuthorWorkflowBO> domainToBo(List<BOSysAuthorWorkflow> boSysAuthorWorkflows);
	
	public Page<SysAuthorWorkflowBO> domainToBo(Page<BOSysAuthorWorkflow> boSysAuthorWorkflows);
}