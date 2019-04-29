package com.asiainfo.rms.alm.demand.service;

import com.asiainfo.rms.alm.demand.convert.AlmReqtmpRewardCntConvert;
import com.asiainfo.rms.alm.demand.dao.AlmReqtmpRewardCntDao;
import com.asiainfo.rms.alm.demand.domain.AlmReqtmpRewardCntRepository;
import com.asiainfo.rms.alm.demand.dto.AlmReqtmpRewardCntDTO;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class AlmReqtmpRewardCntServiceImpl implements AlmReqtmpRewardCntService {
    private final AlmReqtmpRewardCntDao almReqtmpRewardCntDao;

    public AlmReqtmpRewardCntServiceImpl(AlmReqtmpRewardCntDao almReqtmpRewardCntDao) {
        this.almReqtmpRewardCntDao = almReqtmpRewardCntDao;
    }

    @Override
    public String saveAlmReqtmpRewardCnt(AlmReqtmpRewardCntDTO almReqtmpRewardCntDTO) {
        JSONObject json = new JSONObject();
        AlmReqtmpRewardCntRepository almReqtmpRewardCntRepository;
        almReqtmpRewardCntRepository = AlmReqtmpRewardCntConvert.INSTANCE.toSYS(almReqtmpRewardCntDTO);
        if (almReqtmpRewardCntDao.saveAlmReqtmpRewardCnt(almReqtmpRewardCntRepository) > 0) {
            try {
                json.put("code", 1);
                json.put("msg", "success");
                json.put("content_id", almReqtmpRewardCntRepository.getContentId());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

    @Override
    public String updateAlmReqtmpRewardCnt(AlmReqtmpRewardCntDTO almReqtmpRewardCntDTO) {
        JSONObject json = new JSONObject();
        AlmReqtmpRewardCntRepository almReqtmpRewardCntRepository;
        almReqtmpRewardCntRepository = AlmReqtmpRewardCntConvert.INSTANCE.toSYS(almReqtmpRewardCntDTO);
        if (almReqtmpRewardCntDao.updateAlmReqtmpRewardCnt(almReqtmpRewardCntRepository) > 0) {
            try {
                json.put("code", 1);
                json.put("msg", "success");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

    @Override
    public String deleteAlmReqtmpRewardCnt(Integer contentId) {
        JSONObject json = new JSONObject();
        Integer count = almReqtmpRewardCntDao.deleteAlmReqtmpRewardCnt(contentId);
        if (count > 0) {
            try {
                json.put("code", 1);
                json.put("row_count",count);
                json.put("msg", "success");
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
     return json.toString();

}


    @Override
    public AlmReqtmpRewardCntDTO selectAlmReqtmpRewardCnt(Integer contentId) {
        return AlmReqtmpRewardCntConvert.INSTANCE.toDTO(almReqtmpRewardCntDao.selectAlmReqtmpRewardCnt(contentId));
    }

    @Override
    public List<AlmReqtmpRewardCntDTO> selectAllAlmReqtmpRewardCnt(Integer arrId,String keyword,Integer pageNo, Integer pageSize) {
        Integer offset = null;
        if ((pageNo != null) && (pageSize != null)) {
            offset = pageNo;

        }
        List<AlmReqtmpRewardCntRepository> itemList = almReqtmpRewardCntDao.selectAllAlmReqtmpRewardCnt(arrId,keyword, offset, pageSize);
        if (itemList.size() > 0) {
            return AlmReqtmpRewardCntConvert.INSTANCE.toDTOs(itemList);
        } else {
            return null;
        }
    }

    @Override
    public Integer getAllAlmReqtmpRewardCntCount(Integer arrId,String keyword) {
        return almReqtmpRewardCntDao.getAllAlmReqtmpRewardCntCount(arrId,keyword);
    }
}
