package com.asiainfo.rms.workflow.mapper.process.cb;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbThermoCompressorBO;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbThermoCompressorQueryPageBO;
import com.asiainfo.rms.workflow.domain.cb.BOAlmCbThermoCompressor;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbThermoCompressorDTO;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbThermoCompressorQueryPageDTO;

/**
 * 
 * 
 * @author joker
 */
@Mapper
public interface AlmCbThermoCompressorMapper {
	
	AlmCbThermoCompressorMapper INSTANCE = Mappers.getMapper(AlmCbThermoCompressorMapper.class);

	public AlmCbThermoCompressorDTO boToDto(AlmCbThermoCompressorBO almCbThermoCompressorBO);
	
	public List<AlmCbThermoCompressorDTO> boToDto(List<AlmCbThermoCompressorBO> almCbThermoCompressorBOs);
	
	public Page<AlmCbThermoCompressorDTO> boToDto(Page<AlmCbThermoCompressorBO> almCbThermoCompressorBOs);

	@Mappings({
		@Mapping(source = "tc_id_begin", target = "tcIdBegin"),
		@Mapping(source = "tc_id_end", target = "tcIdEnd"),
		@Mapping(source = "tc_tag", target = "tcTag"),
		@Mapping(source = "apply_staff_id_begin", target = "applyStaffIdBegin"),
		@Mapping(source = "apply_staff_id_end", target = "applyStaffIdEnd"),
		@Mapping(source = "cur_status_begin", target = "curStatusBegin"),
		@Mapping(source = "cur_status_end", target = "curStatusEnd"),
		@Mapping(source = "cur_phase_begin", target = "curPhaseBegin"),
		@Mapping(source = "cur_phase_end", target = "curPhaseEnd"),
        @Mapping(source = "page_no", target = "pageNo"),
        @Mapping(source = "page_size", target = "pageSize")
    })
	public AlmCbThermoCompressorQueryPageBO dtoToBo(AlmCbThermoCompressorQueryPageDTO almCbThermoCompressorQueryPageDTO);
	
	public AlmCbThermoCompressorBO dtoToBo(AlmCbThermoCompressorDTO almCbThermoCompressorDTO);

	public BOAlmCbThermoCompressor boToDomain(AlmCbThermoCompressorBO almCbThermoCompressorBO);

	public AlmCbThermoCompressorBO domainToBo(BOAlmCbThermoCompressor boAlmCbThermoCompressor);
	
	public List<AlmCbThermoCompressorBO> domainToBo(List<BOAlmCbThermoCompressor> boAlmCbThermoCompressors);
	
	public Page<AlmCbThermoCompressorBO> domainToBo(Page<BOAlmCbThermoCompressor> boAlmCbThermoCompressors);
}