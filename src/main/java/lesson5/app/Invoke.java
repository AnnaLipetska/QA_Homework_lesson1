package main.java.lesson5.app;

public class Invoke {
    public static void main(String[] args) {
        Server server = new Server();
        System.out.println(server.getUsers());

        // Допустим мы хотим запустить наше приложение - метод Invoke и у нас нет Idea.
        // В Idea можно на зеленый треугольник нажать.
        // Не через Идею, а через консоль - просто написать java Invoke - не получится, т.к. код не
        // скомпилирован. Сначала нужно выполнить компиляцию - написать javac и путь.
        // Строка запуска увеличивается до невероятных размеров, т.к. в нее нужно записывать кучу
        // разных параметров
        // Всю эту строчку решили запихивать в bat-файл и запускать уже bat-файл.
        // bat-файл - это исполняемый файл
        // Можно создать файл Hello.bat, зараннить его в консоли и он выполнит эту команду
        // javac + длинная строка с параметрами.\
        // На Виндоус работает, на Линукс батники не запускаются, т.к на Линуксу есть sh-файлы.

        // A shell script or sh-file is something between a single command and a (not necessarily)
        // small programm.

        // Могут также не совпасть команды, т.к. как минимум разделители файловой системы различаются.

        // На помощь пришел такой замечательный инструмент, который называется Maven - по сути менеджер
        // сборки проектов и менеджер зависимостей. Для облегчения компилляции проекта. Позволяет очень
        // удобно, одной командой буквально собирать проект.
        // Пишем в консоли
        // mvn package
        // Весь проект спакуется в jar-файл
        // Под капотом выполнится огромное количество команд, таких как компилирование, перенесение
        // файлов из одной директории в другую, скачивание, возможно, каких-то зависимостей, прогон
        // тестов.
/////////////////////////////
// Как протестировать метод getUsers() в приложении Invoke?
        // Первый вариант:
        String actual = server.getUsers();
        // String expected = "Vova, Andrey, Alexandr"; //В таком случае у нас тест пройдет
        String expected = "Vova, Andrey, Alexandr---------"; // Тест завалится
        if (!actual.equals(expected)) {
            System.out.println("Test failed");
            // Можно считать, что мы написали автотест
            // Покрыли юнит-тестами поведение этого метода
            // На самом деле методов может быть тысячи
            // Тестов может быть десятки
            // Все писать в консоль, сигнализировать программисту в консоль, где тест упал, где не упал -
            // естественно, что ту консоль никто не читает, будут целые полотна этого всего, никто не будет
            // туда заглядывать. Т.е. первый вариант - ерунда.
            // Вариант 2:
            throw new Error(); // В консоли увидим сообщение об ошибке красным цветом
            // Проблема этого подхода, что если мы будем реализовывать какую-то тестовую логику дальше,
            // то все, что мы здесь исполним :
        }
        System.out.println("After error"); // оно не будет исполняться
        // После того, как выбрасывается ошибка, весь остальной код перестает исполняться
        // Нам нужно отдельные такие блоки оборачивать в какие-то отдельные атомарные тест-кейсы и
        // выбрасывать ошибку каким-то таким образом чтобы она не влияла на другие блоки.
        // За нас уже решили эту проблему и написали библиотеку - тестовый раннер.
    }
}
