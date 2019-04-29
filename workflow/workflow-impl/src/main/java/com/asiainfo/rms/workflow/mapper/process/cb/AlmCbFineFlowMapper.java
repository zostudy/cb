package com.asiainfo.rms.workflow.mapper.process.cb;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbFineFlowBO;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbFineFlowQueryPageBO;
import com.asiainfo.rms.workflow.domain.cb.BOAlmCbFineFlow;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbFineFlowDTO;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbFineFlowQueryPageDTO;

/**
 * 罚款流水
 * 
 * @author joker
 */
@Mapper
public interface AlmCbFineFlowMapper {
	
	AlmCbFineFlowMapper INSTANCE = Mappers.getMapper(AlmCbFineFlowMapper.class);

	@Mappings({
        @Mapping(source = "createTime", target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
	})
	public AlmCbFineFlowDTO boToDto(AlmCbFineFlowBO almCbFineFlowBO);
	
	public List<AlmCbFineFlowDTO> boToDto(List<AlmCbFineFlowBO> almCbFineFlowBOs);
	
	public Page<AlmCbFineFlowDTO> boToDto(Page<AlmCbFineFlowBO> almCbFineFlowBOs);

	@Mappings({
		@Mapping(source = "fine_id_begin", target = "fineIdBegin"),
		@Mapping(source = "fine_id_end", target = "fineIdEnd"),
		@Mapping(source = "staff_id_begin", target = "staffIdBegin"),
		@Mapping(source = "staff_id_end", target = "staffIdEnd"),
		@Mapping(source = "staff_name", target = "staffName"),
		@Mapping(source = "organize_id_begin", target = "organizeIdBegin"),
		@Mapping(source = "organize_id_end", target = "organizeIdEnd"),
		@Mapping(source = "organize_name", target = "organizeName"),
		@Mapping(source = "organize_type_begin", target = "organizeTypeBegin"),
		@Mapping(source = "organize_type_end", target = "organizeTypeEnd"),
		@Mapping(source = "station_id_begin", target = "stationIdBegin"),
		@Mapping(source = "station_id_end", target = "stationIdEnd"),
		@Mapping(source = "station_code", target = "stationCode"),
		@Mapping(source = "station_name", target = "stationName"),
		@Mapping(source = "station_notes", target = "stationNotes"),
		@Mapping(source = "station_type_begin", target = "stationTypeBegin"),
		@Mapping(source = "station_type_end", target = "stationTypeEnd"),
		@Mapping(source = "station_private_type_begin", target = "stationPrivateTypeBegin"),
		@Mapping(source = "station_private_type_end", target = "stationPrivateTypeEnd"),
		@Mapping(source = "author_id_begin", target = "authorIdBegin"),
		@Mapping(source = "author_id_end", target = "authorIdEnd"),
		@Mapping(source = "author_notes", target = "authorNotes"),
		@Mapping(source = "obj_id_begin", target = "objIdBegin"),
		@Mapping(source = "obj_id_end", target = "objIdEnd"),
		@Mapping(source = "obj_tag", target = "objTag"),
		@Mapping(source = "obj_account", target = "objAccount"),
		@Mapping(source = "obj_formula", target = "objFormula"),
		@Mapping(source = "obj_amount", target = "objAmount"),
		@Mapping(source = "obj_staff", target = "objStaff"),
		@Mapping(source = "is_valid_begin", target = "isValidBegin"),
		@Mapping(source = "is_valid_end", target = "isValidEnd"),
		@Mapping(source = "unvalid_reason", target = "unvalidReason"),
		@Mapping(source = "create_time_begin", target = "createTimeBegin", dateFormat = "yyyy-MM-dd HH:mm:ss"),
		@Mapping(source = "create_time_end", target = "createTimeEnd", dateFormat = "yyyy-MM-dd HH:mm:ss"),
		@Mapping(source = "fine_type", target = "fineType"),
		@Mapping(source = "fine_money", target = "fineMoney"),
		@Mapping(source = "fine_desc", target = "fineDesc"),
		@Mapping(source = "reduce_add", target = "reduceAdd"),
		@Mapping(source = "fine_amount", target = "fineAmount"),
		@Mapping(source = "fine_formula", target = "fineFormula"),
		@Mapping(source = "fine_account", target = "fineAccount"),
		@Mapping(source = "flow_id_begin", target = "flowIdBegin"),
		@Mapping(source = "flow_id_end", target = "flowIdEnd"),
        @Mapping(source = "page_no", target = "pageNo"),
        @Mapping(source = "page_size", target = "pageSize")
    })
	public AlmCbFineFlowQueryPageBO dtoToBo(AlmCbFineFlowQueryPageDTO almCbFineFlowQueryPageDTO);
	
	@Mappings({
        @Mapping(source = "createTime", target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
	})
	public AlmCbFineFlowBO dtoToBo(AlmCbFineFlowDTO almCbFineFlowDTO);

	@Mappings({
        @Mapping(source = "createTime", target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
	})
	public BOAlmCbFineFlow boToDomain(AlmCbFineFlowBO almCbFineFlowBO);

	@Mappings({
        @Mapping(source = "createTime", target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
	})
	public AlmCbFineFlowBO domainToBo(BOAlmCbFineFlow boAlmCbFineFlow);
	
	public List<AlmCbFineFlowBO> domainToBo(List<BOAlmCbFineFlow> boAlmCbFineFlows);
	
	public Page<AlmCbFineFlowBO> domainToBo(Page<BOAlmCbFineFlow> boAlmCbFineFlows);
}