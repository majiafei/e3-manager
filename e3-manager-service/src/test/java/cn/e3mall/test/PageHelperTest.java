package cn.e3mall.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;

public class PageHelperTest {
	
	
	public static void testPageHelper(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		//在执行sql之前设置分页信息
		TbItemMapper bean = applicationContext.getBean(TbItemMapper.class);
		PageHelper.startPage(0, 10);
		//执行sql
		TbItemExample itemExample = new TbItemExample();
		List<TbItem> tbItemList = bean.selectByExample(itemExample);
		//取分页信息
		PageInfo<TbItem> pageInfo = new PageInfo<>(tbItemList);
		System.out.println(pageInfo.getTotal());
		System.out.println(pageInfo.getPages());
		System.out.println(pageInfo.getList().size());
	}
	
	public static void main(String[] args) {
		testPageHelper();
	}

}
