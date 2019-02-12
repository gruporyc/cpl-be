-- Update this file with database structure and basic data (metadada, catalogs, etc)
-- Here you'll find an example
-- IMPORTANT: FileName must start with "V" + versionNumber + "__" and have .sql extension

CREATE TABLE cpl_users.users (
  id varchar(36) PRIMARY KEY,
  name varchar(36) DEFAULT NULL,
  status varchar(50) NOT NULL,
  phone varchar(15) DEFAULT NULL,
  create_date TIMESTAMP DEFAULT NOW(),
  update_date TIMESTAMP DEFAULT NOW()
);

CREATE INDEX users_name ON cpl_users.users(name);
CREATE INDEX users_phone ON cpl_users.users(phone);