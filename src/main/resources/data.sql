insert into customer
    (customer_code, customer_name, customer_pass, customer_birth, customer_job, customer_mail,
     customer_tel, customer_post, customer_add, role)
values (customer_seq.nextval, '야마다 소라', '$2y$10$gzwToLfOx2E/eIvcbZKODuOaKL58T/6VoH833mL8EGL3GU4yjN1Bm', '2016-08-15', '관리인', 'sora@naver.com', '010-', '10249', '경기도 고양시', 'USER');

insert into customer
(customer_code, customer_name, customer_pass, customer_birth, customer_job, customer_mail,
 customer_tel, customer_post, customer_add, role)
values (customer_seq.nextval, '스즈키 이치로', '$2y$10$gzwToLfOx2E/eIvcbZKODuOaKL58T/6VoH833mL8EGL3GU4yjN1Bm', '1985-02-10', '야구감독', 'suzuki@naver.com', '010-', '10249', '경기도 고양시', 'USER');

insert into customer
(customer_code, customer_name, customer_pass, customer_birth, customer_job, customer_mail,
 customer_tel, customer_post, customer_add, role)
values (customer_seq.nextval, 'admin', '$2y$10$gzwToLfOx2E/eIvcbZKODuOaKL58T/6VoH833mL8EGL3GU4yjN1Bm', '1985-02-10', 'admin', 'admin@naver.com', '010-', '10249', '경기도 고양시', 'ADMIN');

-- MOVIE

INSERT INTO MOVIE(MOVIE_ID, TITLE, PRICE) VALUES (MOVIE_SEQ.NEXTVAL, '아바타: 물의 길', 10000);
INSERT INTO MOVIE(MOVIE_ID, TITLE, PRICE) VALUES (MOVIE_SEQ.NEXTVAL, '어벤져스 : 엔드게임', 5000);
INSERT INTO MOVIE(MOVIE_ID, TITLE, PRICE) VALUES (MOVIE_SEQ.NEXTVAL, '토르 : 라그나로크', 1000);
INSERT INTO MOVIE(MOVIE_ID, TITLE, PRICE) VALUES (MOVIE_SEQ.NEXTVAL, '닥터 스트레인지: 대혼돈의 멀티버스', 7000);
INSERT INTO MOVIE(MOVIE_ID, TITLE, PRICE) VALUES (MOVIE_SEQ.NEXTVAL, '어벤져스', 7000);
INSERT INTO MOVIE(MOVIE_ID, TITLE, PRICE) VALUES (MOVIE_SEQ.NEXTVAL, '토르: 러브 앤 썬더', 5000);
INSERT INTO MOVIE(MOVIE_ID, TITLE, PRICE) VALUES (MOVIE_SEQ.NEXTVAL, '맨 오브 스틸', 500);
INSERT INTO MOVIE(MOVIE_ID, TITLE, PRICE) VALUES (MOVIE_SEQ.NEXTVAL, '앤트맨과 와스프', 9000);