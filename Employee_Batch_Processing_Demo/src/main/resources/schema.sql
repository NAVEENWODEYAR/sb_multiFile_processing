CREATE TABLE IF NOT EXISTS product_data (
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    price INT NOT NULL,
    discount INT
);
