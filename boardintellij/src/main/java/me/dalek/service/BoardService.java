package me.dalek.service;

import me.dalek.domain.BoardVO;

import java.util.List;

public interface BoardService {

    public List<BoardVO> listAll() throws Exception;

}
