package me.dalek.dao;

import me.dalek.domain.BoardVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class BoardDAOImpl implements BoardDAO{

    @Inject
    private SqlSession session;

    private static String namespace = "me.dalek.mapper.BoardMapper";

    @Override
    public List<BoardVO> listAll() throws Exception {
        return session.selectList(namespace+".listAll");
    }

}
