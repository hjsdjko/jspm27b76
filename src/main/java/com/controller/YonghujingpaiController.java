package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.YonghujingpaiEntity;
import com.entity.view.YonghujingpaiView;

import com.service.YonghujingpaiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 用户竞拍
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-11 17:43:14
 */
@RestController
@RequestMapping("/yonghujingpai")
public class YonghujingpaiController {
    @Autowired
    private YonghujingpaiService yonghujingpaiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YonghujingpaiEntity yonghujingpai, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			yonghujingpai.setYonghuming((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("maijia")) {
			yonghujingpai.setMaijiazhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YonghujingpaiEntity> ew = new EntityWrapper<YonghujingpaiEntity>();
    	PageUtils page = yonghujingpaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yonghujingpai), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YonghujingpaiEntity yonghujingpai, 
		HttpServletRequest request){
        EntityWrapper<YonghujingpaiEntity> ew = new EntityWrapper<YonghujingpaiEntity>();
    	PageUtils page = yonghujingpaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yonghujingpai), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YonghujingpaiEntity yonghujingpai){
       	EntityWrapper<YonghujingpaiEntity> ew = new EntityWrapper<YonghujingpaiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yonghujingpai, "yonghujingpai")); 
        return R.ok().put("data", yonghujingpaiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YonghujingpaiEntity yonghujingpai){
        EntityWrapper< YonghujingpaiEntity> ew = new EntityWrapper< YonghujingpaiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yonghujingpai, "yonghujingpai")); 
		YonghujingpaiView yonghujingpaiView =  yonghujingpaiService.selectView(ew);
		return R.ok("查询用户竞拍成功").put("data", yonghujingpaiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YonghujingpaiEntity yonghujingpai = yonghujingpaiService.selectById(id);
        return R.ok().put("data", yonghujingpai);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YonghujingpaiEntity yonghujingpai = yonghujingpaiService.selectById(id);
        return R.ok().put("data", yonghujingpai);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YonghujingpaiEntity yonghujingpai, HttpServletRequest request){
    	yonghujingpai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yonghujingpai);

        yonghujingpaiService.insert(yonghujingpai);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YonghujingpaiEntity yonghujingpai, HttpServletRequest request){
    	yonghujingpai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yonghujingpai);

        yonghujingpaiService.insert(yonghujingpai);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody YonghujingpaiEntity yonghujingpai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yonghujingpai);
        yonghujingpaiService.updateById(yonghujingpai);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yonghujingpaiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<YonghujingpaiEntity> wrapper = new EntityWrapper<YonghujingpaiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wrapper.eq("yonghuming", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("maijia")) {
			wrapper.eq("maijiazhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = yonghujingpaiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	





}
