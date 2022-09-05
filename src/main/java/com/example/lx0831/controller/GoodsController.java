package com.example.lx0831.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.lx0831.pojo.Goods;
import com.example.lx0831.service.BrandService;
import com.example.lx0831.service.ClassifyService;
import com.example.lx0831.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GoodsController {
    @Autowired
    private GoodsService gs;
    @Autowired
    private ClassifyService cs;
    @Autowired
    private BrandService bs;
    @GetMapping("/find")
    public String findGoods(Model model, @RequestParam(value = "cid", defaultValue = "0")
            int cid, String bname, String keyword, String ordclu, Integer order, Integer pno){

        int ord = order != null ? order : 0;
        IPage<Goods> page = gs.getGoods(cid, bname, keyword, pno, ordclu, ord);
        model.addAttribute("info", page);
        model.addAttribute("classes", cs.getClassifies());
        model.addAttribute("brands", bs.getBrands(cid));
        return "goods";
    }
}
