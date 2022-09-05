package com.example.lx0831.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.lx0831.mapper.GoodsMapper;
import com.example.lx0831.pojo.Goods;
import com.example.lx0831.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper gm;

    @Override
    public IPage<Goods> getGoods(int cid, String bname, String keyword, Integer pageno, String ordercol, int order ) {
        QueryWrapper<Goods> qw = new QueryWrapper<>();
        if(cid != 0){
            qw.eq("cid", cid);
        }
//        if(bid != 0){
//            qw.eq("bid", bid);
//        }
        if(bname != null && !bname.equals("")){
            qw.inSql("bid", "select bid from brand where bname = '"+bname+"'");
        }
        if(keyword != null){
            qw.and(wrapper ->
                    wrapper.like("number", keyword)
                            .or()
                            .like("gname", keyword)
            );
        }
        if(ordercol != null){
            if(order == 0){
                qw.orderByAsc(ordercol);
            }else{
                qw.orderByDesc(ordercol);
            }
        }

        int pno = pageno == null ? 1 : pageno;
        IPage<Goods> page = new Page<>(pno, 5);
        return gm.selectPage(page,qw);
    }
}
