CREATE TABLE users (
    u_id int(11) AUTO_INCREMENT PRIMARY KEY,
    f_name varchar(20)NOT NULL,
    l_name varchar(20)NOT NULL,
    password varchar(256) NOT NULL,
    email varchar(30) UNIQUE NOT NULL
);

CREATE TABLE books (
    b_id int(11) AUTO_INCREMENT PRIMARY KEY,
    b_title varchar(50) UNIQUE NOT NULL,
    auther varchar(50) NOT NULL,
    description varchar(200) NOT NULL,
    genre varchar(50) NOT NULL,
    status varchar(11) NOT NULL DEFAULT 'Available',
    uid int(11)
);

CREATE TABLE bookBorrowing (
    bb_id int(11) AUTO_INCREMENT PRIMARY KEY,
    u_id int(11) NOT NULL,
    b_title varchar(50) NOT NULL, 
    date_b varchar(10) NOT NULL,
    date_r varchar(10) NOT NULL 
);


	ALTER TABLE bookBorrowing
    ADD CONSTRAINT fk_uid
    FOREIGN KEY (u_id) REFERENCES users (u_id) ON DELETE CASCADE ON UPDATE CASCADE;

	ALTER TABLE bookBorrowing
    ADD CONSTRAINT fk_btitle
    FOREIGN KEY (b_title) REFERENCES books (b_title) ON DELETE CASCADE ON UPDATE CASCADE;

    ALTER TABLE books
    ADD CONSTRAINT fk_u_id
    FOREIGN KEY (uid) REFERENCES users (u_id) ON DELETE CASCADE ON UPDATE CASCADE;