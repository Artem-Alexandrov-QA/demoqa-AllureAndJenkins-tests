## Проект с автотестами для сайта: [demoqa.com](https://demoqa.com)

### Technology stack:
- Java
- Gradle
- Junit5
- Selenide
- Jenkins
- Selenoid
- Allure Report
- Реализованы разные подходы: PageObject, Random, Random Faker
### Реализованы проверки:

- [X] - Открытие страницы https://demoqa.com/automation-practice-form;
- [X] - Заполнение всех полей ввода;
- [X] - Использование рандомных значений;
- [X] - Проверка, заполнения формы;

### Ветка "properties":
- [X] - Параметры для Jenkins
- [X] - Credentials файлы
- [X] - Owner test

### Ветка "allure-notifications":
- [X] - Параметры для Jenkins
- [X] - Отправка Allure отчётов в телеграм чат

## Команды для запуска из терминала
Локально должны быть заданы параметры в credentials.properties
### Запуск всех тестов на удалённом сервере:
```bash
gradle clean test -DremoteUrl=server
```
### Запуск тестов для проверки заполнения Student Registration Form:
```bash
gradle clean ui_test
```
### Собрать Allure отчет:
```bash
allure serve build/allure-results
```
## Параметры с помощью которых можно [запустить сборку в Jenkins](https://jenkins.autotests.cloud/job/09-artemalexandrov09-jenkins-notifications/build?delay=0sec):