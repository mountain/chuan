package org.chuanframework.core

trait Identifiable {

  def kind(): String

  def id(): String
  
}