import com.redis.RedisClient
import com.simpleapi.SampleApiServer
import com.twitter.finagle.http.Status
import com.twitter.finatra.http.EmbeddedHttpServer
import com.twitter.inject.server.FeatureTest
import org.mockito.Mockito._
import org.scalatest.mockito.MockitoSugar

class SimpleApiFeatureTest extends FeatureTest with MockitoSugar {

  val mockRedisClient: RedisClient = mock[RedisClient]
  override val server = new EmbeddedHttpServer(new SampleApiServer)
    .bind[RedisClient]
    .toInstance(mockRedisClient)

  /* Tests */

  test("Server Starts") {
    server.assertHealthy(true)
    server.assertStarted(true)
  }

  test("SampleApi# getAllUsers") {
    when(mockRedisClient.hgetall("people"))
      .thenReturn(Some(Map("Zainab" -> "Twitter", "Aisha" -> "School")))
    server.httpGet(
      path = "/auser",
      andExpect = Status.Ok,
      withBody = "{\"Zainab\":\"Twitter\",\"Aisha\":\"School\"}"
    )
  }

//  test("SampleApi# get all users") {
//    server.httpGet(
//      path = "/auser",
//      andExpect = Status.Ok,
//      withBody = """[{
//          "id": "name"
//                }]"""
//    )
//  }
//
//  test("SampleAPI# Post a user") {
//    server.httpPost(
//      path = "/auser/:name/:id",
//      andExpect = Status.Created,
//      postBody = """
//          |{"id":"1",
//          |"name":"somename"
//          |}""".stripMargin
//    )
//  }
  test("SampleAPI# Update") {
    /*
    verify a user is in database
   */
  }
}
