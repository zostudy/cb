package com.asiainfo.rms.alm.demand.dao;

import com.asiainfo.rms.alm.demand.domain.AlmReqtmpRewardCntRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlmReqtmpRewardCntDao {

    Integer saveAlmReqtmpRewardCnt(AlmReqtmpRewardCntRepository almReqtmpRewardCntRepository);

    Integer updateAlmReqtmpRewardCnt(AlmReqtmpRewardCntRepository almReqtmpRewardCntRepository);

    Integer deleteAlmReqtmpRewardCnt(@Param("contentId")Integer contentId);

    AlmReqtmpRewardCntRepository selectAlmReqtmpRewardCnt(@Param("contentId")Integer contentId);

    List<AlmReqtmpRewardCntRepository> selectAllAlmReqtmpRewardCnt(@Param("arrId")Integer arrId,
                                                                   @Param("keyword")String keyword,
                                                                   @Param("offset") Integer offset,
                                                                   @Param("size") Integer size);

    Integer getAllAlmReqtmpRewardCntCount(@Param("arrId")Integer arrId,@Param("keyword")String keyword);
}
