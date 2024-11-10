USE car_system;

-- 修改 user 表的 id 为自增整型
CREATE TABLE user
(
    id                INT AUTO_INCREMENT NOT NULL, -- 自增整数类型
    username          VARCHAR(255) NOT NULL,
    password          VARCHAR(255) NOT NULL,
    role              VARCHAR(255),
    contact_info      VARCHAR(255),
    registration_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 可加上默认值
    PRIMARY KEY (id)
);

-- 修改 car 表的 id 为自增整型
CREATE TABLE car
(
    id     INT AUTO_INCREMENT NOT NULL, -- 自增整数类型
    ip     VARCHAR(15),          -- 假设IP地址最长为15个字符，可根据实际情况调整
    imgurl VARCHAR(255),
    PRIMARY KEY (id)
);

-- car_user_binding 表不需要自增主键，只是关联表
CREATE TABLE car_user_binding
(
    car_id  INT NOT NULL,  -- 外键关联 car 表的 id
    user_id INT NOT NULL,  -- 外键关联 user 表的 id
    PRIMARY KEY (car_id, user_id),
    FOREIGN KEY (car_id) REFERENCES car (id),
    FOREIGN KEY (user_id) REFERENCES user (id)
);

-- 修改 car_control_command 表的 id 为自增整型
CREATE TABLE car_control_command
(
    id               INT AUTO_INCREMENT NOT NULL, -- 自增整数类型
    user_id          INT NOT NULL, -- 外键关联 user 表的 id
    command          VARCHAR(255),
    status           VARCHAR(255),
    created_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 可加上默认值
    execution_result VARCHAR(255),
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user (id)
);

-- 修改 video_stream 表的 id 为自增整型
CREATE TABLE video_stream
(
    id              INT AUTO_INCREMENT NOT NULL, -- 自增整数类型
    car_id          INT NOT NULL, -- 外键关联 car 表的 id
    user_id         INT NOT NULL, -- 外键关联 user 表的 id
    resolution      VARCHAR(255),
    frame_rate      FLOAT,
    bandwidth       FLOAT,
    created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 可加上默认值
    ended_at        TIMESTAMP,
    encoding_format VARCHAR(255),
    PRIMARY KEY (id),
    FOREIGN KEY (car_id) REFERENCES car (id),
    FOREIGN KEY (user_id) REFERENCES user (id)
);
