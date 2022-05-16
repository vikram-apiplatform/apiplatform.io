import pymongo
myclient = pymongo.MongoClient("mongodb://root:pass@localhost:27017/")
mydb = myclient["mydatabase"]
print(Database List :)
print(mydb.list_database_names())
mycol = mydb["github"]
print(Collection List :)
print(mydb.list_collection_names())
mydict = { "account" : "", "partner" : "", "access_token" : "", "repository" : "", }
post = mycol.insert_one(mydict)
print(post.inserted_id)
get = mycol.find_one()
print(get)
