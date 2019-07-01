package com.hp.service.imp;

import com.hp.dao.GoodsDao;
import com.hp.pojo.Goods;
import com.hp.service.GoodsService;
import com.hp.vo.PageObject;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    private final String resourcesPath = "/img/";
    @Override
    public List<Goods> selectGoods() {
        return goodsDao.selectGoods();
    }



    @Override
    public int deleteGoods(Goods goods) {
        return goodsDao.deleteGoods(goods);
    }

    @Override
    public PageObject<Goods> selectGoodsByType(Integer startPage,  String type, String title) {
        int pageSize = 10;
        int startIndex = (startPage - 1) * pageSize;
        int rowCount = goodsDao.selectCount();
        int pageCount = rowCount/pageSize;
        if (rowCount % pageSize != 0){
            pageCount++;
        }
        List<Goods> goods = goodsDao.selectGoodsByType(startIndex,pageSize,type,title);
        PageObject<Goods> goodsPageObject = new PageObject<>();
        goodsPageObject.setPageCount(pageCount);
        goodsPageObject.setPageCurrent(startPage);
        goodsPageObject.setItems(goods);
        goodsPageObject.setTotal(rowCount);

        return goodsPageObject;
    }

    @Override
    public int selectCount() {
        return goodsDao.selectCount();
    }

    @Override
    public int insertGoods(String goods_name, MultipartFile goods_img, String add_time, String type, String goods_price) {
        String img = "";
        try{
            img = saveImg(goods_img);
        }catch (IOException e){
            e.printStackTrace();
        }
        Goods goods = new Goods();
        goods.setGoods_name(goods_name);
        goods.setAdd_time(add_time);
        goods.setGoods_price(goods_price);
        goods.setType(type);
        goods.setGoods_img(img);
        return goodsDao.insertGoods(goods);
    }

    public String saveImg(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new NullPointerException("文件为空");
        }
        String fileAllName = file.getOriginalFilename();
        String fileName = fileAllName.substring(0,fileAllName.lastIndexOf("."));
        String fileExtName = fileAllName.substring(fileAllName.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString();
        String filepath = resourcesPath + uuid + fileExtName;
        System.out.println("////////////////////////");
        System.out.println(filepath);

        try {
            FileUtils.copyInputStreamToFile(file.getInputStream(),new File(filepath));

        }catch (IOException e){
            throw new IOException();
        }

        return filepath;

    }
}
