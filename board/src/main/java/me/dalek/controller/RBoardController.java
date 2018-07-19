package me.dalek.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.dalek.domain.BoardVO;
import me.dalek.service.BoardService;

@RestController
@RequestMapping("/board/*")
public class RBoardController {

	private static Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService service;

	@RequestMapping("api/list")
	public ResponseEntity<List<BoardVO>> rlist() {
		
		ResponseEntity<List<BoardVO>> entity = null;
		try {
			entity = new ResponseEntity<>(service.listAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		logger.info("entity : " + entity.getBody());

		
		return entity;
	}
	


}
