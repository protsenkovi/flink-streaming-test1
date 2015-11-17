import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment
import org.apache.flink.streaming.api.windowing.time._
import org.apache.flink.api.scala._ 

object Main {
  def main(args: Array[String]) {
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    val text = env.socketTextStream("localhost", 9999)

    val words = text.flatMap{ x => x.split(" ") }
    val count = words.map{x => (x, 1) }.keyBy(0).timeWindow(Time.of(5, TimeUnit.SECONDS)).sum(1)

    count.print

    env.execute("Window Stream wordcount")
  }
}
