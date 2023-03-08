package exercise7;

import java.io.*;

public class CopyanImage {
	public static void main(String[] args) {
		try(InputStream in=new FileInputStream("/Users/gokulananth/eclipse-workspace/Java-Excercise/src/exercise7/nature.jpeg");
				OutputStream out=new FileOutputStream("/Users/gokulananth/eclipse-workspace/Java-Excercise/src/exercise7/deer.jpeg")){
				byte[] buffer = new byte[1024];
				int bytesRead;
				while((bytesRead=in.read(buffer))!=-1) {
					out.write(buffer,0,bytesRead);
				}
				for(int i=0;i<buffer.length;i++) {
					System.out.println(buffer[i]+" ");
				}
				System.out.println("Image copy done");
			}catch(Exception e) {
				e.printStackTrace();	
			} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (out != null) {
				out.close();
			}
		}
	}
}
