package com.asiainfo.rms.alm.demand.convert;

import com.asiainfo.rms.alm.demand.domain.AlmReqtmpRewardRepository;
import com.asiainfo.rms.alm.demand.dto.AlmReqtmpRewardDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AlmReqtmpRewardConvert {
    AlmReqtmpRewardConvert INSTANCE = Mappers.getMapper(AlmReqtmpRewardConvert.class);

    AlmReqtmpRewardDTO toDTO(AlmReqtmpRewardRepository almReqtmpRewardRepository);

    AlmReqtmpRewardRepository toSYS(AlmReqtmpRewardDTO almReqtmpRewardDTO);

    List<AlmReqtmpRewardDTO> toDTOs(List<AlmReqtmpRewardRepository> almReqtmpRewardRepositories);
}
