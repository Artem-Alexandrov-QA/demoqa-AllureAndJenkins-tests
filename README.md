## Проект с автотестами для сайта: [demoqa.com](https://demoqa.com)

### Technology stack:
<table>
<tbody>
<tr>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://cdn-icons-png.flaticon.com/512/226/226777.png" width="40" height="40"><br>Java</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Gradle.svg" width="40" height="40"><br>Gradle</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/JUnit5.svg" width="40" height="40"><br>JUnit5</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://user-images.githubusercontent.com/47101779/210963191-4a3df255-fcac-418b-a903-eada87d84120.png" width ="40" height="40"><br>Selenide</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Jenkins.svg" width="40" height="40"><br>Jenkins</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://avatars.githubusercontent.com/u/26328913?s=280&v=4" width="40" height="40"><br>Selenoid</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Allure_Report.svg" width="40" height="40"><br>Allure Report</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Telegram_logo.svg/2048px-Telegram_logo.svg.png" width="40" height="40"><br>Telegram Bot</td>
</tr>
</tbody>
</table>

### Реализованы проверки:

- [X] - Открытие страницы https://demoqa.com/automation-practice-form;
- [X] - Заполнение всех полей ввода;
- [X] - Использование рандомных значений;
- [X] - Проверка, заполнения формы;
- [X] - Реализованы разные подходы: PageObject, Random, Random Faker

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