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


import com.dao.ChengjiaotongzhiDao;
import com.entity.ChengjiaotongzhiEntity;
import com.service.ChengjiaotongzhiService;
import com.entity.vo.ChengjiaotongzhiVO;
import com.entity.view.ChengjiaotongzhiView;

@Service("chengjiaotongzhiService")
public class ChengjiaotongzhiServiceImpl extends ServiceImpl<ChengjiaotongzhiDao, ChengjiaotongzhiEntity> implements ChengjiaotongzhiService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChengjiaotongzhiEntity> page = this.selectPage(
                new Query<ChengjiaotongzhiEntity>(params).getPage(),
                new EntityWrapper<ChengjiaotongzhiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChengjiaotongzhiEntity> wrapper) {
		  Page<ChengjiaotongzhiView> page =new Query<ChengjiaotongzhiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ChengjiaotongzhiVO> selectListVO(Wrapper<ChengjiaotongzhiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChengjiaotongzhiVO selectVO(Wrapper<ChengjiaotongzhiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChengjiaotongzhiView> selectListView(Wrapper<ChengjiaotongzhiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChengjiaotongzhiView selectView(Wrapper<ChengjiaotongzhiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
