package com.dao;

import com.entity.DiscusspaimaishangpinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusspaimaishangpinVO;
import com.entity.view.DiscusspaimaishangpinView;


/**
 * 拍卖商品评论表
 * 
 * @author 
 * @email 
 * @date 2022-04-11 17:43:14
 */
public interface DiscusspaimaishangpinDao extends BaseMapper<DiscusspaimaishangpinEntity> {
	
	List<DiscusspaimaishangpinVO> selectListVO(@Param("ew") Wrapper<DiscusspaimaishangpinEntity> wrapper);
	
	DiscusspaimaishangpinVO selectVO(@Param("ew") Wrapper<DiscusspaimaishangpinEntity> wrapper);
	
	List<DiscusspaimaishangpinView> selectListView(@Param("ew") Wrapper<DiscusspaimaishangpinEntity> wrapper);

	List<DiscusspaimaishangpinView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusspaimaishangpinEntity> wrapper);
	
	DiscusspaimaishangpinView selectView(@Param("ew") Wrapper<DiscusspaimaishangpinEntity> wrapper);
	

}
