package com.asiainfo.rms.workflow.mapper.common;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.asiainfo.rms.workflow.bo.process.common.AssessBO;
import com.asiainfo.rms.workflow.domain.common.BOAssess;
import com.asiainfo.rms.workflow.dto.process.common.AssessDTO;

@Mapper
public interface AssessMapper {
	AssessMapper INSTANCE = Mappers.getMapper(AssessMapper.class);
	public BOAssess boToEntity(AssessBO assessBO);
	public AssessBO entityToBo(BOAssess boAssess);
	public AssessBO dtoToBo(AssessDTO assessDTO);
	public AssessDTO boToDto(AssessBO assessBO);
	
	public List<AssessBO> entityListToBOList(List<BOAssess> list);
	
	public List<AssessDTO> BOListToDTOList(List<AssessBO> list);
}
