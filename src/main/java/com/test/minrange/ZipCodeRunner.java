package com.test.minrange;

import java.util.List;

/*
 * This is a dummy class to put all the classes together
 */
public class ZipCodeRunner {
	public static void main(String[] args) {
		ZipCodeService service = new ZipCodeService();
		DataSourceHelper fileHelper = new DataSourceHelper();
		
		List<ZipCodeRange> zipCodeRangesFromFile = fileHelper.getZipCodeRangesFromFile("input.txt");
		List<ZipCodeRange> finalIntervals = service.evaluateIntervals(zipCodeRangesFromFile);
		
		//optional - write final intervals to file
		fileHelper.writeConsolidatedRangeToFile(finalIntervals);
		
		//check if input zipcode meets the problem statement
		//This value will be true as per the problem statement
		//We have this test case defined in ZipCodeServiceTest class
		boolean validZipCode = service.validZipCode(94150, finalIntervals);
	}
}
