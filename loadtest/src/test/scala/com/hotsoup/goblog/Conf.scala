package com.hotsoup.goblog

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

object Conf {
  var users = System.getProperty("users", "30").toInt
  var baseUrl = System.getProperty("baseUrl", "http://192.168.99.100:6767")
  var httpConf = http.baseURL(baseUrl)
  var duration = System.getProperty("duration", "240").toInt
}