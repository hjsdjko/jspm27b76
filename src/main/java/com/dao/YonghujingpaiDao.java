package com.dao;

import com.entity.YonghujingpaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YonghujingpaiVO;
import com.entity.view.YonghujingpaiView;


/**
 * 用户竞拍
 * 
 * @author 
 * @email 
 * @date 2022-04-11 17:43:14
 */
public interface YonghujingpaiDao extends BaseMapper<YonghujingpaiEntity> {
	
	List<YonghujingpaiVO> selectListVO(@Param("ew") Wrapper<YonghujingpaiEntity> wrapper);
	
	YonghujingpaiVO selectVO(@Param("ew") Wrapper<YonghujingpaiEntity> wrapper);
	
	List<YonghujingpaiView> selectListView(@Param("ew") Wrapper<YonghujingpaiEntity> wrapper);

	List<YonghujingpaiView> selectListView(Pagination page,@Param("ew") Wrapper<YonghujingpaiEntity> wrapper);
	
	YonghujingpaiView selectView(@Param("ew") Wrapper<YonghujingpaiEntity> wrapper);
	

}
