package com.asiainfo.rms.alm.arsenal.convert;

import com.asiainfo.rms.alm.arsenal.domain.AlmAsnltmpChgeExtendRepository;
import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpChgeExtendDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AlmAsnltmpChgeExtendConvert {
    AlmAsnltmpChgeExtendConvert INSTANCE = Mappers.getMapper(AlmAsnltmpChgeExtendConvert.class);

    AlmAsnltmpChgeExtendDTO toDTO(AlmAsnltmpChgeExtendRepository almAsnltmpChgeExtendRepository);

    AlmAsnltmpChgeExtendRepository toSYS(AlmAsnltmpChgeExtendDTO almAsnltmpChgeExtendDTO);

    List<AlmAsnltmpChgeExtendDTO> toDTOs(List<AlmAsnltmpChgeExtendRepository> almAsnltmpChgeExtendRepository);
}
