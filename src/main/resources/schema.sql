-- ================================
--  DROP TABLES (FK 순서 중요)
-- ================================
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS image;
DROP TABLE IF EXISTS member;

-- ================================
--  MEMBER TABLE
-- ================================
CREATE TABLE member (
    member_id BIGINT AUTO_INCREMENT PRIMARY KEY,

    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,

    -- BaseEntity 공통 컬럼
    created_by VARCHAR(255),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_modified_by VARCHAR(255),
    last_modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB;


-- ================================
--  IMAGE TABLE
-- ================================
CREATE TABLE image (
    image_id BIGINT AUTO_INCREMENT PRIMARY KEY,

    origin_file_name VARCHAR(255),
    modified_file_name VARCHAR(255),

    -- BaseEntity 공통 컬럼
    created_by VARCHAR(255),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_modified_by VARCHAR(255),
    last_modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB;


-- ================================
--  BOOK TABLE
-- ================================
CREATE TABLE book (
    book_id BIGINT AUTO_INCREMENT PRIMARY KEY,

    title VARCHAR(255),
    author_name VARCHAR(255),
    category VARCHAR(255),
    description VARCHAR(2000),

    member_id BIGINT,
    image_id BIGINT,

    -- BaseEntity 공통 컬럼
    created_by VARCHAR(255),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_modified_by VARCHAR(255),
    last_modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_book_member
        FOREIGN KEY (member_id)
        REFERENCES member(member_id)
        ON DELETE SET NULL,

    CONSTRAINT fk_book_image
        FOREIGN KEY (image_id)
        REFERENCES image(image_id)
        ON DELETE SET NULL
) ENGINE=InnoDB;
