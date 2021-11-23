**Cистема Ресторан. Клиент осуществляет Заказ из Меню.**

**Что необходимо сделать:**

1. Создать базу данных в любой СУБД (MySQL, MS SQL, SQLite, PostreSQL и тд) на ваш вкус;
2. Организовать доступ к базе данных из вашего приложения используя JDBC и шаблон DAOClasses;
3. Релизовать необходимые сервисы, которые будут каким-либо образом использовать данные из таблиц БД (просто получать, получать по параметру, получать в определённом порядке, считать статистику на основе полученных данных и тд);
4. Реализовать вывод результатов работы сервисного слоя в консоль;
5. Написать тесты для сервисного слоя (TestNG, JUNIT);
6. Классы и интерфейсы должны быть хорошо структурированы по пакетам;
7. Соблюдать Java Code Conventions.  

**Стек, технологии:**   
dataBase: MySQL  
Local Server: MAMP  
Administrator tool for dataBase:  phpMyAdmin  
JDBC  
Lombok

**Настройка подключения к БД:**  
Port 8889  
Username	root  
Password	root  
ДБ: Restaurant_DB  

**SQL commands:**  
CREATE DATABASE Restaurant_DB

CREATE TABLES

CREATE TABLE IF NOT EXISTS dishes (
id INT (11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR (100) NOT NULL,
info VARCHAR (255) NOT NULL,
price INT (11) NOT NULL)
ENGINE INNODB

CREATE TABLE IF NOT EXISTS client (
id INT (11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR (20),
phone VARCHAR (15)
)
ENGINE INNODB

CREATE TABLE IF NOT EXISTS orders (
id INT (11) NOT NULL AUTO_INCREMENT,
client_id INT (11) NOT NULL,
menu_id INT (11) NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (client_id) REFERENCES client(id),
FOREIGN KEY (menu_id) REFERENCES menu(id)
)
ENGINE INNODB

**При работе с пустыми таблицами:**
1. Создать блюдо через права администратора (9 - в первом меню), пароль - admin;
2. Сделать заказ от имени клиента (1 - в первом меню);
3. Затем станут доступны все прочие функции.

Либо, если нет желания - можно через консольку создать меню:
INSERT INTO `menu`(`dishes`, `info`, `price`) VALUES ('Salmon','Carelian salmon','1200'), ('Greek salad','Salad with fresh vegetables','600'), ('Steak tartar','Black angus steak','1600')

Клентов:
INSERT INTO `client`(`name`, `phone`) VALUES ('John','8921312313'), ('Sam','831233112')


