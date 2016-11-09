import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.sql.SparkSession

/**
  * Created by mtustanovskyy on 11/9/16.
  */
object Main {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("DiplomaNeuralClassification").setMaster("local").set("spark.executor.memory", "2g")
    val sc = new SparkContext(conf)

    val spark = SparkSession
      .builder()
      .getOrCreate()

    import spark.implicits._

    // Apply the schema to the RDD
    val df = spark.sparkContext.textFile("my_sample_train.csv").map(_.split(","))
      .toDF()

    df.show()
  }

}
