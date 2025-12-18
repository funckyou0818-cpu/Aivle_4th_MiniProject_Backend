-- member
INSERT INTO member (username, password, created_by, created_date, last_modified_by, last_modified_date)
VALUES ('john', '1234', NULL, CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP);

INSERT INTO member (username, password, created_by, created_date, last_modified_by, last_modified_date)
VALUES ('emma', '1234', NULL, CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP);

INSERT INTO member (username, password, created_by, created_date, last_modified_by, last_modified_date)
VALUES ('michael', '1234', NULL, CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP);

INSERT INTO member (username, password, created_by, created_date, last_modified_by, last_modified_date)
VALUES ('sara', '1234', NULL, CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP);

INSERT INTO member (username, password, created_by, created_date, last_modified_by, last_modified_date)
VALUES ('david', '1234', NULL, CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP);

-- image
INSERT INTO image (origin_file_name, modified_file_name, created_by, created_date, last_modified_by, last_modified_date)
VALUES ('book1.jpg', 'book1_2025.jpg', NULL, CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP);

INSERT INTO image (origin_file_name, modified_file_name, created_by, created_date, last_modified_by, last_modified_date)
VALUES ('book2.jpg', 'book2_2025.jpg', NULL, CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP);

INSERT INTO image (origin_file_name, modified_file_name, created_by, created_date, last_modified_by, last_modified_date)
VALUES ('book3.jpg', 'book3_2025.jpg', NULL, CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP);

INSERT INTO image (origin_file_name, modified_file_name, created_by, created_date, last_modified_by, last_modified_date)
VALUES ('book4.jpg', 'book4_2025.jpg', NULL, CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP);

INSERT INTO image (origin_file_name, modified_file_name, created_by, created_date, last_modified_by, last_modified_date)
VALUES ('book5.jpg', 'book5_2025.jpg', NULL, CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP);

-- book
INSERT INTO book (title, author_name, category, description, member_id, image_id,
                  created_by, created_date, last_modified_by, last_modified_date)
VALUES ('Clean Code', 'Robert C. Martin', 'Programming', '가독성 좋은 코드 작성 원칙',
        1, 1, NULL, CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP);

INSERT INTO book (title, author_name, category, description, member_id, image_id,
                  created_by, created_date, last_modified_by, last_modified_date)
VALUES ('Effective Java', 'Joshua Bloch', 'Programming', '자바 개발자를 위한 실전 가이드',
        2, 2, NULL, CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP);

INSERT INTO book (title, author_name, category, description, member_id, image_id,
                  created_by, created_date, last_modified_by, last_modified_date)
VALUES ('Spring in Action', 'Craig Walls', 'Programming', '스프링 프레임워크 실무 안내서',
        3, 3, NULL, CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP);

INSERT INTO book (title, author_name, category, description, member_id, image_id,
                  created_by, created_date, last_modified_by, last_modified_date)
VALUES ('Domain Driven Design', 'Eric Evans', 'Architecture', '도메인 주도 설계 기본서',
        4, 4, NULL, CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP);

INSERT INTO book (title, author_name, category, description, member_id, image_id,
                  created_by, created_date, last_modified_by, last_modified_date)
VALUES ('Refactoring', 'Martin Fowler', 'Programming', '코드 구조 개선 기법 안내',
        5, 5, NULL, CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP);

