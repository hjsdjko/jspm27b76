package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChengjiaotongzhiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChengjiaotongzhiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChengjiaotongzhiView;


/**
 * 成交通知
 *
 * @author 
 * @email 
 * @date 2022-04-11 17:43:14
 */
public interface ChengjiaotongzhiService extends IService<ChengjiaotongzhiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChengjiaotongzhiVO> selectListVO(Wrapper<ChengjiaotongzhiEntity> wrapper);
   	
   	ChengjiaotongzhiVO selectVO(@Param("ew") Wrapper<ChengjiaotongzhiEntity> wrapper);
   	
   	List<ChengjiaotongzhiView> selectListView(Wrapper<ChengjiaotongzhiEntity> wrapper);
   	
   	ChengjiaotongzhiView selectView(@Param("ew") Wrapper<ChengjiaotongzhiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChengjiaotongzhiEntity> wrapper);
   	

}

