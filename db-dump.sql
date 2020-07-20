--
-- H2 database dump

DROP TABLE IF EXISTS order_item;
DROP TABLE IF EXISTS "order";
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS user_role;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS shopping_cart;
DROP TABLE IF EXISTS shopping_cart_item;


-- Таблица аккаунтов
CREATE TABLE user
(
  id  bigserial NOT NULL,
  name character varying(60),
  email character varying(60) NOT NULL,
  password character varying(80) NOT NULL,
  CONSTRAINT user_pkey PRIMARY KEY (id),
  CONSTRAINT account_email_key UNIQUE (email)
);

-- Таблица прав доступа
CREATE TABLE role
(
  id  bigserial NOT NULL,
  role character varying NOT NULL,
  CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Добавим роли
INSERT INTO role ("id", "role") VALUES (DEFAULT, 'ROLE_USER');
INSERT INTO role ("id", "role") VALUES (DEFAULT, 'ROLE_ADMIN');

-- Таблица прав доступа и соотвутствующих им акк
CREATE TABLE user_role
(
  id_user integer NOT NULL,
  id_role integer NOT NULL,
  CONSTRAINT user_role_pk PRIMARY KEY (id_user, id_role),
  CONSTRAINT user_role_user_id_fk FOREIGN KEY (id_user)
      REFERENCES user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT user_role_role_id_fk FOREIGN KEY (id_role)
      REFERENCES role (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

-- Таблица продуктов магазина
CREATE TABLE product
(
  id integer NOT NULL,
  name character varying(255) NOT NULL,
  length numeric(8,2) NOT NULL,
  width numeric(8,2) NOT NULL,
  height numeric(8,2) NOT NULL,
  price numeric(8,2) NOT NULL,
  status character varying(255) NOT NULL,
  image_url character varying(255) NOT NULL,
  totalCount integer NOT NULL, 
  CONSTRAINT product_pkey PRIMARY KEY (id),
);


-- Таблица корзины
CREATE TABLE shopping_cart
(
  id bigserial NOT NULL,
  id_user integer NOT NULL,
  created timestamp without time zone NOT NULL,
  CONSTRAINT shopping_cart_pk PRIMARY KEY (id),
  CONSTRAINT shopping_cart_user_id_fk FOREIGN KEY (id_user)
      REFERENCES user (id) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE
);

-- Таблица товаров в корзине
CREATE TABLE shopping_cart_item
 (
  id bigserial NOT NULL,
  id_shopping_cart bigint NOT NULL,
  id_product integer NOT NULL,
  count integer,
  CONSTRAINT order_item_pk PRIMARY KEY (id),
  CONSTRAINT shopping_cart_item_id_fk FOREIGN KEY (id_shopping_cart)
      REFERENCES shopping_cart (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT shopping_cart_item_product_id_fk FOREIGN KEY (id_product)
      REFERENCES product (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);


-- Таблица заказов
CREATE TABLE "order"
(
  id bigserial NOT NULL,
  id_account integer NOT NULL,
  created timestamp without time zone NOT NULL,
  CONSTRAINT order_pk PRIMARY KEY (id),
  CONSTRAINT order_user_id_fk FOREIGN KEY (id_user)
      REFERENCES user (id) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE
);

-- Таблица товаров в заказе
CREATE TABLE order_item
 (
  id bigserial NOT NULL,
  id_order bigint NOT NULL,
  id_product integer NOT NULL,
  count integer,
  CONSTRAINT order_item_pk PRIMARY KEY (id),
  CONSTRAINT order_item_order_id_fk FOREIGN KEY (id_order)
      REFERENCES "order" (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT order_item_product_id_fk FOREIGN KEY (id_product)
      REFERENCES product (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

 INSERT INTO PUBLIC.PRODUCT (ID, NAME, LENGTH, WIDTH, HEIGHT, PRICE, STATUS, IMAGE_URL, TOTALCOUNT)
  VALUES (null, 'Songesand', 119.60, 60.00, 191.00, 189.00, 'in stock', '/static/img/0555114_PE660180_S4_SONGESAND.jpg', 12);
 INSERT INTO PUBLIC.PRODUCT (ID, NAME, LENGTH, WIDTH, HEIGHT, PRICE, STATUS, IMAGE_URL, TOTALCOUNT)
  VALUES (null, 'Bryggja', 120.00, 43.00, 173.00, 159.00, 'in stock', '/static/img/0610068_PE689978_S4_BRYGGJA.jpg', 2);
 INSERT INTO PUBLIC.PRODUCT (ID, NAME, LENGTH, WIDTH, HEIGHT, PRICE, STATUS, IMAGE_URL, TOTALCOUNT)
 VALUES (null, 'Hemnes', 120.00, 59.00, 197.00, 239.00, 'in stock', '/static/img/0625541_PE692340_S4_HEMNES.jpg', 22);
  INSERT INTO PUBLIC.PRODUCT (ID, NAME, LENGTH, WIDTH, HEIGHT, PRICE, STATUS, IMAGE_URL, TOTALCOUNT)
 VALUES (null, 'Tyssedal', 88.00, 58.00, 208.00, 299.00, 'under order', '/static/img/0626566_PE692870_S4_Tyssedal.jpg', 0);
  INSERT INTO PUBLIC.PRODUCT (ID, NAME, LENGTH, WIDTH, HEIGHT, PRICE, STATUS, IMAGE_URL, TOTALCOUNT)
 VALUES (null, 'TRYSIL', 79.40, 61.20, 201.70, 169.00, 'out of stock', '/static/img/0626571_PE692875_S4_TRYSIL.jpg', 0);
  INSERT INTO PUBLIC.PRODUCT (ID, NAME, LENGTH, WIDTH, HEIGHT, PRICE, STATUS, IMAGE_URL, TOTALCOUNT)
 VALUES (null, 'Sunlandet', 119.60, 60.00, 191.00, 189.00, 'in stock', '/static/img/0668247_PE716770_S5_SUNLANDET.jpg', 12);