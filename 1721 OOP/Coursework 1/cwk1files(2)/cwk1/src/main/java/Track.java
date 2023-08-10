
/**
 * Represents a point in space and time, recorded by a GPS sensor.
 *
 * @author YOUR NAME
 */

 import java.util.ArrayList;
 import java.io.BufferedReader;
 import java.io.IOException;
 import java.nio.file.*;
 import java.time.ZonedDateTime;
 
 import java.time.temporal.ChronoUnit;
 
 public class Track {
 
   ArrayList<Point> sequence = new ArrayList<Point>();
 
   // TODO: Create a stub for the constructor
 
   public Track() {
 
   }
 
   public Track(String filename) {
     // sequence = new ArrayList<Point>();
     try {
       readFile(filename);
     }
     // if readFile method throws exception
     catch (IOException e) {
 
     }
 
   }
 
   // TODO: Create a stub for readFile()
 
   public void readFile(String filename) throws IOException {
 
     // file access
     Path path = Paths.get(filename);
     BufferedReader br = Files.newBufferedReader(path);
 
     // skip header line
     br.readLine();
     String line = br.readLine();
 
     while (line != null) {
 
       // csv record split into array
       String[] tmpArr = line.split(",");
 
       // insufficient point attributes exception
       if (tmpArr.length != 4) {
         throw new GPSException(null);
       }
 
       // index 0 - ZonedDateTime element
 
       ZonedDateTime time = ZonedDateTime.parse(tmpArr[0]);
 
       // index 1 - Longitude element
       double lon = Double.valueOf(tmpArr[1]);
 
       // index 2 - Latitude element
       double lat = Double.valueOf(tmpArr[2]);
 
       // index 3 - Elevation element
       double elev = Double.valueOf(tmpArr[3]);
 
       // instantiate point element (all valid)
       Point point = new Point(time, lon, lat, elev);
 
       //
       sequence.add(point);
 
       line = br.readLine();
 
     }
 
     br.close();
 
   }
 
   // TODO: Create a stub for add()
 
   public int size() {
     return sequence.size();
   }
 
   // TODO: Create a stub for get()
 
   public Point get(int index) {
     if (sequence.size() == 0 || index < 0 || index > 3) {
       throw new GPSException(null);
     }
     return sequence.get(index);
   }
 
   // TODO: Create a stub for size()
 
   public void add(Point point) {
     sequence.add(point);
   }
 
   // TODO: Create a stub for lowestPoint()
 
   public Point lowestPoint() {
 
     // empty track exception
     if (sequence.size() == 0) {
       throw new GPSException(null);
     }
 
     // initial min variable to compare with rest of sequence
     double min = sequence.get(0).getElevation();
     int minIndex = -1;
 
     // iterative check through sequence
     for (int i = 0; i < sequence.size(); i++) {
       if (sequence.get(i).getElevation() < min) {
         // overwrite min value and index
         min = sequence.get(i).getElevation();
         minIndex = i;
       }
     }
 
     return sequence.get(minIndex);

   }
 
   // TODO: Create a stub for highestPoint()
 
   public Point highestPoint() {
 
     // empty track exception
     if (sequence.size() == 0) {
       throw new GPSException(null);
     }
 
     // initial max variable to compare with rest of sequence
     double max = sequence.get(0).getElevation();
     int maxIndex = -1;
 
     // iterative check through sequence against max
     for (int i = 0; i < sequence.size(); i++) {
       if (sequence.get(i).getElevation() > max) {
         // overwrite max value and index
         max = sequence.get(i).getElevation();
         maxIndex = i;
       }
     }
 
     return sequence.get(maxIndex);
 
   }
 
   // TODO: Create a stub for totalDistance()
 
   public double totalDistance() {
 
     double distance = 0;
 
     // insufficient points exception
     if (sequence.size() < 2) {
       throw new GPSException(null);
     }
 
     for (int i = 0; i < sequence.size() - 1; i++) {
       distance += Point.greatCircleDistance(sequence.get(i), sequence.get(i + 1));
     }
 
     return distance;
 
   }
 
   // TODO: Create a stub for averageSpeed()
 
   public double averageSpeed() {
 
     // insufficient points exception
     if (sequence.size() < 2) {
       throw new GPSException(null);
     }
 
     // distance from first to last point
     double distance = Point.greatCircleDistance(this.sequence.get(0), this.sequence.get(sequence.size() - 1));
 
     // time from first to last point
     long time = ChronoUnit.SECONDS.between(this.sequence.get(0).getTime(),
         this.sequence.get(sequence.size() - 1).getTime());
 
     // speed = distance / time
     return distance / (double) time;
 
   }
 }
