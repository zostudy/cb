package com.asiainfo.rms.workflow.mapper.workflow;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.asiainfo.rms.workflow.bo.workflow.WorkflowTempateBO;
import com.asiainfo.rms.workflow.domain.workflow.BOWorkflowTempate;
import com.asiainfo.rms.workflow.dto.common.WorkflowTempateDTO;
@Mapper
public interface WorkflowTempateMapper {
	WorkflowTempateMapper INSTANCE = Mappers.getMapper(WorkflowTempateMapper.class);
	
	BOWorkflowTempate boToDomain(WorkflowTempateBO WorkflowTempateBO);
	
	WorkflowTempateBO domainToBo(BOWorkflowTempate WorkflowTempate);
	
	WorkflowTempateDTO boToDTO(WorkflowTempateBO WorkflowTempateBO);
	
	WorkflowTempateBO DTOToBo(WorkflowTempateDTO workflowTempateDTO);
	
	List<WorkflowTempateDTO> BOTODTOList(List<WorkflowTempateBO> WorkflowTempate);
	List<WorkflowTempateBO> boTOBOList(List<BOWorkflowTempate> WorkflowTempate);
}
