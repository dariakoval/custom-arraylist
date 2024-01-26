# Custom implementation of ArrayList
Resizable-array implementation of the ArrayList. \
Each CustomArrayList instance has a capacity. The capacity is the size of the array used to store the elements in the list. As elements are added to an ArrayList, its capacity grows automatically. \
Each CustomArrayList instance has the following operations:
* *boolean* **add** *(T element)* - append the specified element to the end of this list
* *boolean* **addAll** *(CustomArrayList<T> list)* - append all of the elements in the specified collection to the end of this list, in the order that they are returned by the specified collection's Iterator
* *void* **insert** *(int index, T element)* - insert the specified element at the specified position in this list
* *T* **get** *(int index)* - return the element at the specified position in this list
* *boolean* **remove** *(T removedElement)* - remove the first occurrence of the specified element from this list, if it is present
* *T* **remove** *(int index)* - remove the element at the specified position in this list
* *void* **clear** *()* - remove all of the elements from this list
* *int* **getSize** *()* - return the number of elements in this list
* *T[]* **toArray** *()* - return an array containing all the elements in this list in proper sequence (from first to last element)
* *String* **toString** *()* - return a string representation of this list

The CustomArrayListUtil class implements sorting of a CustomArrayList instance.
```java
var list = new CustomArrayList<String>();
// ...
CustomArrayListUtil.sort(list);
```

## Tests and linter status
[![Java CI](https://github.com/dariakoval/custom-arraylist/actions/workflows/generate.yml/badge.svg)](https://github.com/dariakoval/custom-arraylist/actions/workflows/generate.yml)
[![Maintainability](https://api.codeclimate.com/v1/badges/2301f03a611edbc7d5f0/maintainability)](https://codeclimate.com/github/dariakoval/custom-arraylist/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/2301f03a611edbc7d5f0/test_coverage)](https://codeclimate.com/github/dariakoval/custom-arraylist/test_coverage)

## Requirements
* JDK 20
* Gradle 8.3
* GNU Make

## Build
```bash
make build
```

## Test
```bash
make test
```

## Report
```bash
make report
cd build/reports/tests/test
# Open index.html in browser
```

## Linter
```bash
make lint
```

## Javadoc
```bash
make doc
```
