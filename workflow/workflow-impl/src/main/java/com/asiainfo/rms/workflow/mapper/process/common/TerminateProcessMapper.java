package com.asiainfo.rms.workflow.mapper.process.common;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.asiainfo.rms.workflow.bo.process.common.TerminateProcessBO;
import com.asiainfo.rms.workflow.dto.process.common.TerminateProcessDTO;

@Mapper
public interface TerminateProcessMapper {
	
	TerminateProcessMapper INSTANCE = Mappers.getMapper(TerminateProcessMapper.class);
	
	TerminateProcessDTO boToDto(TerminateProcessBO terminateProcessBO);
	
	@Mappings({
		@Mapping(target = "objType", ignore= true)
	})
	TerminateProcessBO dtoToBo(TerminateProcessDTO terminateProcessDTO);
}
