package cn.e3mall.service;

import java.util.List;

import cn.e3mall.common.EasyUINode;

public interface ItemCategoryService {
	
	List<EasyUINode> getItemCategoryByPid(long parentId);

}
