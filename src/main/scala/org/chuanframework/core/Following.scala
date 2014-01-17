package org.chuanframework.core

trait Follower extends Identifiable {

  def follow(obj: Followable) : Void

  def unfollow(obj: Followable) : Void
  
}

trait Followable {

  def followedBy(follower: Follower) : Void

  def unfollowedBy(follower: Follower) : Void
  
}