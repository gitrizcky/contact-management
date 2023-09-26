USE rest_api;

CREATE table user(
    username VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    name VARCHAR(100) NOT NULL,
    token VARCHAR(100),
    token_expired_at BIGINT,

    PRIMARY KEY (username),
    UNIQUE (token)
) ENGINE InnoDB;

SELECT * FROM user;

DESC user;

CREATE table contact(
    id VARCHAR(100) NOT NULL,
    username VARCHAR(100) NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100),
    phone VARCHAR(100),
    email VARCHAR(100),
    PRIMARY KEY (id),
    FOREIGN KEY fk_user_contact(username) references user(username)
) ENGINE InnoDB;

SELECT * FROM contact;

DESC contact;

CREATE table address(
    id VARCHAR(100) NOT NULL,
    contact_id VARCHAR(100) NOT NULL,
    street VARCHAR(100),
    city VARCHAR(100),
    province VARCHAR(100),
    country VARCHAR(100) NOT NULL,
    postal_code VARCHAR(10),
    PRIMARY KEY (id),
    FOREIGN KEY fk_contact_address (contact_id) references contact(id)
) ENGINE InnoDB;

SELECT * FROM address;

DESC address;
