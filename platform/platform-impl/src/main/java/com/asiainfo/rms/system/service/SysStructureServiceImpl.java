package com.asiainfo.rms.system.service;

import com.asiainfo.rms.system.convert.SysStructureDefConvert;
import com.asiainfo.rms.system.convert.SysStructureInfoConvert;
import com.asiainfo.rms.system.dao.SysStructureDefDao;
import com.asiainfo.rms.system.dao.SysStructureInfoDao;
import com.asiainfo.rms.system.domain.SysStructureDefRepository;
import com.asiainfo.rms.system.domain.SysStructureInfoRepository;
import com.asiainfo.rms.system.dto.SysStructureDTO;
import com.asiainfo.rms.system.dto.SysStructureDefDTO;
import com.asiainfo.rms.system.dto.SysStructureInfoDTO;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@Transactional
public class SysStructureServiceImpl implements SysStructureService {
    private final SysStructureDefDao structureDefDao;
    private final SysStructureInfoDao structureInfoDao;

    public SysStructureServiceImpl(SysStructureDefDao structureDefDao, SysStructureInfoDao structureInfoDao) {
        this.structureDefDao = structureDefDao;
        this.structureInfoDao = structureInfoDao;
    }

    @Override
    public String saveStructure(SysStructureDTO sysStructureDTO) {
        JSONObject json = new JSONObject();
        SysStructureDefRepository sysStructureDefRepository;
        sysStructureDefRepository = SysStructureDefConvert.INSTANCE.toSYS(sysStructureDTO.getStructureDef());
        if(structureDefDao.saveStructure(sysStructureDefRepository)>0){
            SysStructureInfoRepository sysStructureInfoRepository;
            sysStructureInfoRepository = SysStructureInfoConvert.INSTANCE.toSYS(sysStructureDTO.getStructureInfo());
            sysStructureInfoRepository.setStructureId(sysStructureDefRepository.getStructureId());
            if(structureInfoDao.saveStructureInfo(sysStructureInfoRepository)>0)
            try {
                json.put("code", 1);
                json.put("msg", "success");
                json.put("structure_id", sysStructureDefRepository.getStructureId());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

    @Override
    public String updateStructure(Integer structureId, SysStructureDTO sysStructureDTO) {
        int i=0;
        JSONObject json = new JSONObject();
        if(sysStructureDTO.getStructureDef() !=null){
            SysStructureDefRepository sysStructureDefRepository;
            sysStructureDefRepository = SysStructureDefConvert.INSTANCE.toSYS(sysStructureDTO.getStructureDef());
            sysStructureDefRepository.setStructureId(structureId);

            if(structureDefDao.updateStructure(sysStructureDefRepository)>0){
                i++;
            }
        }

        if(sysStructureDTO.getStructureInfo() !=null){
            SysStructureInfoRepository sysStructureInfoRepository;
            sysStructureInfoRepository = SysStructureInfoConvert.INSTANCE.toSYS(sysStructureDTO.getStructureInfo());
            sysStructureInfoRepository.setStructureId(structureId);
            String str = sysStructureInfoRepository.getStructureInfo();
            Pattern p = Pattern.compile("？</a>");
            Matcher m = p.matcher(str);
            if(m.find()){
                sysStructureInfoRepository.setStructureInfo(str.replace("？",""));
            }
            if(structureInfoDao.updateStructureInfo(sysStructureInfoRepository)>0){
                i++;
            }
        }

        try {
            json.put("code", 1);
            json.put("msg", "success");
            json.put("row_count",i);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return json.toString();
    }

    @Override
    public String deleteStructure(Integer structureId) {
        JSONObject json = new JSONObject();
        Integer count1 = structureDefDao.deleteStructure(structureId);
        Integer count2 = structureInfoDao.deleteStructureInfo(structureId);
        if(count1 >0 || count2 >0) {
            try {
                json.put("code", 1);
                json.put("row_count", count1 + count2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

    @Override
    public SysStructureDTO selectByStructureId(Integer structureId) {
        SysStructureInfoDTO structureInfoDTO = SysStructureInfoConvert.INSTANCE.toDTO(structureInfoDao.selectInfoByStructureId(structureId));
        SysStructureDefDTO structureDefDTO = SysStructureDefConvert.INSTANCE.toDTO(structureDefDao.selectByStructureId(structureId));
        SysStructureDTO sysStructureDTO = new SysStructureDTO();
        if(structureInfoDTO !=null){
            sysStructureDTO.setStructureInfo(structureInfoDTO);
        }
        if(structureDefDTO !=null){
            sysStructureDTO.setStructureDef(structureDefDTO);
        }
        return sysStructureDTO;
    }

    @Override
    public List<SysStructureDefDTO> selectAllStructure() {
        return SysStructureDefConvert.INSTANCE.toDTOs(structureDefDao.selectAllStructure());
    }

    @Override
    public List<SysStructureDefDTO> selectStructureByKeyword(String keyword, Integer structureParentId, Integer pageNo, Integer pageSize) {
        Integer offset = null;
        if ((pageNo != null) && (pageSize != null)) {
            offset = pageNo;
        }
        List<SysStructureDefRepository> structureDefList =structureDefDao.selectStructureByKeyword(keyword, structureParentId, offset, pageSize);
        if (structureDefList.size() > 0) {
            return SysStructureDefConvert.INSTANCE.toDTOs(structureDefList);
        } else {
            return null;
        }
    }

    @Override
    public Integer getStructureByKeywordCount(String keyWord, Integer structureParentId) {
        return structureDefDao.getStructureByKeywordCount(keyWord, structureParentId);
    }
}
