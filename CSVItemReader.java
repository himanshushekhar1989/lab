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

public class CSVItemReader {

	public static void main(String[] args) throws IOException {
		CSVItemReader reader = new CSVItemReader();
		reader.readCSVFile();
	}


	private CSVItemData getRecordFromLine(String line) {
		String[] row = null;
		if (line.contains(",")) {
			row = line.split(",");
		} else if (line.contains(";")) {
			row = line.split(";");
		}
		return new CSVItemData(row[0], row[1], row[2], row[3], row[4], row[5]);
		//return new CSVData(row[0], row[1], row[2], row[3], row[4]);
	}

	void readCSVFile() throws IOException {
		Stream<Path> files = Files.walk(Paths.get("C:\\Users\\i500961\\Desktop\\files\\all_1"));
		List<String> collect = files.filter(file -> !Files.isDirectory(file)).map(Path::toString).collect(Collectors.toList());
		files.close();
		List<CSVItemData> listData = new ArrayList<>();
		CSVItemData title = new CSVItemData("Tenant ID", "Provider Id", "Course Id", "Course GUID", "Cpnt ID", "Stud ID");
		listData.add(title);
		collect.stream().forEach((String p) -> {
			try (Scanner scanner = new Scanner(new File(p))) {
				while (scanner.hasNextLine()) {
					String line = scanner.nextLine();
					if (line.contains("_TMS") && !line.contains("PROVIDER_ID")) {
						if(line.contains("ADAMAAGRIC_PROD_TMS")){
							System.out.println("abcd");
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
		writeDataLineByLine(listData, "C:\\Users\\i500961\\Desktop\\files\\total\\Item.csv");

	}

	public void writeDataLineByLine(List<CSVItemData> data, String filePath) {
		File file = new File(filePath);
		try {
			FileWriter outputfile = new FileWriter(file);
			CSVWriter writer = new CSVWriter(outputfile);
			data.forEach((CSVItemData row) -> {
				String[] rowVal = {row.getTenantId(), row.getProviderId(), row.getCourseId(), row.getSysGuid(), row.getCpntId(), row.getStudId()};
				writer.writeNext(rowVal);
			});
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

class CSVItemData {
	String tenantId;
	String providerId;
	String courseId;
	String sysGuid;
	String cpntId;
	String studId;

	public CSVItemData(String tenantId, String providerId, String courseId, String sysGuid, String cpntId, String studId) {
		this.tenantId = tenantId;
		this.providerId = providerId;
		this.courseId = courseId;
		this.sysGuid = sysGuid;
		this.cpntId = cpntId;
		this.studId = studId;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getSysGuid() {
		return sysGuid;
	}

	public void setSysGuid(String sysGuid) {
		this.sysGuid = sysGuid;
	}

	public String getCpntId() {
		return cpntId;
	}

	public void setCpntId(String cpntId) {
		this.cpntId = cpntId;
	}

	public String getStudId() {
		return studId;
	}

	public void setStudId(String studId) {
		this.studId = studId;
	}
}
