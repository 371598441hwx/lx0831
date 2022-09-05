package com.example.lx0831;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.lx0831.pojo.Goods;
import com.example.lx0831.service.BrandService;
import com.example.lx0831.service.GoodsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Lx0831ApplicationTests {
	@Autowired
	private GoodsService gs;
	@Autowired
	private BrandService bs;
	@Test
	void contextLoads() {
		IPage<Goods> page = gs.getGoods(0,"小米",null, 1,"number", 1);
		System.out.println(page.getTotal());
		System.out.println(page.getPages());
		System.out.println(page.getRecords());
	}
	@Test
	void contextLoads2() {
		System.out.println(bs.getBrands(1));
	}

}

