package com.asiainfo.rms.alm.util.convert;

import com.asiainfo.rms.alm.demand.domain.AlmReqtmpBusiayaRepository;
import com.asiainfo.rms.alm.demand.dto.AlmReqtmpBusiayaDTO;
import com.asiainfo.rms.alm.util.domain.AlmAttachmentRepository;
import com.asiainfo.rms.alm.util.dto.AlmAttachmentDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AlmAttachmentConvert {

	AlmAttachmentConvert INSTANCE = Mappers.getMapper(AlmAttachmentConvert.class);

	AlmAttachmentDTO toDTO(AlmAttachmentRepository almAttachmentRepository);

    AlmAttachmentRepository toSYS(AlmAttachmentDTO almAttachmentDTO);

    List<AlmAttachmentDTO> toDTOs(List<AlmAttachmentRepository> almAttachmentRepositorys);
}
