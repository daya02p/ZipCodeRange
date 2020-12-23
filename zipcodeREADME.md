# ZipCodeRange
Algorithm to produce minimum range
As per my understing, if the zipcodes are overlapping in the given range, then that part of the zipcodes should be consolidated. 

input.txt have input data. This file is being read from the other class for the input range of zipcodes. 
ZipCodeRange pojo class will have min and max. This class implements comparable to sort in ZipCodeService class 
DataSoruceHelper class has 3 methods. Reads from a text file with zipcode range, To test valid zipcode or not and writeConsolidatedRangeToFile method will give the consolidated list of zipcode a range to an outputFile (line-44)
ZipCodeService class has 2 methods. 1 to merge list and 2nd to validate zipcode as per problem statement. 
MinRangeException - if validation fails, if unable to read or write to txt file, throws custom exception
ZipCodeRunner - it is a dummy class to understand the whole flow in a single class.  line-13 reads a form input file, line-14 consolidated list, line-17 output, line-22 checking for valid input or not.  and  this class puts all classes together 

UnitTest folder: 
This folder have 2 txt files. 
    errorInput.txt: invalid input format
    invalidZipCodes.txt: zipcode with more ot less than 5 numbers. 
DataSourceHelperTest - I have handled all the possible test cases like NonEmptyZipCodeRanges, inputForWrongInputFile, ForWrongInputFileContent, ForInvalidZipCodes and WritingToOutputFile. This class Throws custom exception form MinRangeException class.
ZipCodeServiceTest - This class have the test cases to identify zipcode range, ValidZipCodeToShip and InValidZipCodeToShip. 
