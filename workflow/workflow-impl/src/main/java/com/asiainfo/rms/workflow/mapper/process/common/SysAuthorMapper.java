package com.asiainfo.rms.workflow.mapper.process.common;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.common.SysAuthorBO;
import com.asiainfo.rms.workflow.bo.process.common.SysAuthorQueryPageBO;
import com.asiainfo.rms.workflow.domain.common.BOSysAuthor;
import com.asiainfo.rms.workflow.dto.process.common.SysAuthorDTO;
import com.asiainfo.rms.workflow.dto.process.common.SysAuthorQueryPageDTO;

/**
 * 
 * 
 * @author joker
 */
@Mapper
public interface SysAuthorMapper {
	
	SysAuthorMapper INSTANCE = Mappers.getMapper(SysAuthorMapper.class);

	@Mappings({
        @Mapping(source = "createTime", target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
	})
	public SysAuthorDTO boToDto(SysAuthorBO sysAuthorBO);
	
	public List<SysAuthorDTO> boToDto(List<SysAuthorBO> sysAuthorBOs);
	
	public Page<SysAuthorDTO> boToDto(Page<SysAuthorBO> sysAuthorBOs);

	@Mappings({
		@Mapping(source = "author_id_begin", target = "authorIdBegin"),
		@Mapping(source = "author_id_end", target = "authorIdEnd"),
		@Mapping(source = "station_id_begin", target = "stationIdBegin"),
		@Mapping(source = "station_id_end", target = "stationIdEnd"),
		@Mapping(source = "staff_id_begin", target = "staffIdBegin"),
		@Mapping(source = "staff_id_end", target = "staffIdEnd"),
		@Mapping(source = "notes", target = "notes"),
		@Mapping(source = "state_begin", target = "stateBegin"),
		@Mapping(source = "state_end", target = "stateEnd"),
		@Mapping(source = "create_time_begin", target = "createTimeBegin", dateFormat = "yyyy-MM-dd HH:mm:ss"),
		@Mapping(source = "create_time_end", target = "createTimeEnd", dateFormat = "yyyy-MM-dd HH:mm:ss"),
		@Mapping(source = "ext1", target = "ext1"),
		@Mapping(source = "ext2", target = "ext2"),
		@Mapping(source = "ext3", target = "ext3"),
        @Mapping(source = "page_no", target = "pageNo"),
        @Mapping(source = "page_size", target = "pageSize")
    })
	public SysAuthorQueryPageBO dtoToBo(SysAuthorQueryPageDTO sysAuthorQueryPageDTO);
	
	@Mappings({
        @Mapping(source = "createTime", target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
	})
	public SysAuthorBO dtoToBo(SysAuthorDTO sysAuthorDTO);

	@Mappings({
        @Mapping(source = "createTime", target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
	})
	public BOSysAuthor boToDomain(SysAuthorBO sysAuthorBO);

	@Mappings({
        @Mapping(source = "createTime", target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
	})
	public SysAuthorBO domainToBo(BOSysAuthor boSysAuthor);
	
	public List<SysAuthorBO> domainToBo(List<BOSysAuthor> boSysAuthors);
	
	public Page<SysAuthorBO> domainToBo(Page<BOSysAuthor> boSysAuthors);
}