OkHttpClient client = new OkHttpClient().newBuilder().build();
MediaType mediaType = MediaType.parse("text/plain")
RequestBody body = RequestBody.create(mediaType, "")
Request request = new Request.Builder()
.url("https://dev-vikram.gateway.apiplatform.io/v1/gitHub/bulkinsert")
.method("POST", null)
.addHeader("pkey" , "3fbbb8bc5a969f503fdb66e7d90509d6")
.addHeader("apikey" , "7xR2sYhqRAdfhhyu6jMo9E9hi4fRazuw")
.addHeader("Content-Type" , "application/json")
.build();
Response response = call.newCall(request).execute();