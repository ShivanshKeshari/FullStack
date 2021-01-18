import java.util.*;
public class Student
{

      public static void main(String []args){                                                                                            
       
 
     
    System.out.println("Array of Objects");
StudentRec s=new StudentRec();
s.detailInput();

    }
   	}
class StudentRec
{
int id;
String name;
char grade;
int age;
int marks=new int[4];
int avg=0;
Scanner sc=new Scanner(System.in);

void detailInput()
{
 System.out.println("Enter ID: ");
  id=sc.nextInt();
  System.out.println("Enter Name");
   name=sc.nextLine();
   System.out.println("Enter Age");
    age=sc.nextInt();
 System.out.println("Enter Marks ");

int sum=0;
for(int i=0;i<4;i++)
{
marks[i]=sc.nextInt();
}
for(int i=0;i<4;i++)
{
sum+=marks[i];
}
avg=sum/4;

  System.out.println(avg);
}
void calGarde()
{
if(avg>90)
{
grade="A";
}
else if(avg<90 && avg>80)
{
grade="B";
}
else if(avg<80 && avg>70)
{
grade="C";
}
else if(avg<70 && avg>55)
{
grade="D";
}
else
{
grade="E";
}
}

void display()
{
 System.out.println(id);
  System.out.println(name);
System.out.println(age);
System.out.println(grade);
}


}
class StudentTest extends StudentRec
{


}