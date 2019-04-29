package com.asiainfo.rms.workflow.mapper.process.common;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.common.SysOrgPrivateBO;
import com.asiainfo.rms.workflow.bo.process.common.SysOrgPrivateQueryPageBO;
import com.asiainfo.rms.workflow.domain.common.BOSysOrgPrivate;
import com.asiainfo.rms.workflow.dto.process.common.SysOrgPrivateDTO;
import com.asiainfo.rms.workflow.dto.process.common.SysOrgPrivateQueryPageDTO;

/**
 * 
 * 
 * @author joker
 */
@Mapper
public interface SysOrgPrivateMapper {
	
	SysOrgPrivateMapper INSTANCE = Mappers.getMapper(SysOrgPrivateMapper.class);

	public SysOrgPrivateDTO boToDto(SysOrgPrivateBO sysOrgPrivateBO);
	
	public List<SysOrgPrivateDTO> boToDto(List<SysOrgPrivateBO> sysOrgPrivateBOs);
	
	public Page<SysOrgPrivateDTO> boToDto(Page<SysOrgPrivateBO> sysOrgPrivateBOs);

	@Mappings({
		@Mapping(source = "staff_id_begin", target = "staffIdBegin"),
		@Mapping(source = "staff_id_end", target = "staffIdEnd"),
		@Mapping(source = "code", target = "code"),
		@Mapping(source = "employee_name", target = "employeeName"),
		@Mapping(source = "bill_id", target = "billId"),
		@Mapping(source = "lock_flag", target = "lockFlag"),
		@Mapping(source = "staff_org_relat_id_begin", target = "staffOrgRelatIdBegin"),
		@Mapping(source = "staff_org_relat_id_end", target = "staffOrgRelatIdEnd"),
		@Mapping(source = "organize_id_begin", target = "organizeIdBegin"),
		@Mapping(source = "organize_id_end", target = "organizeIdEnd"),
		@Mapping(source = "organize_name", target = "organizeName"),
		@Mapping(source = "org_type_begin", target = "orgTypeBegin"),
		@Mapping(source = "org_type_end", target = "orgTypeEnd"),
		@Mapping(source = "param_name", target = "paramName"),
		@Mapping(source = "param_type", target = "paramType"),
        @Mapping(source = "page_no", target = "pageNo"),
        @Mapping(source = "page_size", target = "pageSize")
    })
	public SysOrgPrivateQueryPageBO dtoToBo(SysOrgPrivateQueryPageDTO sysOrgPrivateQueryPageDTO);
	
	public SysOrgPrivateBO dtoToBo(SysOrgPrivateDTO sysOrgPrivateDTO);

	public BOSysOrgPrivate boToDomain(SysOrgPrivateBO sysOrgPrivateBO);

	public SysOrgPrivateBO domainToBo(BOSysOrgPrivate boSysOrgPrivate);
	
	public List<SysOrgPrivateBO> domainToBo(List<BOSysOrgPrivate> boSysOrgPrivates);
	
	public Page<SysOrgPrivateBO> domainToBo(Page<BOSysOrgPrivate> boSysOrgPrivates);
}