from flask import Flask, request, redirect ,  json, Response
import pyodbc

app = Flask(__name__)

def connection():
    server = 'myserver'
    database = 'sqlserverdevvikramtest'
    username = 'myusername'
    password = 'mypassword'
    connection_str = 'DRIVER={ODBC Driver 17 for SQL Server};SERVER=' + server + ';DATABASE=' + database + ';UID=' + username + ';PWD=' + password
    conn = pyodbc.connect(connection_str)
    return conn

@app.route('/mobile', methods=['GET'])
def read_data():
    output = []
    conn = connection()
    cursor = conn.cursor()
    cursor.execute("SELECT * FROM phone")
    for row in cursor.fetchall():
        output.append(row)
    conn.close()
    return Response(response=json.dumps(output), status=200,
                    mimetype='application/json')

@app.route('/mobile', methods=['POST'])
def create():
    if request.method == 'POST':
        data = request.json
        conn = connection()
        cursor = conn.cursor()
        response = cursor.execute("INSERT INTO phone (name,email,phone,address,age) VALUES ( data['name'],data['email'],data['phone'],data['address'],data['age'])")
        conn.commit()
        conn.close()
        return Response(response=json.dumps(response), status=200,
                        mimetype='application/json')

@app.route('/mobile', methods = ['PUT'])
def update():
    data = request.json
    cr = []
    conn = connection()
    cursor = conn.cursor()
    if request.method == 'PUT':
        response = cursor.execute("UPDATE phone SET name = ?,email = ?,phone = ?,address = ?,age = ? WHERE name = ?", data['name'],data['email'],data['phone'],data['address'],data['age'],data['name'],)
        conn.commit()
        conn.close()
        return Response(response=json.dumps(response), status=200,
                        mimetype='application/json')
    
@app.route('/mobile', methods = ['DELETE'])
def delete():
    data = request.json
    conn = connection()
    cursor = conn.cursor()
    response = cursor.execute("DELETE FROM phone WHERE name = ?", data['name'])
    conn.commit()
    conn.close()
    return Response(response=json.dumps(response), status=200,
                    mimetype='application/json')

if(__name__ == "__main__"):
    server = 'myserver'
    database = 'mydb'
    username = 'myusername'
    password = 'mypassword'
    connection_str = 'DRIVER={ODBC Driver 17 for SQL Server};SERVER=' + server + ';DATABASE=' + database + ';UID=' + username + ';PWD=' + password
    conn = pyodbc.connect(connection_str)
    cursor = conn.cursor()
    cursor.execute(' CREATE TABLE phone ( name varchar(20) PRIMARY KEY NOT NULL,email varchar(50) NOT NULL,phone int(0) NOT NULL,address varchar(0),age int(0))')
    conn.commit()
    app.run(debug=True, port=5000)
