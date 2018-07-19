package me.dalek.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import me.dalek.dao.BoardDAO;
import me.dalek.domain.BoardVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"classpath:spring/root-context.xml"})
public class BoardDAOTest {

	@Inject
	private BoardDAO dao;
	
	private static Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);

	/*
	@Test
	public void testSelectAll() throws Exception {
		logger.info(dao.selectAll().toString());
	}
	
	@Test
	public void testRead() throws Exception {
		logger.info(dao.read(1).toString());
	}
	
	@Test
	public void testInsert() throws Exception {
		BoardVO vo = new BoardVO();
		vo.setTitle("1");
		vo.setContent("1");
		vo.setWriter("1");
		logger.info("insert");
		dao.insert(vo);
	}
	
	@Test
	public void testUpdate() throws Exception {
		BoardVO vo = new BoardVO();
		vo.setBno(1);
		vo.setTitle("3");
		vo.setContent("3");
		vo.setWriter("3");
		logger.info("update");
		dao.update(vo);
	}
	
	@Test
	public void testDelete() throws Exception {
		logger.info("delete");
		dao.delete(4);
	}
	*/
	
}
