package com.asiainfo.rms.alm.util.convert;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.asiainfo.rms.alm.util.domain.AlmAttPackageRepository;
import com.asiainfo.rms.alm.util.domain.AlmAttachmentRepository;
import com.asiainfo.rms.alm.util.dto.AlmAttachmentSelectDTO;

@Mapper
public interface AlmAttachmentSelectConvert {

	AlmAttachmentSelectConvert INSTANCE = Mappers.getMapper(AlmAttachmentSelectConvert.class);
	@Mappings({
        @Mapping(source="almAttPackageRepository.attId",target="attId",ignore=true)
	})
	AlmAttachmentSelectDTO toDTO(AlmAttachmentRepository almAttachmentRepository,AlmAttPackageRepository almAttPackageRepository);
	
    //AlmAttachmentRepository toSYS(AlmAttachmentSelectDTO almAttachmentSelectDTO,);

    //List<AlmAttachmentSelectDTO> toDTOs(List<AlmAttachmentRepository> almAttachmentRepositorys);
}
