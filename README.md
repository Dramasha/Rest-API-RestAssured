<h1 >Проект по автоматизации тестирования API сервиса <a href="https://reqres.in/"> Reqres</a></h1>
<a href="https://reqres.in/"><img  src="images/screenshots/Reqresin.png"></a>

##  💻 Что я использую

<p align="center">
<a href="https://www.jetbrains.com/idea/"><img src="images/logos/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA"/></a>
<a href="https://www.java.com/"><img src="images/logos/Java.svg" width="50" height="50"  alt="Java"/></a>
<a href="https://github.com/"><img src="images/logos/Github.svg" width="50" height="50"  alt="Github"/></a>
<a href="https://junit.org/junit5/"><img src="images/logos/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a>
<a href="https://gradle.org/"><img src="images/logos/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="images/logos/Allure.svg" width="50" height="50"  alt="Allure"/></a>
<a href="https://https://qameta.io/"><img src="images/logos/AllureTestOps.svg" width="50" height="50"  alt="AllureTestOps"/></a>
<a href="https://www.jenkins.io/"><img src="images/logos/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>
<a href="https://https://telegram.org/"><img src="images/logos/Telegram.svg" width="50" height="50"  alt="Telegram"/></a>
</p>

---
## Содержание проекта

- <a href="#check"> Реализованные проверки</a>
- <a href="#buildJenkins"> Cборка в Jenkins</a>
- <a href="#exampleReport"> Пример отчета прохождения автотеста</a>
- <a href="#allureReport"> Пример Allure отчета</a>
- <a href="#integrationAllureTO"> Интеграция с Allure TestOps</a>
- <a href="#telegramReport"> Уведомления в телеграм с использованием бота</a>
- [Уведомления в телеграм с использованием бота](#Telegram-Уведомления-в-телеграм-с-использованием-бота)

--- 

<a id="check"></a>
## Реализованные проверки

- ✓ Регистрация пользователя
- - Проверка негативного сценария регистрации
- ✓ Проверка данных пользователя в общем списке пользователей
- ✓ Обновление данных пользователя
- ✓ Удаление пользователя

--- 

<a id="buildJenkins"></a>
## <img src="images/logos/Jenkins.svg" width="25" height="25"  alt="Jenkins"/></a> Сборка [Jenkins](https://jenkins.autotests.cloud/job/Homework20")
<p align="center">
<a href="https://jenkins.autotests.cloud/job/Homework20/"><img src="images/screenshots/JenkinsReport.jpg" alt="Jenkins1"/></a>
</p>
После выполнения сборки, в блоке <code>История сборок</code> напротив номера сборки появятся 
значки <code>Allure Report</code> и <code>Allure TestOps</code>, при клике на которые откроется страница 
с сформированным html-отчетом и тестовой документацией соответственно.

--- 

<a id="exampleReport"></a>
## 🤖 Пример отчета прохождения автотеста
<p align="center">
<img title="AllureSuite" src="images/screenshots/Allure.jpg">
</p>

--- 

##  Запуск тестов из терминала
Команда запуска тестов:
```
gradle clean test
```
<a id="allureReport"></a>
## <img width="4%" style="vertical-align:middle" title="Allure Report" src="images/logos/Allure.svg"> </a> Пример [Allure-отчета](https://jenkins.autotests.cloud/job/Homework20/3/allure/) 
## ⛅: Основной отчет
<p align="center">
<img title="Allure Overview" src="images/screenshots/AllureReport.jpg">
</p>

--- 

<a id="integrationAllureTO"></a>
## <img src="images/logos/AllureTestOps.svg" width="25" height="25"  alt="Allure_TO"/></a> Интеграция с  [Allure testOps](ttps://allure.autotests.cloud/project/3795/dashboards)

## Доска
На *Dashboard* в <code>Allure TestOps</code> видна статистика количества тестов. Новые тесты, а так же результаты прогона приходят по интеграции при каждом запуске сборки.

<p align="center">
<img title="Allure TestOps DashBoard" src="images/screenshots/AllureTO.jpg">
</p>

--- 

##  Пример тест-кейса
<p align="center">
<img title="AllureTC" src="images/screenshots/AllureTOtestCase.jpg">
</p>

--- 

## 🏃 Запуски
<p align="center">
<img title="Allure Tests" src="images/screenshots/AllureTOrunning.jpg">
</p>

--- 

<a id="telegramReport"></a>
## <img src="images/logos/Telegram.svg" width="25" height="25"  alt="Telegram"/></a> Уведомления в телеграм с использованием бота
После завершения сборки специальный бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с отчетом пройденых тестов.

<p align="center">
<img title="telegram" src="images/screenshots/TelegramAllert.jpg">
</p>
