#!/bin/bash

# 设置变量
CONTAINER_NAME="database_container"
USER="root"
PASSWORD="root"
DATABASE="qiaoshi_db"
BACKUP_DIR="./mysql_backup"
DATE=$(date +%Y%m%d%H%M%S)
BACKUP_FILE="$BACKUP_DIR/${DATABASE}_backup_$DATE.sql"

# 创建备份目录（如果不存在）
mkdir -p "$BACKUP_DIR"

# 执行备份命令
docker exec "$CONTAINER_NAME" /usr/bin/mysqldump -u "$USER" -p"$PASSWORD" "$DATABASE" > "$BACKUP_FILE"

# 删除7天前的备份文件
find "$BACKUP_DIR" -type f -name "*.sql" -mtime +7 -exec rm {} \;
