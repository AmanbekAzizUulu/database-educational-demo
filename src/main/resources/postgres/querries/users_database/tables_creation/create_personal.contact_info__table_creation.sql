-- Создание таблицы contact_info
CREATE TABLE personal.contact_info (
    id SERIAL PRIMARY KEY,
    phone_number VARCHAR(20),
    e_mail VARCHAR(100),
    telegram_login VARCHAR(50),
    telegram_number VARCHAR(20),
    whatsapp VARCHAR(20),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
