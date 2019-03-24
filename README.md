### Строки запуска maven

1.0 Запуск тестов на браузере хром с командной строки\
 ```mvn test -Dtest=WebTesting,WebTesting2 -Dbrowser=chrome verify```

1.1 Запуск тестов в случайном браузере\
 ```mvn test -Dtest=WebTesting,WebTesting2 verify```