# line-read-parser

### context.user
id, name, password

### dao.UserDao
abstract class
- abtract getConnection()
- add() : sql에 insert
- get() : select문 구현

### dao.AWSUserDaoImpl
extends UserDao
- getconnection : aws 서버의 sql과 connect
