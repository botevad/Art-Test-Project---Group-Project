CREATE TABLE users (
id INT PRIMARY KEY,
username VARCHAR(150),
password VARCHAR(20) ,
email VARCHAR(50),
phone_numb VARCHAR(13),
login VARCHAR2(20),
CONSTRAINT chkPhoneNumb CHECK(phone_numb NOT LIKE '%[^+0-9]%' ),
CONSTRAINT chkPhoneNumbL CHECK(LENGTH(phone_numb)=10 OR LENGTH(phone_numb)=13)
);

CREATE SEQUENCE users_seq
MINVALUE 1
MAXVALUE 99999999999999
START WITH 1
INCREMENT BY 1;

--DROP TABLE users;
--DROP SEQUENCE users_seq;



CREATE TABLE SMS (
    sms_id INT ,
    id INT,
    reciever VARCHAR2(50),
    text VARCHAR2(256),
    status VARCHAR(30),
    PRIMARY KEY(sms_id),
    FOREIGN KEY(id) REFERENCES users(id),
    CONSTRAINT chkStatusSMS  CHECK(status IN('send','sent','error' ))
    );

  -- DROP TABLE SMS;

CREATE TABLE email (
    email_id INT ,
    id INT,
    reciever VARCHAR2(50),
    text VARCHAR2(256),
    status VARCHAR(30),
    PRIMARY KEY(email_id),
    FOREIGN KEY(id) REFERENCES users(id),
    CONSTRAINT chkStatusEmail  CHECK(status IN('send','sent','error' ))

      );
 -- DROP TABLE email;


CREATE TABLE call (
    call_id INT ,
    id INT,
    status VARCHAR(30),
    reciever VARCHAR2(50),
    PRIMARY KEY(call_id),
    FOREIGN KEY(id) REFERENCES users(id),
    CONSTRAINT chkStatusCall  CHECK(status IN('call','in_call','error' )),
    CONSTRAINT chkReciever CHECK(LENGTH(reciever)=10 OR LENGTH(reciever)=13)
    );

   --DROP TABLE call;
 CREATE TABLE privilege (
     id INT PRIMARY KEY ,
     privilege_name VARCHAR(150),
     key VARCHAR2(10)
 );


CREATE TABLE users_privilege(
    id           INT GENERATED ALWAYS AS IDENTITY,
    id_user      INT,
    id_privilege INT,
    PRIMARY KEY (id),
    FOREIGN KEY (ID_USER) REFERENCES users (id),
    FOREIGN KEY (ID_PRIVILEGE) REFERENCES privilege (id)
);