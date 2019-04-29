package com.asiainfo.rms.alm.arsenal.service;

import com.asiainfo.rms.alm.arsenal.convert.AlmAsnltmpRuleRelatConvert;
import com.asiainfo.rms.alm.arsenal.dao.AlmAsnltmpRuleRelatDao;
import com.asiainfo.rms.alm.arsenal.domain.AlmAsnltmpRuleRelatRepository;
import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpRuleRelatDTO;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class AlmAsnltmpRuleRelatServiceImpl implements AlmAsnltmpRuleRelatService {
    private final AlmAsnltmpRuleRelatDao almAsnltmpRuleRelatDao;

    public AlmAsnltmpRuleRelatServiceImpl(AlmAsnltmpRuleRelatDao almAsnltmpRuleRelatDao) {
        this.almAsnltmpRuleRelatDao = almAsnltmpRuleRelatDao;
    }

    @Override
    public String saveAlmAsnltmpRuleRelat(AlmAsnltmpRuleRelatDTO almAsnltmpRuleRelatDTO) {
        JSONObject json = new JSONObject();
        AlmAsnltmpRuleRelatRepository almAsnltmpRuleRelatRepository;
        almAsnltmpRuleRelatRepository = AlmAsnltmpRuleRelatConvert.INSTANCE.toSYS(almAsnltmpRuleRelatDTO);
        //同一个类型下，同一个规则只能新增一条数据
        Integer artType = almAsnltmpRuleRelatRepository.getArtType();
        Integer arId = almAsnltmpRuleRelatRepository.getArId();

        if(almAsnltmpRuleRelatDao.getRuleRelaByTypeAndId(artType,arId) ==0){
            if(almAsnltmpRuleRelatDao.saveAlmAsnltmpRuleRelat(almAsnltmpRuleRelatRepository)>0){
                try {
                    json.put("code",1);
                    json.put("msg","success");
                    json.put("atrr_id",almAsnltmpRuleRelatRepository.getAtrrId());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }else{
            try {
                json.put("code",0);
                json.put("msg","该规则已存在");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

    @Override
    public String updateAlmAsnltmpRuleRelat(AlmAsnltmpRuleRelatDTO almAsnltmpRuleRelatDTO) {
        JSONObject json = new JSONObject();
        AlmAsnltmpRuleRelatRepository almAsnltmpRuleRelatRepository;
        almAsnltmpRuleRelatRepository = AlmAsnltmpRuleRelatConvert.INSTANCE.toSYS(almAsnltmpRuleRelatDTO);
        if(almAsnltmpRuleRelatDao.updateAlmAsnltmpRuleRelat(almAsnltmpRuleRelatRepository)>0){
            try {
                json.put("code",1);
                json.put("msg","success");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

    @Override
    public String deleteAlmAsnltmpRuleRelat(Integer atrrId) {
        JSONObject json = new JSONObject();
        Integer count = almAsnltmpRuleRelatDao.deleteAlmAsnltmpRuleRelat(atrrId);
        if(count >0){
            try {
                json.put("code",1);
                json.put("msg","success");
                json.put("row_count",count);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

//    @Override
//    public AlmAsnltmpRuleRelatDTO selectAlmAsnltmpRuleRela(Integer atrrId) {
//        return AlmAsnltmpRuleRelatConvert.INSTANCE.toDTO(almAsnltmpRuleRelatDao.selectAlmAsnltmpRuleRela(atrrId));
//    }

    @Override
    public List<AlmAsnltmpRuleRelatDTO> selectAlmAsnltmpServiceRelatByArtType(Integer artType, Integer aatId, Integer objId) {
        return AlmAsnltmpRuleRelatConvert.INSTANCE.toDTOs(almAsnltmpRuleRelatDao.selectAlmAsnltmpServiceRelatByArtType(artType, aatId, objId));
    }

    @Override
    public List<AlmAsnltmpRuleRelatDTO> selectAllAlmAsnltmpRuleRela(Integer artType, Integer pageNo, Integer pageSize) {
        Integer offset = null;
        if ((pageNo != null) && (pageSize != null)) {
            offset = pageNo;

        }
        List<AlmAsnltmpRuleRelatRepository> itemList = almAsnltmpRuleRelatDao.selectAllAlmAsnltmpRuleRela(artType, offset, pageSize);
        if (itemList.size() > 0) {
            return AlmAsnltmpRuleRelatConvert.INSTANCE.toDTOs(itemList);
        } else {
            return null;
        }
    }

    @Override
    public Integer getAllAlmAsnltmpRuleRelaCount(Integer artType) {
        return almAsnltmpRuleRelatDao.getAllAlmAsnltmpRuleRelaCount(artType);
    }
}
