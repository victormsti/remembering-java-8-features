package demo;

import java.io.File;
import java.io.FileFilter;

public class FirstLambda {

	public static void main(String[] args) {
		// Old anonymours style
//		FileFilter fileFilter = new FileFilter() {
//			
//			@Override
//			public boolean accept(File file) {
//				return file.getName().startsWith(".java");
//			}
//		};
		
		//Lambda style
		FileFilter filterLambda = (File file) -> file.getName().startsWith(".java");
		
		File file = new File("/home/victorsilva/Documents/Java/Java8Features/tmp");
		File[] files = file.listFiles(filterLambda);
		
		for (File f : files) {
			System.out.println(f);
		}
	}

}
