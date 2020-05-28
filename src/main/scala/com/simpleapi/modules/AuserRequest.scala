package com.simpleapi.modules

import com.twitter.finatra.http.annotations.RouteParam

case class AuserRequest(@RouteParam name: String)
