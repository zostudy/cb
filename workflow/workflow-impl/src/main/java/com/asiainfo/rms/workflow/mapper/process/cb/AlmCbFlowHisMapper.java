package com.asiainfo.rms.workflow.mapper.process.cb;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbFlowBO;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbFlowHisBO;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbFlowHisQueryPageBO;
import com.asiainfo.rms.workflow.domain.cb.BOAlmCbFlowHis;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbFlowHisDTO;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbFlowHisQueryPageDTO;

/**
 * 详情表
 * 
 * @author joker
 */
@Mapper
public interface AlmCbFlowHisMapper {
	
	AlmCbFlowHisMapper INSTANCE = Mappers.getMapper(AlmCbFlowHisMapper.class);

	@Mappings({
        @Mapping(source = "createTime", target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
	})
	public AlmCbFlowHisDTO boToDto(AlmCbFlowHisBO almCbFlowHisBO);
	
	public List<AlmCbFlowHisDTO> boToDto(List<AlmCbFlowHisBO> almCbFlowHisBOs);
	
	public Page<AlmCbFlowHisDTO> boToDto(Page<AlmCbFlowHisBO> almCbFlowHisBOs);

	@Mappings({
		@Mapping(source = "his_flow_id_begin", target = "hisFlowIdBegin"),
		@Mapping(source = "his_flow_id_end", target = "hisFlowIdEnd"),
		@Mapping(source = "flow_id_begin", target = "flowIdBegin"),
		@Mapping(source = "flow_id_end", target = "flowIdEnd"),
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
		@Mapping(source = "create_time_begin", target = "createTimeBegin", dateFormat = "yyyy-MM-dd HH:mm:ss"),
		@Mapping(source = "create_time_end", target = "createTimeEnd", dateFormat = "yyyy-MM-dd HH:mm:ss"),
		@Mapping(source = "appaly_staff_id_begin", target = "appalyStaffIdBegin"),
		@Mapping(source = "appaly_staff_id_end", target = "appalyStaffIdEnd"),
		@Mapping(source = "appaly_staff_name", target = "appalyStaffName"),
		@Mapping(source = "appaly_staff_code", target = "appalyStaffCode"),
        @Mapping(source = "page_no", target = "pageNo"),
        @Mapping(source = "page_size", target = "pageSize")
    })
	public AlmCbFlowHisQueryPageBO dtoToBo(AlmCbFlowHisQueryPageDTO almCbFlowHisQueryPageDTO);
	
	@Mappings({
        @Mapping(source = "createTime", target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
	})
	public AlmCbFlowHisBO dtoToBo(AlmCbFlowHisDTO almCbFlowHisDTO);

	@Mappings({
        @Mapping(source = "createTime", target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
	})
	public BOAlmCbFlowHis boToDomain(AlmCbFlowHisBO almCbFlowHisBO);

	@Mappings({
        @Mapping(target = "appalyStaffCode", ignore = true),
        @Mapping(target = "appalyStaffId", ignore = true),
        @Mapping(target = "appalyStaffName", ignore = true),
        @Mapping(target = "createTime", ignore = true),
        @Mapping(target = "hisFlowId", ignore = true)
	})
	public AlmCbFlowHisBO boToBo(AlmCbFlowBO almCbFlowBO);

	@Mappings({
        @Mapping(source = "createTime", target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
	})
	public AlmCbFlowHisBO domainToBo(BOAlmCbFlowHis boAlmCbFlowHis);
	
	public List<AlmCbFlowHisBO> domainToBo(List<BOAlmCbFlowHis> boAlmCbFlowHiss);
	
	public Page<AlmCbFlowHisBO> domainToBo(Page<BOAlmCbFlowHis> boAlmCbFlowHiss);
}