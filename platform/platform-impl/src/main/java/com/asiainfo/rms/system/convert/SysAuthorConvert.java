package com.asiainfo.rms.system.convert;

import com.asiainfo.rms.system.domain.SysAuthorRepository;
import com.asiainfo.rms.system.dto.SysAuthorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface SysAuthorConvert {
    SysAuthorConvert INSTANCE = Mappers.getMapper(SysAuthorConvert.class);

    SysAuthorDTO toDTO(SysAuthorRepository authorRepository);

    List<SysAuthorDTO> toDTO(List<SysAuthorRepository> authorRepositorys);

    @Mappings({
            @Mapping(target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })
    SysAuthorRepository toSYS(SysAuthorDTO authorDTO);


    List<SysAuthorDTO> toDTOs(List<SysAuthorRepository> authorRepositoryList);
}
