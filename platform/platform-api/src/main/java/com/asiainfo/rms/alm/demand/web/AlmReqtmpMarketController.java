package com.asiainfo.rms.alm.demand.web;

import com.asiainfo.rms.alm.demand.dto.AlmReqtmpMarketDTO;
import com.asiainfo.rms.alm.demand.dto.MarketDTO;
import com.asiainfo.rms.core.api.Page;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/alm")
public interface AlmReqtmpMarketController {
    /**
     * 新增营销类需求模板信息
     *
     * @param marketDTO
     * @return
     */
    @RequestMapping(value = "/alm_reqtmp_market", method = RequestMethod.POST)
    String saveAlmReqtmpMarket(MarketDTO marketDTO);

    /**
     * 修改营销类需求模板信息
     *
     * @param marketDTO
     * @return
     */
    @RequestMapping(value = "/alm_reqtmp_market", method = RequestMethod.PUT)
    String updateAlmReqtmpMarket(@RequestBody MarketDTO marketDTO);

    /**
     * 删除营销类需求模板信息
     *
     * @param armId
     * @return
     */
    @RequestMapping(value = "/alm_reqtmp_market/{arm_id}", method = RequestMethod.DELETE)
    String deletaAlmReqtmpMarket(@PathVariable("arm_id") Integer armId);

    /**
     * 查询营销类需求模板信息
     *
     * @param armId
     * @return
     */
    @RequestMapping(value = "/alm_reqtmp_market/{arm_id}", method = RequestMethod.GET)
    MarketDTO selectAlmReqtmpMarket(@PathVariable("arm_id") Integer armId);

    /**
     * 根据artId查询资费需求模板信息
     *
     * @param artId
     * @return
     */
    @RequestMapping(value = "/alm_reqtmp_market/market/{art_id}", method = RequestMethod.GET)
    MarketDTO selectMarket(@PathVariable("art_id") Integer artId);

    /**
     * 查询所有营销类需求模板信息（带分页）
     *
     * @return
     */
    @RequestMapping(value = "/alm_reqtmp_market/all", method = RequestMethod.GET)
    Page<AlmReqtmpMarketDTO> selectAllAlmReqtmpMarket(@RequestParam(value = "keyword", required = false) String keyword,
                                                      @RequestParam(value = "art_type", required = false) Integer artType,
                                                      @RequestParam(value = "art_name", required = false) String artName,
                                                      @RequestParam(value = "art_tag", required = false) String artTag,
                                                      @RequestParam(value = "art_region", required = false) Integer artRegion,
                                                      @RequestParam(value = "urgent_level", required = false) Integer urgentLevel,
                                                      @RequestParam(value = "submit_staff_name", required = false) String submitStaffName,
                                                      @RequestParam(value = "page_no") Integer pageNo,
                                                      @RequestParam(value = "page_size") Integer pageSize);
}
