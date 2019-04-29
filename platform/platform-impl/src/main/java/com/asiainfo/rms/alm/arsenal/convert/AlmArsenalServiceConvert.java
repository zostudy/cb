package com.asiainfo.rms.alm.arsenal.convert;

import com.asiainfo.rms.alm.arsenal.domain.AlmArsenalServiceRepository;
import com.asiainfo.rms.alm.arsenal.dto.AlmArsenalServiceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AlmArsenalServiceConvert {
    AlmArsenalServiceConvert INSTANCE = Mappers.getMapper(AlmArsenalServiceConvert.class);

    AlmArsenalServiceDTO toDTO(AlmArsenalServiceRepository almArsenalServiceRepository);

    AlmArsenalServiceRepository toSYS(AlmArsenalServiceDTO almArsenalServiceDTO);

    List<AlmArsenalServiceDTO> toDTOs(List<AlmArsenalServiceRepository> almArsenalServiceRepositories);
}
