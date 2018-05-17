package cn.e3mall.service;

import cn.e3mall.pojo.TbItem;

public interface TbItemService {
	
	/**
	 * 根据主键查找商品
	 * @param itemId
	 * @return
	 */
	TbItem getItemById(Long itemId);

}
