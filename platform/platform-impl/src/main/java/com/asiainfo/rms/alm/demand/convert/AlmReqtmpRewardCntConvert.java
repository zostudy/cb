package com.asiainfo.rms.alm.demand.convert;

import com.asiainfo.rms.alm.demand.domain.AlmReqtmpRewardCntRepository;
import com.asiainfo.rms.alm.demand.dto.AlmReqtmpRewardCntDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AlmReqtmpRewardCntConvert {

    AlmReqtmpRewardCntConvert INSTANCE = Mappers.getMapper(AlmReqtmpRewardCntConvert.class);

    AlmReqtmpRewardCntDTO toDTO(AlmReqtmpRewardCntRepository almReqtmpRewardCntRepository);

    AlmReqtmpRewardCntRepository toSYS(AlmReqtmpRewardCntDTO almReqtmpRewardCntDTO);

    List<AlmReqtmpRewardCntDTO> toDTOs(List<AlmReqtmpRewardCntRepository> almReqtmpRewardCntRepositoryList);
}
