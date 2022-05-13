import mysql.connector
mydb = mysql.connector.connect(host="localhost",user="yourusername",password="yourpassword",database="mydatabase")
mycursor = mydb.cursor()
mycursor.execute("CREATE TABLE company(name VARCHAR(100),email VARCHAR(50),)
mycursor.execute("SELECT * FROM company")
myresult = mycursor.fetchall()
for x in myresult:
   print(x)