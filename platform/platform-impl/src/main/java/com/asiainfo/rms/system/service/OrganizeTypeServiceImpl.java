package com.asiainfo.rms.system.service;

import com.asiainfo.rms.system.convert.SysOrganizeTypeConvert;
import com.asiainfo.rms.system.dao.SysOrganizeTypeDao;
import com.asiainfo.rms.system.domain.SysOrganizeTypeRepository;
import com.asiainfo.rms.system.dto.SysOrganizeTypeDTO;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class OrganizeTypeServiceImpl implements OrganizeTypeService {
    private final SysOrganizeTypeDao organizeTypeDao;

    public OrganizeTypeServiceImpl(SysOrganizeTypeDao organizeTypeDao) {
        this.organizeTypeDao = organizeTypeDao;
    }

    @Override
    public String saveOrganizeType(SysOrganizeTypeDTO organizeTypeDTO) {
        JSONObject json = new JSONObject();
        SysOrganizeTypeRepository organizeTypeRepository;
        organizeTypeRepository = SysOrganizeTypeConvert.INSTANCE.toSYS(organizeTypeDTO);
        organizeTypeRepository.setCreateDate(new java.sql.Date(new java.util.Date().getTime()));
        organizeTypeRepository.setState(1);

        List<SysOrganizeTypeRepository> typeList =organizeTypeDao.selectAllCode();
        if(typeList.size() == 0){
            String code = "OT" + String.format("%0" + 3 + "d", 1);
            organizeTypeRepository.setCode(code);
        }else{
            Integer num = Integer.valueOf(typeList.get(0).getCode().replaceAll(".*[^\\d](?=(\\d+))",""))+1;
            String code = "OT" + String.format("%0" + 3 + "d", num);
            organizeTypeRepository.setCode(code);
        }
        if(organizeTypeDao.saveOrganizeType(organizeTypeRepository)>0) {
            try {
                json.put("code", 1);
                json.put("msg", "success");
                json.put("organize_type_id", organizeTypeRepository.getOrganizeTypeId());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

    @Override
    public String updateOrganizeType(SysOrganizeTypeDTO organizeTypeDTO) {
        JSONObject json = new JSONObject();
        SysOrganizeTypeRepository organizeTypeRepository;
        organizeTypeRepository = SysOrganizeTypeConvert.INSTANCE.toSYS(organizeTypeDTO);
        if(organizeTypeDao.updateOrganizeType(organizeTypeRepository)>0) {

            try {
                json.put("code", 1);
                json.put("msg", "修改成功！");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

    @Override
    public String deleteOrganizeTypeById(Integer organizeTypeId) {
        JSONObject json = new JSONObject();
        Integer count = organizeTypeDao.deleteOrganizeTypeById(organizeTypeId);
        if(count >0) {
            try {
                json.put("code", 1);
                json.put("msg", "success");
                json.put("row_count", count);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

    @Override
    public List<SysOrganizeTypeDTO> selectOrganizeType(String keywork, Integer pageNo, Integer pageSize) {
        Integer offset = null;
        if ((pageNo != null) && (pageSize != null)) {
            offset = pageNo;

        }
        List<SysOrganizeTypeRepository> organizeTypeList = organizeTypeDao.selectOrganizeType(keywork, offset, pageSize);
        if (organizeTypeList.size() > 0) {
            return SysOrganizeTypeConvert.INSTANCE.toDTOs(organizeTypeList);
        } else {
            return null;
        }
    }

    @Override
    public Integer getOrganizeTypeCount(String keywork) {
        return organizeTypeDao.getOrganizeTypeCount(keywork);
    }

//    @Override
//    public List<SysOrganizeTypeDTO> selectOrganizeType(String keywork) {
//        return SysOrganizeTypeConvert.INSTANCE.toDTOs(organizeTypeDao.selectOrganizeType(keywork));
//    }
}
