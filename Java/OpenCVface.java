import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

class DetectFaceDemo {
  public void run() {
    System.out.println("Running Canny edge detection Demo");
    // Read image and compute the Canny edge detection
    Mat src = Imgcodecs.imread("./UweMeyerBaese.jpg");
    Mat dst = src.clone(); // Same size destination image
    Imgproc.Canny(src, dst, 50, 100, 3, false);
    String filename = "UweOnEdge.jpg";
    System.out.println("Writing " + filename);
    Imgcodecs.imwrite(filename, dst);
  }
}

public class OpenCVface {
  public static void main(String[] args) {
    System.out.println("Using OpenCV version: " + Core.VERSION);
    // Load the native library.
    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    new DetectFaceDemo().run();
  }
}