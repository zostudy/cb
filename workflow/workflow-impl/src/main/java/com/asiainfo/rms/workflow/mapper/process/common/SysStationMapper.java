package com.asiainfo.rms.workflow.mapper.process.common;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.common.SysStationBO;
import com.asiainfo.rms.workflow.bo.process.common.SysStationQueryPageBO;
import com.asiainfo.rms.workflow.domain.common.BOSysStation;
import com.asiainfo.rms.workflow.dto.process.common.SysStationDTO;
import com.asiainfo.rms.workflow.dto.process.common.SysStationQueryPageDTO;

/**
 * 
 * 
 * @author joker
 */
@Mapper
public interface SysStationMapper {
	
	SysStationMapper INSTANCE = Mappers.getMapper(SysStationMapper.class);

	public SysStationDTO boToDto(SysStationBO sysStationBO);
	
	public List<SysStationDTO> boToDto(List<SysStationBO> sysStationBOs);
	
	public Page<SysStationDTO> boToDto(Page<SysStationBO> sysStationBOs);

	@Mappings({
		@Mapping(source = "station_id_begin", target = "stationIdBegin"),
		@Mapping(source = "station_id_end", target = "stationIdEnd"),
		@Mapping(source = "code", target = "code"),
		@Mapping(source = "name", target = "name"),
		@Mapping(source = "notes", target = "notes"),
		@Mapping(source = "state_begin", target = "stateBegin"),
		@Mapping(source = "state_end", target = "stateEnd"),
		@Mapping(source = "type_begin", target = "typeBegin"),
		@Mapping(source = "type_end", target = "typeEnd"),
		@Mapping(source = "ext1", target = "ext1"),
		@Mapping(source = "ext2", target = "ext2"),
		@Mapping(source = "ext3", target = "ext3"),
		@Mapping(source = "station_type_begin", target = "stationTypeBegin"),
		@Mapping(source = "station_type_end", target = "stationTypeEnd"),
        @Mapping(source = "page_no", target = "pageNo"),
        @Mapping(source = "page_size", target = "pageSize")
    })
	public SysStationQueryPageBO dtoToBo(SysStationQueryPageDTO sysStationQueryPageDTO);
	
	public SysStationBO dtoToBo(SysStationDTO sysStationDTO);

	public BOSysStation boToDomain(SysStationBO sysStationBO);

	public SysStationBO domainToBo(BOSysStation boSysStation);
	
	public List<SysStationBO> domainToBo(List<BOSysStation> boSysStations);
	
	public Page<SysStationBO> domainToBo(Page<BOSysStation> boSysStations);
}