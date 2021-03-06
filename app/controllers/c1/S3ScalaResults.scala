package controllers.c1

import play.api.mvc._

/**
 * Created by trydofor on 7/1/15.
 * @see https://playframework.com/documentation/2.4.x/ScalaResults
 * @see https://github.com/playframework/playframework/blob/2.4.x/documentation/manual/working/scalaGuide/main/http/code/ScalaResults.scala
 */

class S3ScalaResults extends Controller {

  val a0 = Action {
    val list = Seq(
      "/c1/1-3-a1",
      "/c1/1-3-a2",
      "/c1/1-3-a3",
      "/c1/1-3-a4",
      "/c1/1-3-a5",
      "/c1/1-3-a6",
      "/c1/1-3-a7"
    )

    Ok(views.html.list("1.3.Manipulating results", list))
  }

  val a1 = Action {
    Ok("Hello World!")
  }

  val a2 = Action {
    Ok(<message>Hello World!</message>)
  }

  val a3 = Action {
    Ok(<h1>Hello World!</h1>).as("text/html")
  }

  val a4 = Action {
    Ok(<h1>Hello World!</h1>).as(HTML)
  }

  val a5 = Action {
    Ok("use `F12` to debug network").withHeaders(
      CACHE_CONTROL -> "max-age=3600",
      ETAG -> "xx")
  }

  val a6 = Action {
    val result = Ok("use `F12` to debug network")
    result.withCookies(Cookie("theme", "blue"))
      .discardingCookies(DiscardingCookie("skin"))
  }

  def a7 = Action {
    implicit val myCustomCharset = Codec.javaSupported("iso-8859-1")
    Ok(<h1>use `F12` to debug network</h1>).as(HTML)
  }
}
