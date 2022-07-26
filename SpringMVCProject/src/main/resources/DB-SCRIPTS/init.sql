# Дропаем и создаём бд
DROP SCHEMA IF EXISTS ESHOP_DB;
CREATE SCHEMA IF NOT EXISTS ESHOP_DB;

# Дропаем и создаём таблицу категорий
DROP TABLE IF EXISTS ESHOP_DB.CATEGORIES;
CREATE TABLE IF NOT EXISTS ESHOP_DB.CATEGORIES
(
    ID          INT PRIMARY KEY,
    NAME        VARCHAR(45)   NOT NULL,
    DESCRIPTION VARCHAR(1000) NOT NULL,
    IMG         VARCHAR(1000) NOT NULL,
    UNIQUE INDEX IDX_CATEGORIES_CATEGORY_ID_UNIQUE (ID ASC),
    UNIQUE INDEX IDX_CATEGORIES_NAME_UNIQUE (NAME ASC)
);

# Дропаем и создаём таблицу продуктов
DROP TABLE IF EXISTS ESHOP_DB.PRODUCTS;
CREATE TABLE IF NOT EXISTS ESHOP_DB.PRODUCTS
(
    ID          INT PRIMARY KEY AUTO_INCREMENT,
    CATEGORY_ID    INT   NOT NULL,
    NAME        VARCHAR(45)   NOT NULL,
    PRICE       INT           NOT NULL,
    DESCRIPTION VARCHAR(1000) NOT NULL,
    IMG         VARCHAR(1000) NOT NULL,
    UNIQUE INDEX IDX_PRODUCTS_ID_UNIQUE (ID ASC),
    CONSTRAINT FK_PRODUCTS_CATEGORY_ID_CATEGORIES_ID
    FOREIGN KEY (CATEGORY_ID)
    REFERENCES ESHOP_DB.CATEGORIES (ID)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

# Дропаем и создаём таблицу пользователей
DROP TABLE IF EXISTS ESHOP_DB.USERS;
CREATE TABLE IF NOT EXISTS ESHOP_DB.USERS
(
    ID       INT PRIMARY KEY AUTO_INCREMENT,
    USERNAME VARCHAR(45) NOT NULL,
    NAME     VARCHAR(45) NOT NULL,
    SURNAME  VARCHAR(45) NOT NULL,
    PASSWORD VARCHAR(45) NOT NULL,
    IMG      VARCHAR(45)    DEFAULT 'cat.jpg',
    INFO     VARCHAR(10000) DEFAULT 'Личная информация не настроена',
    EMAIL    VARCHAR(45) NOT NULL,
    BIRTHDAY DATE        NOT NULL,
    UNIQUE INDEX IDX_USERS_USER_ID_UNIQUE (ID ASC),
    UNIQUE INDEX IDX_USERS_EMAIL_UNIQUE (EMAIL ASC)
);

# Дропаем и создаём таблицу заказов
DROP TABLE IF EXISTS ESHOP_DB.ORDERS;
CREATE TABLE IF NOT EXISTS ESHOP_DB.ORDERS (
    ID INT NOT NULL AUTO_INCREMENT,
    DATE DATETIME NOT NULL,
    PRICE INT NOT NULL,
    USER_ID INT NOT NULL,
    PRIMARY KEY (ID),
    UNIQUE INDEX IDX_ORDERS_ID_UNIQUE (ID ASC),
    CONSTRAINT FK_ORDERS_USER_ID_USERS_ID
    FOREIGN KEY (USER_ID)
    REFERENCES ESHOP_DB.USERS (ID)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

# Дропаем и создаём связующую таблицу ЗАКАЗ - ПРОДУКТ
DROP TABLE IF EXISTS ESHOP_DB.ORDERS_PRODUCTS;
CREATE TABLE IF NOT EXISTS ESHOP_DB.ORDERS_PRODUCTS (
    ORDER_ID INT NOT NULL,
    PRODUCT_ID INT NOT NULL,
    PRIMARY KEY (ORDER_ID, PRODUCT_ID),
    CONSTRAINT FK_ORDERS_PRODUCTS_ORDER_ID_ORDERS_ID
    FOREIGN KEY (ORDER_ID)
    REFERENCES ORDERS(ID),
    CONSTRAINT FK_ORDERS_PRODUCTS_PRODUCT_ID_PRODUCTS_ID
    FOREIGN KEY (PRODUCT_ID)
    REFERENCES PRODUCTS(ID)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


# Инициализация юзера
INSERT INTO ESHOP_DB.USERS (username, name, surname, password, img, info, email, birthday) VALUE ('admin', 'Anton',
                                                                                                  'Auseichyk', 'admin',
                                                                                                  'anton_photo.jpg', 'Beginner java programmer. Studying a Java developer course at TeachMeSkills. Studying at the
                4th year of the Belarusian State Technological University in the specialty "Three-dimensional
                technologies". I am a team player, easily and quickly trained, sociable, I quickly cope with tasks. I have
                a technical mindset and dream of working in IT. With that said, I can assure you that I can be a useful
                employee of the company.', 'imtoshaa.work@gmail.com', '2001-05-08');

# Инициализация категорий
# Камера
INSERT INTO ESHOP_DB.CATEGORIES (id, name, description, img) VALUE ('1', 'Камеры', 'Самые лучшие камеры', 'camera.jpg');
# Машина
INSERT INTO ESHOP_DB.CATEGORIES (id, name, description, img) VALUE ('2', 'Автомобили', 'Быстрые машины', 'car.jpg');
# Холодильник
INSERT INTO ESHOP_DB.CATEGORIES (id, name, description, img) VALUE ('3', 'Холодильники', 'Самые лучшие холодильники', 'fridge.jpg');
# GPS
INSERT INTO ESHOP_DB.CATEGORIES (id, name, description, img) VALUE ('4', 'GPS-навигаторы', 'Самые точные навигаторы', 'jps_nav.jpg');
# Ноутбук
INSERT INTO ESHOP_DB.CATEGORIES (id, name, description, img) VALUE ('5', 'Ноутбуки', 'Хорошие ноутбуки', 'laptop.jpg');
# Телефон
INSERT INTO ESHOP_DB.CATEGORIES (id, name, description, img) VALUE ('6', 'Телефоны', 'Самыеы красивые телефоны', 'mobile.jpg');

# Инициализация товаров
# Камеры
INSERT INTO ESHOP_DB.PRODUCTS (CATEGORY_ID, name, price, description, img) VALUE ('1', 'Sony Alpha a7 III Body',
                                                                               '1300',
                                                                               'Беззеркальная камера, байонет Sony E, матрица Full frame (полный кадр) 24.2 Мп, без объектива (body), Wi-Fi, два слота для карт памяти',
                                                                               'sony_camera.jpg');
INSERT INTO ESHOP_DB.PRODUCTS (CATEGORY_ID, name, price, description, img) VALUE ('1', 'Canon EOS R6 Body', '1200',
                                                                               'беззеркальная камера, байонет Canon RF, матрица Full frame (полный кадр) 20.1 Мп, без объектива (body), Wi-Fi, два слота для карт памяти',
                                                                               'canon_camera.jpg');

# Машины
INSERT INTO ESHOP_DB.PRODUCTS (CATEGORY_ID, name, price, description, img) VALUE ('2', 'Kia Rio-X', '52000',
                                                                               'Kia Rio X смотрится эффектно и убедительно благодаря множеству дизайнерских акцентов и штрихов. Собранный, словно готовый к моментальному ускорению, он ждет лишь одного: когда Вы запустите двигатель и нажмете на педаль',
                                                                               'kia_car.jpg');
INSERT INTO ESHOP_DB.PRODUCTS (CATEGORY_ID, name, price, description, img) VALUE ('2', 'BMW X3 xDrive20i', '170000',
                                                                               'BMW X3 — люксовый компактный кроссовер немецкой компании BMW.',
                                                                               'bmw_car.jpg');

# Холодильники
INSERT INTO ESHOP_DB.PRODUCTS (CATEGORY_ID, name, price, description, img) VALUE ('3', 'ATLANT ХМ 4307-000', '1400',
                                                                               'Встраиваемый, без No Frost, механическое управление, класс A, полезный объём: 234 л (167 + 67 л), перенавешиваемые двери, лоток для яиц, 54x56x178 см, белый',
                                                                               'atlant_fridge.jpg');
INSERT INTO ESHOP_DB.PRODUCTS (CATEGORY_ID, name, price, description, img) VALUE ('3', 'Nordfrost (Nord) NR 403 AW',
                                                                               '530',
                                                                               'отдельностоящий, без No Frost, механическое управление, класс A+, полезный объём: 104 л, перенавешиваемые двери, лоток для яиц, 50x53x86 см, белый',
                                                                               'nord_fridge.jpg');

# GPS
INSERT INTO ESHOP_DB.PRODUCTS (CATEGORY_ID, name, price, description, img) VALUE ('4', 'Roadmax Uno [MS-7]', '140',
                                                                               'экран 7" TFT (800 x 480), ОЗУ 256 Мб, флэш-память 8 Гб, Windows CE 6.0',
                                                                               'roadmax_gps.jpg');
INSERT INTO ESHOP_DB.PRODUCTS (CATEGORY_ID, name, price, description, img) VALUE ('4', 'NAVITEL E707 Magnetic', '151',
                                                                               'экран 7" TFT (800 x 480), процессор MStar MSB2531 800 МГц, флэш-память 8 Гб, Linux',
                                                                               'navitel_gps.jpg');

# Ноутбуки
INSERT INTO ESHOP_DB.PRODUCTS (CATEGORY_ID, name, price, description, img) VALUE ('5', 'HP 255 G8 34P23ES', '1130',
                                                                               '15.6" 1920 x 1080 IPS, 60 Гц, несенсорный, AMD Athlon Silver 3050U 2300 МГц, 8 ГБ DDR4, SSD 256 ГБ, видеокарта встроенная, без ОС, цвет крышки серебристый',
                                                                               'hp_laptop.jpg');
INSERT INTO ESHOP_DB.PRODUCTS (CATEGORY_ID, name, price, description, img) VALUE ('5', 'Lenovo IdeaPad 3', '2300',
                                                                               '15.6" 1920 x 1080 IPS, 60 Гц, несенсорный, AMD Ryzen 3 5300U 2600 МГц, 8 ГБ DDR4, SSD 256 ГБ, видеокарта встроенная, без ОС, цвет крышки серый',
                                                                               'lenovo_laptop.jpg');

# Телефоны
INSERT INTO ESHOP_DB.PRODUCTS (CATEGORY_ID, name, price, description, img) VALUE ('6', 'HONOR 50', '1300',
                                                                               'Android, экран 6.57" OLED (1080x2340), Qualcomm Snapdragon 778G, ОЗУ 8 ГБ, флэш-память 128 ГБ, камера 108 Мп, аккумулятор 4300 мАч, 2 SIM',
                                                                               'honor_mobile.jpg');
INSERT INTO ESHOP_DB.PRODUCTS (CATEGORY_ID, name, price, description, img) VALUE ('6', 'Xiaomi Redmi Note 10 Pro',
                                                                               '1800',
                                                                               'Android, экран 6.67" AMOLED (1080x2400), Qualcomm Snapdragon 732G, ОЗУ 8 ГБ, флэш-память 128 ГБ, карты памяти, камера 108 Мп, аккумулятор 5020 мАч, 2 SIM',
                                                                               'xiaomi_mobile.jpg');
