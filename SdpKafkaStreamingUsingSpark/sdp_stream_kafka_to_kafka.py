import time
from pyspark.sql import SparkSession

spark = SparkSession.builder.master("local").getOrCreate()

df = spark \
    .readStream \
    .format("kafka") \
    .option("kafka.bootstrap.servers", "path-to-kafka-server") \
    .option("subscribe", "idrac") \
    .option("startingOffsets", "latest") \
    .option("kafka.group.id", "sdp-spark-reader-application") \
    .option("enable.auto.commit", True) \
    .load()

values = df.selectExpr("CAST(value AS STRING)").writeStream \
    .queryName("vsphere") \
    .format("memory") \
    .start()

time.sleep(10)

values.stop()

results=spark.sql("select * from vsphere")
results.show(500,truncate=False)

df.selectExpr("CAST(key AS STRING)", "CAST(value AS STRING)") \
    .writeStream \
    .format("kafka") \
    .outputMode("append") \
    .option("kafka.bootstrap.servers", "path-to-kafka-server") \
    .option("topic", "spark-stream") \
    .option("checkpointLocation", "/tmp/") \
    .start() \
    .awaitTermination()