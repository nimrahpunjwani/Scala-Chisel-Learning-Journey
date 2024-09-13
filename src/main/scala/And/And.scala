package And

import chisel3._

class AND  extends Module{
  //extend key is for inheritance
//module is a class in chisel
  //gate will always be a derived class of parent class
  val io = IO(new Bundle{
    val a = Input(UInt(1.W))
      //1 tells that 1 bit ka input hai and w represents width hai
    val b= Input(UInt(1.W))

    //for output

    val c = Output(UInt(1.W))
  })
  //io is function
  //new keyword likhne se object banta hai
  //:= represents connection and wiring

 io.c := io.a & io.b
  //wo code jo module ko call karata hai is called test batch



}
