insert into tbl_board (title, content, writer) 
(select title, content, writer from tbl_board);