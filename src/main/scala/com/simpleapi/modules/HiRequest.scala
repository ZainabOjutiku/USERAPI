package com.simpleapi.modules

import com.twitter.finatra.http.annotations.RouteParam

case class HiRequest(@RouteParam id: Long, @RouteParam name: String)