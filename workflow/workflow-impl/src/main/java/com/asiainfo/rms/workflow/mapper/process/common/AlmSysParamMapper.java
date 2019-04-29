package com.asiainfo.rms.workflow.mapper.process.common;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.common.AlmSysParamBO;
import com.asiainfo.rms.workflow.bo.process.common.AlmSysParamQueryPageBO;
import com.asiainfo.rms.workflow.domain.common.BOAlmSysParam;
import com.asiainfo.rms.workflow.dto.process.common.AlmSysParamDTO;
import com.asiainfo.rms.workflow.dto.process.common.AlmSysParamQueryPageDTO;

/**
 * 
 * 
 * @author joker
 */
@Mapper
public interface AlmSysParamMapper {
	
	AlmSysParamMapper INSTANCE = Mappers.getMapper(AlmSysParamMapper.class);

	public AlmSysParamDTO boToDto(AlmSysParamBO almSysParamBO);
	
	public List<AlmSysParamDTO> boToDto(List<AlmSysParamBO> almSysParamBOs);
	
	public Page<AlmSysParamDTO> boToDto(Page<AlmSysParamBO> almSysParamBOs);

	@Mappings({
		@Mapping(source = "param_type", target = "paramType"),
		@Mapping(source = "param_id_begin", target = "paramIdBegin"),
		@Mapping(source = "param_id_end", target = "paramIdEnd"),
		@Mapping(source = "param_no", target = "paramNo"),
		@Mapping(source = "param_name", target = "paramName"),
		@Mapping(source = "param_disc", target = "paramDisc"),
		@Mapping(source = "param_rela_id_begin", target = "paramRelaIdBegin"),
		@Mapping(source = "param_rela_id_end", target = "paramRelaIdEnd"),
		@Mapping(source = "param_value_begin", target = "paramValueBegin"),
		@Mapping(source = "param_value_end", target = "paramValueEnd"),
		@Mapping(source = "sort_id_begin", target = "sortIdBegin"),
		@Mapping(source = "sort_id_end", target = "sortIdEnd"),
        @Mapping(source = "page_no", target = "pageNo"),
        @Mapping(source = "page_size", target = "pageSize")
    })
	public AlmSysParamQueryPageBO dtoToBo(AlmSysParamQueryPageDTO almSysParamQueryPageDTO);
	
	public AlmSysParamBO dtoToBo(AlmSysParamDTO almSysParamDTO);

	public BOAlmSysParam boToDomain(AlmSysParamBO almSysParamBO);

	public AlmSysParamBO domainToBo(BOAlmSysParam boAlmSysParam);
	
	public List<AlmSysParamBO> domainToBo(List<BOAlmSysParam> boAlmSysParams);
	
	public Page<AlmSysParamBO> domainToBo(Page<BOAlmSysParam> boAlmSysParams);
}