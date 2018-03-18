package magicsquare;
import java.io.BufferedReader;
import java.io.File;  
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.String;
import java.util.Scanner; 
public class Hf {
	public static void main(String[] args) {
		System.out.println(s("1.txt"));
		System.out.println(s("2.txt"));
		System.out.println(s("3.txt"));
		System.out.println(s("4.txt"));
		System.out.println(s("5.txt"));
		int n;
		Scanner input = new Scanner(System.in);
		System.out.println("输入一个整数");
		n=input.nextInt();
		generateMagicSquare(n);
		System.out.println(s("6.txt"));
	   }
	public static boolean s(String a) {
		File file=new File("C:\\Users\\11593\\Desktop\\labno1:\\"+a);
		BufferedReader reader=null;
		String temp=null;
		int mm[][]=new int [1000][1000];
		int l=0;
		int i=0;
		try {
			reader=new BufferedReader(new FileReader(file));
			while ((temp=reader.readLine())!=null) {
			String[] ss= temp.split("\t");
			for(l=0;l<ss.length;l++) {
				try{
					mm[i][l] = Integer.valueOf(ss[l]).intValue();
							}
				catch(Exception e) {
				return false;
			}
				}
			i++;
			}
			}catch(Exception e) {
			e.printStackTrace();
		}
		    finally {
		    	if(reader!=null) {
		    		try {
		    			reader.close();
		    		}
		    		catch(Exception e) {
		    			e.printStackTrace();
		    		}
		    	}
		    }
		if(l!=i) {
			return false;
		}
		l=0;
		int sum[]=new int[200];
		int b=0;
		int x=0;
		i=0;
		for(b=0;b<sum.length;b++) {
			for(l=0;l<200;l++) {
		        x=x+mm[i][l];
		}
			sum[b]=x;
			i++;
		}
		int y=0;
		l=0;
		int q=0;
        int rsum[]=new int [200];
        for(q=0;q<200;q++) {
        	for(i=0;i<1000;i++) {
        		y=y+mm[i][l];
        	       	}
        	rsum[q]=y;
        	l++;
        }
       int w=0;
        if(sum[0]!=rsum[0])
        	return false;//1
       for(b=1;b<sum.length;b++) {
        	if(sum[b]==sum[0]) {
           return true;
		}
        	else continue;
       }
	for(q=1;q<rsum.length;q++) {
		if(rsum[q]==rsum[0]) {
			return true;
		}else continue;
	}
	for(i=0;i<1000;i++) {
		l=i;
		w=w+mm[i][l];
	}
	if(w!=sum[0]) {
	return false;
	}
	else return true;
	}
	public static boolean generateMagicSquare(int n) {
		if (n % 2 == 0 || n <= 0) {
			System.out.println("n is illegal");
			return false;
		}
		int magic[][] = new int[n][n];
		int row = 0, col = n / 2, i, j, square = n * n;
		for (i = 1; i <= square; i++) {
			magic[row][col] = i;
			if (i % n == 0)
				row++;
			else {
				if (row == 0)
					row = n - 1;
				else
					row--;
				if (col == (n - 1))
					col = 0;
				else
					col++;
			}
		}
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++)
				System.out.print(magic[i][j] + "\t");
			System.out.println();
		}
		try {
			FileWriter writer = new FileWriter("C:\\\\Users\\\\11593\\\\Desktop\\\\labno1:\\6.txt", false);
			for (i = 0; i < n; i++) {
				for (j = 0; j < n; j++)
					writer.write(String.format(String.format("%d\t", magic[i][j])));
				writer.write(String.format(String.format("%n")));
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}
