package com.simpleapi

import com.google.inject.Module
import com.simpleapi.controller.UserController
import com.simpleapi.modules.RedisClientModule
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
  override val modules: Seq[Module] =
    Seq(RedisClientModule)

  override def configureHttp(router: HttpRouter): Unit = {
    router
      .filter[LoggingMDCFilter[Request, Response]]
      .filter[TraceIdMDCFilter[Request, Response]]
      .filter[CommonFilters]
      .add[UserController]
  }
}
