package com.asiainfo.rms.alm.arsenal.convert;

import com.asiainfo.rms.alm.arsenal.domain.AlmAsnltmpSgExtendRepository;
import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpSgExtendDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AlmAsnltmpSgExtendConvert {
    AlmAsnltmpSgExtendConvert INSTANCE = Mappers.getMapper(AlmAsnltmpSgExtendConvert.class);

    AlmAsnltmpSgExtendDTO toDTO(AlmAsnltmpSgExtendRepository almAsnltmpSgExtendRepository);

    AlmAsnltmpSgExtendRepository toSYS(AlmAsnltmpSgExtendDTO almAsnltmpSgExtendDTO);

    List<AlmAsnltmpSgExtendDTO> toDTOs(List<AlmAsnltmpSgExtendRepository> almAsnltmpSgExtendRepositories);
}
