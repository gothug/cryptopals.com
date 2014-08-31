package ex3

object Ex3 {
  def scoreCharacter(c: Char) =
    if (c >= 'a' && c <= 'z' || c == ' ') 1
    else if (c >= 'A' && c <= 'Z') 0.3
    else if (c >= '0' && c <= '9') 0.2
    else if (c == ',' || c == ''') 0.1
    else 0

  def scoreCharText(txt: List[Char]) = txt.map(scoreCharacter).reduce(_ + _)

  def main(args: Array[String]) {
      val encStr =
        "1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736"

      val r = (0 to 255).map {
        byte => {
          val charTxt =
            encStr.grouped(2).toList.map(Integer.parseInt(_, 16)).
              map(_ ^ byte).map(_.toChar)

          (byte, byte.toChar, scoreCharText(charTxt), charTxt.mkString)
        }
      }.sortWith(_._3 > _._3)

      r.take(1).foreach(println)

      //Answer found: the text was encoded with character 'X'

      //You now have our permission to make "ETAOIN SHRDLU" jokes on Twitter.
      val jokesTypeEncoded = "ETAOIN SHRDLU"

      val jokesType = jokesTypeEncoded.toList.
        map((c: Char) => (c.toInt ^ 'X'.toInt).toChar).mkString

      println("'" + jokesType + "'")
  }
}
