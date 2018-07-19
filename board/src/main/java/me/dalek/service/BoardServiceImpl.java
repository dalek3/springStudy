package me.dalek.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dalek.dao.BoardDAO;
import me.dalek.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO dao;
	
	@Override
	public List<BoardVO> listAll() throws Exception {
		
		return dao.selectAll();
	}

	@Override
	public void create(BoardVO vo) throws Exception {
		
		dao.insert(vo);
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		
		return dao.read(bno);
	}

	@Override
	public void modify(BoardVO vo) throws Exception {
		
		dao.update(vo);
	}

	@Override
	public void remove(Integer bno) throws Exception {
		
		dao.delete(bno);
	}

}
