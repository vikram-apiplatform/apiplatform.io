import mysql.connector
mydb = mysql.connector.connect(host="localhost",user="yourusername",password="yourpassword",database="mydatabase")
mycursor = mydb.cursor()
mycursor.execute("CREATE TABLE app(name VARCHAR(100),)
mycursor.execute("SELECT * FROM app")
myresult = mycursor.fetchall()
for x in myresult:
   print(x)