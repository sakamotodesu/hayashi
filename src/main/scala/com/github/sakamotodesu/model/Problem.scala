package com.github.sakamotodesu.model

/**
  * Created by sakamotominoru on 2016/06/28.
  */
case class Problem(id: String, game: Game, answer: String, commentary: String)

case class Game(player1: Player, player2: Player, rule: Rule, dice: (Int, Int))

case class Rule(bareOffToTheLeft: Boolean)

case class Player(name: String, position: Position, isNext: Boolean, cube: Int)

case class Position(checkers: List[Int]) {
  def pip = 0
}
