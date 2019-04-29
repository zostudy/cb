package com.asiainfo.rms.alm.demand.web;

import com.asiainfo.rms.alm.demand.dto.AlmReqtmpRewardCntDTO;
import com.asiainfo.rms.core.api.Page;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/alm")
public interface AlmReqtmpRewardCntController {

    /**
     * 新增酬金配置信息
     * @param almReqtmpRewardCntDTO
     * @return
     */
    @RequestMapping(value = "/alm_reqtmp_rewardcnt",method = RequestMethod.POST)
    String saveAlmReqtmpRewardCnt(@RequestBody AlmReqtmpRewardCntDTO almReqtmpRewardCntDTO);

    /**
     * 修改酬金配置信息
     * @param almReqtmpRewardCntDTO
     * @return
     */
    @RequestMapping(value = "/alm_reqtmp_rewardcnt/{content_id}",method = RequestMethod.PUT)
    String updateAlmReqtmpRewardCnt(@PathVariable("content_id") Integer contentId, @RequestBody AlmReqtmpRewardCntDTO almReqtmpRewardCntDTO);

    /**
     * 删除酬金配置信息
     * @return
     */
    @RequestMapping(value = "/alm_reqtmp_rewardcnt/{content_id}",method = RequestMethod.DELETE)
    String deleteAlmReqtmpRewardCnt(@PathVariable("content_id")Integer contentId);

    /**
     * 查询骤减配置信息
     * @param contentId
     * @return
     */
    @RequestMapping(value = "/alm_reqtmp_rewardcnt/{content_id}",method = RequestMethod.GET)
    AlmReqtmpRewardCntDTO selectAlmReqtmpRewardCnt(@PathVariable("content_id")Integer contentId);

    /**
     * 查询所有配置信息-带分页
     * @param arrId
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value ="/alm_reqtmp_rewardcnt/all",method = RequestMethod.GET)
    Page<AlmReqtmpRewardCntDTO> selectAllAlmReqtmpRewardCnt(@RequestParam("arr_id")Integer arrId,
                                                            @RequestParam(value = "keyword",required = false)String keyword,
                                                            @RequestParam(value = "page_no") Integer pageNo,
                                                            @RequestParam(value = "page_size") Integer pageSize);
}
