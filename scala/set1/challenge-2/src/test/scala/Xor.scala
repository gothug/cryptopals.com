package ex2

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TestSuite extends FunSuite {
  import Ex2.xor

  test("xor: XOR two hex strings") {
    assert(
    	xor("1c0111001f010100061a024b53535009181c",
    			"686974207468652062756c6c277320657965") ===
      	"746865206b696420646f6e277420706c6179")
  }
}
