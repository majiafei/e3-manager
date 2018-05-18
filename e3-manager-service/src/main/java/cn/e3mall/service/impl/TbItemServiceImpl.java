package cn.e3mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.common.EasyUIResultVO;
import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.service.TbItemService;

@Service
public class TbItemServiceImpl implements TbItemService{

	@Autowired
	private TbItemMapper tbItemMapper;
	
	@Override
	public TbItem getItemById(Long itemId) {
		TbItem tbItem = tbItemMapper.selectByPrimaryKey(itemId);
		return tbItem;
	}

	@Override
	public EasyUIResultVO<List<TbItem>> getItemList(int page, int size) {
		//设置分页
		PageHelper.startPage(page, size);
		//查询数据
		TbItemExample itemExample = new TbItemExample();
		List<TbItem> itemList = tbItemMapper.selectByExample(itemExample);
		PageInfo<TbItem> pageInfo = new PageInfo<>(itemList);
		EasyUIResultVO<List<TbItem>> easyUIResultVO = new EasyUIResultVO<>();
		easyUIResultVO.setRows(itemList);
		easyUIResultVO.setTotal(pageInfo.getTotal());
		return easyUIResultVO;
	}

	
	
}
