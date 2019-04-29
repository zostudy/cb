package com.asiainfo.rms.workflow.mapper.workflow;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.asiainfo.rms.workflow.bo.workflow.LinkTimeConfigBO;
import com.asiainfo.rms.workflow.domain.workflow.BOLinkTimeConfig;
import com.asiainfo.rms.workflow.dto.common.LinkTimeConfigDTO;

@Mapper
public interface LinkTimeConfigMapper {

	LinkTimeConfigMapper INSTANCE = Mappers.getMapper(LinkTimeConfigMapper.class);
	
	BOLinkTimeConfig boToDomain(LinkTimeConfigBO linkTimeConfigBO);
	
	LinkTimeConfigBO domainToBo(BOLinkTimeConfig LinkTimeConfig);
	
	LinkTimeConfigDTO boToDTO(LinkTimeConfigBO linkTimeConfigBO);
	
	LinkTimeConfigBO DTOToBo(LinkTimeConfigDTO linkTimeConfigDTO);
}
