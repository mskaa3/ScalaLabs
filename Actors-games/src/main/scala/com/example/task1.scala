
package com.example

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import akka.event.{Logging, LoggingAdapter}

import scala.util.Random
case class Players(myBall : Ball,person1: ActorRef,person2 : ActorRef )
case class Ball(number : Int)
case class PingPong(person: ActorRef, result: Int)
object main extends App {
  val system = ActorSystem("WelcomeSystem")
  var actorReq = system.actorOf(Props(actor()), name = "welcomeActor")
  actorReq ! "Rick"
  actorReq ! "Morty"
  actorReq ! "Nicolaus"
  actorReq ! "Milo"
  Thread.sleep(1000)
  val newSystem = ActorSystem("pingPongGame")
  var pingGame = system.actorOf(Props(actor()), name = "pingPong")
  var person1 = newSystem.actorOf(Props(actor()), name = "person1")
  var person2 = newSystem.actorOf(Props(actor()), name = "person2")
  person1 ! PingPong(person2, 0)
  Thread.sleep(10000)
  val anotherSystem = ActorSystem("BallGame")
  var ballGame = anotherSystem.actorOf(Props(actor()), name = "ballGame")
  var newperson1 = anotherSystem.actorOf(Props(actor()), name = "Person1")
  var newperson2 = anotherSystem.actorOf(Props(actor()), name = "Person2")
  var newperson3 = anotherSystem.actorOf(Props(actor()), name = "Person3")
  newperson1 ! Players(Ball(0),newperson2,newperson3)
Thread.sleep(20000)

system.terminate()
}
//==========================================================================================================================
case class actor() extends Actor {
  val loggingAdapter: LoggingAdapter = Logging(context.system, this)
  val random = List(1,2)
  override def receive: Receive = {
     //reaction only if the name passed matches the given one
    case "Rick" => loggingAdapter.info("Hi Rick");
    case "Morty"  =>loggingAdapter.info("What's up Morty" )
    case "Nicolaus"  =>loggingAdapter.info("Oh, dear Santa!" )



      //the game between two players. Either one scores or misses the ball, the game finishes while the sum
      //of points is 10. Sum increasing when player hits, stays constant while missing the ball.
      //Recursive call with change of passed parameters
    case PingPong(person: ActorRef, sum: Int) =>

      if (sum< 10) {
        if (random.apply(Random.nextInt(random.size)) == 1) {
          loggingAdapter.info(person.path.name + " misses the ball, the result is " + sum)
          person ! PingPong(this.self, sum)
          Thread.sleep(1000)
        } else {
          loggingAdapter.info(person.path.name + " hits, scores and changes the result to " + (sum + 1))
          person ! PingPong(this.self, 1 + sum)
          Thread.sleep(1000)
        }
      } else if (sum == 10) {
        loggingAdapter.info(this.self.path.name + " ends the game with " + sum)
        context.system.terminate()
      }


    //the game between three players. Either one passes the ball to the randomly chosen next one, after passing it
      //10 times game finishes. Similarly as in the previous task solved with a recursive call with changed parameters(sum,players)
    case Players( myBall: Ball,person1: ActorRef,person2 : ActorRef ) =>
      if (myBall.number < 10) {loggingAdapter.info(this.self.path.name+ " catches. Result is: " + (myBall.number + 1).toString)
        Thread.sleep(1000)

        if(random.apply(Random.nextInt(random.size)) ==1) person1 ! Players(Ball(myBall.number + 1),person2, this.self)
        else person2 ! Players(Ball(myBall.number+ 1),person1, this.self)
      }else{
        loggingAdapter.info("Game finished")
        context.system.terminate()
      }

    case _ => "Unknown command"//handling case of uknown name or command
  }

}





