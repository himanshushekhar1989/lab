package lab;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.opencsv.CSVWriter;

public class CSVFileReader {
	public static void main(String[] args) throws IOException {

		CSVFileReader reader = new CSVFileReader();
		reader.readCSVFile();

	}


	private CSVData getRecordFromLine(String line) {
		String[] row = null;
		if (line.contains(",")) {
			row = line.split(",");
		} else if (line.contains(";")) {
			row = line.split(";");
		}
		return new CSVData(row[0], row[1], row[2], row[3], row[4], row[5]);
		//return new CSVData(row[0], row[1], row[2], row[3], row[4]);
	}

	void readCSVFile() throws IOException {
		Stream<Path> files = Files.walk(Paths.get("C:\\Users\\i500961\\Desktop\\files\\all"));
		List<String> collect = files.filter(file -> !Files.isDirectory(file)).map(Path::toString).collect(Collectors.toList());
		files.close();
		List<CSVData> listData = new ArrayList<>();
		CSVData title = new CSVData("Tenant ID", "Total OCN Course", "Duplicate Course", "Items created", "Inactive Item", "Assigned Item");
		listData.add(title);
		collect.stream().forEach((String p) -> {
			try (Scanner scanner = new Scanner(new File(p))) {
				while (scanner.hasNextLine()) {
					String line = scanner.nextLine();
					if (line.contains("_TMS")) {
						if (line.contains("CAPGROUP_PROD_TMS")) {
							System.out.println("file name " + p);
						}
						listData.add(getRecordFromLine(line));
					}
				}
			} catch (Exception e) {
				//
			}
		});
		//System.out.println(listData.size());
		//listData.forEach(System.out::println);
		writeDataLineByLine(listData, "C:\\Users\\i500961\\Desktop\\files\\total\\OCN2.csv");

	}

	public void writeDataLineByLine(List<CSVData> data, String filePath) {
		File file = new File(filePath);
		try {
			FileWriter outputfile = new FileWriter(file);
			CSVWriter writer = new CSVWriter(outputfile);
			data.forEach((CSVData row) -> {
				String[] rowVal = {row.getTenantId(), row.getTotalCourse(), row.getDuplicateCourse(), row.getNoOfItemsCreated(), row.getNumberOfInactiveItems(), row.getNumberOfItemAssigned()};
				//String[] rowVal = {row.getTenantId(), row.getTotalCourse(), row.getDuplicateCourse(), row.getNoOfItemsCreated(), row.getNumberOfInactiveItems()};
				writer.writeNext(rowVal);
			});
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

class CSVData {
	String tenantId;
	String totalCourse;
	String duplicateCourse;
	String noOfItemsCreated;
	String numberOfInactiveItems;
	String numberOfItemAssigned;

	public CSVData(String tenantId, String totalCourse, String duplicateCourse, String noOfItemsCreated, String numberOfInactiveItems, String numberOfItemAssigned) {
		this.tenantId = tenantId;
		this.totalCourse = totalCourse;
		this.duplicateCourse = duplicateCourse;
		this.noOfItemsCreated = noOfItemsCreated;
		this.numberOfInactiveItems = numberOfInactiveItems;
		this.numberOfItemAssigned = numberOfItemAssigned;
	}

	public CSVData(String tenantId, String totalCourse, String duplicateCourse, String noOfItemsCreated, String numberOfInactiveItems) {
		this.tenantId = tenantId;
		this.totalCourse = totalCourse;
		this.duplicateCourse = duplicateCourse;
		this.noOfItemsCreated = noOfItemsCreated;
		this.numberOfInactiveItems = numberOfInactiveItems;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getTotalCourse() {
		return totalCourse;
	}

	public void setTotalCourse(String totalCourse) {
		this.totalCourse = totalCourse;
	}

	public String getDuplicateCourse() {
		return duplicateCourse;
	}

	public void setDuplicateCourse(String duplicateCourse) {
		this.duplicateCourse = duplicateCourse;
	}

	public String getNoOfItemsCreated() {
		return noOfItemsCreated;
	}

	public void setNoOfItemsCreated(String noOfItemsCreated) {
		this.noOfItemsCreated = noOfItemsCreated;
	}

	public String getNumberOfInactiveItems() {
		return numberOfInactiveItems;
	}

	public void setNumberOfInactiveItems(String numberOfInactiveItems) {
		this.numberOfInactiveItems = numberOfInactiveItems;
	}

	public String getNumberOfItemAssigned() {
		return numberOfItemAssigned;
	}

	public void setNumberOfItemAssigned(String numberOfItemAssigned) {
		this.numberOfItemAssigned = numberOfItemAssigned;
	}

	@Override
	public String toString() {
		return "CSVData{" +
				"tenantId='" + tenantId + '\'' +
				", totalCourse='" + totalCourse + '\'' +
				", duplicateCourse='" + duplicateCourse + '\'' +
				", noOfItemsCreated='" + noOfItemsCreated + '\'' +
				", numberOfInactiveItems='" + numberOfInactiveItems + '\'' +
				", numberOfItemAssigned='" + numberOfItemAssigned + '\'' +
				'}';
	}
}
