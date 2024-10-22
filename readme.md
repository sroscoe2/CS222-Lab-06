# Programming II

## Lab 6: Linked Lists

In this lab, you will implement some more advanced linked list operations, union and intersection.

# Instructions

1. Clone this lab from Github. Use this link: <https://github.com/sroscoe2/CS222-Lab-06.git> Refer to Lab 1 if you need a refresher for how to do so. If possible: when importing, name your folder `firstnameLI-CS222-Lab-06`

## LL.java

2. Open `LL.java`. Most of the class has been defined for you, with some additional methods not discussed in class. Review this class to familiarize yourself with the new methods. **Write what is new in a multi-line comment at the top of the LL class**

3. [Explanation](#union) [Hints](#union-hints) Implement `union()`.

4. [Explanation](#intersection) [Hints](#intersection-hints) Implement `intersect()`.

5. Run the JUnit tests in `ComputerListTests.java` and ensure all test cases pass.

## Finishing Up

6. [Explanation](#turning-in) Zip your project folder and turn it in to Canvas.

# Explanations

## Union

The *union* of two collections `A` and `B` produces a collection that has all the elements in `A`, plus all the elements in `B`. Any element in common is retained, but not duplicated.

<p align="center">
<img src="images/union.png" alt="Visual representation of a union of two sets" width="50%">
</p>

Let's look at an example:

```
A = [1, 2, 3, 4]
B = [2, 3, 5, 6]
A union B = [1, 2, 3, 4, 5, 6]
```

And another:

```
A = [1]
B = [5, 6, 7, 8]
A union B = [1, 5, 6, 7, 8]
```

[Go back to the instructions](#lljava)

### Union Hints

Here are some hints to get you started:

Your job is to modify the `LL<T>` class, by computing the **union** of `this` list with another list, called `b`. You should modify the list *in-place*; that is, any elements in `b` not seen in `this` should be added to `this`.

1. **Draw pictures.** Drawing pictures is an essential component for learning these topics. For every picture you draw relevant to this lab, I will give you 1 pt extra credit.
2. You might want to iterate through `b` to find any elements not found in `this`.
3. `find()` is your friend!

*Note:* In actuality, doing the union of a set containing duplicates would remove the duplicates. Such as `A = [1, 1]`, `A union A = [1]`. However, this is a more difficult problem, so for now you do not have to consider this case.

[Go back to the instructions](#lljava)

## Intersection

The *intersection* of two collections `A` and `B` produces a collection that has only the elements both `A` and `B` have in common. Any element that is held by only one of the sets is not retained. If no elements are in common, the result is an empty collection.

<p align="center">
<img src="images/intersection.png" alt="Visual representation of a intersection of two sets" width="50%">
</p>

Let's look at an example:

```
A = [1, 2, 3, 4]
B = [2, 3, 5, 6]
A intersect B = [2, 3]
```

And another:

```
A = [1]
B = [5, 6, 7, 8]
A intersect B = []
```

[Go back to the instructions](#lljava)

### Intersection Hints

Here are some hints to get you started:

Your job is to modify the `LL<T>` class, by computing the **intersection** of `this` list with another list, called `b`.

You should modify the list *in-place*.
Any elements not in both `b` and `this` should be removed from `this`.

1. **Draw pictures.** Drawing pictures is an essential component for learning these topics. For every picture you draw relevant to this lab, I will give you 1 pt extra credit.
2. You might want to iterate through `this`, and see if you can find any elements not in `b`.
3. Like before, `find()` is your friend!

[Go back to the instructions](#lljava)

## Turning In

Zip your entire project file and submit the zip file to Canvas. To aid in grading, please name or re-name your project folder & zip file `firstnameLI-CS222-Lab-06.zip`

Since my first name is Sarah and my last initial (I only have one, add more as needed) is R, my lab would be named `sarahR-CS222-Lab-06`.

Thanks for your cooperation, this helps cut down on grading time!

[Go back to the instructions](#finishing-up)
