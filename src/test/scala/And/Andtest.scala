package And
import chisel3._
import chiseltest._
import org.scalatest._

  class ANDtest  extends FreeSpec with ChiselScalatestTester {
    "AND Gate" in {
      test(new AND()) { v=>
        v.io.a.poke(0.U)
        v.io.b.poke(1.U)
        v.clock.step(1)
        v.io.c.expect(0.U)


      }
    }



}
 