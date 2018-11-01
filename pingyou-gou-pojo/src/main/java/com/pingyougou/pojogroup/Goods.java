package com.pingyougou.pojogroup;
import com.pinyougou.pojo.TbGoods;
import com.pinyougou.pojo.TbGoodsDesc;
import com.pinyougou.pojo.TbItem;

import java.io.Serializable;
import java.util.List;

/*建立一个组合实体类,
类中的成员变量分别对应两个表的pojo;
其实类,包含了两个表;

*/

public class Goods implements Serializable{
	private TbGoods goods;
	private TbGoodsDesc goodDesc;
	private List<TbItem> itemList;

	public TbGoods getGoods() {
		return goods;
	}

	public void setGoods(TbGoods goods) {
		this.goods = goods;
	}

	public TbGoodsDesc getGoodDesc() {
		return goodDesc;
	}

	public void setGoodDesc(TbGoodsDesc goodDesc) {
		this.goodDesc = goodDesc;
	}

	public List<TbItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<TbItem> itemList) {
		this.itemList = itemList;
	}
}
