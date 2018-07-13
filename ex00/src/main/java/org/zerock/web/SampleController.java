package org.zerock.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.ProductVO;

@Controller
public class SampleController {
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	//
	
	@RequestMapping("doA")
	public void doA(){
		logger.info("doA called....");
	}
	
	@RequestMapping("doB")
	public void doB(){
		logger.info("doB called....");
	}
	
	// 
	
	@RequestMapping("doC")
	public String doC(@ModelAttribute("msg") String msg){
		logger.info("doC called....");
		return "result";
	}

	// bean
	
	@RequestMapping("doD")
	public String doD(Model model){
		logger.info("doD called....");
		ProductVO product = new ProductVO("sample Product", 10000);
		model.addAttribute(product);
		return "productDetail";
	}
	
	// redirect
	@RequestMapping("doE")
	public String doE(RedirectAttributes rttr){
		logger.info("doE called....");
		rttr.addFlashAttribute("msg", "redirect msg");
		return "redirect:/doF";
	}
	
	@RequestMapping("doF")
	public void doF(@ModelAttribute("msg") String msg){
		logger.info("doF called...." + msg);
	}

	// json
	@RequestMapping("/doJSON")
	public @ResponseBody ProductVO doJSON() {
		ProductVO vo = new ProductVO("sample Product", 10000);
		return vo;
	}
	
	
	@RequestMapping("doZ")
	public String doZ(@RequestParam String msg,ModelMap model){
		logger.info("doZ called...." + msg);
		model.addAttribute("msg", "z-" + msg);
		return "result";
	}
	
}
