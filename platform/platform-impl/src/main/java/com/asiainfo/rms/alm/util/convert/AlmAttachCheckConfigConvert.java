package com.asiainfo.rms.alm.util.convert;

import com.asiainfo.rms.alm.demand.domain.AlmReqtmpBusiayaRepository;
import com.asiainfo.rms.alm.demand.dto.AlmReqtmpBusiayaDTO;
import com.asiainfo.rms.alm.util.domain.AlmAttachCheckConfigRepository;
import com.asiainfo.rms.alm.util.domain.AlmAttachmentRepository;
import com.asiainfo.rms.alm.util.dto.AlmAttachCheckConfigDTO;
import com.asiainfo.rms.alm.util.dto.AlmAttachmentDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AlmAttachCheckConfigConvert {

	AlmAttachCheckConfigConvert INSTANCE = Mappers.getMapper(AlmAttachCheckConfigConvert.class);

	AlmAttachCheckConfigDTO toDTO(AlmAttachCheckConfigRepository almAttachCheckConfigRepository);

	AlmAttachCheckConfigRepository toSYS(AlmAttachCheckConfigDTO almAttachCheckConfigDTO);

    List<AlmAttachCheckConfigDTO> toDTOs(List<AlmAttachCheckConfigRepository> almAttachCheckConfigRepositorys);
}
