package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscusspaimaishangpinDao;
import com.entity.DiscusspaimaishangpinEntity;
import com.service.DiscusspaimaishangpinService;
import com.entity.vo.DiscusspaimaishangpinVO;
import com.entity.view.DiscusspaimaishangpinView;

@Service("discusspaimaishangpinService")
public class DiscusspaimaishangpinServiceImpl extends ServiceImpl<DiscusspaimaishangpinDao, DiscusspaimaishangpinEntity> implements DiscusspaimaishangpinService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusspaimaishangpinEntity> page = this.selectPage(
                new Query<DiscusspaimaishangpinEntity>(params).getPage(),
                new EntityWrapper<DiscusspaimaishangpinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusspaimaishangpinEntity> wrapper) {
		  Page<DiscusspaimaishangpinView> page =new Query<DiscusspaimaishangpinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusspaimaishangpinVO> selectListVO(Wrapper<DiscusspaimaishangpinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusspaimaishangpinVO selectVO(Wrapper<DiscusspaimaishangpinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusspaimaishangpinView> selectListView(Wrapper<DiscusspaimaishangpinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusspaimaishangpinView selectView(Wrapper<DiscusspaimaishangpinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
