import com.simpleapi.SampleApiServer
import com.twitter.finagle.http.Status
import com.twitter.finatra.http.EmbeddedHttpServer
import com.twitter.inject.server.FeatureTest

class SimpleApiFeatureTest extends FeatureTest {

  override val server = new EmbeddedHttpServer(new SampleApiServer)

  /* Tests */

  test("SampleApi# get all users") {
    server.httpGet(
      path = "/auser",
      andExpect = Status.Ok,
      withBody = """[{
          "id": "name"
                }]"""
    )
  }

  test("SampleAPI# Post a user") {
    server.httpPost(
      path = "/auser/:name/:id",
      andExpect = Status.Created,
      postBody = """
          |{"id":"1",
          |"name":"somename"
          |}""".stripMargin
    )
  }
  test("SampleAPI# Update") {
    /*
    verify a user is in database
   */
  }
}
