package com.asiainfo.rms.alm.arsenal.service;

import com.asiainfo.rms.alm.arsenal.dto.AlmStoreGiveDTO;

public interface AlmStoreGiveService {
    String saveStoreGive(AlmStoreGiveDTO almStoreGiveDTO);

    String updateStoreGive(AlmStoreGiveDTO almStoreGiveDTO);

    AlmStoreGiveDTO selectStoreGive(Integer aatId);
}
