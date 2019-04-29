package com.asiainfo.rms.system.dao;

import com.asiainfo.rms.system.domain.SysAuthorRepository;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SysAuthorDao {
    Integer saveAuthor(SysAuthorRepository authorRepository);

    Integer updateAuthor(SysAuthorRepository authorRepository);

    Integer deleteAuthorById(@Param("state")Integer state, @Param("endTime")Date endTime, @Param("authorId")Integer authorId);

    SysAuthorRepository selectByAuthorId(@Param("authorId")Integer authorId);

	List<SysAuthorRepository> selectByStationId(@Param("stationId")Integer authorId);

    List<SysAuthorRepository> selectAuthorByStaffId(@Param("staffId") Integer staffId, @Param("offset") Integer offset, @Param("size") Integer size);

    int getAuthorByStaffIdCount(@Param("staffId")Integer staffId);
    
    List<SysAuthorRepository> selectByStationIdAndStaffId(@Param("stationId") Integer stationId,@Param("staffId") Integer staffId);

}
