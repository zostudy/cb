package com.asiainfo.rms.system.convert;

import com.asiainfo.rms.system.domain.SysLoginUserInfoRepository;
import com.asiainfo.rms.system.dto.SysLoginUserInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SysLoginUserInfoConvert {
    SysLoginUserInfoConvert INSTANCE = Mappers.getMapper(SysLoginUserInfoConvert.class);


    SysLoginUserInfoDTO toDTO(SysLoginUserInfoRepository sysLoginUserInfoRepository);


    SysLoginUserInfoRepository toSYS(SysLoginUserInfoDTO sysLoginUserInfoDTO);

    List<SysLoginUserInfoDTO> toDTOs(List<SysLoginUserInfoRepository> sysLoginUserInfoRepositoryList);
}
