package com.hp.service;

import com.hp.pojo.GetMap;

import java.io.IOException;

public interface GetMapLngLatService {

    GetMap getMapLngLat(String addr)throws IOException;
}
