
import scala.collection.mutable
object Assignment1 {
  
  //Answer 1
  def main(args: Array[String]): Unit = {
    //methode 1
    var a = Array(1, 2, 3, 4, 5)
    println(a.mkString(", "))

    //method 2
    var b = Array.apply(6, 7, 8, 9, 10)
    println(b.mkString(", "))
    //method 3
    var c = Array.range(11, 16)
    println(c.mkString(", "))

    //Set and Map collections can also be mutable.
    // Figure out how to make them mutable.

    var mySet = scala.collection.mutable.Set[Int]()
    mySet += 1
    mySet += 2
    mySet += 3
    println(mySet)
    //map
    val mutablemap = collection.mutable.Map("x" -> 10, "y" -> 11, "z" -> 12)
    println(mutablemap)


    //Figure out how to use Option type in a function parameter.
    def greet(name: Option[String]): Unit = {
      name match {
        case Some(n) => println(s"Hello, $n!")
        case None => println("Hello, Oops idk your name ughh!!!")
      }
    }

    greet(Some("Nimrah"))
    greet(None)

    //      In this session we saw some methods like .head and .tail that can be applied on Lists and Arrays.
    //        Some of these methods are called higher order methods and we can pass a function in these method as
    //      parameter. Explore the higher order methods available in scala for arrays. This will be helpful in doing task
    //        4 in assignments.
    // 1.Map:
    val arr3 = Array(1, 2, 3)
    val doubled = arr3.map(_ * 2)
    println(doubled.mkString(", "))
    // 2.Filter:
    val arr4 = Array(1, 2, 3, 4, 5)
    val even = arr4.filter(_ % 2 == 0)
    println(even.mkString(", "))

    //      Task-2 Solve the following
    //        Task 1: Generate a list of 15 integer numbers generated randomly from 50 - 500. After making the
    //        complete list check if each element is prime or not, if its a prime number then put it into an iterator. Finally
    //      sort them in ascending order and put them into a Map. Where each key should be the element location
    //        of the number. Bonus point for anyone who does not uses for loop.

    import scala.util.Random
    import scala.collection.mutable

    // Generate a list of 15 random integers between 50 and 500
    val randomList = List.fill(15)(Random.nextInt(451) + 50)

    // Function to check if a number is prime
    def isPrime(n: Int) = (2 to n - 1).forall(n % _ != 0) && n > 1

    // Filter prime numbers and store in an iterator
    val primeIterator = randomList.filter(isPrime).iterator

    // Sort the prime numbers in ascending order and store in a map
    val primeMap = primeIterator.toSeq.sorted.zipWithIndex.map(_.swap).toMap
    println(primeMap)

    //      Task 2: Write a function that returns a List[Char] that contains ’a’-’z’ using tail recursion. The only
    //        argument which is passed to the method is the start alphabet array in ascii i.e 98. Hint: Use toChar to
    //      make this work.

    def CharArray(start: Int): List[Char] = {
      def generate(current: Int, acc: List[Char]): List[Char] = {
        if (current > 122) acc
        else generate(current + 1, (current.toChar :: acc))
      }

      generate(97, List.empty[Char]).reverse
    }

    // Call the function and print the result
    println(CharArray(98))

    //      Task 3: Given two Array[Double] values of the same length, write a function that returns the element-
    //        wise sum. This is a new Array where each element is the sum of the values from the two input arrays at
    //        that location. So if you have Array(1,2,3) and Array(4,5,6) you will get back Array(5,7,9).

    def elementWiseSum(arr1: Array[Double], arr2: Array[Double]): Array[Double] = {
      arr1.zip(arr2).map { case (a, b) => a + b }
    }

    val arr5 = Array(1.0, 2.0, 3.0)
    val arr6 = Array(4.0, 5.0, 6.0)
    val result1 = elementWiseSum(arr5, arr6)
    println(result1.mkString(", "))

    //    Task
    //    4: Code different techniques that will take an
    //    Array[Int] and
    //    return number of even values in the
    //      Array.Each one will use a different technique.To test this on a larger array you can make one using
    //      Array.fill(100)(util.Random.nextInt(100))
    //    1. Use a recursive function.
    //    2. Use the count higher - order method
    // Recursive Function
    def countEvenRecursive(arr: Array[Int]): Int = {
      def helper(i: Int): Int = {
        if (i >= arr.length) 0
        else if (arr(i) % 2 == 0) 1 + helper(i + 1)
        else helper(i + 1)
      }

      helper(0)
    }

    // Count Higher-Order Method
    def countEvenCount(arr: Array[Int]): Int = {
      arr.count(_ % 2 == 0)
    }

    // Test on a larger array
    val largerArray = Array.fill(100)(util.Random.nextInt(100))

    println("Recursive Function: " + countEvenRecursive(largerArray))
    println("Count Higher-Order Method: " + countEvenCount(largerArray))

    //    Task
    //    5: Implement the following function that will build a Map from any sequence of
    //    a
    //    type with a
    //    function that can make keys from values
    //
    //    def buildMap[A, B](data: Seq[A], f: A = > B): Map[B, A] {
    //      // code here
    //    }
    //
    //    where
    //    ‘f
    //    ’is an user defined function which is passed as parameter
    //  .Below is an example of how we
    //    can use buildMap method to make a Map collection.
    //    // Example
    //    val lst = Array(1, 2, 3, 4, 5)
    //
    //    def func(x: Int): Boolean = x % 2 == 0 // entry is even or not
    //
    //    val result = buildMap(lst, func)
    //    // Output
    //    // result : Map [ Int , Boolean ] = Map (1 -> false , 2 -> true , 3 -> false, 4 ->True)

    def buildMap[A, B](data: Seq[A], f: A => B): Map[B, A] = {
      data.map(x => f(x) -> x).toMap
    }

    val lst = Array(1, 2, 3, 4, 5)

    def func(x: Int): Boolean = x % 2 == 0

    val result = buildMap(lst, func)
    println(result) // Output: Map(false -> 5, true -> 4)
  }


  }
