/*ȸ������*/
create table xmember(
	mem_num number not null,
	id varchar2(12) unique not null,
	auth number(1) default 2 not null,	/* ȸ����� : 0(Ż��) �뿩����ȸ��(1) ȸ��(2) ������(3) */
	constraint xmember_pk primary key (mem_num)
);

/* Q&A �Խ��� - ���� */
create table xboard_qna(
	qna_num number not null,
	title varchar2(150) not null,
	q_content clob not null,
	a_content clob,
	hit number default 0 not null,
	reg_date date default sysdate not null,
	answer_date date,
	filename varchar2(150),
	ip varchar2(40) not null,
	mem_num number not null,
	constraint xquestion_pk primary key (qna_num),
	constraint xquestion_fk foreign key (mem_num) references xmember (mem_num)
);

create sequence xboard_qna_seq;
