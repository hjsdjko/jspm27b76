package com.entity.view;

import com.entity.DiscusspaimaishangpinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 拍卖商品评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-11 17:43:14
 */
@TableName("discusspaimaishangpin")
public class DiscusspaimaishangpinView  extends DiscusspaimaishangpinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusspaimaishangpinView(){
	}
 
 	public DiscusspaimaishangpinView(DiscusspaimaishangpinEntity discusspaimaishangpinEntity){
 	try {
			BeanUtils.copyProperties(this, discusspaimaishangpinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
