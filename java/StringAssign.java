import java.util.*;
public class StringAssign
{
public static void main(String args[])
{

int n;
 Scanner sc=new Scanner(System.in);
System.out.println("Enter no of names");
n=sc.nextInt();
String s[]= new String[n];
System.out.println("Enter names");
for(int i=0;i<n;i++)
{
s[i]=sc.next();
}
for(int i = 0; i<n-1; i++)   
{  
for (int j = i+1; j<n; j++)   
{  

if(s[i].compareTo(s[j])>0)   
{  

String temp = s[i];  
s[i] = s[j];  
s[j] = temp;  
}  
}  
}
System.out.println("Print names are in ascending order");
for(int i=0;i<n;i++)
{
System.out.println(s[i]);
}
}
}
