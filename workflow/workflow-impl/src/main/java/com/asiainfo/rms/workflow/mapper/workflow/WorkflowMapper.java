package com.asiainfo.rms.workflow.mapper.workflow;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.asiainfo.rms.workflow.bo.workflow.WorkflowBO;
import com.asiainfo.rms.workflow.domain.workflow.BOAlmWorkflow;
import com.asiainfo.rms.workflow.dto.common.AlmWorkflowDTO;

@Mapper
public interface WorkflowMapper {
	
	WorkflowMapper INSTANCE = Mappers.getMapper(WorkflowMapper.class);
	
	BOAlmWorkflow boToDomain(WorkflowBO workflowBO);
	
	WorkflowBO domainToBo(BOAlmWorkflow almWorkflow);
	
	AlmWorkflowDTO boToDTO(WorkflowBO almWorkflowBO);
	
	WorkflowBO DTOToBo(AlmWorkflowDTO workflowDTO);
	
	List<AlmWorkflowDTO> BOTODTOList(List<WorkflowBO> almWorkflow);
	List<WorkflowBO> boTOBOList(List<BOAlmWorkflow> almWorkflow);
}
