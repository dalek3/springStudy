package me.dalek.dao;

import me.dalek.domain.BoardVO;

import java.util.List;

public interface BoardDAO {

    public List<BoardVO> listAll() throws Exception;

}
