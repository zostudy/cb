package com.asiainfo.rms.workflow.mapper.process.cb;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbSawBoardBO;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbSawBoardQueryPageBO;
import com.asiainfo.rms.workflow.domain.cb.BOAlmCbSawBoard;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbSawBoardDTO;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbSawBoardQueryPageDTO;

/**
 * 
 * 
 * @author joker
 */
@Mapper
public interface AlmCbSawBoardMapper {
	
	AlmCbSawBoardMapper INSTANCE = Mappers.getMapper(AlmCbSawBoardMapper.class);

	public AlmCbSawBoardDTO boToDto(AlmCbSawBoardBO almCbSawBoardBO);
	
	public List<AlmCbSawBoardDTO> boToDto(List<AlmCbSawBoardBO> almCbSawBoardBOs);
	
	public Page<AlmCbSawBoardDTO> boToDto(Page<AlmCbSawBoardBO> almCbSawBoardBOs);

	@Mappings({
		@Mapping(source = "sb_id_begin", target = "sbIdBegin"),
		@Mapping(source = "sb_id_end", target = "sbIdEnd"),
		@Mapping(source = "sb_tag", target = "sbTag"),
		@Mapping(source = "apply_staff_id_begin", target = "applyStaffIdBegin"),
		@Mapping(source = "apply_staff_id_end", target = "applyStaffIdEnd"),
		@Mapping(source = "cur_status_begin", target = "curStatusBegin"),
		@Mapping(source = "cur_status_end", target = "curStatusEnd"),
		@Mapping(source = "cur_phase_begin", target = "curPhaseBegin"),
		@Mapping(source = "cur_phase_end", target = "curPhaseEnd"),
        @Mapping(source = "page_no", target = "pageNo"),
        @Mapping(source = "page_size", target = "pageSize")
    })
	public AlmCbSawBoardQueryPageBO dtoToBo(AlmCbSawBoardQueryPageDTO almCbSawBoardQueryPageDTO);
	
	public AlmCbSawBoardBO dtoToBo(AlmCbSawBoardDTO almCbSawBoardDTO);

	public BOAlmCbSawBoard boToDomain(AlmCbSawBoardBO almCbSawBoardBO);

	public AlmCbSawBoardBO domainToBo(BOAlmCbSawBoard boAlmCbSawBoard);
	
	public List<AlmCbSawBoardBO> domainToBo(List<BOAlmCbSawBoard> boAlmCbSawBoards);
	
	public Page<AlmCbSawBoardBO> domainToBo(Page<BOAlmCbSawBoard> boAlmCbSawBoards);
}