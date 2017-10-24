package com.dicero.diceroller.common.util;

import com.spatial4j.core.distance.DistanceUtils;

/**   
* <p></p>
* @author zengningzong
*/
public class DistanceTestUtil {
//	public static double[] trainPolyFit(int degree, int Length){
//	    PolynomialCurveFitter polynomialCurveFitter = PolynomialCurveFitter.create(degree);
//	    double minLat = 10.0; //中国最低纬度
//	    double maxLat = 60.0; //中国最高纬度
//	    double interv = (maxLat - minLat) / (double)Length;
//	    List<WeightedObservedPoint> weightedObservedPoints = new ArrayList<WeightedObservedPoint>();
//	    for(int i = 0; i < Length; i++) {
//	        WeightedObservedPoint weightedObservedPoint = new WeightedObservedPoint(1,  minLat + (double)i*interv, Math.cos(toRadians(x[i])));
//	        weightedObservedPoints.add(weightedObservedPoint); 
//	    }
//	    return polynomialCurveFitter.fit(weightedObservedPoints);
//	}
//
//
//	public static double distanceSimplifyMore(double lat1, double lng1, double lat2, double lng2, double[] a) {
//	     //1) 计算三个参数
//	     double dx = lng1 - lng2; // 经度差值
//	     double dy = lat1 - lat2; // 纬度差值
//	     double b = (lat1 + lat2) / 2.0; // 平均纬度
//	     //2) 计算东西方向距离和南北方向距离(单位：米)，东西距离采用三阶多项式
//	     double Lx = (a[3] * b*b*b  + a[2]* b*b  +a[1] * b + a[0] ) * toRadians(dx) * 6367000.0; // 东西距离
//	     double Ly = 6367000.0 * toRadians(dy); // 南北距离
//	     //3) 用平面的矩形对角距离公式计算总距离
//	     return Math.sqrt(Lx * Lx + Ly * Ly);
//	}
	
	public static double distHaversineRAD(double lat1, double lon1, double lat2, double lon2) {
        double hsinX = Math.sin((lon1 - lon2) * 0.5);
        double hsinY = Math.sin((lat1 - lat2) * 0.5);
        double h = hsinY * hsinY +
                (Math.cos(lat1) * Math.cos(lat2) * hsinX * hsinX);
        return 2 * Math.atan2(Math.sqrt(h), Math.sqrt(1 - h)) * 6367000;
    }
	
	public static double distanceSimplify(double lat1, double lng1, double lat2, double lng2) {
	     double dx = lng1 - lng2; // 经度差值
	     double dy = lat1 - lat2; // 纬度差值
	     double b = (lat1 + lat2) / 2.0; // 平均纬度
	     double Lx = DistanceUtils.toRadians(dx) * 6367000.0* Math.cos(DistanceUtils.toRadians(b)); // 东西距离
	     double Ly = 6367000.0 * DistanceUtils.toRadians(dy); // 南北距离
	     return Math.sqrt(Lx * Lx + Ly * Ly);  // 用平面的矩形对角距离公式计算总距离
	}
	
	public static void main(String[] args) {
		//System.out.println(distHaversineRAD(116.45, 39.941,  116.451, 39.94));
		System.out.println(distanceSimplify(116.45, 39.941,  116.451, 39.94));
		System.out.println(DistanceUtils.distHaversineRAD( 116.45,39.941,  116.451, 39.94));
		//System.out.println(DistanceUtils.distHaversineRAD( 39.941, 116.45, 39.94, 116.451));
		// System.out.println(DistanceUtils.distHaversineRAD(39.941, 116.45, 39.94, 116.451));
		
		// x :39.941 * 1000000 = 3994100 
		// y :39.941 * 1000000 = 3994000
		
		// 50m
		int x = 39941000;
		int y = 116450000;
		Double lat1 = Double.valueOf(x) / 1000000;
		Double lng1 = Double.valueOf(y) / 1000000;
		System.out.println(lat1);
		System.out.println(lng1);
		
		
		int x2 = 39940000;
		int y2 = 116451000;
		Double lat2 = Double.valueOf(x2) / 1000000;
		Double lng2 = Double.valueOf(y2) / 1000000;
		System.out.println(lat2);
		System.out.println(lng2);
		
		
		System.out.println(Math.PI/180.0);
		
	}
	
}
