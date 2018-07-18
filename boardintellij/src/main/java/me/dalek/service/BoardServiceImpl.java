package me.dalek.service;

import me.dalek.dao.BoardDAO;
import me.dalek.domain.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardDAO dao;

    @Override
    public List<BoardVO> listAll() throws Exception {
        return dao.listAll();
    }

}
