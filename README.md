kiss-assert [![Build Status](https://travis-ci.org/punkratz312/kiss-assert.svg?branch=master)](https://travis-ci.org/punkratz312/kiss-assert) [![Coverage Status](https://coveralls.io/repos/punkratz312/kiss-assert/badge.svg?branch=master&service=github)](https://coveralls.io/github/punkratz312/kiss-assert?branch=master)
=====================================
Simple stupid assertion framework for java.

### Example usage
```java
public void order(Customer customer) {
	Assert.notNull (customer);
	Assert.notBlank(customer.getId());
	Assert.notBlank(customer.getToken());
	Assert.notEmpty(customer.getOrders());
	
	orderService.order(customer)
}
```

### Characteristics
* nullsafe
* Exceptiontype: IllegalArgumentException

### API
* notNull
	* Object
* notBlank
	* String
* notEmpty
	* String
	* Collection
	* Iterator
* notTrue
	* Boolean
* notFalse
	* Boolean