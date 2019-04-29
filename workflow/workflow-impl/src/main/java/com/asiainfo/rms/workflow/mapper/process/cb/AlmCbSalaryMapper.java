package com.asiainfo.rms.workflow.mapper.process.cb;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbSalaryBO;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbSalaryQueryPageBO;
import com.asiainfo.rms.workflow.domain.cb.BOAlmCbSalary;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbSalaryDTO;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbSalaryQueryPageDTO;

/**
 * 
 * 
 * @author joker
 */
@Mapper
public interface AlmCbSalaryMapper {
	
	AlmCbSalaryMapper INSTANCE = Mappers.getMapper(AlmCbSalaryMapper.class);

	public AlmCbSalaryDTO boToDto(AlmCbSalaryBO almCbSalaryBO);
	
	public List<AlmCbSalaryDTO> boToDto(List<AlmCbSalaryBO> almCbSalaryBOs);
	
	public Page<AlmCbSalaryDTO> boToDto(Page<AlmCbSalaryBO> almCbSalaryBOs);

	@Mappings({
		@Mapping(source = "s_id_begin", target = "sidBegin"),
		@Mapping(source = "s_id_end", target = "sidEnd"),
		@Mapping(source = "s_tag", target = "stag"),
		@Mapping(source = "apply_staff_id_begin", target = "applyStaffIdBegin"),
		@Mapping(source = "apply_staff_id_end", target = "applyStaffIdEnd"),
		@Mapping(source = "cur_status_begin", target = "curStatusBegin"),
		@Mapping(source = "cur_status_end", target = "curStatusEnd"),
		@Mapping(source = "cur_phase_begin", target = "curPhaseBegin"),
		@Mapping(source = "cur_phase_end", target = "curPhaseEnd"),
        @Mapping(source = "page_no", target = "pageNo"),
        @Mapping(source = "page_size", target = "pageSize")
    })
	public AlmCbSalaryQueryPageBO dtoToBo(AlmCbSalaryQueryPageDTO almCbSalaryQueryPageDTO);
	
	public AlmCbSalaryBO dtoToBo(AlmCbSalaryDTO almCbSalaryDTO);

	public BOAlmCbSalary boToDomain(AlmCbSalaryBO almCbSalaryBO);

	public AlmCbSalaryBO domainToBo(BOAlmCbSalary boAlmCbSalary);
	
	public List<AlmCbSalaryBO> domainToBo(List<BOAlmCbSalary> boAlmCbSalarys);
	
	public Page<AlmCbSalaryBO> domainToBo(Page<BOAlmCbSalary> boAlmCbSalarys);
}