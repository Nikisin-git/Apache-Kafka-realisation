Задание 06 
1. Реализуйте для добавления одной из сущностей вашего задания паттерн CQRS:  
a. сервис вместо записи в базу данных должен сохранять сообщение в topic 
kafka (допускается одновременное сохранение сущности в кеш Redis – 
шаблон сквозная-запись) 
b. реализуйте отдельный контейнер, который считывает сообщения из 
topic kafka и сохраняет их в базу данных 
2. Актуализируйте модель архитектуры в Structurizr DSL 
3. Ваши сервисы должны запускаться через docker-compose командой docker
compose up (создайте Docker файлы для каждого сервиса) 