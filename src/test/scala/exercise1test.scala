package exercise1
import chisel3._
import chiseltest._
import org.scalatest._
class exercise1Test extends FreeSpec with ChiselScalatestTester {
  "exercise1" in {
    test(new exercise1(4) {
      // val dut = Module(new exercise1(4)) // instantiate the design module
      dut.io.result.expect(false.B) // check that result is 0
      for (i <- 0 until 16) { // run for 16 cycles
        dut.clock.step(1)
      }
    }) { _ => }
  }
}
