package br.com.dvfs.unzipfile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnzipFile {

	public static void main(String[] args) throws IOException {
		
		String fileZip = "compressed.zip";
		
		byte[] fileZipByte = Files.readAllBytes(new File(fileZip).toPath());
		
		File destDir = new File("/src/unzipTest");
		
		byte[] buffer = new byte[1024];
		ZipInputStream zis = new ZipInputStream(new ByteArrayInputStream(fileZipByte));
		ZipEntry zipEntry = zis.getNextEntry();
		
		while (zipEntry != null) {
			File newFile = newFile(destDir, zipEntry);
			FileOutputStream fos = new FileOutputStream(newFile);
			int len;
			while ((len = zis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}
			
			fos.close();
			zipEntry = zis.getNextEntry();
		}
		
		zis.closeEntry();
		zis.close();
	}
	
	 public static File newFile(File destinationDir, ZipEntry zipEntry) throws IOException {
	        File destFile = new File(destinationDir, zipEntry.getName());
	         
	        String destDirPath = destinationDir.getCanonicalPath();
	        String destFilePath = destFile.getCanonicalPath();
	         
	        if (!destFilePath.startsWith(destDirPath + File.separator)) {
	            throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
	        }
	         
	        return destFile;
	    }

}
