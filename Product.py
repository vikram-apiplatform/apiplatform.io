from flask import Flask, request, json, Response
from pymongo import MongoClient


app = Flask(__name__)

class product:
    def __init__(self, data):
        self.client = MongoClient("mongodb://localhost:27017/")
        database = 'mongodbdevvikram'
        collection = 'product'
        cursor = self.client[database]
        self.collection = cursor[collection]
        self.data = data

    def insert_data(self, data):
        new_document = data['document']
        response = self.collection.insert_one(new_document)
        output = {'Status': 'Successfully Inserted',
                  'Document_ID': str(response.inserted_id)}
        return output

    def read(self):
        documents = self.collection.find()
        output = [{item: data[item] for item in data if item != '_id'} for data in documents]
        return output

    def update_data(self):
        filter = self.data['condition']
        updated_data = {"$set": self.data['DataToBeUpdated']}
        response = self.collection.update_one(filter, updated_data)
        output = {'Status': 'Successfully Updated' if response.modified_count > 0 else "Nothing was updated."}
        return output

    def delete_data(self, data):
        filter = data['condition']
        response = self.collection.delete_one(filter)
        output = {'Status': 'Successfully Deleted' if response.deleted_count > 0 else "Document not found."}
        return output


@app.route('/Product', methods=['GET'])
def read_data():
    # sample request payload { }
    data = {}
    read_obj = product(data)
    response = read_obj.read()
    return Response(response=json.dumps(response), status=200,
                    mimetype='application/json')


@app.route('/Product', methods=['POST'])
def create():
    # sample request payload { 'document':{ data } }
    data = request.json
    if data is None or data == {} or 'document' not in data:
        return Response(response=json.dumps({"Error": "Please provide connection information"}),
                        status=400, mimetype='application/json')
    create_obj = product(data)
    response = create_obj.insert_data(data)
    return Response(response=json.dumps(response), status=200,
                    mimetype='application/json')

@app.route('/Product', methods=['PUT'])
def update():
    # sample request payload { 'database':'demo', 'collection':'demo', 'condition':{ 'id':1 }, 'DataToBeUpdated':{ data to be updated } }
    data = request.json
    if data is None or data == {} or 'condition' not in data:
        return Response(response=json.dumps({"Error": "Please provide connection information"}),
                        status=400, mimetype='application/json')
    update_obj = product(data)
    response = update_obj.update_data()
    return Response(response=json.dumps(response), status=200,
                    mimetype='application/json')

@app.route('/Product', methods=['PATCH'])
def update_one():
    # sample request payload { 'database':'demo', 'collection':'demo', 'condition':{ 'id':1 }, 'DataToBeUpdated':{ data to be updated } }
    data = request.json
    if data is None or data == {} or 'condition' not in data:
        return Response(response=json.dumps({"Error": "Please provide connection information"}),
                        status=400, mimetype='application/json')
    update_obj = product(data)
    response = update_obj.update_data()
    return Response(response=json.dumps(response), status=200,
                    mimetype='application/json')


@app.route('/Product', methods=['DELETE'])
def delete():
    # sample request payload { 'database':'demo', 'collection':'demo', 'condition':{ 'id':1 } }
    data = request.json
    if data is None or data == {} or 'condition' not in data:
        return Response(response=json.dumps({"Error": "Please provide connection information"}),
                        status=400, mimetype='application/json')
    delete_obj = product(data)
    response = delete_obj.delete_data(data)
    return Response(response=json.dumps(response), status=200,
                    mimetype='application/json')

if __name__ == '__main__':
    myclient = MongoClient("mongodb://localhost:27017/")
    mydb = myclient["mongodbdevvikram"]
    collection_list = mydb.list_collection_names()
    if 'product' not in collection_list:
        mydb.create_collection(name='product',
                             validator={"$jsonSchema": {
                                 "bsonType": "object",
                                 "required": ["Product_ID","Product_Name","Product_Price"],
                                 "properties": {
                                     "Product_ID": {
                                         "bsonType": "Integer",
                                     },
                                     "Product_Name": {
                                         "bsonType": "String",
                                     },
                                     "Product_Price": {
                                         "bsonType": "String",
                                     },
                                     
                                 }
                             }},
                             validationAction="error",)
    print('collection list ',mydb.list_collection_names())
    app.run(debug=True, port=5000)