package mahout_action.recommender.ch02;


import java.io.File;
import java.io.IOException;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.apache.mahout.common.RandomUtils;



public class EvaluatorIntro {
	private EvaluatorIntro() {
	  }
	public static void main(String[] args) throws IOException, TasteException {
		RandomUtils.useTestSeed();

		File modelFile = null;
		if (args.length > 0)
			modelFile = new File(args[0]);
		if(modelFile == null || !modelFile.exists())
			modelFile = new File("src/main/java/mia/recommender/ch02/intro.csv");
		if(!modelFile.exists()) {
			System.err.println("Please, specify name of file, or put file 'input.csv' into current directory!");
			System.exit(1);
		}
	    DataModel model = new FileDataModel(modelFile);
	    
	    RecommenderEvaluator evaluator=new AverageAbsoluteDifferenceRecommenderEvaluator();
	    RecommenderBuilder recommenderBuilder =new RecommenderBuilder() {
	    	
	    	
	    	// Build the same recommender for testing that we did last time:
			
			@Override
			public Recommender buildRecommender(DataModel paramDataModel) throws TasteException {
				UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
		        UserNeighborhood neighborhood =
		          new NearestNUserNeighborhood(2, similarity, model);
				return new GenericUserBasedRecommender(paramDataModel, neighborhood, similarity);
			}
		};
		// Use 70% of the data to train; test using the other 30%.
	    double score = evaluator.evaluate(recommenderBuilder, null, model, 0.7, 1.0);
	    System.out.println(score);
	}
}
