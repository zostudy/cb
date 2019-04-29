package com.asiainfo.rms.system.service;

import com.asiainfo.rms.system.convert.SysParamConvert;
import com.asiainfo.rms.system.dao.SysParamDao;
import com.asiainfo.rms.system.dto.SysParamDTO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class SysParamServiceImpl implements SysParamService {
    private final SysParamDao sysParamDao;

    public SysParamServiceImpl(SysParamDao sysParamDao) {
        this.sysParamDao = sysParamDao;
    }

    @Override
    public List<SysParamDTO> selectParamByType(String paramType,Integer paramReleId) {
        return SysParamConvert.INSTANCE.toDTOs(sysParamDao.selectParamByType(paramType,paramReleId));
    }

    @Override
    public List<SysParamDTO> selectParams(String paramType) {
        return SysParamConvert.INSTANCE.toDTOs(sysParamDao.selecParams(paramType));
    }
}
