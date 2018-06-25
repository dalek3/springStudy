package org.zerock.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.ReplyVO;
import org.zerock.persistence.ReplyDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"classpath:spring/root-context.xml"})
public class ReplyDAOTest {
	
	@Inject
	private ReplyDAO dao;
	
	private static Logger logger = LoggerFactory.getLogger(ReplyDAOTest.class);
	
	@Test
	public void testCreate() throws Exception {
		
		ReplyVO reply = new ReplyVO();
		reply.setBno(2);
		reply.setReplytext("댓글 테스트");
		reply.setReplyer("홍길동");
		
		dao.create(reply);
		
	}
	
	@Test
	public void testList() throws Exception {
		
		logger.info(dao.list(2).toString());
	}
	
}
