package com.pingyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;
import entity.PageResult;

import java.util.List;

public interface BrandService {
	//1,查找全部的tbBrand;
	public List<TbBrand> findAll();
	//2,实现分页功能;
	public PageResult findPage(int pageNumber, int pageSize);
	//3,添加产品;
	public void add(TbBrand brand);
	//4,修改产品
	public void update(TbBrand brand);
	//5,genjuId查找数据;
	public TbBrand findOne(Long id);
	//6,删除数据(先查找,在删除)
	public void delete(Long[] ids);
	//搜索按照条件搜索数据;
	public PageResult findPage(TbBrand brand, int pageNumber, int pageSize);
}
