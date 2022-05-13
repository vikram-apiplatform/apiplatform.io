OkHttpClient client = new OkHttpClient().newBuilder().build();
Request request = new Request.Builder()
.url("https://api.github.com/user/repos")
.method("GET", null)
.build();
Response response = call.newCall(request).execute();