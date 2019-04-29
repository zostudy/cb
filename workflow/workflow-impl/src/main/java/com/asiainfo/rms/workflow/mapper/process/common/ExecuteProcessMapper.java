package com.asiainfo.rms.workflow.mapper.process.common;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.asiainfo.rms.workflow.bo.process.common.ExecuteProcessBO;
import com.asiainfo.rms.workflow.dto.process.common.ExecuteProcessDTO;

@Mapper
public interface ExecuteProcessMapper {
	
	ExecuteProcessMapper INSTANCE = Mappers.getMapper(ExecuteProcessMapper.class);

	@Mappings({
		@Mapping(target = "stds", ignore= true),
		@Mapping(target = "cond", ignore= true),
		@Mapping(target = "objectId", ignore= true),
		@Mapping(target = "objectTypeId", ignore= true)
	})
	ExecuteProcessBO dtoToBo(ExecuteProcessDTO executeProcessDTO);
	
	@Mappings({
		@Mapping(target = "stds", ignore= true)
	})
	ExecuteProcessDTO boToDto(ExecuteProcessBO executeProcessBO);
}
