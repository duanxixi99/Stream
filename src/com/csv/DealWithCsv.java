package com.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DealWithCsv {
	public static void main(String[] args) throws IOException {
		List<String> fileList = getAllCsv("csv\\input\\");
		for (String filePath : fileList) {
			// һ��24Сʱ����ˮ���������
			List<AmmeterInfo> dayDataList = getCsvData(filePath);
			// ����
			String fileName = filePath.substring(filePath.lastIndexOf("\\") + 1, filePath.lastIndexOf("."));
			System.out.println(fileName);
			// ��ÿ���ֽM
			Map<String, List<AmmeterInfo>> collect = dayDataList.stream()
					.collect(Collectors.groupingBy(AmmeterInfo::getAmmeterID));
			// ÿ������ʹ�������
			collect.forEach((ammeterID, list) -> {
				list.forEach((ammeterInfo) -> {
					
				});
			});
		}
	}

	private static List<AmmeterInfo> getCsvData(String filePath) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
		String line = "";
		List<AmmeterInfo> lineList = new ArrayList<>();
		AmmeterInfo ammeterInfo = null;
		while ((line = br.readLine()) != null) {
			String[] rowData = line.split(",");
			if ("���ID".equals(rowData[0])) {
				continue;
			}
			ammeterInfo = new AmmeterInfo();
			ammeterInfo.setAmmeterID(rowData[0]);
			ammeterInfo.setReadTime(rowData[1]);
			ammeterInfo.setAmmeterReading(rowData[2]);
			lineList.add(ammeterInfo);
		}
		br.close();
		return lineList;
	}

	/**
	 * ��ȡĿ¼��ǰ·��������csv�ļ��ľ���·��
	 * 
	 * @param path ����csv�����·��
	 * @return ����csv�ļ��ľ���·��
	 */
	private static List<String> getAllCsv(String path) {
		File root = new File(path);
		File[] listFile = root.listFiles();
		List<String> strList = new ArrayList<String>();
		if (listFile == null) {
			return strList;
		}
		for (File file : listFile) {
			if ((file.isFile()) && (".csv"
					.equals(file.getName().substring(file.getName().lastIndexOf("."), file.getName().length())))) {
				strList.add(file.getAbsolutePath());
			}
		}
		return strList;
	}

}
