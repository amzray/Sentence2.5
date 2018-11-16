package com.liangzhelang.controller;

import com.liangzhelang.entity.Sentence;
import com.liangzhelang.service.OneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.*;


@Controller
public class OneController {
	
	@Autowired
	private OneService oneService;


    /**
     * 响应查看单个句子的请求
     * @param session
     * @param sid
     * @param model
     * @return
     */
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
				return "redirect:/nss";
			}else{
				return "redirect:/one?sid="+sid;
			}
		}
		model.addAttribute("sid", sid);
		return "one";
	}


    /**
     * 获取句子内容
     * @param sid
     * @param model
     * @return s
     */
	@RequestMapping(value = "/ss", method = GET)
	@ResponseBody
	public Sentence sentenceContent(
		@RequestParam Integer sid,
		Model model) {
		Sentence s = oneService.selectOne(sid);
		return s;
	}

    /**
     * 更新句子
     * @param model
     * @param s
     * @return
     */
	@RequestMapping(value = "/update", method = POST)
	public String updateSentence(Model model, Sentence s) {
		Integer result = oneService.updateOne(s);
		model.addAttribute("updateStatus", result);
		return "redirect:/one?sid="+s.getId();
	}

    /**
     * 删除句子
     * @param model
     * @param sid
     * @return
     */
	@RequestMapping("/delete")
    @ResponseBody
	public Integer deleteSentence(Model model, @RequestParam Integer sid) {
			return oneService.deleteOne(sid);
		}
}
