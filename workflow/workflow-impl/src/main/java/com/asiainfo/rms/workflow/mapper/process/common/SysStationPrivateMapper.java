package com.asiainfo.rms.workflow.mapper.process.common;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.common.SysStationPrivateBO;
import com.asiainfo.rms.workflow.bo.process.common.SysStationPrivateQueryPageBO;
import com.asiainfo.rms.workflow.domain.common.BOSysStationPrivate;
import com.asiainfo.rms.workflow.dto.process.common.SysStationPrivateDTO;
import com.asiainfo.rms.workflow.dto.process.common.SysStationPrivateQueryPageDTO;

/**
 * 
 * 
 * @author joker
 */
@Mapper
public interface SysStationPrivateMapper {
	
	SysStationPrivateMapper INSTANCE = Mappers.getMapper(SysStationPrivateMapper.class);

	public SysStationPrivateDTO boToDto(SysStationPrivateBO sysStationPrivateBO);
	
	public List<SysStationPrivateDTO> boToDto(List<SysStationPrivateBO> sysStationPrivateBOs);
	
	public Page<SysStationPrivateDTO> boToDto(Page<SysStationPrivateBO> sysStationPrivateBOs);

	@Mappings({
		@Mapping(source = "staff_id_begin", target = "staffIdBegin"),
		@Mapping(source = "staff_id_end", target = "staffIdEnd"),
		@Mapping(source = "staff_code", target = "staffCode"),
		@Mapping(source = "employee_name", target = "employeeName"),
		@Mapping(source = "bill_id", target = "billId"),
		@Mapping(source = "lock_flag", target = "lockFlag"),
		@Mapping(source = "author_id_begin", target = "authorIdBegin"),
		@Mapping(source = "author_id_end", target = "authorIdEnd"),
		@Mapping(source = "notes", target = "notes"),
		@Mapping(source = "notes_type", target = "notesType"),
		@Mapping(source = "station_id_begin", target = "stationIdBegin"),
		@Mapping(source = "station_id_end", target = "stationIdEnd"),
		@Mapping(source = "station_code", target = "stationCode"),
		@Mapping(source = "name", target = "name"),
		@Mapping(source = "type_begin", target = "typeBegin"),
		@Mapping(source = "type_end", target = "typeEnd"),
		@Mapping(source = "station_type_begin", target = "stationTypeBegin"),
		@Mapping(source = "station_type_end", target = "stationTypeEnd"),
		@Mapping(source = "sta_private_name", target = "staPrivateName"),
		@Mapping(source = "sta_private_type", target = "staPrivateType"),
		@Mapping(source = "staff_org_relat_id_begin", target = "staffOrgRelatIdBegin"),
		@Mapping(source = "staff_org_relat_id_end", target = "staffOrgRelatIdEnd"),
		@Mapping(source = "organize_id_begin", target = "organizeIdBegin"),
		@Mapping(source = "organize_id_end", target = "organizeIdEnd"),
		@Mapping(source = "organize_name", target = "organizeName"),
		@Mapping(source = "org_type_begin", target = "orgTypeBegin"),
		@Mapping(source = "org_type_end", target = "orgTypeEnd"),
		@Mapping(source = "org_private_name", target = "orgPrivateName"),
		@Mapping(source = "org_private_type", target = "orgPrivateType"),
        @Mapping(source = "page_no", target = "pageNo"),
        @Mapping(source = "page_size", target = "pageSize")
    })
	public SysStationPrivateQueryPageBO dtoToBo(SysStationPrivateQueryPageDTO sysStationPrivateQueryPageDTO);
	
	public SysStationPrivateBO dtoToBo(SysStationPrivateDTO sysStationPrivateDTO);

	public BOSysStationPrivate boToDomain(SysStationPrivateBO sysStationPrivateBO);

	public SysStationPrivateBO domainToBo(BOSysStationPrivate boSysStationPrivate);
	
	public List<SysStationPrivateBO> domainToBo(List<BOSysStationPrivate> boSysStationPrivates);
	
	public Page<SysStationPrivateBO> domainToBo(Page<BOSysStationPrivate> boSysStationPrivates);
}