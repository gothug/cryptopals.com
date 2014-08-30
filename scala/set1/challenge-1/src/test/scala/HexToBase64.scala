package ex1

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TestSuite extends FunSuite {
  import Ex1.hexToBase64

  test("hexToBase64: convert hex string to base64") {
    assert(
    	hexToBase64(
    		"49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69" +
    			"736f6e6f7573206d757368726f6f6d") ===
    	"SSdtIGtpbGxpbmcgeW91ciBicmFpbiBsaWtlIGEgcG9pc29ub3VzIG11c2hyb29t")
  }
}
