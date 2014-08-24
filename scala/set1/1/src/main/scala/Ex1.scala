package ex1

object Ex1 {
	def hexToBase64(hexStr: String): String = {
		def base64IntToChar(num: Int): Char =
			if (num < 26) ('A' + num).toChar
			else if (num < 52) ('a' + (num - 26)).toChar
			else if (num < 62) ('0' + (num - 26 * 2)).toChar
			else if (num == 62) '+'
			else if (num == 63) '/'
			else throw new NoSuchElementException("Number should be < 64")

		def splitNumInto6BitNums(num: Int): List[Int] = {
			def splitAndAccumulate(num: Int, Nums: List[Int]): List[Int] =
				if (num > 0) splitAndAccumulate(num >> 6, (num & 0x3F) :: Nums) // x & 0x3F - take the lowest 6 bits from number x
				else Nums

			splitAndAccumulate(num, List())
		}

		// split hex string by chunks of 6 hex digits (3 bytes), then processing these chunks
		hexStr.grouped(6).toList.map(Integer.parseInt(_, 16)).
			map(splitNumInto6BitNums).flatten.map(base64IntToChar).mkString
	}
}
