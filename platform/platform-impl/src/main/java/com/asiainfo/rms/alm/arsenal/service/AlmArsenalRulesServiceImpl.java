package com.asiainfo.rms.alm.arsenal.service;

import com.asiainfo.rms.alm.arsenal.convert.AlmArsenalRulesConvert;
import com.asiainfo.rms.alm.arsenal.dao.AlmArsenalRulesDao;
import com.asiainfo.rms.alm.arsenal.domain.AlmArsenalRulesRepository;
import com.asiainfo.rms.alm.arsenal.dto.AlmArsenalRulesDTO;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class AlmArsenalRulesServiceImpl implements AlmArsenalRulesService{

    private final AlmArsenalRulesDao almArsenalRulesDao;

    public AlmArsenalRulesServiceImpl(AlmArsenalRulesDao almArsenalRulesDao) {
        this.almArsenalRulesDao = almArsenalRulesDao;
    }

    @Override
    public String saveAlmArsenalRules(AlmArsenalRulesDTO almArsenalRulesDTO) {
        JSONObject json = new JSONObject();
        AlmArsenalRulesRepository almArsenalRulesRepository;
        almArsenalRulesRepository = AlmArsenalRulesConvert.INSTANCE.toSYS(almArsenalRulesDTO);
        String ruleTagStr = almArsenalRulesRepository.getRuleTag();
        if((almArsenalRulesDao.getRuleTagCount(ruleTagStr)) == 0){
        if(almArsenalRulesDao.saveAlmArsenalRules(almArsenalRulesRepository)>0){
            try {
                json.put("code",1);
                json.put("msg","success");
                json.put("ar_id",almArsenalRulesRepository.getArId());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }}else{
            try {
                json.put("code",0);
                json.put("msg","此配置编码已存在，请重新输入！");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

    @Override
    public String updateAlmArsenalRules(AlmArsenalRulesDTO almArsenalRulesDTO) {
        JSONObject json = new JSONObject();
        if(almArsenalRulesDao.updateAlmArsenalRules(AlmArsenalRulesConvert.INSTANCE.toSYS(almArsenalRulesDTO))>0){

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
    public String deleteAlmArsenalRules(Integer arId) {
        JSONObject json = new JSONObject();
        Integer count = almArsenalRulesDao.deleteAlmArsenalRules(arId);
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

    @Override
    public AlmArsenalRulesDTO selectArsenalRulesById(Integer arId) {
        return AlmArsenalRulesConvert.INSTANCE.toDTO(almArsenalRulesDao.selectArsenalRulesById(arId));
    }


    @Override
    public List<AlmArsenalRulesDTO> selectAllArsenalRules(String keyword, Integer pageNo, Integer pageSize) {
        Integer offset = null;
        if ((pageNo != null) && (pageSize != null)) {
            offset = pageNo;

        }
        List<AlmArsenalRulesRepository> itemList = almArsenalRulesDao.selectAllArsenalRules(keyword, offset, pageSize);
        if (itemList.size() > 0) {
            return AlmArsenalRulesConvert.INSTANCE.toDTOs(itemList);
        } else {
            return null;
        }
    }

    @Override
    public Integer getAllArsenalRules(String keyword) {
        return almArsenalRulesDao.getAllArsenalRules(keyword);
    }
}
