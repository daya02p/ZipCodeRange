package com.test.minrange;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataSourceHelper {
	private static final String COMMA_SEPARATOR = ",";
	/*
	 * This code is to fetch Zip code ranges from input text file
	 * Also perform validations
	 */
	public List<ZipCodeRange> getZipCodeRangesFromFile(final String inputFile) throws MinRangeException {
		try (Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource(inputFile).toURI()))){
            return stream.map(line -> {
				String[] lineTokens = line.split(COMMA_SEPARATOR);
				int min = Integer.parseInt(lineTokens[0]);
				int max = Integer.parseInt(lineTokens[1]);
				return new ZipCodeRange(validateZipCode(min), validateZipCode(max));
			}).collect(Collectors.toList());
        } catch (Exception e) {
           throw new MinRangeException("Error while reading from input text file for ranges", e);
        }
	}
	
	public int validateZipCode(int zipCode) throws MinRangeException {
		if (!(zipCode >= 10000 && zipCode <= 99999)) {
			throw new MinRangeException("Error while reading from input text file for ranges");
		}
		return zipCode;
	}
	
	/*
	 * Write final consolidated range list to a text file and create this file in resources folder
	 */
	public Path writeConsolidatedRangeToFile(final List<ZipCodeRange> finalRanges) throws MinRangeException {
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(finalRanges);
			byte[] bytes = bos.toByteArray();
			String outputFile = "/output"+ Instant.now().toEpochMilli() +".txt";
			Path path = Paths.get(this.getClass().getResource("/").getPath());
			Path outputFilePath = Paths.get(path.toAbsolutePath() + outputFile);
			Files.createFile(outputFilePath);
			return Files.write(outputFilePath, bytes);
		} catch (IOException e) {
			throw new MinRangeException("Error while writing output to text file in resources folder", e);
		}
	}
}
