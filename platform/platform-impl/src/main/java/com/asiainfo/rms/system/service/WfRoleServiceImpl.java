package com.asiainfo.rms.system.service;

import com.asiainfo.rms.system.convert.SysWfRoleConvert;
import com.asiainfo.rms.system.dao.SysWfRoleDao;
import com.asiainfo.rms.system.domain.SysWfRoleRepository;
import com.asiainfo.rms.system.dto.SysWfRoleDTO;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class WfRoleServiceImpl implements SysWfRoleService {
    private final SysWfRoleDao wfRoleDao;

    public WfRoleServiceImpl(SysWfRoleDao wfRoleDao) {
        this.wfRoleDao = wfRoleDao;
    }

    @Override
    public String saveSysWfRole(SysWfRoleDTO wfRoleDTO) {
        JSONObject json = new JSONObject();
        SysWfRoleRepository wfRoleRepository;
        wfRoleRepository = SysWfRoleConvert.INSTANCE.toSYS(wfRoleDTO);
        String keyword = wfRoleRepository.getCode();
        if(StringUtils.isNotBlank(keyword)){
            int cnt = wfRoleDao.getSysWfRoleCount(keyword,null,null);
            if(cnt > 0){
                try {
                    json.put("code", 0);
                    json.put("msg", "该环节编码已存在");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return json.toString();
            }
        }
//        List<SysWfRoleRepository> wfRoleList = wfRoleDao.selectAllCode();
//        if (wfRoleList.size() == 0) {
//            code = "WR" + String.format("%0" + 3 + "d", 1);
//        } else {
//            Integer num = Integer.valueOf(wfRoleList.get(0).getCode().substring(2)) + 1;
//            code = "WR" + String.format("%0" + 3 + "d", num);
//        }
//        wfRoleRepository.setCode(code);
        wfRoleRepository.setState(1);
        wfRoleRepository.setCreateDate(new java.sql.Date(new java.util.Date().getTime()));
        if (wfRoleDao.saveSysWfRole(wfRoleRepository) > 0) {
            try {
                json.put("code", 1);
                json.put("msg", "success");
                json.put("wf_role_id", wfRoleRepository.getWfRoleId());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

    @Override
    public String updateSysWfRole(SysWfRoleDTO wfRoleDTO) {
        JSONObject json = new JSONObject();
        SysWfRoleRepository wfRoleRepository;
        wfRoleRepository = SysWfRoleConvert.INSTANCE.toSYS(wfRoleDTO);
        String keyword = wfRoleRepository.getCode();
        if(StringUtils.isNotBlank(keyword)){
            Integer wfRoleId = wfRoleRepository.getWfRoleId();
            int cnt = wfRoleDao.getCountRemoveId(keyword,wfRoleId);
            if(cnt > 0){
                try {
                    json.put("code", 0);
                    json.put("msg", "该环节编码已存在");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return json.toString();
            }
        }
        if (wfRoleDao.updateSysWfRole(wfRoleRepository) > 0) {
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
    public String deleteSysWfRoleById(Integer wfRoleId) {
        JSONObject json = new JSONObject();
        Integer count = wfRoleDao.deleteSysWfRoleById(wfRoleId);
        if (count > 0) {
            try {
                json.put("code", 1);
                json.put("row_count", count);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

    @Override
    public List<SysWfRoleDTO> selectSysWfRole(String keyword,Integer selectedStationId,String processKey, Integer pageNo, Integer pageSize) {
        Integer offset = null;
        if ((pageNo != null) && (pageSize != null)) {
            offset = pageNo;

        }
        List<SysWfRoleRepository> wfRoleList = wfRoleDao.selectSysWfRole(keyword,selectedStationId,processKey, offset, pageSize);
        if (wfRoleList.size() > 0) {
            return SysWfRoleConvert.INSTANCE.toDTOs(wfRoleList);
        } else {
            return null;
        }
    }

    @Override
    public Integer getSysWfRoleCount(String keyword,Integer selectedStationId,String processKey) {
        return wfRoleDao.getSysWfRoleCount(keyword,selectedStationId,processKey);
    }
}
