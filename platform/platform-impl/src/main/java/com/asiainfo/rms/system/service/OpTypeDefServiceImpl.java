package com.asiainfo.rms.system.service;

import com.asiainfo.rms.system.convert.SysOpTypeDefConvert;
import com.asiainfo.rms.system.dao.SysOpTypeDefDao;
import com.asiainfo.rms.system.domain.SysOpTypeDefRepository;
import com.asiainfo.rms.system.dto.SysOpTypeDefDTO;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class OpTypeDefServiceImpl implements OpTypeDefService {
    private final SysOpTypeDefDao opTypeDefDao;

    public OpTypeDefServiceImpl(SysOpTypeDefDao opTypeDefDao) {
        this.opTypeDefDao = opTypeDefDao;
    }

    @Override
    public String saveOpTypeDef(SysOpTypeDefDTO sysOpTypeDefDTO) {
        JSONObject json = new JSONObject();
        SysOpTypeDefRepository sysOpTypeDefRepository;
        sysOpTypeDefRepository = SysOpTypeDefConvert.INSTANCE.toSYS(sysOpTypeDefDTO);
        sysOpTypeDefRepository.setState(1);
        List<SysOpTypeDefRepository> codeList = opTypeDefDao.selectAllCode();
        if (codeList.size() == 0) {
            String code = "TD" + String.format("%0" + 3 + "d", 1);
            sysOpTypeDefRepository.setCode(code);
        } else {
            Integer num = Integer.valueOf(codeList.get(0).getCode().substring(2)) + 1;
            String code = "TD" + String.format("%0" + 3 + "d", num);
            sysOpTypeDefRepository.setCode(code);
        }
        if (opTypeDefDao.saveOpTypeDef(sysOpTypeDefRepository) > 0) {
            try {
                json.put("code", 1);
                json.put("msg", "success");
                json.put("op_type_id", sysOpTypeDefRepository.getOpTypeId());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

    @Override
    public String updateOpTypeDef(SysOpTypeDefDTO sysOpTypeDefDTO) {
        JSONObject json = new JSONObject();
        if (opTypeDefDao.updateOpTypeDef(SysOpTypeDefConvert.INSTANCE.toSYS(sysOpTypeDefDTO)) > 0) {
            try {
                json.put("code", 1);
                json.put("msg", "success！");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

    @Override
    public String deleteOpTypeDefById(Integer opTypeId) {
        JSONObject json = new JSONObject();
        Integer count = opTypeDefDao.deleteOpTypeDefById(opTypeId);
        try {
            if (count > 0) {
                json.put("code", 1);
                json.put("msg", "success");
                json.put("row_count", count);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return json.toString();
    }

    @Override
    public List<SysOpTypeDefDTO> selectAllOpType(String code, String opTypeName, Integer pageNo, Integer pageSize) {
        Integer offset = null;
        if ((pageNo != null) && (pageSize != null)) {
            offset = pageNo;
        }
        List<SysOpTypeDefRepository> opTypeDefList = opTypeDefDao.selectAllOpType(code, opTypeName, offset, pageSize);
        if (opTypeDefList.size() > 0) {
            return SysOpTypeDefConvert.INSTANCE.toDTOs(opTypeDefList);
        } else {
            return null;
        }
    }

    @Override
    public int getOpTypeCount(String code, String opTypeName) {
        return opTypeDefDao.getOpTypeCount(code, opTypeName);
    }
}
