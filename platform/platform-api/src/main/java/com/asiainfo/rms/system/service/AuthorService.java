package com.asiainfo.rms.system.service;

import com.asiainfo.rms.system.dto.SysAuthorDTO;

import java.util.List;
import java.util.Map;


public interface AuthorService {
    String saveAuthor(SysAuthorDTO authorDTO);

    String updateAuthor(SysAuthorDTO authorDTO);

    String deleteAuthorById(Integer authorId);

    SysAuthorDTO selectByAuthorId(Integer authorId);
    
    public List<SysAuthorDTO> selectByStationId(Integer stationId);

    List<SysAuthorDTO> selectAuthorByStaffId(Integer staffId, Integer pageNo, Integer pageSize);

    int getAuthorByStaffIdCount(Integer staffId);
    
    List<SysAuthorDTO> selectByStationIdAndStaffId(Integer stationId,Integer staffId);

}
