package com.simpleapi.modules

import com.twitter.finatra.http.annotations.RouteParam

case class UserRequest(@RouteParam id: Long, @RouteParam name: String)
