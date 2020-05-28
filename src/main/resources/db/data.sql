insert into users(id,username,password,email,phone_numb,login) values (users_seq.nextval,'admin','dsafa2','sfghha','+359456123','admin');
insert into users(id,username,password,email,phone_numb,login) values (users_seq.nextval,'dada','dsafda2','sfgfhha','+359456122','admin');
insert into users(id,username,password,email,phone_numb,login) values (users_seq.nextval,'guest','dsafda3','sfgfhha','+359456122','guest');
insert into users(id,username,password,email,phone_numb,login) values (users_seq.nextval,'dasfaf','dsafda2','sfgfhha','+359456122','guest');

insert into privilege ( id,privilege_name, key) values (users_seq.nextval,'CREATE', 'C');
insert into privilege (id, privilege_name, key) values (users_seq.nextval,'READ', 'R');
insert into privilege (id, privilege_name, key) values (users_seq.nextval,'UPDATE', 'U');
insert into privilege (id, privilege_name, key) values (users_seq.nextval,'SMS READ ONLY', 'SMS_R');
insert into privilege (id, privilege_name, key) values (users_seq.nextval,'SMS READ/WRITE ONLY', 'SMS_RW');
insert into privilege (id, privilege_name, key) values (users_seq.nextval,'EMAIL READ ONLY', 'EMAIL_R');
insert into privilege (id, privilege_name, key) values (users_seq.nextval,'EMAIL READ/WRITE ONLY', 'EMAIL_RW');
insert into privilege (id, privilege_name, key) values (users_seq.nextval,'CALL READ ONLY', 'CALL_R');
insert into privilege (id, privilege_name, key) values (users_seq.nextval,'CALL READ/WRITE ONLY', 'CALL_RW');

insert into users_privilege (id_user, id_privilege) (select u.id, p.id
                                                     from users u,
                                                          privilege p
                                                     where u.login = 'admin');
insert into users_privilege (id_user, id_privilege) (select u.id, p.id
                                                     from users u,
                                                          privilege p
                                                     where u.login = 'admin' and p.key = 'RW'
                                                     and p.key ='SMS_RW' and p.key ='EMAIL_RW'
                                                     and p.key ='CALL_RW');--0
insert into users_privilege (id_user, id_privilege) (select u.id, p.id
                                                     from users u,
                                                          privilege p
                                                     where u.login = 'guest' and p.key = 'R');
insert into users_privilege (id_user, id_privilege) (select u.id, p.id
                                                     from users u,
                                                          privilege p
                                                     where u.login = 'guest' and p.key = 'SMS_R');
insert into users_privilege (id_user, id_privilege) (select u.id, p.id
                                                     from users u,
                                                          privilege p
                                                     where u.login = 'guest' and p.key = 'EMAIL_R');
insert into users_privilege (id_user, id_privilege) (select u.id, p.id
                                                     from users u,
                                                          privilege p
                                                     where u.login = 'guest' and p.key = 'CALL_R');