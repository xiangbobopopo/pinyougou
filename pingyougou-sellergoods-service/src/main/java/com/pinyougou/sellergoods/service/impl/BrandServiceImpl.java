package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbBrandMapper;
import com.pingyougou.sellergoods.service.BrandService;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/*
 * 这里的service要使用import com.alibaba.dubbo.config.annotation.Service;
 * 将方法注册到zookeeper中;
  * */

@Service
public class BrandServiceImpl implements BrandService{

	@Autowired
	private TbBrandMapper brandmapper;
    @Override//第二个功能,添加分页;
	public List<TbBrand> findAll() {
		List<TbBrand> tbBrands = brandmapper.selectByExample(null);
		System.out.println(tbBrands);
		return brandmapper.selectByExample(null);
	}


	@Override
	public PageResult findPage(int pageNumber, int pageSize) {
		PageHelper.startPage(pageNumber,pageSize);
		Page<TbBrand> page= (Page<TbBrand>) brandmapper.selectByExample(null);
		return new PageResult(page.getTotal(),page.getResult());
	}

	@Override
	public void add(TbBrand brand) {
		brandmapper.insert(brand);
	}

	@Override
	public void update(TbBrand brand) {
		brandmapper.updateByPrimaryKey(brand);
	}

	@Override
	public TbBrand findOne(Long id) {
		return	brandmapper.selectByPrimaryKey(id);
	}

	@Override
	public void delete(Long[] ids) {
		for (Long id:ids){
			brandmapper.deleteByPrimaryKey(id);
		}
	}
	//按照品牌查询;
	@Override
	public PageResult findPage(TbBrand brand, int pageNumber, int pageSize) {
		PageHelper.startPage(pageNumber,pageSize);
		TbBrandExample example = new TbBrandExample();
		TbBrandExample.Criteria criteria = example.createCriteria();
		if(brand!=null){
			if (brand.getName()!=null&&brand.getName().length()>0){
				criteria.andNameLike("%"+brand.getName()+"%");
			}
			if (brand.getFirstChar()!=null&&brand.getFirstChar().length()>0){
				criteria.andFirstCharEqualTo(brand.getFirstChar());
			}
		}
		Page<TbBrand> page = (Page<TbBrand>) brandmapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}
}
