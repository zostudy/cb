package com.asiainfo.rms.workflow.mapper.process.common;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.asiainfo.rms.workflow.domain.workflow.BOWorkorderList;
import com.asiainfo.rms.workflow.dto.common.WorkorderListDTO;
@Mapper
public interface WorkorderListMapper {
	WorkorderListMapper INSTANCE = Mappers.getMapper(WorkorderListMapper.class);
	
	WorkorderListDTO boToDTO(BOWorkorderList workorderList);
	
    List<WorkorderListDTO> toDTOs(List<BOWorkorderList> workorderListList);

}
