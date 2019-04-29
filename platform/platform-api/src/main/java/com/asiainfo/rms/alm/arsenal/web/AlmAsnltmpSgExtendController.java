package com.asiainfo.rms.alm.arsenal.web;

import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpSgExtendDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/alm")
public interface AlmAsnltmpSgExtendController {

//    /**
//     * 删除存送附表
//     * @param aasId
//     * @return
//     */
//    @RequestMapping(value="/alm_asnltmp_sg_extend/{aas_id}",method = RequestMethod.DELETE)
//    String deleteAlmAsnltmpSgExtend(@PathVariable("aas_id")Integer aasId);

    /**
     * 查询
     * @param aasId
     * @return
     */
    @RequestMapping(value="/alm_asnltmp_sg_extend/{aas_id}",method = RequestMethod.GET)
    AlmAsnltmpSgExtendDTO selectAlmAsnltmpSgExtend(@PathVariable("aas_id")Integer aasId);

//    /**
//     * 带分页查询所有
//     * @param aatId
//     * @param pageNo
//     * @param pageSize
//     * @return
//     */
//    @RequestMapping(value="/alm_asnltmp_sg_extend/all",method = RequestMethod.GET)
//    Page<AlmAsnltmpSgExtendDTO> selectAllAlmAsnltmpSgExtend(@RequestParam("aat_id")Integer aatId,
//                                                            @RequestParam("page_no")Integer pageNo,
//                                                            @RequestParam("page_size")Integer pageSize);
}
