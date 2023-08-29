# Процедура запуска автотестов.

## Установка дополнительного ПО

### IntelliJ IDEA

1. Открыть [страницу](https://www.jetbrains.com/idea/download/?section=windows) IntleIj.
2. Скачать и установить IntelliJ IDEA Community Edition.
3. Открыть программу и в настройках во вкладке плагины найти и устаноовить плагин "Docker".

### Docker Desktop

1. Открыть [страницу](https://www.docker.com/products/docker-desktop/) Docker Desktop.
2. Скачать и установить.

## Настройка ПО для тестирования.

1. Открыть Docker Desktop.
2. Открыть InteliJ.
3. Открыть вкладку "Services".
4. Во вкладке "Images" в строке "Image to pull" ввести "docker pull mysql:8.1" и нажать "Pull".
5. В терминале ввести "Docker-compose up".
6. В терминале ввести "-java jar aqa-shop.jar".

## Тестирование

В InteliJ нажать два раза Ctrl и ввести "gradlew test allureReport".