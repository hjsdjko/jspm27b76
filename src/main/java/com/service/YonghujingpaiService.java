package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YonghujingpaiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YonghujingpaiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YonghujingpaiView;


/**
 * 用户竞拍
 *
 * @author 
 * @email 
 * @date 2022-04-11 17:43:14
 */
public interface YonghujingpaiService extends IService<YonghujingpaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YonghujingpaiVO> selectListVO(Wrapper<YonghujingpaiEntity> wrapper);
   	
   	YonghujingpaiVO selectVO(@Param("ew") Wrapper<YonghujingpaiEntity> wrapper);
   	
   	List<YonghujingpaiView> selectListView(Wrapper<YonghujingpaiEntity> wrapper);
   	
   	YonghujingpaiView selectView(@Param("ew") Wrapper<YonghujingpaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YonghujingpaiEntity> wrapper);
   	

}

