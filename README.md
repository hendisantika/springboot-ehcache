# springboot-ehcache

Project Demo

Open the postman tool and hit the following urls to display the data in the json format.
	
**:: GET PRODUCT BY ID ::**
```
http://localhost:8080/api/product/1
```

**:: DELETE PRODUCT BY ID ::**
```
http://localhost:8080/api/product/15
```

**:: UPDATE PRODUCT BY ID ::**
```
http://localhost:8080/api/product/11/Pancetta
```
Here the first request will be served by the request handler method. This point no data is present with Ehcache. During the subsequent requests, the data will be retrieved from the cache itself. That is all for this tutorial and I hope the article served you whatever you were looking for. Happy Learning and do not forget to share!