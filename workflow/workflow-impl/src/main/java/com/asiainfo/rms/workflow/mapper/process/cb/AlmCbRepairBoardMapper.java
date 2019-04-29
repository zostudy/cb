package com.asiainfo.rms.workflow.mapper.process.cb;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbRepairBoardBO;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbRepairBoardQueryPageBO;
import com.asiainfo.rms.workflow.domain.cb.BOAlmCbRepairBoard;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbRepairBoardDTO;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbRepairBoardQueryPageDTO;

/**
 * 
 * 
 * @author joker
 */
@Mapper
public interface AlmCbRepairBoardMapper {
	
	AlmCbRepairBoardMapper INSTANCE = Mappers.getMapper(AlmCbRepairBoardMapper.class);

	public AlmCbRepairBoardDTO boToDto(AlmCbRepairBoardBO almCbRepairBoardBO);
	
	public List<AlmCbRepairBoardDTO> boToDto(List<AlmCbRepairBoardBO> almCbRepairBoardBOs);
	
	public Page<AlmCbRepairBoardDTO> boToDto(Page<AlmCbRepairBoardBO> almCbRepairBoardBOs);

	@Mappings({
		@Mapping(source = "rb_id_begin", target = "rbIdBegin"),
		@Mapping(source = "rb_id_end", target = "rbIdEnd"),
		@Mapping(source = "rb_tag", target = "rbTag"),
		@Mapping(source = "apply_staff_id_begin", target = "applyStaffIdBegin"),
		@Mapping(source = "apply_staff_id_end", target = "applyStaffIdEnd"),
		@Mapping(source = "cur_status_begin", target = "curStatusBegin"),
		@Mapping(source = "cur_status_end", target = "curStatusEnd"),
		@Mapping(source = "cur_phase_begin", target = "curPhaseBegin"),
		@Mapping(source = "cur_phase_end", target = "curPhaseEnd"),
        @Mapping(source = "page_no", target = "pageNo"),
        @Mapping(source = "page_size", target = "pageSize")
    })
	public AlmCbRepairBoardQueryPageBO dtoToBo(AlmCbRepairBoardQueryPageDTO almCbRepairBoardQueryPageDTO);
	
	public AlmCbRepairBoardBO dtoToBo(AlmCbRepairBoardDTO almCbRepairBoardDTO);

	public BOAlmCbRepairBoard boToDomain(AlmCbRepairBoardBO almCbRepairBoardBO);

	public AlmCbRepairBoardBO domainToBo(BOAlmCbRepairBoard boAlmCbRepairBoard);
	
	public List<AlmCbRepairBoardBO> domainToBo(List<BOAlmCbRepairBoard> boAlmCbRepairBoards);
	
	public Page<AlmCbRepairBoardBO> domainToBo(Page<BOAlmCbRepairBoard> boAlmCbRepairBoards);
}