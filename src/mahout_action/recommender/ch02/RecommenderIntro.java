package mahout_action.recommender.ch02;

import java.io.File;

import org.apache.mahout.cf.taste.common.Refreshable;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.*;
import org.apache.mahout.cf.taste.impl.neighborhood.*;
import org.apache.mahout.cf.taste.impl.recommender.*;
import org.apache.mahout.cf.taste.impl.similarity.*;
import org.apache.mahout.cf.taste.model.*;
import org.apache.mahout.cf.taste.neighborhood.*;
import org.apache.mahout.cf.taste.recommender.*;
import org.apache.mahout.cf.taste.similarity.*;
import java.io.*;
import java.util.*;

public class RecommenderIntro {
	
	private RecommenderIntro(){
		
	}
	
public static void main(String[] args) throws Exception{
	File modelFile=null;
	if (args.length>0){
		modelFile=new File(args[0]);
	}
	if(modelFile==null||!modelFile.exists())
		modelFile=new File("src/main/java/mia/recommender/ch02/u.data");
	if(!modelFile.exists()){
		System.err.println("Please, specify name of file, or put file 'input.csv' into current directory!");
		  System.exit(1);
	}
	
	DataModel model =new FileDataModel(modelFile);
	UserSimilarity similarity=(UserSimilarity) new PearsonCorrelationSimilarity(model);
	UserNeighborhood neighborhoods=new NearestNUserNeighborhood(2, similarity, model);
	Recommender recommender =new GenericUserBasedRecommender(model, neighborhoods, similarity);
	List<RecommendedItem> recommendations =recommender.recommend(1, 1);
	
	for(RecommendedItem recommendation: recommendations){
		System.out.println(recommendation);
	}
	
}

}
