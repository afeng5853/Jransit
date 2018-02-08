import java.io.IOException;
import java.util.Map;

import api.MTAApi;
import api.MTAApiStaticFactory;
import api.TrainFeed;
import info.Direction;
import info.LineInfo;
import info.LineInfoStaticFactory;

public class Test {
	public static void main(String[] args) throws IOException, InterruptedException {
		Map<TrainFeed, MTAApi> apis = MTAApiStaticFactory.getApis();
		Map<String, LineInfo> mapOfLineInfos = LineInfoStaticFactory.getLines();
		System.out.println(mapOfLineInfos);

		System.out.println(Direction.NORTH);
		MTAApi forever = new MTAApi("e7ed4dd1445f127eb503c38630a5d3e0", TrainFeed.GREEN);
		System.out.println(forever.getTripIds());
		
		// For Alex: http://web.mta.info/developers/data/nyct/subway/Stations.csv
		// mta.printEverything();

		// System.out.println(mta.grabTrainInfo("081100_E..S"));
		//LineInfo gTrain = new LineInfo(mtaGreen, "G");
		// LineInfo lTrain = new LineInfo(mta, "L");
		// LineInfo ETRAIN = new LineInfo(mta, "G");
		//TrainInfo test = new TrainInfo(mtaGreen, "067650_G..S");
		// System.out.println(gTrain.getStations());
		//for (StationInfo test2 : gTrain.getStationInfos()) {
			// System.out.println(test2.getName());
		//}
		//System.out.println(mtaGreen.getStopTimes("067650_G..S"));
		//System.out.println(test.getCurrentStation());
	}
}
