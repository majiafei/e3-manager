package cn.e3mall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3mall.common.EasyUINode;
import cn.e3mall.mapper.TbItemCatMapper;
import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItemCat;
import cn.e3mall.pojo.TbItemCatExample;
import cn.e3mall.pojo.TbItemCatExample.Criteria;
import cn.e3mall.service.ItemCategoryService;

@Service
public class ItemCategoryServiceImpl implements ItemCategoryService{
	
	
	@Autowired
	private TbItemCatMapper tbItemCatMapper;

	@Override
	public List<EasyUINode> getItemCategoryByPid(long parentId) {
		//添加条件
		TbItemCatExample catExample = new TbItemCatExample();
		Criteria criteria = catExample.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		//查询数据
		List<TbItemCat> tbItemCatList = tbItemCatMapper.selectByExample(catExample);
		
		List<EasyUINode> easyUINodes = new ArrayList<>();
		for(TbItemCat itemCat : tbItemCatList){
			Long id = itemCat.getId();
			String name = itemCat.getName();
			EasyUINode easyUINode = new EasyUINode();
			easyUINode.setId(id);
			easyUINode.setText(name);
			easyUINode.setState(itemCat.getIsParent() ? "closed" : "open");
			easyUINodes.add(easyUINode);
		}
		return easyUINodes;
	}
	

}
