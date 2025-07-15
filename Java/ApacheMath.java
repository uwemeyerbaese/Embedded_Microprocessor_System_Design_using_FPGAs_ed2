// From: https://mvnrepository.com/artifact/org.apache.commons/commons-math3/3.6.1
// Download file commons-math3-3.6.1.jar
// IntelliJ needs to be added under: File -> Project Structure -> Libraries
import org.apache.commons.math3.util.CombinatoricsUtils;
import org.apache.commons.math3.complex.Complex;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import org.apache.commons.math3.linear.EigenDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

public class ApacheMath {
  public static void main(String[] args) {
    System.out.println("*** Advanced Math methods:");
    System.out.println("factorial(10) = " + CombinatoricsUtils.factorial(10));
    Complex c = new Complex(-4.0, 0.0);
    System.out.println("sqrt(-4) = " + c.sqrt());

    System.out.println("\n*** Statistic Math:");
    double[] values = new double[]{1.0, 2.0, 3.0, 4.0, 10.0};
    DescriptiveStatistics stats = new DescriptiveStatistics();
    for (double v : values) stats.addValue(v);

    System.out.println("mean(1.0,2.0,3.0,4.0,10.0) = " + stats.getMean());
    System.out.println("median(1.0,2.0,3.0,4.0,10.0) = " + stats.getPercentile(50));
    System.out.println("variance(1.0,2.0,3.0,4.0,10.0) = " + stats.getVariance());

    System.out.println("\n*** Matrix Algebra:");
    double[][] T1 = {{-2, 1}, {1.5, -0.5}}; // Test Data
    RealMatrix M1 = MatrixUtils.createRealMatrix(T1);
    RealMatrix I = MatrixUtils.inverse(M1);
    System.out.println(I);

    double[][] T2 = {{1.0, 2.0}, {2.0, 1.0}}; // Test Data
    RealMatrix M2 = MatrixUtils.createRealMatrix(T2);
    EigenDecomposition decomposition = new EigenDecomposition(M2);
    System.out.printf("Eigen values = %1.2f, %1.2f\n", decomposition.getRealEigenvalue(0),
                                                       decomposition.getRealEigenvalue(1));
    System.out.println("Eigen vector[0] = " + decomposition.getEigenvector(0));
    System.out.println("Eigen vector[1] = " + decomposition.getEigenvector(1));
  }
}