INSERT IGNORE INTO roles (role_id, role_name) VALUES (1, 'ADMIN')
INSERT IGNORE INTO roles (role_id, role_name) VALUES (2, 'BASIC')

INSERT IGNORE INTO user_roles (user_id, role_id) VALUES (1, 1)
INSERT IGNORE INTO user_roles (user_id, role_id) VALUES (2, 2)