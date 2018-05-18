package cn.e3mall.service;


import java.util.List;

import cn.e3mall.common.EasyUIResultVO;
import cn.e3mall.pojo.TbItem;

public interface TbItemService {
	
	/**
	 * 根据主键查找商品
	 * @param itemId
	 * @return
	 */
	TbItem getItemById(Long itemId);
	
	EasyUIResultVO<List<TbItem>> getItemList(int page, int size);

}
