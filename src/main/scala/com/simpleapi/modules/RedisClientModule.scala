package com.simpleapi.modules

import com.google.inject.{Provides, Singleton}
import com.redis.RedisClient
import com.twitter.inject.TwitterModule

object RedisClientModule extends TwitterModule {
  @Provides
  @Singleton
  def providesredisClient(): RedisClient = {
    //This could change when the server is on another machine.
    new RedisClient("localhost", 6379)
  }
}
