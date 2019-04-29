package com.asiainfo.rms.workflow.mapper.workflow;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.asiainfo.rms.workflow.bo.workflow.WorkorderBO;
import com.asiainfo.rms.workflow.domain.workflow.BOAlmWorkorder;
import com.asiainfo.rms.workflow.dto.workflow.WorkorderUpdateDTO;

@Mapper
public interface WorkorderMapper {
	
	WorkorderMapper INSTANCE = Mappers.getMapper(WorkorderMapper.class);

	@Mappings({
        @Mapping(source = "creatTime", target = "creatTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
        @Mapping(source = "recvTime", target = "recvTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
        @Mapping(source = "lockTime", target = "lockTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
        @Mapping(source = "realseLockTime", target = "realseLockTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
        @Mapping(source = "execTime", target = "execTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
        @Mapping(source = "finishTime", target = "finishTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })
	WorkorderBO domainToBo(BOAlmWorkorder almWorkorder);
	
	List<WorkorderBO> domainToBo(List<BOAlmWorkorder> almWorkorders);
	
	@Mappings({
        @Mapping(source = "creatTime", target = "creatTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
        @Mapping(source = "recvTime", target = "recvTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
        @Mapping(source = "lockTime", target = "lockTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
        @Mapping(source = "realseLockTime", target = "realseLockTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
        @Mapping(source = "execTime", target = "execTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
        @Mapping(source = "finishTime", target = "finishTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })
	BOAlmWorkorder boToDomain(WorkorderBO workorder);
	
	@Mappings({
        @Mapping(target = "actTaskId", ignore = true),
        @Mapping(target = "alarmFlg", ignore = true),
        @Mapping(target = "alarmTime", ignore = true),
        @Mapping(target = "alarmTimes", ignore = true),
        @Mapping(target = "cond", ignore = true),
        @Mapping(target = "creatTime", ignore = true),
        @Mapping(target = "dealType", ignore = true),
        @Mapping(target = "delayTime", ignore = true),
        @Mapping(target = "deployId", ignore = true),
        @Mapping(target = "execRoleId", ignore = true),
        @Mapping(target = "execStaffId", ignore = true),
        @Mapping(target = "execTime", ignore = true),
        @Mapping(target = "execTimes", ignore = true),
        @Mapping(target = "finishPrint", ignore = true),
        @Mapping(target = "finishTime", ignore = true),
        @Mapping(target = "isCurrentTask", ignore = true),
        @Mapping(target = "isLock", ignore = true),
        @Mapping(target = "lastActTaskId", ignore = true),
        @Mapping(target = "lastOrderId", ignore = true),
        @Mapping(target = "linkId", ignore = true),
        @Mapping(target = "lockOpinion", ignore = true),
        @Mapping(target = "lockRoleId", ignore = true),
        @Mapping(target = "lockStaffId", ignore = true),
        @Mapping(target = "lockTime", ignore = true),
        @Mapping(target = "lockTimes", ignore = true),
        @Mapping(target = "nextLinkPlantime", ignore = true),
        @Mapping(target = "objId", ignore = true),
        @Mapping(target = "objType", ignore = true),
        @Mapping(target = "operType", ignore = true),
        @Mapping(target = "orderType", ignore = true),
        @Mapping(target = "parentActTaskId", ignore = true),
        @Mapping(target = "parentOrderId", ignore = true),
        @Mapping(target = "prealarmTime", ignore = true),
        @Mapping(target = "procInstId", ignore = true),
        @Mapping(target = "realseLockTime", ignore = true),
        @Mapping(target = "recvTime", ignore = true),
        @Mapping(target = "smgflag", ignore = true),
        @Mapping(target = "status", ignore = true),
        @Mapping(target = "warningFlag", ignore = true),
        @Mapping(source = "plantime", target = "plantimeTemp")
    })
	WorkorderBO dtoToBo(WorkorderUpdateDTO workorderUpdate);

	List<WorkorderBO> domainToBoList(List<BOAlmWorkorder> almWorkorder);
	
}
