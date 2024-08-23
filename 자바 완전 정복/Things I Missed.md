## Ch5. Array
### Array Creation
Array is an object. So `new` is used to create an array.  
And thus it is in heap.
### Array Iteration
1. For each: Through `for(<data type> <variable name> : <array name>)`, I can access each element via `<variable name>`.
1. toString: `Arrays.toString()` prints the entire array.

## Ch7. Components of Class
### Variable Length Parameter
Parameters can be a variable length array. It is noted as `<data type>...`, which is same as `<data type>[]`.
Actually, main function has this signature.
However, the argument doesn't have to be an array object. `sum(1, 2, 3)` for `sum(int... arr)` is possible.
### `this()` Constructor
To prevent the repitition of the same code in constructors, `this()` can be used in the first line in another constructor. (same for `super()`)

## Ch9. Modifiers
### Public/Protected/Default/Private
It is sth like same package + α(any class/descendants/no/no in other packages), except for private.
### Static
I can initialize static values with `static {}`.

