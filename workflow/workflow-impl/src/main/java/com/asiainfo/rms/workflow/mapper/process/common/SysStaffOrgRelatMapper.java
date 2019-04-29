package com.asiainfo.rms.workflow.mapper.process.common;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.common.SysStaffOrgRelatBO;
import com.asiainfo.rms.workflow.bo.process.common.SysStaffOrgRelatQueryPageBO;
import com.asiainfo.rms.workflow.domain.common.BOSysStaffOrgRelat;
import com.asiainfo.rms.workflow.dto.process.common.SysStaffOrgRelatDTO;
import com.asiainfo.rms.workflow.dto.process.common.SysStaffOrgRelatQueryPageDTO;

/**
 * 
 * 
 * @author joker
 */
@Mapper
public interface SysStaffOrgRelatMapper {
	
	SysStaffOrgRelatMapper INSTANCE = Mappers.getMapper(SysStaffOrgRelatMapper.class);

	@Mappings({
        @Mapping(source = "createTime", target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
	})
	public SysStaffOrgRelatDTO boToDto(SysStaffOrgRelatBO sysStaffOrgRelatBO);
	
	public List<SysStaffOrgRelatDTO> boToDto(List<SysStaffOrgRelatBO> sysStaffOrgRelatBOs);
	
	public Page<SysStaffOrgRelatDTO> boToDto(Page<SysStaffOrgRelatBO> sysStaffOrgRelatBOs);

	@Mappings({
		@Mapping(source = "staff_org_relat_id_begin", target = "staffOrgRelatIdBegin"),
		@Mapping(source = "staff_org_relat_id_end", target = "staffOrgRelatIdEnd"),
		@Mapping(source = "organize_id_begin", target = "organizeIdBegin"),
		@Mapping(source = "organize_id_end", target = "organizeIdEnd"),
		@Mapping(source = "staff_id_begin", target = "staffIdBegin"),
		@Mapping(source = "staff_id_end", target = "staffIdEnd"),
		@Mapping(source = "state_begin", target = "stateBegin"),
		@Mapping(source = "state_end", target = "stateEnd"),
		@Mapping(source = "notes", target = "notes"),
		@Mapping(source = "create_time_begin", target = "createTimeBegin", dateFormat = "yyyy-MM-dd HH:mm:ss"),
		@Mapping(source = "create_time_end", target = "createTimeEnd", dateFormat = "yyyy-MM-dd HH:mm:ss"),
		@Mapping(source = "ext1", target = "ext1"),
		@Mapping(source = "ext2", target = "ext2"),
		@Mapping(source = "ext3", target = "ext3"),
        @Mapping(source = "page_no", target = "pageNo"),
        @Mapping(source = "page_size", target = "pageSize")
    })
	public SysStaffOrgRelatQueryPageBO dtoToBo(SysStaffOrgRelatQueryPageDTO sysStaffOrgRelatQueryPageDTO);
	
	@Mappings({
        @Mapping(source = "createTime", target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
	})
	public SysStaffOrgRelatBO dtoToBo(SysStaffOrgRelatDTO sysStaffOrgRelatDTO);

	@Mappings({
        @Mapping(source = "createTime", target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
	})
	public BOSysStaffOrgRelat boToDomain(SysStaffOrgRelatBO sysStaffOrgRelatBO);

	@Mappings({
        @Mapping(source = "createTime", target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
	})
	public SysStaffOrgRelatBO domainToBo(BOSysStaffOrgRelat boSysStaffOrgRelat);
	
	public List<SysStaffOrgRelatBO> domainToBo(List<BOSysStaffOrgRelat> boSysStaffOrgRelats);
	
	public Page<SysStaffOrgRelatBO> domainToBo(Page<BOSysStaffOrgRelat> boSysStaffOrgRelats);
}