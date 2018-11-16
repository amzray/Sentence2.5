package com.liangzhelang.controller;

import com.liangzhelang.entity.Sentence;
import com.liangzhelang.service.OneService;
import com.liangzhelang.util.MyJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.*;


@Controller
public class OneController {
	private static Logger LOGGER = LoggerFactory.getLogger(OneController.class);

	@Autowired
	private OneService oneService;

	@RequestMapping(value = "/one", method = GET)
	public String one(HttpSession session, @RequestParam(required=false) Integer sid,  Model model) {
		//需登录
//		if(session.getAttribute("uid")==null) {
//			return "/unlogin";
//		}
		
		if(sid==null) {
			//随机查看句子
			sid = oneService.randomOneId();
			//数据库中没有句子
			if(sid==-1){
				//跳转到无此句页面
				LOGGER.warn("重定向到无此句页面");
				return "redirect:/nss";
			}else{
				LOGGER.info("重定向到随机ID的单句页面");
				return "redirect:/one?sid="+sid;
			}
		}
		LOGGER.info("发送句子ID到前端");
		model.addAttribute("sid", sid);
		LOGGER.info("进入单句页面，句子ID为"+sid);
		return "one";
	}

	@RequestMapping(value = "/ss", method = GET)
	@ResponseBody
	public Sentence sentenceContent(
		@RequestParam Integer sid) {
		Sentence s = oneService.selectOne(sid);
		if(s!=null){
			LOGGER.info("取得到句子内容："+ MyJson.obj2Str(s));
		}else{// TODO: 2018/11/16 Exception?
			LOGGER.error("未能取得句子内容");
		}
		LOGGER.info("发送句子内容到前端");
		return s;
	}

	@RequestMapping(value = "/update", method = POST)
	public String updateSentence(Model model, Sentence s) {
		Integer result = oneService.updateOne(s);
		if(result==1){
			LOGGER.info("成功更新了一条句子：");
		}else{
			// TODO: 2018/11/16 Exception?
			LOGGER.error("未能更新句子：");
		}
		LOGGER.info("发送状态码到前端");
		model.addAttribute("updateStatus", result);
		LOGGER.info("返回单句页面");
		return "redirect:/one?sid="+s.getId();
	}

	@RequestMapping("/delete")
    @ResponseBody
	public Integer deleteSentence(Model model, @RequestParam Integer sid) {
		Integer i = oneService.deleteOne(sid);
		if(i==1){
			LOGGER.info("成功删除了一条句子：");
		}else{
			// TODO: 2018/11/16 Exception?
			LOGGER.error("未能删除句子：");
		}
		LOGGER.info("发送状态码到前端");
		return i;
	}
}
