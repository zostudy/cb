package com.asiainfo.rms.workflow.mapper.process.common;

import com.asiainfo.rms.workflow.domain.workflow.BOWoflowOrderList;
import com.asiainfo.rms.workflow.dto.common.WorkflowOrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface WoflowOrderListMapper {
    WoflowOrderListMapper INSTANCE = Mappers.getMapper(WoflowOrderListMapper.class);

    WorkflowOrderDto boToDto(BOWoflowOrderList woflowOrderList);

    List<WorkflowOrderDto> boToDtos(List<BOWoflowOrderList> woflowOrderLists);

}
