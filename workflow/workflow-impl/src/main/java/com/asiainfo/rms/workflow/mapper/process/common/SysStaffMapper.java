package com.asiainfo.rms.workflow.mapper.process.common;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.common.SysStaffBO;
import com.asiainfo.rms.workflow.bo.process.common.SysStaffQueryPageBO;
import com.asiainfo.rms.workflow.domain.common.BOSysStaff;
import com.asiainfo.rms.workflow.dto.process.common.SysStaffDTO;
import com.asiainfo.rms.workflow.dto.process.common.SysStaffQueryPageDTO;

/**
 * 
 * 
 * @author joker
 */
@Mapper
public interface SysStaffMapper {
	
	SysStaffMapper INSTANCE = Mappers.getMapper(SysStaffMapper.class);

	@Mappings({
        @Mapping(source = "recentTime", target = "recentTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
	})
	public SysStaffDTO boToDto(SysStaffBO sysStaffBO);
	
	public List<SysStaffDTO> boToDto(List<SysStaffBO> sysStaffBOs);
	
	public Page<SysStaffDTO> boToDto(Page<SysStaffBO> sysStaffBOs);

	@Mappings({
		@Mapping(source = "staff_id_begin", target = "staffIdBegin"),
		@Mapping(source = "staff_id_end", target = "staffIdEnd"),
		@Mapping(source = "code", target = "code"),
		@Mapping(source = "password", target = "password"),
		@Mapping(source = "recent_password", target = "recentPassword"),
		@Mapping(source = "recent_time_begin", target = "recentTimeBegin", dateFormat = "yyyy-MM-dd HH:mm:ss"),
		@Mapping(source = "recent_time_end", target = "recentTimeEnd", dateFormat = "yyyy-MM-dd HH:mm:ss"),
		@Mapping(source = "employee_name", target = "employeeName"),
		@Mapping(source = "bill_id", target = "billId"),
		@Mapping(source = "email", target = "email"),
		@Mapping(source = "religion", target = "religion"),
		@Mapping(source = "state_begin", target = "stateBegin"),
		@Mapping(source = "state_end", target = "stateEnd"),
		@Mapping(source = "lock_flag", target = "lockFlag"),
		@Mapping(source = "notes", target = "notes"),
		@Mapping(source = "ext1", target = "ext1"),
		@Mapping(source = "ext2", target = "ext2"),
		@Mapping(source = "ext3", target = "ext3"),
		@Mapping(source = "account_4a", target = "account4a"),
		@Mapping(source = "account_crm", target = "accountCrm"),
		@Mapping(source = "account_boss", target = "accountBoss"),
        @Mapping(source = "page_no", target = "pageNo"),
        @Mapping(source = "page_size", target = "pageSize")
    })
	public SysStaffQueryPageBO dtoToBo(SysStaffQueryPageDTO sysStaffQueryPageDTO);
	
	@Mappings({
        @Mapping(source = "recentTime", target = "recentTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
	})
	public SysStaffBO dtoToBo(SysStaffDTO sysStaffDTO);

	@Mappings({
        @Mapping(source = "recentTime", target = "recentTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
	})
	public BOSysStaff boToDomain(SysStaffBO sysStaffBO);

	@Mappings({
        @Mapping(source = "recentTime", target = "recentTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
	})
	public SysStaffBO domainToBo(BOSysStaff boSysStaff);
	
	public List<SysStaffBO> domainToBo(List<BOSysStaff> boSysStaffs);
	
	public Page<SysStaffBO> domainToBo(Page<BOSysStaff> boSysStaffs);
}