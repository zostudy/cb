package com.asiainfo.rms.alm.demand.web;

import com.asiainfo.rms.alm.demand.dto.AlmReqtmpRewardDTO;
import com.asiainfo.rms.alm.demand.dto.RewardDTO;
import com.asiainfo.rms.core.api.Page;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/alm")
public interface AlmReqtmpRewardController {

    /**
     * 新增酬金需求模板信息
     * @param rewardDTO
     * @return
     */
    @RequestMapping(value="/alm_reqtmp_reward",method = RequestMethod.POST)
    String saveAlmReqtmpReward(RewardDTO rewardDTO);

    /**
     * 修改酬金需求模板信息
     * @param rewardDTO
     * @return
     */
    @RequestMapping(value="/alm_reqtmp_reward",method = RequestMethod.PUT)
    String updateAlmReqtmpReward(@RequestBody RewardDTO rewardDTO);

    /**
     * 删除酬金需求模板信息
     * @param arrId
     * @return
     */
    @RequestMapping(value="/alm_reqtmp_reward/{arr_id}",method = RequestMethod.DELETE)
    String deleteAlmReqtmpReward(@PathVariable("arr_id")Integer arrId);

    /**
     * 根据ID查询酬金需求模板信息
     * @param arrId
     * @return
     */
    @RequestMapping(value="/alm_reqtmp_reward/{arr_id}",method = RequestMethod.GET)
    RewardDTO selectAlmReqtmpReward(@PathVariable("arr_id")Integer arrId);

    /**
     * 根据artId查询资费需求模板信息
     * @param artId
     * @return
     */
    @RequestMapping(value="/alm_reqtmp_reward/reward/{art_id}",method = RequestMethod.GET)
    RewardDTO selectReward(@PathVariable("art_id")Integer artId);

    /**
     * 带分页查询所有酬金需求模板信息
     * @param keyword
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value="/alm_reqtmp_reward/all",method = RequestMethod.GET)
    Page<AlmReqtmpRewardDTO> selectAllAlmReqtmpReward(@RequestParam(value = "keyword",required = false)String keyword,
											    		@RequestParam(value = "art_type", required = false) Integer artType,
											    		@RequestParam(value = "art_name", required = false) String artName,
											    		@RequestParam(value = "art_tag", required = false) String artTag,
											    		@RequestParam(value = "art_region", required = false) Integer artRegion,
											    		@RequestParam(value = "urgent_level", required = false) Integer urgentLevel ,
											    		@RequestParam(value = "submit_staff_name", required = false) String submitStaffName,
											    		@RequestParam(value = "page_no") Integer pageNo,
                                                      @RequestParam(value = "page_size") Integer pageSize);
}
