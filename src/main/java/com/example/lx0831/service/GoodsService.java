package com.example.lx0831.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.lx0831.pojo.Goods;


public interface GoodsService {
    public IPage<Goods> getGoods(int cid, String bname, String keyword, Integer pageno, String ordercol, int order);
}
