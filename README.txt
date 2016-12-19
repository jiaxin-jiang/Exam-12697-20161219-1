db_info:
driverClassName=com.mysql.cj.jdbc.Driver
url=jdbc:mysql://localhost:3306/sakila?&serverTimezone=GMT
username=root
password=123456

attention：
1.url中必须设置serverTimezone=GMT，否则无法连接数据库，使用了dbcp数据库连接池
2.有级联删除的无法级联删除，会提示删除失败；自己插入的数据，可以删除成功！！！

