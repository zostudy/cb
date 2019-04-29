package com.asiainfo.rms.workflow.mapper.workflow;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.asiainfo.rms.workflow.bo.process.common.StakeholderOprBO;
import com.asiainfo.rms.workflow.bo.workflow.StakeholderBO;
import com.asiainfo.rms.workflow.domain.workflow.BOAlmHisStakeholder;
import com.asiainfo.rms.workflow.domain.workflow.BOAlmStakeholder;
import com.asiainfo.rms.workflow.dto.common.StakeholderOprDTO;
import com.asiainfo.rms.workflow.dto.workflow.StakeholderDTO;

@Mapper
public interface StakeholderMapper {
	
	StakeholderMapper INSTANCE = Mappers.getMapper(StakeholderMapper.class);
	
	@Mappings({
        @Mapping(source = "createTime", target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })
	StakeholderBO domainToBo(BOAlmStakeholder almStakeholder);
	
	List<StakeholderBO> domainToBo(List<BOAlmStakeholder> almStakeholder);
	
	List<StakeholderOprBO> dtoToBo(List<StakeholderOprDTO> almStakeholder);
	
	List<StakeholderDTO> boToDto(List<StakeholderBO> stakeholders);
	
	StakeholderDTO boToDto(StakeholderBO stakeholder);
	
	@Mappings({
        @Mapping(source = "createTime", target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })
	BOAlmStakeholder boToDomain(StakeholderBO stakeholder);

	@Mappings({
        @Mapping(source = "createTime", target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
        @Mapping(target = "hisStdholderId",  ignore = true)
    })
	BOAlmHisStakeholder domainToHisDomain(BOAlmStakeholder almStakeholder);
	
	@Mappings({
        @Mapping(source = "createTime", target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
        @Mapping(target = "hisStdholderId",  ignore = true)
    })
	BOAlmHisStakeholder boToHisDomain(StakeholderBO stakeholder);

	@Mappings({
        @Mapping(target = "createTime",  ignore = true),
        @Mapping(target = "objId",  ignore = true),
        @Mapping(target = "objType",  ignore = true),
        @Mapping(target = "processKey",  ignore = true),
        @Mapping(target = "stdholdeType",  ignore = true),
        @Mapping(target = "stdholderId",  ignore = true)
    })
	StakeholderBO dtoToBo(StakeholderDTO stakeholderDTO);
	
	StakeholderOprBO dtoToBo(StakeholderOprDTO stakeholderDTO);
	
	@Mappings({
        @Mapping(target = "createTime",  ignore = true),
        @Mapping(target = "objId",  ignore = true),
        @Mapping(target = "objType",  ignore = true),
        @Mapping(target = "processKey",  ignore = true),
        @Mapping(target = "stdholdeType",  ignore = true),
        @Mapping(target = "stdholderId",  ignore = true)
    })
	BOAlmStakeholder boToDomain(StakeholderOprBO stakeholder);
}
