package com.asiainfo.rms.alm.arsenal.dao;

import com.asiainfo.rms.alm.arsenal.domain.AlmArsenalServiceRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlmArsenalServiceDao {

    Integer saveAlmArsenalService(AlmArsenalServiceRepository almArsenalServiceRepository);

    Integer updateAlmArsenalService(AlmArsenalServiceRepository almArsenalServiceRepository);

    Integer deleteAlmArsenalService(@Param("asId") Integer asId);

    AlmArsenalServiceRepository selectAlmArsenalServiceById(@Param("asId") Integer asId);

    List<AlmArsenalServiceRepository> selectAllAlmArsenalService(@Param("keyword")String keyword,
                                                                 @Param("offset") Integer offset,
                                                                 @Param("size") Integer size);

    Integer getAllAlmArsenalService(@Param("keyword")String keyword);

    Integer getAlmArsenalServiceByServiceId(@Param("serviceId")Integer serviceId);
}
