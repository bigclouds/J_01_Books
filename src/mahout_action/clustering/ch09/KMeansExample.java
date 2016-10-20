package mahout_action.clustering.ch09;

import java.util.ArrayList;
import java.util.List;

import org.apache.mahout.clustering.kmeans.KMeansDriver;
import org.apache.mahout.clustering.kmeans.Kluster;
import org.apache.mahout.common.distance.EuclideanDistanceMeasure;
import org.apache.mahout.math.Vector;

public class KMeansExample {

	public static void main(String[] args) {
		List<Vector> sampleData = new ArrayList<Vector>();

		RandomPointsUtil.generateSamples(sampleData, 400, 1, 1, 3);
		RandomPointsUtil.generateSamples(sampleData, 300, 1, 0, 0.5);
		RandomPointsUtil.generateSamples(sampleData, 300, 0, 2, 0.1);

		int k = 3;
		List<Vector> randomPoints = RandomPointsUtil.chooseRandomPoints(
				sampleData, k);
		List<Kluster> clusters = new ArrayList<Kluster>();

		int clusterId = 0;
		for (Vector v : randomPoints) {
			clusters.add(new Kluster(v, clusterId++, new EuclideanDistanceMeasure()));
		}

//		List<List<Kluster>> finalClusters
//		=KMeansDriver.run(input, clustersIn, output, measure, convergenceDelta, maxIterations, runClustering, clusterClassificationThreshold, runSequential);
//	
//		for (Kluster cluster : finalClusters.get(finalClusters.size() - 1)) {
//			System.out.println("Cluster id: " + cluster.getId() + " center: "
//					+ cluster.getCenter().asFormatString());
//		}
	}

}