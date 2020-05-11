package com.sampleapi.controller
import com.twitter.finagle.http.Request
import com.twitter.finatra.http._

class SampleApiController extends Controller {
  get("/") { request: Request =>
    "<h1>Hello, world!</h1>"
  }
}
