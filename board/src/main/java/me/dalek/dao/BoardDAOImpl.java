package me.dalek.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me.dalek.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession session;
	
	private static final String namespace = "me.dalek.mapper.BoardMapper";
	
	@Override
	public List<BoardVO> selectAll() {
		
		return session.selectList(namespace + ".selectAll");
	}

	@Override
	public BoardVO read(Integer bno) throws Exception{
	
		return session.selectOne(namespace + ".read", bno);
	}

	@Override
	public void insert(BoardVO vo) throws Exception{
		
		session.insert(namespace + ".insert", vo);
	}

	@Override
	public void update(BoardVO vo) throws Exception{
	
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(Integer bno) throws Exception{

		session.delete(namespace + ".delete", bno);
	}
	
}
