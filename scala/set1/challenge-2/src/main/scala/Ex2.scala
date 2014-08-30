package ex2

object Ex2 {
	def xor(hexStr1: String, hexStr2: String) = {
		List(hexStr1, hexStr2).map(_.grouped(1).toList.
			map(Integer.parseInt(_, 16)))
				match {
					case x1::x2::Nil => (x1 zip x2).map(tuple => tuple._1 ^ tuple._2).
																map(_.toHexString).mkString
					case _					 => throw new IllegalArgumentException("Bad params")
				}
	}
}
