INSERT INTO users(id,username,password,email,phone_numb,login) VALUES (users_seq.NEXTVAL,'sfas','dsafa2','sfghha','+359456123','admin');
INSERT INTO users(id,username,password,email,phone_numb,login) VALUES (users_seq.NEXTVAL,'dada','dsafda2','sfgfhha','+359456122','admin');
INSERT INTO users(id,username,password,email,phone_numb,login) VALUES (users_seq.NEXTVAL,'gasgh','dsafda3','sfgfhha','+359456122','guest');
INSERT INTO users(id,username,password,email,phone_numb,login) VALUES (users_seq.NEXTVAL,'dasfaf','dsafda2','sfgfhha','+359456122','guest');

INSERT INTO privilege ( id,privilege_name, key) VALUES (users_seq.NEXTVAL,'CREATE', 'C');
INSERT INTO privilege (id, privilege_name, key) VALUES (users_seq.NEXTVAL,'READ', 'R');
INSERT INTO privilege (id, privilege_name, key) VALUES (users_seq.NEXTVAL,'UPDATE', 'U');
INSERT INTO privilege (id, privilege_name, key) VALUES (users_seq.NEXTVAL,'SMS READ ONLY', 'SMS_R');
INSERT INTO privilege (id, privilege_name, key) VALUES (users_seq.NEXTVAL,'SMS READ/WRITE ONLY', 'SMS_RW');
INSERT INTO privilege (id, privilege_name, key) VALUES (users_seq.NEXTVAL,'EMAIL READ ONLY', 'EMAIL_R');
INSERT INTO privilege (id, privilege_name, key) VALUES (users_seq.NEXTVAL,'EMAIL READ/WRITE ONLY', 'EMAIL_RW');
INSERT INTO privilege (id, privilege_name, key) VALUES (users_seq.NEXTVAL,'CALL READ ONLY', 'CALL_R');
INSERT INTO privilege (id, privilege_name, key) VALUES (users_seq.NEXTVAL,'CALL READ/WRITE ONLY', 'CALL_RW');

INSERT INTO users_privilege (id_user, id_privilege) (SELECT u.id, p.id
                                                     FROM users u,
                                                          privilege p
                                                     WHERE u.login = 'admin');
INSERT INTO users_privilege (id_user, id_privilege) (SELECT u.id, p.id
                                                     FROM users u,
                                                          privilege p
                                                     WHERE u.login = 'admin' AND p.key = 'RW'
                                                     AND p.key ='SMS_RW' AND p.key ='EMAIL_RW'
                                                     AND p.key ='CALL_RW');--0
INSERT INTO users_privilege (id_user, id_privilege) (SELECT u.id, p.id
                                                     FROM users u,
                                                          privilege p
                                                     WHERE u.login = 'guest' AND p.key = 'R');
INSERT INTO users_privilege (id_user, id_privilege) (SELECT u.id, p.id
                                                     FROM users u,
                                                          privilege p
                                                     WHERE u.login = 'guest' AND p.key = 'SMS_R');
INSERT INTO users_privilege (id_user, id_privilege) (SELECT u.id, p.id
                                                     FROM users u,
                                                          privilege p
                                                     WHERE u.login = 'guest' AND p.key = 'EMAIL_R');
INSERT INTO users_privilege (id_user, id_privilege) (SELECT u.id, p.id
                                                     FROM users u,
                                                          privilege p
                                                     WHERE u.login = 'guest' AND p.key = 'CALL_R');


                                                  

