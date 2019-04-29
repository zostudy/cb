package com.asiainfo.rms.alm.util.convert;

import com.asiainfo.rms.alm.demand.domain.AlmReqtmpBusiayaRepository;
import com.asiainfo.rms.alm.demand.dto.AlmReqtmpBusiayaDTO;
import com.asiainfo.rms.alm.util.domain.AlmAttPackageRepository;
import com.asiainfo.rms.alm.util.domain.AlmAttachmentRepository;
import com.asiainfo.rms.alm.util.dto.AlmAttPackageDTO;
import com.asiainfo.rms.alm.util.dto.AlmAttachmentDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AlmAttPackageConvert {

	AlmAttPackageConvert INSTANCE = Mappers.getMapper(AlmAttPackageConvert.class);
	
	AlmAttPackageDTO toDTO(AlmAttPackageRepository almAttPackageRepository);

	AlmAttPackageRepository toSYS(AlmAttPackageDTO almAttPackageDTO);

    List<AlmAttPackageDTO> toDTOs(List<AlmAttPackageRepository> almAttPackageRepositorys);
}
