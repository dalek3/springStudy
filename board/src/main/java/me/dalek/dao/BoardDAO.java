package me.dalek.dao;

import java.util.List;

import me.dalek.domain.BoardVO;

public interface BoardDAO {

	public void insert(BoardVO vo) throws Exception;
	
	public BoardVO read(Integer bno) throws Exception;
	
	public void update(BoardVO vo) throws Exception;
	
	public void delete(Integer bno) throws Exception;
	
	public List<BoardVO> selectAll() throws Exception;
}
