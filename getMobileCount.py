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


@app.route('/getMobileCount', methods=['GET'])
def create():
    data = request.json
    conn = connection()
    cursor = conn.cursor()
    response = cursor.execute("DECLARE   mobile_count NUMBER; BEGIN   SELECT COUNT(DISTINCT email) INTO mobile_count FROM mobile; END;")
    conn.commit()
    conn.close()
    return Response(response=json.dumps(response), status=200,
                    mimetype='application/json')


if(__name__ == "__main__"):
   
    app.run(debug=True, port=5000)
