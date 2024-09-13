object Assignment2 {
  //Answer 1
  def main(args: Array[String]): Unit = {
    //Write a skala program that implements the function y = ax² + bx + c
    // where a = 3 b = 5 and
    // c equals to 7
    // create list of integers in the range - 3 lesser than equal to X
    // lesser than equal to 3 and
    // use the defined function to map its payment to another list in the map list
    // and verify the result
    val a = 3
    val b = 5
    val c = 7
    val x = 2
    //    //For Quadratic
    //    //for value of x
    //    import scala.math.sqrt
    //    val x1 = (-b + sqrt(b * b - 4 * a * c)) / 2 * a
    //    val x2 = (-b - sqrt(b * b - 4 * a * c)) / 2 * a

    //for y
    val y = a * (x * x) + b * x + c
    //val y2 = a * (x * x) + b * x + c

    //Question 1 part II
    val myList = (-3 to 3).toList

    //Question 1 Part III
    val mappedList = myList.map(x => x)

    //Zip the two lists created in Exercise 1 and
    // then zip the resulting list with its index.
    // A list with three elements per pair is created in the following format: (2, f(x), index).
    // Find the mean value of f(x) and store the respective pair to a variable mean.
    // Refer to Listings 10.11, 10.16 and 10.21 for possible hints.

    //QUESTION 2 PT I
    val zippedList = myList.zip(mappedList)
    //QUESTION 2 PT II
    val zippedwithindex=  zippedList.zipWithIndex
    //QUESTION 2 PT III
    val zippedlist = myList.map(x => (2, x * x, myList.indexOf(x)))
    //QUESTION 2 PT IV
    val meanFx = zippedlist.map(_._2).sum / zippedlist.length
    val mean = (2, meanFx, -1)


    //    Write a Scala code that takes in a vector as an integer list
    //    and calculates its Euclidean norm.
    //    Recall that this is also termed as the magnitude of a vector
    //    and is evaluated as given below.














    // Print results
    println("The calculated value of x is " + x)
    //println("The calculated value of x2 is " + x)
    println("The calculated value of y is " + y)
    //println("The calculated value of y2 is " + y2)
    println(myList)
    println(mappedList)
    println(zippedList)
    println(zippedwithindex)
    println(zippedlist)
    println(mean)
    println(meanFx)


  }
}



