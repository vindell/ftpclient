package net.jeebiz.ftpclient;

import java.io.File;
import java.io.FileInputStream;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runners.MethodSorters;
@FixMethodOrder(MethodSorters.JVM) 
public class FTPResourceClientUploadTest extends FTPResourceClientTest {
	
	@Rule
	public ContiPerfRule rule = new ContiPerfRule();
	 
	/**
 	 * 向ftp写文件(数据)
 	 */
	@Test
	@PerfTest(invocations = 300,threads = 40)  
 	public void uploadFile() {
 		try {
 			File localFile = new File("E:\\第九套广播体操.mp4");
 			
 			ftpClient.upload(localFile,"20063586");
 			
 			ftpClient.upload(new StringBuilder(fileContent),"tst1.txt");
 			ftpClient.upload(new StringBuilder(fileContent),"20063586/20160118","tst2.txt");
 			
 			ftpClient.upload(localFile,"tst.mp4");
 			ftpClient.upload(new FileInputStream(localFile),"tst2.mp4");
 			ftpClient.upload("E:\\第九套广播体操.mp4","tst1.mp4");
 			ftpClient.upload(new StringBuilder(fileContent),"tst1.txt");
 			
 			ftpClient.upload(localFile,"20063586");
 			
 			ftpClient.upload(new FileInputStream(localFile),"20063586","tst2.mp4");
 			ftpClient.upload("E:\\第九套广播体操.mp4","20063586");
 			ftpClient.upload(new StringBuilder(fileContent),"20063586","tst1.txt");
 			
 			ftpClient.upload(localFile,"20063586/20160118");
 			ftpClient.upload(new FileInputStream(localFile),"20063586/20160118","tst2.mp4");
 			ftpClient.upload("E:\\第九套广播体操.mp4","20063586/20160118");
 			ftpClient.upload(new StringBuilder(fileContent),"20063586/20160118","tst1.txt");
 			
 			//部分ftp服务异常
 			ftpClient.uploadByChannel(localFile,"tst.mp4");
 			ftpClient.uploadByChannel(localFile,"20063586/20160118");
 			
 		} catch (Exception e) {
 			e.printStackTrace();
 		}  
 	}
 	
 }
 