package com.asiainfo.rms.alm.arsenal.convert;

import com.asiainfo.rms.alm.arsenal.domain.AlmAsnltmpRuleRelatRepository;
import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpRuleRelatDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AlmAsnltmpRuleRelatConvert {
    AlmAsnltmpRuleRelatConvert INSTANCE = Mappers.getMapper(AlmAsnltmpRuleRelatConvert.class);

    AlmAsnltmpRuleRelatDTO toDTO(AlmAsnltmpRuleRelatRepository almAsnltmpRuleRelatRepository);

    AlmAsnltmpRuleRelatRepository toSYS(AlmAsnltmpRuleRelatDTO almAsnltmpRuleRelatDTO);

    List<AlmAsnltmpRuleRelatDTO> toDTOs(List<AlmAsnltmpRuleRelatRepository> almAsnltmpRuleRelatRepositoryList);
}
