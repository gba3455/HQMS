package edc2010.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ReadTxtFile {
public static ArrayList<String> readTxt(String filePath) {
		ArrayList<String> fprns_list = new ArrayList<>();
		try {
			File file = new File(filePath);
			if (file.isFile() && file.exists()) {
				InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "utf-8");
				BufferedReader br = new BufferedReader(isr);
				String lineTxt = null;
				while ((lineTxt = br.readLine()) != null) {
					fprns_list.add(lineTxt);
				}
				br.close();
			} else {
				System.out.println("文件不存在!");
			}
		} catch (Exception e) {
			System.out.println("文件读取错误!");
		}
		return fprns_list;
	}

public static String listToString(ArrayList<String> fprns_list) {
	String fprns = "";
	for(String fprn : fprns_list) {
		fprns += "'" + fprn + "',";
	}
	if (fprns.length() > 0) {
		return fprns.substring(0, fprns.length() - 1);
	}
	return fprns;
}

public static void main(String args[]) {
	System.out.println(readTxt(CONFIG.ReUploadTimeFilePath).isEmpty());
}
}