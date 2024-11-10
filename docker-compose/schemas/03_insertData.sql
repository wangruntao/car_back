-- 插入用户数据
INSERT INTO user (username, password, role, contact_info)
VALUES
    ('alice', 'password123', 'admin', 'alice@example.com'),
    ('bob', 'password456', 'user', 'bob@example.com'),
    ('charlie', 'password789', 'user', 'charlie@example.com');


-- 插入车辆数据
INSERT INTO car (ip, imgurl)
VALUES
    ('192.168.1.1', 'http://example.com/car1.jpg'),
    ('192.168.1.2', 'http://example.com/car2.jpg'),
    ('192.168.1.3', 'http://example.com/car3.jpg');


-- 插入用户和车辆的绑定关系
INSERT INTO car_user_binding (car_id, user_id)
VALUES
    (1, 1),  -- 用户 alice 绑定 车辆 1
    (2, 2),  -- 用户 bob 绑定 车辆 2
    (3, 3);  -- 用户 charlie 绑定 车辆 3

-- 插入车辆控制命令数据
INSERT INTO car_control_command (user_id, command, status, execution_result)
VALUES
    (1, 'Start Engine', 'Completed', 'Success'),
    (2, 'Lock Doors', 'Pending', 'Waiting for response'),
    (3, 'Turn on Lights', 'Completed', 'Success');

-- 插入视频流数据
INSERT INTO video_stream (car_id, user_id, resolution, frame_rate, bandwidth, encoding_format)
VALUES
    (1, 1, '1920x1080', 30, 2.5, 'H.264'),
    (2, 2, '1280x720', 25, 1.8, 'H.265'),
    (3, 3, '640x480', 20, 1.0, 'VP8');
