package com.asiainfo.rms.workflow.mapper.process.common;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.common.SysOrganizeBO;
import com.asiainfo.rms.workflow.bo.process.common.SysOrganizeQueryPageBO;
import com.asiainfo.rms.workflow.domain.common.BOSysOrganize;
import com.asiainfo.rms.workflow.dto.process.common.SysOrganizeDTO;
import com.asiainfo.rms.workflow.dto.process.common.SysOrganizeQueryPageDTO;

/**
 * 
 * 
 * @author joker
 */
@Mapper
public interface SysOrganizeMapper {
	
	SysOrganizeMapper INSTANCE = Mappers.getMapper(SysOrganizeMapper.class);

	@Mappings({
        @Mapping(source = "createDate", target = "createDate", dateFormat = "yyyy-MM-dd HH:mm:ss")
	})
	public SysOrganizeDTO boToDto(SysOrganizeBO sysOrganizeBO);
	
	public List<SysOrganizeDTO> boToDto(List<SysOrganizeBO> sysOrganizeBOs);
	
	public Page<SysOrganizeDTO> boToDto(Page<SysOrganizeBO> sysOrganizeBOs);

	@Mappings({
		@Mapping(source = "organize_id_begin", target = "organizeIdBegin"),
		@Mapping(source = "organize_id_end", target = "organizeIdEnd"),
		@Mapping(source = "parent_organize_id_begin", target = "parentOrganizeIdBegin"),
		@Mapping(source = "parent_organize_id_end", target = "parentOrganizeIdEnd"),
		@Mapping(source = "organize_name", target = "organizeName"),
		@Mapping(source = "code", target = "code"),
		@Mapping(source = "org_type_begin", target = "orgTypeBegin"),
		@Mapping(source = "org_type_end", target = "orgTypeEnd"),
		@Mapping(source = "notes", target = "notes"),
		@Mapping(source = "state_begin", target = "stateBegin"),
		@Mapping(source = "state_end", target = "stateEnd"),
		@Mapping(source = "create_date_begin", target = "createDateBegin", dateFormat = "yyyy-MM-dd HH:mm:ss"),
		@Mapping(source = "create_date_end", target = "createDateEnd", dateFormat = "yyyy-MM-dd HH:mm:ss"),
		@Mapping(source = "ext1", target = "ext1"),
		@Mapping(source = "ext2", target = "ext2"),
		@Mapping(source = "ext3", target = "ext3"),
		@Mapping(source = "organize_type_id_begin", target = "organizeTypeIdBegin"),
		@Mapping(source = "organize_type_id_end", target = "organizeTypeIdEnd"),
		@Mapping(source = "parent_code", target = "parentCode"),
        @Mapping(source = "page_no", target = "pageNo"),
        @Mapping(source = "page_size", target = "pageSize")
    })
	public SysOrganizeQueryPageBO dtoToBo(SysOrganizeQueryPageDTO sysOrganizeQueryPageDTO);
	
	@Mappings({
        @Mapping(source = "createDate", target = "createDate", dateFormat = "yyyy-MM-dd HH:mm:ss")
	})
	public SysOrganizeBO dtoToBo(SysOrganizeDTO sysOrganizeDTO);

	@Mappings({
        @Mapping(source = "createDate", target = "createDate", dateFormat = "yyyy-MM-dd HH:mm:ss")
	})
	public BOSysOrganize boToDomain(SysOrganizeBO sysOrganizeBO);

	@Mappings({
        @Mapping(source = "createDate", target = "createDate", dateFormat = "yyyy-MM-dd HH:mm:ss")
	})
	public SysOrganizeBO domainToBo(BOSysOrganize boSysOrganize);
	
	public List<SysOrganizeBO> domainToBo(List<BOSysOrganize> boSysOrganizes);
	
	public Page<SysOrganizeBO> domainToBo(Page<BOSysOrganize> boSysOrganizes);
}