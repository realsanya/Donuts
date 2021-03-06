# Документация к web приложению по продаже пончиков.
## Общий стек технологий
**Шаблонизатор:** Freemaker

**База данных:** Mysql

**Библиотека для css:** bootstrap

**Концепция разработки:** MVC

**Паттерн проектирования:** Repository

**Работа с базой данных:** ORM

## Функционал сайта
* Авторизация и регистрация пользователя, с возможностью выбора запомнить пользователя
* Профиль пользователя. Просмотр заказов и корзины, редактирование своих данных: фотография профиля, номер телефона, пароль...
* Открытые отзывы, каждый посетитель может увидеть отзыв человека к продукции сайта.
* У зарегистрированного пользователя возможность оставлять отзыв.
* Для анонимных посетителей работает корзина и просмотр продукции, но чтобы оформить заказ нужно авторизоваться.
* Для авторизированных пользователей состояние корзины остается на любом устройстве.
* Фильтр: по цене, по популярности, по новизне,по весу.
* Поиск по ключевым словам, тэгам.

## Страницы сайта
* Главная страница(Целевая страница)
* Каталог пончиков
* Детальное описание пончика
* Корзина
* Страница оплаты и доставки
* Авторизация
* Регистрация
* Профиль
* Страница с преимуществами нашего приложения
* Страница о нас

## Задачи по разработке приложения
* Использование сессий для авторизации пользователей
* Использование cookies чтобы хранить локальную информацию пользователя: "запомнить меня", "Корзина"
* Конфиденциальность пользователей: хэширование паролей.
* Использование регулярных выражений для проверки правильности заполненных данных.
* Автозаполнения заказа по данным из профиля пользователя.
* Ограничение количества символов в полях при регисрации, авторизации, изменении данных профиля.
* Ajax запросы: для проверки уже существуещего email при регистрации, правильность заполненных данных на этапе авторизации.
* Описать такие сущности как: `Donuts-пончики`, `User-пользователь`, `Order-заказ`, `Сomment-отзыв`
* Разработать ORM удобной работы с бд.
* "User friendly interface" - удобный дизайн сайта для повышения количества пользователей.
* Верстка по дизайну.
* Работоспособность всех страниц приложения

## Бизнес требования
* Цель: создать качественное приложение. Выйти на рынок продаж пончиков.
* Проблема: в городе нет возможности выбрать и заказать онлайн пончики, так как большинство производителей пончиков продают их локально или через знакомых.
* Мы даем: удобный интерфес как для компьютеров, так и для смартфонов. Понятную каждому легкую навигацию по сайту.
* Наш продукт соотвествует требованиям федеральных законов: 
```text
 "О персональных данных" от 27.07.2006 N 152-ФЗ
 "О применении контрольно-кассовой техники при осуществлении расчетов в Российской Федерации" от 22.05.2003 N 54-ФЗ
``` 


