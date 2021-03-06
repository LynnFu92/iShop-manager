package com.iShop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iShop.mapper.TbItemMapper;
import com.iShop.pojo.TbItem;
import com.iShop.pojo.TbItemExample;
import com.iShop.pojo.TbItemExample.Criteria;
import com.iShop.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Resource
	private TbItemMapper itemMapper;
	@Override
	public TbItem getItemById(Long itemId) {
		//TbItem item = itemMapper.selectByPrimaryKey(itemId);
		TbItemExample example = new TbItemExample();
		//创建查询条件
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(itemId);
		List<TbItem> list = itemMapper.selectByExample(example);
		//判断list中是否为空
		TbItem item = null;
		if (list != null && list.size() > 0) {
			item = list.get(0);
		}
		return item;
	}

}
