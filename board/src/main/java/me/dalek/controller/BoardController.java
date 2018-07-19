package me.dalek.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import me.dalek.domain.BoardVO;
import me.dalek.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	private static Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public void list(Model model) throws Exception {
		logger.info("list");
		model.addAttribute("boardVOs", service.listAll());
		
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET() throws Exception{
		logger.info("registerGET");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(BoardVO board) throws Exception {
		logger.info("registerPOST");
		service.create(board);
		
		return "redirect:/board/rlist";
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model) throws Exception{
		logger.info("read : " + bno);
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno) throws Exception{
		logger.info("remove");
		service.remove(bno);
		
		return "redirect:/board/rlist";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGET(@RequestParam("bno") int bno, Model model) throws Exception{
		logger.info("modifyGET");
		model.addAttribute(service.read(bno));
		
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(BoardVO board, Model model) throws Exception{
		logger.info("modifyPOST");
		
		service.modify(board);

		return "redirect:/board/rlist";
	}
	
	@RequestMapping("/rlist")
	public void list() throws Exception{
		logger.info("test");
	}
	
}
