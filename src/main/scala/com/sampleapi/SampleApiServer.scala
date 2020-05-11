package com.sampleapi

import com.sampleapi.controller.SampleApiController
import com.twitter.finagle.http.{Request, Response}
import com.twitter.finatra.http.{HttpServer, Tls}
import com.twitter.finatra.http.filters.{
  CommonFilters,
  LoggingMDCFilter,
  TraceIdMDCFilter
}
import com.twitter.finatra.http.routing.HttpRouter

object SampleApiServerMain extends SampleApiServer

class SampleApiServer extends HttpServer {
  override def configureHttp(router: HttpRouter): Unit = {
    router
      .filter[LoggingMDCFilter[Request, Response]]
      .filter[TraceIdMDCFilter[Request, Response]]
      .filter[CommonFilters]
      .add[SampleApiController]
  }
}
