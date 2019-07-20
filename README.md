# springboot-ehcache

## Introduction to Caching

Caching represents a mechanism to increase system performance by storing the recently used data items by reducing database trips. It acts as a temporary memory present between application and database. In general, there are four types of caches i.e.

* In-memory caching
* Database caching
* Web server caching
* CDN caching

## Caching annotations in spring boot

Following annotations are used in a spring boot application.
1. `@EnableCaching`: This annotation enables the caching capability in a spring boot application
2. `@Cacheable`: This method level annotation tells the spring framework to make the method response is cacheable
3. `@CachePut`: This annotation updates the cache before the method execution
4. `@CacheEvict`: This annotation removes the specific key from the cache. If developers want to remove all the entries from the cache they can use the allEntries=true attribute

Now, open the your favorite IDE and let’s see how to implement this tutorial in spring boot.


## Project Demo

1. Clone the repo:
```
git clone https://github.com/hendisantika/springboot-ehcache.git
```

2. Go yo your folder: `cd springboot-ehcache`

3. Run the application: `mvn clean spring-boot:run`

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