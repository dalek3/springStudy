insert into tbl_board (title, content, writer) 
(select title, content, writer from tbl_board);
alter table tbl_board add column replycnt int default 0;