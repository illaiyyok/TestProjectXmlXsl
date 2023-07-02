package Alagu;

import java.io.File;

public class FileListener {

	public static void main(String a[]) {
		
		String filePath = "/Users/irajamo/Documents/MyDoc/";

		String fileName = "cacert.zip";
		
		long timerInSeconds = 15;
		
		FileListener fileListener = new FileListener();
		fileListener.listenAFolder(filePath, fileName, timerInSeconds);
		
		
	}
	
	private String listenAFolder(String folderPath, String fileName, long timerInSeconds ) {
		
		long now = System.currentTimeMillis();
		long startInSeconds =  (now/1000)%60;
		long endTime = now + (timerInSeconds * 1000);

		while( now <=  endTime - 1) {
			
			 now = System.currentTimeMillis();
			 startInSeconds =  (now/1000)%60;

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(checkIfFileExist(folderPath, fileName)) {
				System.out.println(" File "+ fileName + " EXISTS in the folder " + folderPath);
				break;
			} else {
				System.out.println(" File "+ fileName + " doesn't exist in the folder " + folderPath);
			}
		}

		return null;
		
	}
	
	private boolean checkIfFileExist(String filePath, String fileName) {
		try {
			File file = new File(filePath + fileName);
			//file.createNewFile();
			return file.exists();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}
}

