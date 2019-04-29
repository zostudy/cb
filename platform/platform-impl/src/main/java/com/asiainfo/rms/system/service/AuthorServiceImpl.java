package com.asiainfo.rms.system.service;

import com.asiainfo.rms.system.convert.SysAuthorConvert;
import com.asiainfo.rms.system.dao.SysAuthorDao;
import com.asiainfo.rms.system.domain.SysAuthorRepository;
import com.asiainfo.rms.system.dto.SysAuthorDTO;

import org.apache.tomcat.jni.Local;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Component
@Transactional
public class AuthorServiceImpl implements AuthorService {
    private final SysAuthorDao authorDao;

    public AuthorServiceImpl(SysAuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    public String saveAuthor(SysAuthorDTO authorDTO) {
        JSONObject json = new JSONObject();
        SysAuthorRepository authorRepository;
        authorRepository = SysAuthorConvert.INSTANCE.toSYS(authorDTO);
        authorRepository.setState(1);
        authorRepository.setCreateTime(new java.sql.Date(new java.util.Date().getTime()));
        if (authorDao.saveAuthor(authorRepository) > 0) {
            try {
                json.put("code", 1);
                json.put("msg", "success");
                json.put("author_id", authorRepository.getAuthorId());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();

    }

    @Override
    public String updateAuthor(SysAuthorDTO authorDTO) {
        JSONObject json = new JSONObject();
        if (authorDao.updateAuthor(SysAuthorConvert.INSTANCE.toSYS(authorDTO)) > 0) {
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
    public String deleteAuthorById(Integer authorId) {
        JSONObject json = new JSONObject();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss", Locale.CHINA);
        Date endDate = new Date();
//		try {
//			//endDate = simpleDateFormat.parse(simpleDateFormat.format(endDate));
//		} catch (ParseException e1) {
//			e1.printStackTrace();
//		}
        Integer count = authorDao.deleteAuthorById(0, endDate, authorId);
        try {
            if (count > 0) {
                json.put("code", 1);
                json.put("msg", "succuss");
                json.put("row_count", count);

            } else {
                json.put("code", 0);
                json.put("msg", "fail");
                json.put("row_count", 0);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return json.toString();

    }

    @Override
    public SysAuthorDTO selectByAuthorId(Integer authorId) {
        return SysAuthorConvert.INSTANCE.toDTO(authorDao.selectByAuthorId(authorId));
    }

    @Override
    public List<SysAuthorDTO> selectByStationId(Integer stationId) {
    	List<SysAuthorRepository> sysAuthorRepositories = authorDao.selectByStationId(stationId);
        return SysAuthorConvert.INSTANCE.toDTO(sysAuthorRepositories);
    }

    @Override
    public List<SysAuthorDTO> selectAuthorByStaffId(Integer staffId, Integer pageNo, Integer pageSize) {
        Integer offset = null;
        if ((pageNo != null) && (pageSize != null)) {
            offset = pageNo;
        }
        List<SysAuthorRepository> authorList = authorDao.selectAuthorByStaffId(staffId, offset, pageSize);
        if (authorList.size() > 0) {
            return SysAuthorConvert.INSTANCE.toDTOs(authorList);
        } else {
            return null;
        }
    }

    @Override
    public int getAuthorByStaffIdCount(Integer staffId) {
        return authorDao.getAuthorByStaffIdCount(staffId);
    }
    
    @Override
    public List<SysAuthorDTO> selectByStationIdAndStaffId(Integer stationId, Integer staffId){
        List<SysAuthorRepository> authorList = authorDao.selectByStationIdAndStaffId(stationId, staffId);
        if (authorList.size() > 0) {
            return SysAuthorConvert.INSTANCE.toDTOs(authorList);
        } else {
            return null;
        }
    }
}
