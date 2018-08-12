package array;

public class NthRoot {

    static double root(double x, int n) {
        if (x == 0)
            return 0;
        double lowerBound = 0;
        double upperBound = Math.max(1, x);
        double approxRoot = (upperBound + lowerBound) / 2;
        while (approxRoot - lowerBound >= 0.001) {
            if (Math.pow(approxRoot, n) > x)
                upperBound = approxRoot;
            else if (Math.pow(approxRoot, n) < x)
                lowerBound = approxRoot;
            else
                break;
            approxRoot = (upperBound + lowerBound) / 2;
        }


        return approxRoot;
    }

//    static double root(double x, int n) {
//        // your code goes here
//        double ans = 0;
//        double i = 1;
//        double root = x / 2;
//
//        while (i < root && ans < x) {
//            i++;
//            ans = Math.pow(i, n);
//            //System.out.println(i + ":" + ans);
//
//        }
//        if (Math.pow(i, n) == x) {
//            return i;
//        } else {
//
//            double mantisa = x - ans;
//            System.out.println(mantisa);
//            if (x - ans < 0) {
//                while (true) {
//                    //i = (double) Math.round(i * 1000) / 1000;
//                    if (Math.pow(i - .001, n) >= x) {
//                        // System.out.println(mantisa);
//                        i = (double) Math.round(i * 1000) / 1000;
//                        i = i - .001;
//                    } else {
//                        i = i * 1000 / 1000;
//                        //i= i - .001;
//                        if (Math.pow(i , n) > x)
//                            return  i - .001;
//                        return (double)Math.round(i * 1000)/ 1000;
////                        return i * 1000/ 1000;
//                        //System.out.println(Math.pow(mantisa - .001,i));
//                        //break;
//                    }
//                }
//            } else {
//                while (true) {
//                    mantisa = Math.abs(mantisa);
//                    if (Math.pow(i + .001, n) <= x) {
//                        // System.out.println(mantisa);
//                        i = i + .001;
//                    } else {
//                        i = i * 1000 / 1000;
//                        //i = i + .001;
//                        return i * 1000/ 1000;
//                        //System.out.println(Math.pow(mantisa - .001,i));
//                        //break;
//                    }
//                }
//
//            }
//        }
//    }

  
  /*
  binSearch(double toFind, double low, double high) {
    while(low < high){
      double mid = (int) (low + high ) /2;
      if(mid == toFind){
        return mid;
      }
      if (mid < toFind){
        binSearch(toFind, mid+!,high);
      }
      else{
        binSearch(toFind,low, mid-1);
      }
    }
    retrun -1;
  }
  */

    public static void main(String[] args) {
        System.out.println(root(160, 3));
//        System.out.println(root(3, 2));
//        System.out.println(root(10, 3));
        //root(4,2);
    }

}