package com.asiainfo.rms.system.convert;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.asiainfo.rms.system.domain.ReverseAuthenticateRepostitory;
import com.asiainfo.rms.system.dto.ReverseAuthenticateDTO;

@Mapper
public interface ReverseAuthenticateConvert {
	ReverseAuthenticateConvert INSTANCE = Mappers.getMapper(ReverseAuthenticateConvert.class);

	ReverseAuthenticateDTO toDTO(ReverseAuthenticateRepostitory reverseAuthenticateRepostitory);

	ReverseAuthenticateRepostitory toSYS(ReverseAuthenticateDTO reverseAuthenticateDTO);

    List<ReverseAuthenticateDTO> toDTOs(List<ReverseAuthenticateRepostitory> reverseAuthenticateRepostitoryList);

}
