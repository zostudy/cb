package com.asiainfo.rms.system.service;

import com.asiainfo.rms.system.convert.SysOrganizeConvert;
import com.asiainfo.rms.system.dao.SysOrganizeDao;
import com.asiainfo.rms.system.domain.SysOrganizeRepository;
import com.asiainfo.rms.system.dto.SysOrganizeDTO;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class OrganizeServiceImpl implements OrganizeService {
    private final SysOrganizeDao organizeDao;

    public OrganizeServiceImpl(SysOrganizeDao organizeDao) {
        this.organizeDao = organizeDao;
    }

    @Override
    public String saveOrganize(SysOrganizeDTO organizeDTO) {
        JSONObject json = new JSONObject();
        SysOrganizeRepository organizeRepository;
        organizeRepository = SysOrganizeConvert.INSTANCE.toSYS(organizeDTO);
        //查询parentCode下的节点，生成下一级节点code
        String parentCode = organizeRepository.getParentCode();

        List<SysOrganizeRepository> organizeList = organizeDao.selectByParentCode(parentCode);
        if (organizeList.size() == 0) {
            Integer code = Integer.valueOf(parentCode) + 100;
            organizeRepository.setCode(code.toString());
        } else {
            Integer max = 0;
            for (SysOrganizeRepository organize : organizeList) {
                Integer code = Integer.valueOf(organize.getCode());
                if (max < code) {
                    max = code;
                }
            }
            Integer newCode = max + 1;
            organizeRepository.setCode(newCode.toString());
        }
        organizeRepository.setCreateDate(new java.sql.Date(new java.util.Date().getTime()));
        organizeRepository.setState(1);

        if (organizeDao.saveOrganize(organizeRepository) > 0) {
            try {
                json.put("code", 1);
                json.put("msg", "success");
                json.put("organize_id", organizeRepository.getOrganizeId());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

    @Override
    public String updateOrganize(SysOrganizeDTO organizeDTO) {
        JSONObject json = new JSONObject();
        if (organizeDao.updateOrganize(SysOrganizeConvert.INSTANCE.toSYS(organizeDTO)) > 0) {
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
    public String deleteByOrganizeId(Integer organizeId) {
        JSONObject json = new JSONObject();
        Integer count = organizeDao.deleteByOrganizeId(organizeId);
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
    public SysOrganizeDTO selectByOrganizeId(Integer organizeId) {
        return SysOrganizeConvert.INSTANCE.toDTO(organizeDao.selectByOrganizeId(organizeId));
    }

//    @Override
//    public SysOrganizeDTO selectOrganizeByStaffId(Integer staffId) {
//        return SysOrganizeConvert.INSTANCE.toDTO(organizeDao.selectOrganizeByStaffId(staffId));
//    }

    @Override
    public List<SysOrganizeDTO> selectAllOrganize(String code, String organizeName, Integer state) {
        return SysOrganizeConvert.INSTANCE.toDTOs(organizeDao.selectAllOrganize(code, organizeName, state));
    }

    @Override
    public List<SysOrganizeDTO> selectOrganizeByParentId(Integer parentOrganizeId, Integer state) {
        return SysOrganizeConvert.INSTANCE.toDTOs(organizeDao.selectOrganizeByParentId(parentOrganizeId, state));
    }

    @Override
    public SysOrganizeDTO selectOrganizeInfo(Integer tire,Integer organizeId,String organizeCode,Integer staffId,String staffCode) {
        SysOrganizeRepository sysOrganizeRepository = null;
        if(organizeId !=null || organizeCode !=null){
            sysOrganizeRepository= organizeDao.selectOrganizeInfoByOrganize(tire,organizeId, organizeCode);
        }
        if(staffId !=null || staffCode !=null){
            sysOrganizeRepository=organizeDao.selectOrganizeInfoByStaff(tire,staffId, staffCode);
        }

        return SysOrganizeConvert.INSTANCE.toDTO(sysOrganizeRepository);
    }
}
