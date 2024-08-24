
INSERT INTO tb_user (username) VALUES ('DavidLyra')
INSERT INTO tb_user (username) VALUES ('GustavoLyra')

INSERT INTO tb_user_credentials (email, password,enabled,user_id) VALUES ('david@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG',true,1);
INSERT INTO tb_user_credentials (email, password,enabled,user_id) VALUES ('gustavo@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG',false,2);

INSERT INTO tb_role (authority) VALUES ('ROLE_USER');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id,role_id) VALUES (1,1);
INSERT INTO tb_user_role (user_id,role_id) VALUES (2,2);