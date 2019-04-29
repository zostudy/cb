package com.asiainfo.rms.workflow.mapper.process.common;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.asiainfo.rms.workflow.bo.process.common.LaunchProcessBO;
import com.asiainfo.rms.workflow.dto.process.common.LaunchProcessDTO;

@Mapper
public interface LaunchProcessMapper {
	
	LaunchProcessMapper INSTANCE = Mappers.getMapper(LaunchProcessMapper.class);

	@Mappings({
		@Mapping(target = "stds", ignore= true),
		@Mapping(target = "cond", ignore= true),
		@Mapping(target = "objectId", ignore= true),
		@Mapping(target = "objectTypeId", ignore= true),
		@Mapping(target = "processKey", ignore= true),
		@Mapping(target = "sourcePath", ignore= true)
	})
	LaunchProcessBO dtoToBo(LaunchProcessDTO launchProcessDTO);
	
	@Mappings({
		@Mapping(target = "stds", ignore= true)
	})
	LaunchProcessDTO boToDto(LaunchProcessBO launchProcessBO);
}
