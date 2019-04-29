package com.asiainfo.rms.alm.arsenal.convert;

import com.asiainfo.rms.alm.arsenal.domain.AlmAsnltmpChargeRepository;
import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpChargeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AlmAsnltmpChargeConvert {
    AlmAsnltmpChargeConvert INSTANCE = Mappers.getMapper(AlmAsnltmpChargeConvert.class);

    AlmAsnltmpChargeDTO toDTO(AlmAsnltmpChargeRepository almAsnltmpChargeRepository);

    AlmAsnltmpChargeRepository toSYS(AlmAsnltmpChargeDTO almAsnltmpChargeDTO);

    List<AlmAsnltmpChargeDTO> toDTOs(List<AlmAsnltmpChargeRepository> almAsnltmpChargeRepositories);
}
