package com.hp.controller;

import com.hp.pojo.GetMap;
import com.hp.service.GetMapLngLatService;
import com.hp.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/api/map")
public class GetMapLngLat {

    @Autowired
    private GetMapLngLatService getMapLngLatService;
    /**
     * 根据城市名称查询所在经纬度
     * @param addr
     * 查询的地址
     * @return
     * @throws IOException
     */
    @PostMapping(value = "getCoordinate")
    public JsonResult getCoordinate(@RequestParam("addr") String addr)  {
       GetMap getMap = new GetMap();
        try {
             getMap = getMapLngLatService.getMapLngLat(addr);
        }catch (IOException e){
            e.printStackTrace();
        }

        return new JsonResult(1,getMap);
    }


    @PostMapping(value = "searchcCoordinate")
    public JsonResult searchcCoordinate(@RequestParam("addr") String addr){
        GetMap getMap = new GetMap();

        try{
             getMap = getMapLngLatService.getMapLngLat(addr);
         }catch (IOException e){
             e.printStackTrace();
         }
        return new JsonResult(1,getMap);
    }

}
