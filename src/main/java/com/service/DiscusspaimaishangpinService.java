package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusspaimaishangpinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusspaimaishangpinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusspaimaishangpinView;


/**
 * 拍卖商品评论表
 *
 * @author 
 * @email 
 * @date 2022-04-11 17:43:14
 */
public interface DiscusspaimaishangpinService extends IService<DiscusspaimaishangpinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusspaimaishangpinVO> selectListVO(Wrapper<DiscusspaimaishangpinEntity> wrapper);
   	
   	DiscusspaimaishangpinVO selectVO(@Param("ew") Wrapper<DiscusspaimaishangpinEntity> wrapper);
   	
   	List<DiscusspaimaishangpinView> selectListView(Wrapper<DiscusspaimaishangpinEntity> wrapper);
   	
   	DiscusspaimaishangpinView selectView(@Param("ew") Wrapper<DiscusspaimaishangpinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusspaimaishangpinEntity> wrapper);
   	

}

